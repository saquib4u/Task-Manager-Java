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
<title>Update Task</title>
<%@ include file="component/all_css.jsp" %>	
</head>
<body>
	<%@ include file="component/navbar.jsp" %>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-primary">Edit Task</h3>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						TaskDAO dao = new TaskDAO(DBConnect.getConn());
						TaskDetails t = dao.getTaskById(id);
						%>
						
						<form action="update" method="POST">
							<input type="hidden" value="<%=t.getId()%>" name="id">
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Name</label>
						    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" value="<%=t.getName()%>">
						  </div>
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Task</label>
						    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="task" value="<%=t.getTask()%>">
						  </div>
						  <div class="col-md-4">
						    <label for="inputState" class="form-label">Status</label>
						    <select id="inputState" class="form-select" name="status">
						    	<%
						    	if("ToDo".equals(t.getStatus())){
						    	%> 
							      <option value="ToDo">ToDo</option>
							      <option value="Doing">Doing</option>
						      	  <option value="Done">Done</option>
						      	<%
						    	}else if("Doing".equals(t.getStatus())){
						      	%>
						      		<option value="Doing">Doing</option>
							      	<option value="Done">Done</option>
							      	<option value="ToDo">ToDo</option>
							    <%
							    }else{
							     %> 
							      	<option value="Done">Done</option>
							      	<option value="ToDo">ToDo</option>
								    <option value="Doing">Doing</option>
							      <%
							      }
							      %>
						    </select>
						  </div>
						  <div class="text-center">
						  	<button type="submit" class="btn btn-primary">Update</button>
						  	
						  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>