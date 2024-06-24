<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.DAO.TaskDAO"%>
<%@ page import="com.entity.TaskDetails"%>
<%@ page import="com.db.DBConnect"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<%@ include file="component/all_css.jsp" %>	
</head>
<body>
	<%@ include file = "component/navbar.jsp" %>
	<%
	String successMsg=(String) session.getAttribute("successMsg");
			if(successMsg != null)
			{
	%>
		<div class="alert alert-success" role="alert">
	  		<%=successMsg%>
	  		<%
	  		session.removeAttribute("successMsg");
	  		%>
	  		
		</div>
	<%
	}
	%>
	
	<%
		String failedMsg=(String) session.getAttribute("failedMsg");
				if(failedMsg != null)
				{
		%>
		<div class="alert alert-danger" role="alert">
	  		<%=failedMsg%>
	  		<%
	  		session.removeAttribute("failedMsg");
	  		%>
		</div>
	<%
	}
	%>
		
		<div class="container table-container">
		<h2 class="text-center text-primary" >Task Details</h2>
		<table class="table table-striped" border = "1px">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Task</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				TaskDAO dao = new TaskDAO(DBConnect.getConn());
							List<TaskDetails> task = dao.getTask();
							for(TaskDetails t : task){
				%>
						<tr>
							<th scope="row"><%= t.getId() %></th>
							<th scope="col"><%= t.getName() %></th>
								<td><%= t.getTask() %></td>
								<td><%= t.getStatus() %></td>
								<td>
									<a href="edit.jsp?id=<%= t.getId() %>" 
									class="btn btn-sm btn-success">Edit</a>
									<a href="delete?id=<%= t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
								</td>
						</tr>
				<%
					}
				%>

			</tbody>
		</table>
		</div>
		
  </body>
	
</body>
</html>