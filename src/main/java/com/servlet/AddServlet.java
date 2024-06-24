package com.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.DAO.TaskDAO;
import com.db.DBConnect;

@WebServlet("/add_task")
public class AddServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
		String task = req.getParameter("task");
		String status = req.getParameter("status");
		
		TaskDAO dao = new TaskDAO(DBConnect.getConn());
		boolean f= dao.addTask(username, task, status);
		
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("successMsg", "Task added sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Something went wrong. Unable to add task.");
			resp.sendRedirect("index.jsp");
		}
	}
}
