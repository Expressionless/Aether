package data.menu;

import org.newdawn.slick.TrueTypeFont;

import data.Game;
import data.helpers.BobRoss;

public class Text extends Component {

	private String text;
	public Text(float x, float y, String text, int size, Game game) {
		super(x, y, 1, 1, game);
		this.text = text;
	}

	@Override
	public void render() {
		TrueTypeFont font = BobRoss.prepareFont("Times New Roman", 64);
		BobRoss.drawText(text, x, y, font);
	}

	@Override
	public void tick() {
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
