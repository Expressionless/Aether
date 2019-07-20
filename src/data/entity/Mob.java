package data.entity;

import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Mob extends Entity {

	public static final int MOB_WIDTH = 16, MOB_HEIGHT = 16;

	protected int health, healthMax;
	protected boolean passive;
	protected float speed;

	public Mob(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, map, map.getGame());
		this.speed = speed;
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

}
