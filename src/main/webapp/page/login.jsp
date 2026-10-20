<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/20/2026
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<form id="login_form" >

    <input type="password" id="login_pass" placeholder="Enter Password"/>

    <button type="button" id="login_btn">Login</button>
</form>

<%


    Cookie[] cookies = request.getCookies();
    String usernameCookie = null;

    for (Cookie c:cookies){
        if (c.getName().equals("username")){
            usernameCookie = c.getValue();

        }
    }
%>


<script>

    const btn = document.getElementById("login_btn");

    function login(){

        const entity = {
            password: document.getElementById("login_pass").value,
            username: "<%=usernameCookie%>"
        }


        fetch("http://localhost:8080/Blog_Management_System_war_exploded/Register",{
            method:"PUT",
            headers:{"Content-Type": "application/json"},
            body:JSON.stringify(entity)
        })
            .then(response => {
                return response.json();
            })
            .then(data => {
                console.log(data.username)
                window.location.href = "http://localhost:8080/Blog_Management_System_war_exploded/page/profile.jsp"
            })
    }

    btn.addEventListener("click",login)

</script>

</body>
</html>
