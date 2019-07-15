package data;

import data.states.GameState;
import data.states.MenuState;
import data.states.State;

public class Game {

	private String currentStateString;

	private State currentState;
	private State menuState, gameState;

	public Game(String s) {
		currentStateString = s;
		menuState = new MenuState(this);
		gameState = new GameState(this);
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
		}
		System.out.println("Changed State to " + currentState.getName());
	}
	public void setCurrentState(State state) {
		currentState = state;
		System.out.println("Changed State to " + currentState.getName());
		
	}

	public void tick() {
		if (currentState != null)
			currentState.tick();
	}

	public void render() {
		if (currentState != null)
			currentState.render();
	}


	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}
}
