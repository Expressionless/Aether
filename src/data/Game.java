package data;

import data.helpers.BobRoss;
import data.helpers.Neo;
import data.states.GameState;
import data.states.MenuState;
import data.states.State;

public class Game {

	private String currentStateString;

	
	private State currentState;
	private State menuState, gameState;

	private UI ui = null;
	private Neo mouse = null;

	public Game(String s) {
		while (ui == null) {
			ui = new UI(0, 0, BobRoss.WIDTH, BobRoss.HEIGHT, this);
		}
		while(mouse == null) {
			mouse = new Neo(32,32,this);
		}
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

	public UI getUI() {
		return ui;
	}

	public void setUI(UI ui) {
		this.ui = ui;
	}

	public Neo getMouse() {
		return mouse;
	}
}
