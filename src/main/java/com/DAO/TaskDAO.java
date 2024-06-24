package com.DAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.db.DBConnect;
import java.sql.PreparedStatement;
import com.entity.TaskDetails;

public class TaskDAO {
	private Connection conn;
	public TaskDAO(Connection conn) {
		super();
		this.conn=conn;
	}

	public boolean addTask(String name, String task, String status) {
		boolean f = false;
		try {
			String q = "INSERT INTO task(name, task, status) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, task);
			ps.setString(3, status);
			int i =ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<TaskDetails> getTask(){
		List<TaskDetails> list = new ArrayList<TaskDetails>();
		TaskDetails t = null;
		try {
			String q="SELECT * FROM task";
			PreparedStatement ps = conn.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TaskDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTask(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public TaskDetails getTaskById(int id) {
		TaskDetails t = null;
		try {
			String sql= "SELECT * FROM task WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TaskDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTask(rs.getString(3));
				t.setStatus(rs.getString(4));	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public boolean updateTask(TaskDetails t) {
		boolean f=false;
		try {
			String sql="UPDATE task SET name=?, task=?, status=? WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getTask());
			ps.setString(3, t.getStatus());
			ps.setInt(4, t.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteTask(int id) {
		boolean f=false;
		try {
			String sql="DELETE FROM task WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}
