<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "webjars/jquery/3.0.0/jquery.min.js"></script> 
<link href = "webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
<script src = "webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>

<form method="post" action="/calculate_years" th:object="${formData}"> 

<select  id="firstSelect">
	<option th:each="user : ${users}" th:value="${user.id}" th:text="${user.firstName}">
	</option>
</select>



<select id="secondSelect">
	<option th:each="user : ${users}" th:value="${user.id}" th:text="${user.firstName}">
	</option>
</select>





<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Разница в возрасте</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id = "contentBody">

        
      </div>

    </div>
  </div>
</div>

<br>
<br>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick="kek()">
 Посчитать разницу в возрасте
</button>


<a th:href="@{users}">Вернуться в меню </a>


<script>
function kek(){
  $.ajax
  
 	 $.post('/calculate_years', {user1: $('#firstSelect').val(), user2: $('#secondSelect').val()}, function(data){	  
      $('#contentBody').text(data);

      $('#myModal').modal('show');
	  });
  
}

  </script>
                	
</form>
</body>
</html>