<%--
  Created by IntelliJ IDEA.
  User: hanjae
  Date: 2023/09/06
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="css/board.css">
  <script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
  <h1>게시글 등록</h1>
  <form action="BoardServlet" name="frm" method="post">
    <input type="hidden" name="command" value="board_write">
    <table>
      <tr>
        <th>작성자</th>
        <td><input type="text" name="name" required>* 필수</td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="pass" autocomplete="current-password" required>* 필수(게시물 수정, 삭제시 필요)</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="email" name="email"></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input type="text" name="title" size="70" required>* 필수</td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name="content" cols="70" rows="15"></textarea></td>
      </tr>
    </table>
    <br><br>
    <input type="submit" value="등록" onclick="return boardCheck()">
    <input type="reset" value="다시 작성">
    <input type="button" value="목록" onclick="location.href='BoardServlet?command=board_list'">
  </form>
</div>
</body>
</html>
