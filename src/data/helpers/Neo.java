package data.helpers;

import org.lwjgl.input.Mouse;

import data.Game;
import data.entity.user.Villager;
import data.menu.Component;
import data.util.Point;

public class Neo extends Component {

	private Point pos;

	private static String[][] data = { { "", "" }, { "", "" }, { "", "" } };

	private Villager selectedVillager;

	public static String[][] getData() {
		return data;
	}

	public static void setData(String temp, int i) {
		String[] stuff = temp.split(" ! ");
		data[i] = stuff;
	}

	public Neo(float x, float y, Game game) {
		super(x, y, 1, 1, "mouse", game);
		pos = new Point(x, y);
	}

	public void tick() {
		setData("Coords: ! (" + Float.toString(pos.getX()) + "," + Float.toString(pos.getY()), 0);
		pos.setX(Mouse.getX());
		pos.setY(BobRoss.HEIGHT - Mouse.getY());
	}

	public void render() {
		BobRoss.drawText("(" + pos.getX() + "," + pos.getY() + ")", pos.getX() + 32, pos.getY() + 32);
		if (selectedVillager != null) {
			Villager v = selectedVillager;
			BobRoss.drawText("Selected Villager: " + v.getName()[0] + " " + v.getName()[1], 32, 32);
			BobRoss.drawText("Coords: (" + v.getPos().getX() + ", " + v.getPos().getY() +
			")", 32, 64);
		}
	}

	public boolean clicked(int button, String state) {
		while (Mouse.next()) {
			if (Mouse.getEventButtonState()) {
				if (Mouse.getEventButton() == button && state == "pressed") {
					System.out.println("registered press");
					return true;
				}
				return false;
			} else {
				if (Mouse.getEventButton() == button && state == "released") {
					System.out.println("registered release");
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Villager getSelectedVillager() {
		return selectedVillager;
	}

	public void setSelectedVillager(Villager selectedVillager) {
		this.selectedVillager = selectedVillager;
	}

}
