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
제목: <textarea rows="1" style="resize: none" disabled>${board.title}</textarea><br>
작성자: ${board.nickname}<br>
작성시간: ${board.entryDate}<br>
수정시간: ${board.modifyDate}<br>
내용: <textarea rows="4" style="resize: none" disabled>${board.content}</textarea><br>
<c:if test="${board.writerId eq login.id}">
    <a href="/board/update/${board.id}">수정하기</a>
    <a href="/board/delete/${board.id}">삭제하기</a>
</c:if>
<c:if test="${sessionScope.login != null}">
    <form action="/${board.id}/write-reply" method="post">
        댓글 : <textarea style="resize: none" name="content"></textarea>
        <br>
        <button type="submit">작성하기</button>
    </form>
</c:if>

<c:if test="${replyList != null}">
    <table>
        <th>댓글번호</th>
        <th>작성자</th>
        <th>내용</th>
        <th>작성 날짜</th>
        <th>마지막 수정 날짜</th>
        <c:forEach items="${replyList}" var="reply" varStatus="status">
            <br>
            <c:set var="size" value="${replyList.size()}"></c:set>
            <tr align="center">
                <td>${size - status.index}</td>
                <td>${reply.nickname}</td>
                <td>
                    <textarea style="resize: none" disabled>${reply.content}</textarea>
                </td>
                <td>${reply.entryDate}</td>
                <td>${reply.modifyDate}</td>
            </tr>

        </c:forEach>
    </table>
</c:if>
<br>
<a href="/board/showAll">목록으로</a>
</body>
</html>