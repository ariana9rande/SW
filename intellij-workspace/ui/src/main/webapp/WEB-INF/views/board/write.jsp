<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
</head>
<body>
    <h1>글쓰기</h1>
    <form action="/board/write" method="post">
        제목: <input type="text" name="title"><br>
        내용: <textarea name="content"></textarea>
        <button type="submit">글쓰기</button>
    </form>
</body>
</html>