<%@ page import="ir.maktabsharif.dto.user.UserResponseDto" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/18/2026
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user post</title>
</head>
<body>

<%
    HttpSession session1 = request.getSession();
    Integer userId = (Integer) session1.getAttribute("userId");
%>

<button id="myPosts">my posts</button>

<ul id="listPost"></ul>



<button id="editPost">edit</button><br>
<button id="createpost">add post</button><br>

<script>

    let listPost = document.getElementById("listPost");

    const btn = document.getElementById("myPosts");
    const btnEdit = document.getElementById("editPost");
    const btncrete = document.getElementById("createpost");

    function getPosts() {
        fetch("http://localhost:8080/Blog_Management_System_war_exploded/userPost",{
            method:"GET",
            headers:{"Content-Type": "application/json"}
        })
            .then(response => {
                return response.json();
            })
            .then(data => {
                console.log(data)
                listPost.innerHTML = ""
                for (let i = 0 ;i<data.length;i++){
                    let inpu = document.createElement("input")
                    inpu.innerText = "id = "+data[i].id +" title = "+ data[i].title;
                    listPost.appendChild(inpu)
                }
            })
    }


    function editPost(){
        window.location.href="postEdited.jsp"
    }

    function cretepost(){
        window.location.href="cretePost.jsp"
    }

    btn.addEventListener("click",getPosts);
    btnEdit.addEventListener("click",editPost)
    btncrete.addEventListener("click",cretepost)

</script>

</body>
</html>
