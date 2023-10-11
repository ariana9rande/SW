<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글</title>
</head>
<body>
<h1>게시글</h1>
<table id="table-board">
    <thead>
    <tr>
        <td>글 번호</td>
        <td>글 제목</td>
        <td>작성자</td>
        <td>작성시간</td>
        <td>수정시간</td>
    </tr>
    </thead>
    <tbody id="tbody-board">

    </tbody>
</table>
<script>
    let result = ${result};

    var obj = result;
    let tr = document.createElement("tr");

    console.log(obj);

    var td1 = document.createElement("td");
    td1.innerText = obj.id;

    var td2 = document.createElement("td");
    td2.innerHTML = "<a href='/board/showOne/" + obj.id + "'>" + obj.title + "</a>";

    var td3 = document.createElement("td");
    td3.innerText = obj.writerId;

    var td4 = document.createElement("td");
    td4.innerText = obj.entryDate;

    var td5 = document.createElement("td");
    td5.innerText = obj.modifyDate;

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);

    document.getElementById("tbody-board").appendChild(tr);

</script>
</body>
</html>