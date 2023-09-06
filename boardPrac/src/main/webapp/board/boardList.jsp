<%@ page import="com.keduit.dao.BoardDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: hanjae
  Date: 2023/09/05
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 목록</title>
  <link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
<div id="wrap" align="center">
  <h1>게시판 목록</h1>
  <table class="list">
    <tr>
      <td colspan="5" style="border:white; text-align: right"><a href="BoardServlet?command=board_write_form">게시글 등록</a></td>
    </tr>
      <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
      </tr>
      <c:forEach var="board" items="${boardList}">
          <tr>
              <td><a href="BoardServlet?command=board_view&num=${board.num}">${board.num}</a></td>
              <td><a href="BoardServlet?command=board_view&num=${board.num}">${board.title}</a></td>
              <td>${board.name}</td>
              <td><fmt:formatDate value="${board.writeDate}"></fmt:formatDate></td>
              <td>${board.readCount}</td>
          </tr>
      </c:forEach>
  </table>
</div>
</body>
</html>
