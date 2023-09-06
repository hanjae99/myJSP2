package com.keduit.controller.action;

import com.keduit.dao.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        BoardDAO bDAO = BoardDAO.getInstance();
        bDAO.deleteBoard(num);

        new BoardListAction().execute(request, response);
    }
}
