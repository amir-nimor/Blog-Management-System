<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/19/2026
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>explorw</title>
</head>
<body>

<ul id="list"></ul>


<script>

    const ul = document.getElementById("list");
    fetch("http://localhost:8080/Blog_Management_System_war_exploded/explore",{
        method:"GET",
        headers:{"Content-Type": "application/json"}
    })
        .then(response => {
            return response.json();
        })
        .then(data => {
            for (let i = 0;i<data.length;i++){
                let li = document.createElement("li");
                li.innerText = "id = "+data[i].id+"  title = "+data[i].title+"  description = "+data[i].description+" userid = "+data[i].userId
                ul.appendChild(li)
            }

        })

</script>

</body>
</html>
