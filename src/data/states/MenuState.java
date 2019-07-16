package data.states;

import org.newdawn.slick.opengl.Texture;

import data.Game;
import data.helpers.BobRoss;
import data.menu.Image;
import data.states.menuState.buttons.Play;
import data.states.menuState.buttons.Quit;

public class MenuState extends State {

	Texture background = BobRoss.quickLoad("menu/menuColour");
	
	public void initComponents() {
		components.add(new Image(BobRoss.WIDTH/8*3, 48, 529, 148, "menu/title", game));
		components.add(new Play(BobRoss.WIDTH/2-160, BobRoss.HEIGHT/4, 320, 96, "menu/button64x64", game));
		components.add(new Quit(BobRoss.WIDTH/2-160, BobRoss.HEIGHT/4+200, 320,96, "menu/button64x64", game));
	}
	public MenuState(Game game) {
		super(game, "menu");
		initComponents();
	}

	@Override
	public void tick() {
		for(int i = 0; i < components.size(); i++)  {
			components.get(i).tick();
		}
	}

	@Override
	public void render() {
		BobRoss.drawQuadTex(background, 0, 0, 1280, 960);
		for(int i = 0; i < components.size(); i++)  {
			components.get(i).render();
		}
	}
}