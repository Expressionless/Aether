package data;

import org.lwjgl.opengl.Display;

import data.helpers.BobRoss;
import data.helpers.DrStrange;

public class Boot {

	Game game;
	
	public Boot() {

		BobRoss.beginSession();
		
		game = new Game("menu");
		while (!Display.isCloseRequested()) {
			DrStrange.update();
			game.tick();
			
			game.render();
			Display.update();
			Display.sync(60);
		}

		Display.destroy();
		System.exit(0);
	}

	public static void main(String[] args) {
		new Boot();
	}

}
