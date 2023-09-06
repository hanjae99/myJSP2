package com.keduit.dao;

import com.keduit.dto.BoardVO;
import util.DBManager;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private BoardDAO() {
    }

    private static BoardDAO instance = new BoardDAO();

    public static BoardDAO getInstance() {
        return instance;
    }

    public List<BoardVO> selectAllBoards() {
        List<BoardVO> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM board ORDER BY num DESC";

        try {
            conn = DBManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BoardVO bVO = new BoardVO();

                bVO.setNum(rs.getInt("num"));
                bVO.setPass(rs.getString("pass"));
                bVO.setName(rs.getString("name"));
                bVO.setEmail(rs.getString("email"));
                bVO.setTitle(rs.getString("title"));
                bVO.setContent(rs.getString("content"));
                bVO.setReadCount(rs.getInt("readCount"));
                bVO.setWriteDate(rs.getTimestamp("writeDate"));

                list.add(bVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, stmt, rs);
        }

        return list;
    }

    public void insertBoard(BoardVO bVO) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into board (num, pass, name, email, title, content) values(board_seq.nextval, ?, ?, ?, ?, ?)";

        int result;
        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bVO.getPass());
            pstmt.setString(2, bVO.getName());
            pstmt.setString(3, bVO.getEmail());
            pstmt.setString(4, bVO.getTitle());
            pstmt.setString(5, bVO.getContent());
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }

    public BoardVO selectOne(String num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM board where num = ?";

        BoardVO bVO = null;
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()){
                bVO = new BoardVO();

                bVO.setNum(rs.getInt("num"));
                bVO.setPass(rs.getString("pass"));
                bVO.setName(rs.getString("name"));
                bVO.setEmail(rs.getString("email"));
                bVO.setTitle(rs.getString("title"));
                bVO.setContent(rs.getString("content"));
                bVO.setReadCount(rs.getInt("readcount"));
                bVO.setWriteDate(rs.getTimestamp("writedate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return bVO;
    }

    public void updateReadCount(String num){
        String sql = "update board set readcount = readcount + 1 where num = " + num;

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBManager.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, stmt);
        }
    }

    public void deleteBoard(String num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from board where num = ?";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }

    }

    public void updateBoard(BoardVO bVO){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update board set name=?, email=?, title=?, content=? where num=?";

        int result;
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bVO.getName());
            pstmt.setString(2, bVO.getEmail());
            pstmt.setString(3, bVO.getTitle());
            pstmt.setString(4, bVO.getContent());
            pstmt.setInt(5, bVO.getNum());
            result = pstmt.executeUpdate();
            if (result > 0){
                System.out.println("업데이트 성공!");
            }else {
                System.out.println("업데이트 실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }
}
