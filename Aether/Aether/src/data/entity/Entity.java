package data.entity;

import org.newdawn.slick.opengl.Texture;

import data.helpers.BobRoss;
import data.states.gameState.world.Chunk;
import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Entity {
	
	protected int width, height;
	protected Texture texture;
	private boolean first = true;
	
	protected Point pos;
	protected Chunk currentChunk;
	
	protected Map map;
	
	//private Tile initTile;
	
	public Entity(int id, float x, float y, int width, int height, String textureName, Map map) {
		//this.initTile = initTile;
		this.width = width;
		this.height = height;
		pos = new Point(x, y);
		this.texture = BobRoss.quickLoad(textureName);
		this.map = map;
	}
	public abstract void tick();
	
	public void entityTick() {
		if(first)
			first = false;
		else {
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
	public Chunk getCurrentChunk() {
		return currentChunk;
	}
	public void setCurrentChunk(Chunk currentChunk) {
		this.currentChunk = currentChunk;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}

}
