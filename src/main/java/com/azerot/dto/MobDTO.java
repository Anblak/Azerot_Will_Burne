package com.azerot.dto;

public class MobDTO {
	
	private String name;
	private int lvl;
	private int hp;
	private int manapool;
	private int attack;
	private String agr;
	
	public MobDTO() {
		// TODO Auto-generated constructor stub
	}

	public MobDTO(String name, int lvl, int hp, int manapool, int attack, String agr) {
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
	
}
