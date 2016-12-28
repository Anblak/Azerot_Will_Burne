package com.azerot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;





@Entity
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int minLvlOfMob;
	private int maxLvlOfMob;
	
	@ManyToOne
	private Materic materic;
	
	@OneToMany(mappedBy = "area")
	private List<Inst> insts;
	
	@ManyToMany
	@JoinTable(name = "mob_area", joinColumns = @JoinColumn(name = "id_area"), inverseJoinColumns = @JoinColumn(name = "id_mob"))
	private List<Mob> mobs;
	
	public Area() {
		// TODO Auto-generated constructor stub
	}
	
	public Area(String name, int minLvlOfMob, int maxLvlOfMob) {
		super();
		this.name = name;
		this.minLvlOfMob = minLvlOfMob;
		this.maxLvlOfMob = maxLvlOfMob;
		
	}

	public List<Mob> getMobs() {
		return mobs;
	}

	public void setMobs(List<Mob> mobs) {
		this.mobs = mobs;
	}

	public int getId() {
		return id;
	}

	public List<Inst> getInsts() {
		return insts;
	}

	public void setInsts(List<Inst> insts) {
		this.insts = insts;
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

	public int getMinLvlOfMob() {
		return minLvlOfMob;
	}

	public void setMinLvlOfMob(int minLvlOfMob) {
		this.minLvlOfMob = minLvlOfMob;
	}

	public int getMaxLvlOfMob() {
		return maxLvlOfMob;
	}

	public void setMaxLvlOfMob(int maxLvlOfMob) {
		this.maxLvlOfMob = maxLvlOfMob;
	}

	public Materic getMateric() {
		return materic;
	}

	public void setMateric(Materic materic) {
		this.materic = materic;
	}

	
	
	
}

