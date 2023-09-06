<%--
  Created by IntelliJ IDEA.
  User: hanjae
  Date: 2023/09/06
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>게시글 수정</title>
  <link rel="stylesheet" href="css/board.css">
  <script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
  <h1>게시글 수정</h1>
  <form action="BoardServlet" name="frm" method="post">
    <input type="hidden" name="command" value="board_update">
    <input type="hidden" name="num" value="${board.num}">
    <input type="hidden" name="readCount" value="${board.readCount}">
    <input type="hidden" name="writeDate" value="${board.writeDate}">

    <table>
      <tr>
        <th>작성자</th>
        <td><input type="text" name="name" value="${board.name}" required>* 필수</td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="email" name="email" value="${board.email}"></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input type="text" name="title" size="70" value="${board.title}" required>* 필수</td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name="content" cols="70" rows="15">${board.content}</textarea></td>
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
