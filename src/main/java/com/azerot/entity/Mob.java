package com.azerot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Mob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int lvl;
	private int hp;
	private int manapool;
	private int attack;
	private String agr;
	
	@ManyToMany
	@JoinTable(name="mob_area",
	joinColumns= @JoinColumn(name="id_mob"),
	inverseJoinColumns=@JoinColumn(name="id_area"))
	private List<Area> areas;
	
	public Mob() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Mob(String name, int lvl, int hp, int manapool, int attack, String agr) {
		super();
		this.name = name;
		this.lvl = lvl;
		this.hp = hp;
		this.manapool = manapool;
		this.attack = attack;
		this.agr = agr;
		
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getManapool() {
		return manapool;
	}

	public void setManapool(int manapool) {
		this.manapool = manapool;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getAgr() {
		return agr;
	}

	public void setAgr(String agr) {
		this.agr = agr;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	
	
}
