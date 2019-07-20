package data.entity.user;

import java.util.ArrayList;

import data.entity.Mob;
import data.entity.doodads.Item;
import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Villager extends Mob {

	public static final int ERR_NOT_IN_RANGE = 0, ERR_INVENTORY_FULL = 1, OK = 2;

	protected String state = "work";
	private String role;

	private String[] name = new String[2];

	protected ArrayList<Item> inventory;
	protected double maxWeight = 32.0;
	protected double weight = 0.0;

	public Villager() {
		super(0, 0, 0, 0, 0, null, 0, null);
	}

	public Villager(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, speed, map);
		System.out.println("Spawned Vil at: " + x + ", " + y);
		inventory = new ArrayList<Item>();
		name[0] = "Bob";
		name[1] = "Ross";
	}

	public int harvest(Point pos, Item resource) {
		if (Point.findDistanceTo(pos) > 32)
			return ERR_NOT_IN_RANGE;
		if (weight >= maxWeight) {
			return ERR_INVENTORY_FULL;
		} else return OK;
	}

	@Override
	public void tick() {
		manageState();
	}

	public abstract void manageState();

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
