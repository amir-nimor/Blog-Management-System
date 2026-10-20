<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/19/2026
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post edited</title>
</head>
<body>

<form id="edit post">

    <label>id:
        <input id="id" type="number" name="id"><br>
    </label>

    <label>title:
        <input id="title" type="text" name="title"><br>
    </label>

    <label>description:
        <input id="description" type="text" name="description"><br>
    </label>

    <button id="btn-submit" type="button">Submit</button>
</form>

<ul id="listpost"></ul>

<%
    HttpSession session1 = request.getSession();
    Integer userId = (Integer) session1.getAttribute("userId");
%>

<script>

    const btn = document.getElementById("btn-submit");
    let listpost = document.getElementById("listpost");

    function edited() {
        let idjson = document.getElementById("id")

        let post = {
            id: Number(idjson.value),
            title: document.getElementById("title").value,
            description: document.getElementById("description").value,
            userId:Number(<%=userId%>)
        }
        fetch("http://localhost:8080/Blog_Management_System_war_exploded/userPost", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(post)
        })
            .then(response => {
                return response.json()
            })
            .then(data => {
                let li = document.createElement("li");
                li.innerText = "id = " + data.id + "  title = " + data.title + "  description = " + data.description
                listpost.appendChild(li);
            })
    }

    btn.addEventListener("click", edited)


</script>

</body>
</html>
