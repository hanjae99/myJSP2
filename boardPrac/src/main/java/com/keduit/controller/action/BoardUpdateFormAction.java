package com.keduit.controller.action;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "board/boardUpdate.jsp";
        String num = request.getParameter("num");

        BoardDAO bDAO = BoardDAO.getInstance();
        BoardVO bVO = bDAO.selectOne(num);
        request.setAttribute("board", bVO);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
