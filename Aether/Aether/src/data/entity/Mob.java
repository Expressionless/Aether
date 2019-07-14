package data.entity;

import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Mob extends Entity {
	
	public static final int MOB_WIDTH = 32, MOB_HEIGHT = 32;
	
	protected int health, healthMax;
	protected boolean passive;
	protected float speed;
	protected Point pos;
	
	public Mob(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, map);
		this.speed = speed;
		pos = super.getPos();
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

}
