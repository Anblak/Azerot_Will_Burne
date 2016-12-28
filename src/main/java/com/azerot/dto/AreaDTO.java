package com.azerot.dto;

public class AreaDTO {
	private int id;
	private String name;
//	private int minLvlOfMob;
//	private int maxLvlOfMob;
	
	public AreaDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public AreaDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



}
