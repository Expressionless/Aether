package data;

import java.util.ArrayList;

import data.menu.Component;
import data.menu.Text;

public class UI extends Component {

	ArrayList<Component> components;

	public boolean loaded = false;

	public boolean addComponent(Component c) {
		components.add(c);
		return true;
	}

	public Component getComponent(Component c) {
		for (int i = 0; i < components.size(); i++) {
			if (components.get(i).equals(c)) {
				return components.get(i);
			}
		}
		return null;
	}

	public UI(float x, float y, float width, float height, Game game) {
		super(x, y, width, height, "UI", game);
		components = new ArrayList<Component>();
		loaded = true;
	}

	public void initUI() {
		Component objectCount = new Text(300, 300, "Object Count: ", 24, game);
		addComponent(objectCount);
	}

	public void updateInfo() {
		// info[0] = "Position: (" + pos.getX() + "," + pos.getY() + ")";
		ArrayList<String> info = new ArrayList<String>();
		info.add("Test");
		for (int i = 0; i < info.size(); i++) {
			new Text(32, 32 + i * 26, info.get(i), 24, game);
		}
	}

	public void render() {
		for (int i = 0; i < components.size(); i++) {
			components.get(i).render();
		}
	}

	public void tick() {
		updateInfo();
		for (int i = 0; i < components.size(); i++) {
			components.get(i).tick();
		}
	}
}
