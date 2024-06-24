<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.DAO.TaskDAO" %>
<%@ page import="com.entity.TaskDetails" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
<%@ include file="component/all_css.jsp" %>	
</head>
<body>
	<%@ include file="component/navbar.jsp" %>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-primary">Add Task</h3>
						<form action="add_task" method="POST">
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Name</label>
						    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
						  </div>
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Task</label>
						    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="task">
						  </div>
						  <div class="col-md-4">
						    <label for="inputState" class="form-label">Status</label>
						    <select id="inputState" class="form-select" name="status">
						      <option selected>--Select--</option>
						      <option value="ToDo">ToDo</option>
						      <option value="Doing">Doing</option>
						      <option value="Done">Done</option>
						    </select>
						  </div>
						  <div class="text-center">
						  	<button type="submit" class="btn btn-primary">Add</button>
						  	
						  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>