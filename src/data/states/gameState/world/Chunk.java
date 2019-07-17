package data.states.gameState.world;

import static data.states.gameState.world.Map.CHUNK_SIZE;

import java.util.ArrayList;
import java.util.Random;

import data.entity.Entity;
import data.entity.Mob;
import data.entity.doodads.Tree;
import data.helpers.BobRoss;
import data.tile.TileGrid;

public class Chunk {

	private float x, y;
	
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Tree> trees = new ArrayList<Tree>();

	private TileGrid terrain;
	private Map parentMap;
	
	public Chunk(float x, float y, int biome, Map map) {
		parentMap = map;
		this.x = x;
		this.y = y;
		int[][] terrainData = new int[CHUNK_SIZE][CHUNK_SIZE];
		for (int i = 0; i < terrainData.length; i++) {
			for (int j = 0; j < terrainData[i].length; j++) {
				terrainData[i][j] = biome;
			}
		}
		terrain = new TileGrid(x, y, CHUNK_SIZE, CHUNK_SIZE, terrainData);
		for (int i = 0; i < CHUNK_SIZE / 2; i++) {
			Random r = new Random();
			int xPos = r.nextInt(CHUNK_SIZE);
			int yPos = r.nextInt(CHUNK_SIZE);
			Entity tree = new Tree(x + xPos * BobRoss.TILE_WIDTH, y + yPos * BobRoss.TILE_HEIGHT, map);
			Map.getEntities().add(tree);
			trees.add((Tree) tree);
		}
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public Map getParentMap() {
		return parentMap;
	}

	public void tick() {
		terrain.tick();
	}

	public void renderTerrain() {
		terrain.render();
	}
	
	public void renderEntities() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render();
		}
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

	public TileGrid getTerrain() {
		return terrain;
	}

	public ArrayList<Tree> getTrees() {
		return trees;
	}

	public void setTrees(ArrayList<Tree> trees) {
		this.trees = trees;
	}
}
