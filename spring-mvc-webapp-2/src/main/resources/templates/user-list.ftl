<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href = "webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
	<script src = "webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src = "webjars/jquery/3.0.0/js/jquery.min.js"></script> 
</head>
<body>

<div class = "container">
<div class = "card">
<div class = "card-block">
<table class = "table table-hover">
	<thead>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Birthday</th>
			<th>is Alive</th>
		</tr>
			</thead>
			
				<tbody>
					<tr th:each="user : ${users}">
               			<td th:text="${user.firstName}"></td>
             			<td th:text="${user.lastName}"></td>
             		    <td th:text="${user.birthDay}"></td>
                		<td th:text="${user.isAlive}"></td>
                		<td><a th:href="@{user-update/{id}(id=${user.id})}">Edit</a></td>
                		<td><a th:href="@{user-delete/{id}(id=${user.id})}">Delete</a></td>
					</tr>
				</tbody>	
</table>
<hr/>
<ul class="nav nav-pills">
<li class="nav-item"
 th:each="i :${#numbers.sequence(0,users.totalPages-1)}">
 <a th:href="@{/users(page=${i})}" th:text="${i}" class="nav-link"
 th:classappend="${currentPage}==${i}?'active':''"> </a>
 </li>
</ul>

</div>
</div>
</div> 

 <p><a href="/user-create">Create user</a></p>
     <p><a href="/user-difference">Find out the age difference of user's</a></p>

</body>
</html>