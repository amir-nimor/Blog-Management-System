<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/17/2026
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SingUp</title>
</head>
<body>

<h1>SingUp</h1>

<form id="singUpForm">

    <input type="text" id="username">
    <input type="password" id="password">
    <input type="text" id="phonenumber">
    <input type="text" id="fullname">

    <button id="reset-button">Submit</button>
<%--    <button onclick="sendToServlet()">change title</button>--%>
</form>

<%
    Cookie[] cookies = request.getCookies();
String usernameCookie = null;

for (Cookie c:cookies){
    if (c.getName().equals("username")){
        usernameCookie = c.getValue();

    }
}
if (usernameCookie != null){


if (!usernameCookie.isBlank()){%>
   <button id="login-button">login</button>
<%}}%>


<ul id="show"></ul>

<script>
    const form = document.getElementById("singUpForm")
    let buttom = document.getElementById("reset-button")
    let ul = document.getElementById("show");

    let loginButton = document.getElementById("login-button");

    function sendToServlet() {


        event.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const phonNumber = document.getElementById("phonenumber").value;
        const fullName = document.getElementById("fullname").value;

        const entity = {
            username :  username,
            password : password,
            phonNumber : phonNumber,
            fullName : fullName
        }



        fetch("http://localhost:8080/Blog_Management_System_war_exploded/Register",{
            method:"POST",
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


    function login() {
        <%--const usernameCookie = "<%= usernameCookie%>";--%>
        <%--window.location.href =--%>
        <%--    "<%= request.getContextPath()%>/Register/"+usernameCookie--%>
        window.location.href = "login.jsp"
        // fetch("http://localhost:8080/Blog_Management_System_war_exploded/Register/"+usernameCookie,{
        //     method:"GET",
        //     // headers:{"Content-Type": "application/json"}
        // })
            // .then(response => {
            //     return response.json();
            // })
            // .then(data => {
            //     console.log(data.username)
            //   window.location.href = "http://localhost:8080/Blog_Management_System_war_exploded/page/profile.jsp"
            // })
    }


    buttom.addEventListener("click",sendToServlet)
    loginButton.addEventListener("click",login)



</script>

</body>
</html>
