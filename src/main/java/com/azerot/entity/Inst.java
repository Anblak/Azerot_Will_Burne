package com.azerot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inst {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String nameOfBoss;
	
	@ManyToOne
	private Area area;
	
	public Inst() {
		// TODO Auto-generated constructor stub
	}
	

	public Inst(String name, String nameOfBoss) {
		super();
		this.name = name;
		this.nameOfBoss = nameOfBoss;
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void setNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
