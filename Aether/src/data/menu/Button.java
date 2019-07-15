package data.menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import data.Game;
import data.helpers.BobRoss;

public abstract class Button extends Component {

	public final int LEFT_BUTTON = 0, MIDDLE_BUTTON = 2, RIGHT_BUTTON = 1;
	
	private Texture texture;
	private String text;

	public abstract void tick();

	public Button(float x, float y, float width, float height, String textureName, String text, Game game) {
		super(x-width/2, y-height/2, width, height, game);
		this.texture = BobRoss.quickLoad(textureName);
		this.text = text;
	}

	public boolean clicked(int button) {
		boolean isXBounds = Math.abs(Mouse.getX() - (getX() + getWidth() / 2)) < getWidth() / 2;
		boolean isYBounds = Math.abs((BobRoss.HEIGHT - Mouse.getY()) - (getY() + getHeight() / 2)) < getHeight() / 2;
		if (isXBounds && isYBounds) {
			while (Mouse.next()){
			    if (Mouse.getEventButtonState()) {
			        if (Mouse.getEventButton() == 0) {
			            System.out.println("Left button pressed");
			        }
		            return false;
			    }else {
			        if (Mouse.getEventButton() == 0) {
			            System.out.println("Left button released");
			            return true;
			        }
		            return false;
			    }
			}
            return false;
			//if (Mouse.isButtonDown(button)) {
				//return true;
		//	} else return false;
		} else return false;
	}

	public Texture getTexture() {
		return texture;
	}

	public void render() {
		if(clicked(0))
			Color.red.bind();
		else if(!clicked(0))
			Color.white.bind();
		BobRoss.drawQuadTex(texture, x, y, width, height);
		BobRoss.drawText(text, x+width/2-text.length()*12,y+height/4);
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
