<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/19/2026
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>crete post</title>
</head>
<body>

<%
    HttpSession session1 = request.getSession(false);
    Integer userId = (Integer) session1.getAttribute("userId");
%>

<form id="crete form">

    <label>Title:
        <input type="text" id="title" name="title">
    </label>

    <label>Description:
        <input type="text" id="description" name="description">
    </label>

    <button id="creteBtn">Submit</button>
</form>

<ul id="list"></ul>

<script>

    const btn = document.getElementById("creteBtn")
    let ul = document.getElementById("list");


    function cretePos() {
        let titlejson = document.getElementById("title").value;
        let descriptionjson = document.getElementById("description").value;
        let userIdjson = Number(<%=userId%>)

        let post ={
            title : titlejson,
            description : descriptionjson,
            userId: userIdjson
        }

        fetch("http://localhost:8080/Blog_Management_System_war_exploded/userPost",{
            method:"PUT",
            headers:{"Content-Type": "application/json"},
            body:JSON.stringify(post)
        })
            .then(response => {
                return response.json()
            })
            .then(data => {
                console.log(data)
                let li = document.createElement("li");
                li.innerText = "id = "+data.id+"  title = "+data.title+" description = "+data.description+"  userid = "+data.userId
                ul.appendChild(li);
            })

    }
    btn.addEventListener("click",cretePos)


</script>

</body>
</html>
