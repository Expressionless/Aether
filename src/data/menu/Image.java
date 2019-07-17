package data.menu;

import org.newdawn.slick.opengl.Texture;

import data.Game;
import data.helpers.BobRoss;
import data.util.Point;

public class Image extends Component {

	private Point pos;
	private Texture tex;
	private int width, height;
	
	public Image(float x, float y, int width, int height, String textureName, Game game) {
		super(x, y, width, height, "image", game);
		tex = BobRoss.quickLoad(textureName);
		pos = new Point(x, y);
		this.width = width;
		this.height = height;
	}
	
	public void render() {
		BobRoss.drawQuadTex(tex, pos.getX(), pos.getY(), width, height);
	}
	
	public Point getPos() {
		return pos;
	}



	public void setPos(Point pos) {
		this.pos = pos;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
