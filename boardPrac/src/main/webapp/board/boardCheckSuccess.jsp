<%--
  Created by IntelliJ IDEA.
  User: hanjae
  Date: 2023/09/06
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>비밀번호 일치시 분기하기</title>
</head>
<body>
<script>
    if (window.name == "update"){
        window.opener.parent.location.href = "BoardServlet?command=board_update_form&num=${param.num}";
    }else if (window.name == "delete"){
        alert("삭제되었습니다.");
        window.opener.parent.location.href = "BoardServlet?command=board_delete&num=${param.num}";
    }
    window.close();
</script>
</body>
</html>
