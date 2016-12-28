package com.azerot.dto;

public class InstDTO {
	private int id;
	private String name;
	
	
	public InstDTO() {
	// TODO Auto-generated constructor stub
	}

	

	public InstDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	
}
