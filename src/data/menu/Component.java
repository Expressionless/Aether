package data.menu;

import data.Game;
import data.UI;
import data.util.Point;

public abstract class Component {

	protected float x, y, width, height;
	protected Game game;
	protected String type;

	protected Point pos;

	protected UI parentUI;

	public Component(float x, float y, float width, float height, String type, Game game) {
		pos = new Point(x, y);
		this.width = width;
		this.height = height;
		this.game = game;

		game.getObjects().add(this);
		
		this.type = type;

	}

	public Component(float x, float y, float width, float height, String type, UI ui) {
		pos = new Point(x, y);
		this.width = width;
		this.height = height;
		parentUI = ui;

		this.type = type;
		this.game = parentUI.getGame();
	}

	public String getType() {
		return type;
	}

	public abstract void render();

	public abstract void tick();

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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public UI getParentUI() {
		return parentUI;
	}

	public void setParentUI(UI parentUI) {
		this.parentUI = parentUI;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}
}
