package data;

import data.states.GameState;
import data.states.MenuState;
import data.states.State;

public class Game {

	private String currentStateString;

	private State currentState;
	private State gameState, menuState;

	public Game(String s) {
		currentStateString = s;
		menuState = new MenuState(this);
		setCurrentState(s);
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String state) {
		currentStateString = state;
		switch (currentStateString) {
		case "menu":
			if (currentState != menuState)
				currentState = menuState;
			break;
		case "game":
			if(gameState == null)
				gameState = new GameState(this, map);
			if (currentState != gameState)
				currentState = gameState;
			break;
		}
		System.out.println("Changed State to " + currentState.getName());
	}

	public void tick() {
		if(currentState != null) currentState.tick();
	}

	public void render() {
		if(currentState != null) currentState.render();
	}

}
