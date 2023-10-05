<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<body>
<%@ include file="../loginnav.jsp" %>
<form action="/board/update/${board.id}" method="post">
    제목: <textarea rows="1" name="title">${board.title}</textarea><br>
    작성자: ${board.nickname}<br>
    작성시간: ${board.entryDate}<br>
    수정시간: ${board.modifyDate}<br>
    내용: <textarea name="content">${board.content}</textarea><br>
    <button type="submit">수정</button>
</form>
<a href="/board/showAll">목록으로</a>
</body>
</html>