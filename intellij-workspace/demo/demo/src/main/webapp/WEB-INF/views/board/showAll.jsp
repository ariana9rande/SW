<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
</head>
<body>
<%@ include file="../loginnav.jsp" %>
<a href="/board/write">글 쓰기</a><br>
<table>
    <th>글번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성 날짜</th>
    <th>마지막 수정 날짜</th>
    <c:forEach items="${list}" var="board" varStatus="status">
        <c:set var="size" value="${list.size()}"></c:set>
        <tr>
            <td>${size - status.index}</td>
            <td><a href="/board/showOne/${board.id}">${board.title}</a></td>
            <td>${board.nickname}</td>
            <td>${board.entryDate}</td>
            <td>${board.modifyDate}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>