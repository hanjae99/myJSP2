package com.keduit.controller.action;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardViewAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "board/boardView.jsp";

        request.setCharacterEncoding("UTF-8");
        String num = request.getParameter("num");

        BoardDAO bDAO = BoardDAO.getInstance();
        bDAO.updateReadCount(num); /* 조회수 증가 */
        BoardVO bVO = bDAO.selectOne(num);
        request.setAttribute("board", bVO);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
