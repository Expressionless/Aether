package data.tile;

import org.newdawn.slick.opengl.Texture;

import data.enums.TileType;
import data.helpers.BobRoss;

public class Tile {

	private float x, y, width, height;
	private Texture texture;
	private TileType type;
	private TileGrid tg;
	//private int[][] nearby;
	//private int waterCount = 0;

	final Texture[] CORNER = { BobRoss.quickLoad("water/64/halftl"), // TOP LEFT
			BobRoss.quickLoad("water/64/halftr"), // TOP RIGHT
			BobRoss.quickLoad("water/64/halfbl"), // BOTTOM LEFT
			BobRoss.quickLoad("water/64/halfbr"), // BOTTOM RIGHT
	};

	public Tile(float x, float y, float width, float height, TileType type, TileGrid tg) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.tg = tg;

		this.texture = BobRoss.quickLoad(type.textureName);
	}

	public int[][] findNearbyTiles() {
		int[][] grid = { { 0, 0, 0 }, { 0, 2, 0 }, { 0, 0, 0 } };
		int xCoord = (int) (x / width);
		int yCoord = (int) (y / height);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				try {
					TileType t = tg.getTile(xCoord - 1 + j, yCoord - 1 + i).getType();
					if (t == TileType.Water) {
						grid[j][i] = 2;
					}
				} catch (NullPointerException e) {
					System.err.println("Invalid COORD:" + (xCoord - 1 + j) + " " + (yCoord - 1 + j));
					e.printStackTrace();
				}
			}
		}
		return grid;
	}

	public void tick() {
		/*if (type == TileType.Water) {
			if(nearby == null)
				nearby = findNearbyTiles();
			int temp = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					try {
						if (nearby[i][j] == 2)
							temp++;
					} catch (NullPointerException e) {
						System.err.println("Illegal: " + i + " " + j + "for" + type.textureName);
						e.printStackTrace();
					}
				}
			}
			waterCount = temp;
		}
		if (waterCount > 2) {
			boolean topLeft = (nearby[0][1] == 2 && nearby[1][0] == 2 && nearby[0][0] != 2);
			boolean topRight = (nearby[2][1] == 2 && nearby[1][0] == 2 && nearby[2][0] != 2);
			boolean bottomLeft = (nearby[0][1] == 2 && nearby[1][2] == 2 && nearby[0][2] != 2);
			boolean bottomRight = (nearby[2][1] == 2 && nearby[1][2] == 2 && nearby[2][2] != 2);
			if (topLeft)
				BobRoss.drawQuadTex(CORNER[0], x - width, y - height, width, height);
			if (topRight)
				BobRoss.drawQuadTex(CORNER[1], x + width, y - height, width, height);
			if (bottomLeft)
				BobRoss.drawQuadTex(CORNER[2], x - width, y + height, width, height);
			if (bottomRight)
				BobRoss.drawQuadTex(CORNER[3], x + width, y + height, width, height);
		}*/
	}

	public void draw() {
		BobRoss.drawQuadTex(texture, x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

}
