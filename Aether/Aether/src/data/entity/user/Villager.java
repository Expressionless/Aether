package data.entity.user;

import java.util.ArrayList;

import data.entity.Mob;
import data.entity.doodads.Item;
import data.states.gameState.world.Map;

public abstract class Villager extends Mob {

	private String state = "idle";
	private String role;

	protected Map map;
	
	protected ArrayList<Item> inventory;
	
	public Villager(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, speed, map);
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

}
