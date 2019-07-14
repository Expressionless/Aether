package data.menu;

import data.Game;
import data.helpers.Neo;

public abstract class Component {
	
	protected float x, y, width, height;
	protected Game game;
	
	public Component(float x, float y, float width, float height, Game game) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
	}

	public abstract void render();
	public abstract void tick();
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
}
