package data.states.gameState.world;

import static data.states.gameState.generators.MapGenerator.CHUNK_SIZE;

import java.util.ArrayList;
import java.util.Random;

import data.entity.Entity;
import data.entity.doodads.Tree;
import data.entity.hostile.Zombie;
import data.entity.user.types.Woodcutter;
import data.helpers.BobRoss;
import data.tile.TileGrid;

public class Chunk {

	private float x, y;

	private int id = 0;
	
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
		for (int i = 0; i < CHUNK_SIZE / 4; i++) {
			Random r = new Random();
			int xPos = r.nextInt(CHUNK_SIZE);
			int yPos = r.nextInt(CHUNK_SIZE);
			Entity tree = new Tree(x + xPos * BobRoss.TILE_WIDTH, y + yPos * BobRoss.TILE_HEIGHT, map);
			entities.add(tree);
			trees.add((Tree) tree);
			xPos = r.nextInt(CHUNK_SIZE);
			yPos = r.nextInt(CHUNK_SIZE);
			Entity zombie = new Zombie(id, x + xPos * BobRoss.TILE_WIDTH, y + yPos * BobRoss.TILE_HEIGHT, map);
			id++;
			entities.add(zombie);
			xPos = r.nextInt(CHUNK_SIZE);
			yPos = r.nextInt(CHUNK_SIZE);
			Entity villager = new Woodcutter(id, x + xPos * BobRoss.TILE_WIDTH, y + yPos * BobRoss.TILE_HEIGHT, map);
			id++;
			entities.add(villager);
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
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
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
