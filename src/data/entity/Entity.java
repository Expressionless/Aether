package data.entity;

import org.newdawn.slick.opengl.Texture;

import data.Game;
import data.helpers.BobRoss;
import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Entity {

	protected int width, height;
	protected Texture texture;
	private boolean first = true;

	protected Point pos;
	protected int[] chunkCoord = new int[2];

	protected long[] alarm = new long[10];
	
	protected Map map;
	protected Game game;

	public Entity(int id, float x, float y, int width, int height, String textureName, Map map, Game game) {
		this.game = game;
		this.width = width;
		this.height = height;
		pos = new Point(x, y);
		if(textureName != null) this.texture = BobRoss.quickLoad(textureName);
		this.map = map;

		// Init Chunk code
		int chunkX = (int) Math.ceil((double) x / (double) (Map.CHUNK_SIZE * BobRoss.TILE_WIDTH));
		int chunkY = (int) Math.ceil((double) y / (double) (Map.CHUNK_SIZE * BobRoss.TILE_HEIGHT));
		chunkCoord[0] = chunkX;
		chunkCoord[1] = chunkY;
	}

	protected abstract void tick();

	public void updateAlarms() {
		for(int i = 0; i < 10; i++) {
			if(alarm[i] > 0) {
				alarm[i] -= 1;
				System.out.println(alarm[i]);
			} else if (alarm[i] == 0) alarm[i] = -1;
		}
	}
	
	public void entityTick() {
		if (first)
			first = false;
		else {
			updateAlarms();
			tick();
		}

	}

	public void render() {
		BobRoss.drawQuadTex(texture, pos.getX(), pos.getY(), width, height);
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public int[] getChunkCoord() {
		return chunkCoord;
	}

	public void setChunkCoord(int[] chunkCoord) {
		this.chunkCoord = chunkCoord;
	}

}
