package com.entity;

public class TaskDetails {
	private int id;
	private String name;
	private String task;
	private String status;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", task=" + task + ", status=" + status + "]";
	}


}
