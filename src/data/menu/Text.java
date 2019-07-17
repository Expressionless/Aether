package data.menu;

import org.newdawn.slick.TrueTypeFont;

import data.Game;
import data.UI;
import data.helpers.BobRoss;

public class Text extends Component {

	private String text;
	
	private int size;

	public Text(float x, float y, String text, int size, Game game) {
		super(x, y, 1, 1, "text", game);
		this.text = text;
		this.size = size;
	}

	public Text(float x, float y, String text, int size, UI ui) {
		super(x, y, 1, 1, "text", ui);
		this.text = text;
		this.size = size;
		ui.addComponent(this);
	}

	@Override
	public void render() {
		TrueTypeFont font = BobRoss.prepareFont("Times New Roman", size);
		BobRoss.drawText(text, pos.getX(), pos.getY(), font);
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
