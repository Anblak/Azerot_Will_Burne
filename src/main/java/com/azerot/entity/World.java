package com.azerot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class World {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "world")
	private List<Materic> materiky;
	


	public World(String name) {
		super();
		
		this.name = name;
		
	}



	public World() {
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



	public List<Materic> getMateriky() {
		return materiky;
	}



	public void setMateriky(List<Materic> materiky) {
		this.materiky = materiky;
	}
	
	
	
	
	
}
