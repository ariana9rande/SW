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
    <tbody id="tbody-board">

    </tbody>
</table>
<script>
    let result = ${result};

    var obj = result;
    let tr1 = document.createElement("tr");
    let tr2 = document.createElement("tr");
    let tr3 = document.createElement("tr");
    let tr4 = document.createElement("tr");
    let tr5 = document.createElement("tr");
    let tr6 = document.createElement("tr");

    console.log(obj);

    var td1 = document.createElement("td");
    td1.innerHTML = "글 번호 : " + obj.id;

    var td2 = document.createElement("td");
    td2.innerHTML = "작성자 ID : " + obj.writerId;

    var td3 = document.createElement("td");
    td3.innerHTML = "제목 : " + obj.title;

    var td4 = document.createElement("td");
    td4.innerHTML = "내용 ";
    var td4_textarea = document.createElement("textarea");
    td4_textarea.innerText = obj.content;
    td4_textarea.setAttribute("rows", "10");
    td4_textarea.setAttribute("style", "resize: none");
    td4.appendChild(td4_textarea);

    var td5 = document.createElement("td");
    td5.innerHTML = "작성시간 : " + obj.entryDate;

    var td6 = document.createElement("td");
    td6.innerHTML = "수정시간 : " + obj.modifyDate;

    tr1.appendChild(td1);
    tr2.appendChild(td2);
    tr3.appendChild(td3);
    tr4.appendChild(td4);
    tr5.appendChild(td5);
    tr6.appendChild(td6);

    document.getElementById("tbody-board").appendChild(tr1);
    document.getElementById("tbody-board").appendChild(tr2);
    document.getElementById("tbody-board").appendChild(tr3);
    document.getElementById("tbody-board").appendChild(tr4);
    document.getElementById("tbody-board").appendChild(tr5);
    document.getElementById("tbody-board").appendChild(tr6);

</script>
</body>
</html>