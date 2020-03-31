package com.kingsroyale.kingdom;

import java.util.LinkedList;

import com.kingsroyale.objects.buildings.Building;

public class Province {

	private LinkedList<Building> buildings = new LinkedList<Building>();
	private String name;
	private int gold;
	//short for population duh
	private int pop;
	private int attack;
	private int defense;
	
	
	public Province(String name, int gold, int pop, int attack, int defense) {
		this.name = name;
		this.gold = gold;
		this.pop = pop;
		this.attack = attack;
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBuilding(Building newBuilding) {
		this.buildings.add(newBuilding);
	}
	
	public LinkedList<Building> getBuildings() {
		return buildings;
	}

	public int getGold() {
		return gold;
	}
	
	public void AddGold(int gold) {
		this.gold += gold;
	}
	
	public void removeGold(int gold) {
		this.gold -= gold;
	}

	public int getPop() {
		return pop;
	}
	
	public void AddPop(int pop) {
		this.pop += pop;
	}
	
	public void removePop(int pop) {
		this.pop -= pop;
	}

	public int getAttack() {
		return attack;
	}
	
	public void addAttack(int attack) {
		this.attack += attack;
	}
	
	public void removeAttack(int attack) {
		this.attack -= attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void addDefense(int defense) {
		this.defense += defense;
	}
	
	public void removeDefense(int defense) {
		this.defense -= defense;
	}
	
}
