<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
    <link href = "webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
	<script src = "webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src = "webjars/jquery/3.0.0/js/jquery.min.js"></script> 
</head>
<body>
<form action="#" th:action="@{/user-create}" th:object="${user}" method="post">
    <label for="firstName">First name</label>
    <input type="text" th:field="*{firstName}" id="firstName" placeholder="First Name">
    <label for="lastName">Last name</label>
    <input type="text" th:field="*{lastName}" id="lastName" placeholder="Last Name"> 
    <label for="birthDay">BirthDay</label>
    <input id="birthDay" type="datetime-local" placeholder="BirthDay" th:field="*{birthDay}" 
    pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}" required>
    <span class="validity"></span>
    <label for="firstName">IS ALIVE?</label>
   <input type="checkbox" th:field="*{isAlive}" name="isAlive" id="isAlive"
                    value="1" Checked><br>
     <br>                
    <input type="submit" value="Create User">
    <a th:href="@{users}">Вернуться в меню </a>
   

</form>
</body>
</html>