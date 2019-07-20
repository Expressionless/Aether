package data.entity.user;

import java.util.ArrayList;

import data.entity.Mob;
import data.entity.doodads.Item;
import data.states.gameState.world.Map;

public abstract class Villager extends Mob {

	private String state = "work";
	private String role;
	
	private String[] name = new String[2];
	
	protected ArrayList<Item> inventory;
	
	public Villager(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, speed, map);
		System.out.println("Spawned Vil at: " + x + ", " + y);
		inventory = new ArrayList<Item>();
		name[0] = "Bob";
		name[1] = "Ross";
	}

	public abstract void work();
	
	@Override
	public void tick() {
		manageState();
	}
	
	public void manageState() {
		switch (state) {
		case "idle":
			
			break;
		case "work":
			work();
			break;
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

}
