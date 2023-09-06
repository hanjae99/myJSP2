package com.keduit.controller.action;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardWriteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardVO bVO = new BoardVO();
        bVO.setName(name);
        bVO.setPass(pass);
        bVO.setEmail(email);
        bVO.setTitle(title);
        bVO.setContent(content);

        BoardDAO bDAO = BoardDAO.getInstance();
        bDAO.insertBoard(bVO);

        List<BoardVO> boardList = bDAO.selectAllBoards();
        request.setAttribute("boardList", boardList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardList.jsp");
        dispatcher.forward(request, response);
    }
}
