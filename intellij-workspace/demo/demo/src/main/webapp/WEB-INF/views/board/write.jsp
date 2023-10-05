<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>글 쓰기</title>
</head>
<body>
<%@ include file="../loginnav.jsp" %>
    <form action="/board/write" method="post">
        제목: <input tyoe="text" name="title"><br>
        내용: <textarea name="content"></textarea><br>
        <button type="submit">작성하기</button>
    </form>
    <br>
    <a href="/board/showAll">목록으로</a>
</body>
</html>