<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 삭제</title>
</head>
<body>
<%@ include file="../loginnav.jsp" %>
<form action="/board/delete/${board.id}" method="post">
    비밀번호: <input type="password" name="password">
    <button type="submit">삭제</button>
</form>
${message}
</body>
</html>