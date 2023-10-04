<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body>
<form action="/user/auth" method="post">
    ID: <input type="text" name="username">
    PW: <input type="password" name="password">
    <button type="submit">로그인</button>
</form>
</body>
</html>