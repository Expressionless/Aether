package data.states;

import java.util.ArrayList;

import data.Game;
import data.menu.Component;

public abstract class State {

	protected ArrayList<Component> components = new ArrayList<Component>();
	
	protected Game game;
	protected String name;
	
	public State(Game game, String name) {
		this.name = name;
		this.game = game;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void tick();
	public abstract void render();
	
}
