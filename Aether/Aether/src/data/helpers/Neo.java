package data.helpers;

import org.lwjgl.input.Mouse;

import data.Game;
import data.menu.Component;
import data.util.Point;

public class Neo extends Component {

	private Point pos;

	private static String[][] data = { { "", "" }, { "", "" }, { "", "" } };

	public static String[][] getData() {
		return data;
	}

	public static void setData(String temp, int i) {
		String[] stuff = temp.split(" ! ");
		data[i] = stuff;
	}

	public Neo(float x, float y, Game game) {
		super(x, y, 1, 1, game);
		pos = new Point(x, y);
	}

	public void tick() {
		setData("Coords: ! (" + Float.toString(pos.getX()) + "," + Float.toString(pos.getY()), 0);
		pos.setX(Mouse.getX());
		pos.setY(BobRoss.HEIGHT - Mouse.getY());
	}

	public void render() {
		BobRoss.drawText("(" + pos.getX() + "," + pos.getY() + ")", pos.getX() + 32, pos.getY() + 32);
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

}
