package data.states.menuState.buttons;

import data.Game;
import data.menu.Button;

public class Play extends Button {

	public Play(float x, float y, float width, float height, String textureName, Game game) {
		super(x, y, width, height, textureName, "PLAY", game);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void tick() {
		if(clicked(LEFT_BUTTON)) {
			game.setCurrentState("game");
		}
	}
	
}
