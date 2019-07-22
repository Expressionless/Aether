package data.entity;

import java.util.HashMap;

import data.entity.doodads.Item;
import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Mob extends Entity {

	public static final int MOB_WIDTH = 16, MOB_HEIGHT = 16;

	public static final int ERR_NOT_IN_RANGE = 0, ERR_INVENTORY_FULL = 1, OK = 2;
	public static final int HARVEST_DISTANCE = 3;

	//Stats
	protected int health, maxHealth;
	protected boolean passive;
	protected float speed;
	private String[] name = new String[2];

	//State machines
	public abstract void manageState();
	protected String state = "work";

	
	//Inventory Stuff
	protected HashMap<Integer, Item> inventory;
	
	protected double weight = 0.0, maxWeight = 12.0;
	public final float pickupRadius = 3;

	public Mob(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, map, map.getGame());
		inventory = new HashMap<Integer, Item>();
		this.speed = speed;
		name[0] = "Bob";
		name[1] = "Ross";
	}

	@Override
	public void tick() {
		manageState();
	}

	public void move(float xDir, float yDir) {
		Point pos = getPos();
		setPos(new Point(pos.getX() + xDir, pos.getY() + yDir));
	}

	public void moveInDirection(double angle) {
		double arcsin = Math.asin(angle);
		double arccos = Math.acos(angle);
		move((float) arccos, (float) arcsin);
	}

	public void moveTo(Point p2) {
		Point p1 = getPos();
		float disX = p2.getX() - p1.getX();
		float disY = p2.getY() - p1.getY();
		float distance = (float) Math.pow(Math.pow(disX, 2) + Math.pow(disY, 2), 0.5);
		float arcsin = disY / distance;
		float arccos = disX / distance;
		move(arccos, arcsin);
	}

	public int harvest(Entity target) {
		if (Point.findDistanceTo(getPos(), target.getPos()) > HARVEST_DISTANCE)
			return ERR_NOT_IN_RANGE;
		if (weight >= maxWeight) {
			return ERR_INVENTORY_FULL;
		} else {
			// Harvest resource
			return OK;
		}
	}

	public int pickup(Item resource) {
		if (Point.findDistanceTo(getPos(), resource.getPos()) > pickupRadius) {
			return ERR_NOT_IN_RANGE;
		}
		if (weight >= maxWeight) {
			return ERR_INVENTORY_FULL;
		} else {
			// pickup item
			
			return OK;
		}
	}

	public HashMap<Integer, Item> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<Integer, Item> inventory) {
		this.inventory = inventory;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

}
