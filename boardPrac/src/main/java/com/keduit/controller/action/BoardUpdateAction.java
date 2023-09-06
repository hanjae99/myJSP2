package com.keduit.controller.action;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class BoardUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "board/boardView.jsp";

        BoardVO bVO = new BoardVO();
        bVO.setNum(Integer.parseInt(request.getParameter("num")));
        bVO.setName(request.getParameter("name"));
        bVO.setEmail(request.getParameter("email"));
        bVO.setTitle(request.getParameter("title"));
        bVO.setContent(request.getParameter("content"));
        bVO.setReadCount(Integer.parseInt(request.getParameter("readCount")));
        bVO.setWriteDate(Timestamp.valueOf(request.getParameter("writeDate")));

        BoardDAO bDAO = BoardDAO.getInstance();
        bDAO.updateBoard(bVO);

        request.setAttribute("board", bVO);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
