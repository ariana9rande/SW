<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시글</title>
</head>
<body>
<%@ include file="../loginnav.jsp" %>
제목: <textarea rows="1" disabled>${board.title}</textarea><br>
작성자: ${board.nickname}<br>
작성시간: ${board.entryDate}<br>
수정시간: ${board.modifyDate}<br>
내용: <textarea disabled>${board.content}</textarea><br>
<c:if test="${board.writerId eq login.id}">
    <a href="/board/update/${board.id}">수정하기</a>
    <a href="/board/delete/${board.id}">삭제하기</a>
</c:if>
<a href="/board/showAll">목록으로</a>
</body>
</html>