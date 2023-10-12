<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<div class="container-fluid vh-100">
    <div class="h-50 row align-content-center">
        <div class="row justify-content-center">
            <div class="col-6">
                <label class="col-form-label" for="username">아이디</label>
                <input class="form-control" type="text" name="username" id="username">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <label for="password">비밀번호</label>
                <input class="form-control" type="password" name="password" id="password">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <button type="submit" class="btn btn-outline-primary" onclick="login()">로그인</button>
            </div>
        </div>
    </div>
</div>
<script>
    function login() {
        let username = $('#username').val();
        let password = $('#password').val();

        console.log(username);
        console.log(password);
    }
</script>
</body>
</html>