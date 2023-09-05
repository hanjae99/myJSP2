package com.keduit.dao;

import com.keduit.dto.BoardVO;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                bVO.setReadcount(rs.getInt("readcount"));
                bVO.setWritedate(rs.getTimestamp("writedate"));

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
}
