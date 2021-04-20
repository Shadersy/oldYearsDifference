<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>User update</title>
    <script src = "/webjars/jquery/3.0.0/js/jquery.min.js"></script> 
    <link href = "/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
	<script src = "/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="#" th:action="@{/user-update}" th:object="${user}" method="post">
   <label for="id">ID</label>
    <input readonly type="number" th:field="*{id}" id="id" placeholder="ID">
    <br>
    <label for="firstName">First name</label>
    <input type="text" th:field="*{firstName}" id="firstName" placeholder="First Name">
    <br>
    <label for="lastName">Last name</label>
    <input type="text" th:field="*{lastName}" id="lastName" placeholder="Last Name">
    <br>
    <div>
    <label for="birthDay">Birthday</label>
    <input id="birthDay" th:field="*{birthDay}" type="datetime-local" placeholder="BirthDay" 
    pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}" required>
    <span class="validity"></span>
    <br>
    </div>
     <input type="checkbox"  th:field="*{isAlive}" name="isAlive" value="true">IS ALIVE<Br>
  	<br>
    <input type="submit" value="Update User">
     <a th:href="@{/users}">Вернуться в меню?</a> 
</form>
</body>
</html>