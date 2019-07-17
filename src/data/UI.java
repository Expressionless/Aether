package data;

import java.util.ArrayList;

import data.menu.Component;

public class UI extends Component {

	ArrayList<Component> components;

	public boolean loaded = false;
	
	public boolean addComponent(Component c) {
		components.add(c);
		return true;
	}
	
	public Component getComponent(Component c) {
		for(int i = 0; i < components.size(); i++) {
			if(components.get(i).equals(c)) {
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

	public void render() {
		for (int i = 0; i < components.size(); i++) {
			components.get(i).render();
		}
	}

	public void tick() {
		for (int i = 0; i < components.size(); i++) {
			components.get(i).render();
		}
	}
}
