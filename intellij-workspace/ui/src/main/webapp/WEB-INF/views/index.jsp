<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <form action="/auth" method="post">
        ID: <input type="text" name="username">
        PW: <input type="password" name="password">
        <button type="submit">로그인</button>
    </form>
</body>
</html>