<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:choose>
        <c:when test="${sessionScope.login != null}">
            <div style="float: right">
                    ${sessionScope.login.username}
                <a href="/user/logout">로그아웃</a>
            </div>
        </c:when>
        <c:otherwise>
            <div style="float: right">
                <a href="/">로그인</a>
            </div>
        </c:otherwise>
    </c:choose>
</div>