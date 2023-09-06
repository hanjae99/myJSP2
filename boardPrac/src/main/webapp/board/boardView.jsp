<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: hanjae
  Date: 2023/09/06
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 상세</title>
    <link rel="stylesheet" href="css/board.css">
    <script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 상세</h1>
    <table>
        <tr>
            <th>작성자</th>
            <td>${board.name}</td>
            <th>이메일</th>
            <td>${board.email}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><fmt:formatDate value="${board.writeDate}"></fmt:formatDate></td>
            <th>조회수</th>
            <td>${board.readCount}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td colspan="3">${board.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3">${board.content}</td>
        </tr>
    </table>
    <br><br>
    <input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
    <input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'update')">
    <input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'delete')">
    <input type="button" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write_form'">
</div>
</body>
</html>
