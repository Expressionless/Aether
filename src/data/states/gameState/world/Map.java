package data.states.gameState.world;

import java.util.ArrayList;
import java.util.Random;

import data.Game;
import data.entity.Entity;
import data.entity.Mob;
import data.entity.hostile.Zombie;
import data.entity.user.types.Woodcutter;
import data.helpers.BobRoss;

public class Map {

	private static ArrayList<Entity> entities;

	public static final int CHUNK_SIZE = 8;

	private Chunk[][] chunks;

	private Game game;

	public Map(Game game) {
		chunks = generateChunkData(CHUNK_SIZE, BobRoss.WIDTH, BobRoss.HEIGHT, this);
		if (chunks.length == 0)
			System.out.println("Failed to Generate Map!");
		this.game = game;
	}

	public Map(Chunk[][] chunks, Game game) {
		this.chunks = chunks;
		this.game = game;
		spawnMob("woodcutter",32,32);
	}

	public static Map generateMap(int chunkSize, int width, int height, Game game) {
		System.out.println("Generating new map with: ");
		System.out.println("ChunkSize: " + chunkSize);
		System.out.println("Dimensions: " + width + "," + height);

		entities = new ArrayList<Entity>();

		Map m = new Map(new Chunk[chunkSize / width][chunkSize / height], game);
		m.setChunks(generateChunkData(chunkSize, width, height, m));
		return m;
	}

	public void tick() {
		updateChunks();
	}

	public void render() {
		renderChunks();
		renderEntities();
	}

	public void updateEntities() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).entityTick();
		}
	}

	public void updateChunks() {
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				chunks[i][j].tick();
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).entityTick();
		}
	}

	public void renderEntities() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render();
		}
	}

	public void renderChunks() {
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				chunks[i][j].renderTerrain();
			}
		}
	}

	public static Chunk[][] generateChunkData(int chunkSize, int width, int height, Map map) {
		int chunkWidth = CHUNK_SIZE * BobRoss.TILE_WIDTH;
		int chunkHeight = CHUNK_SIZE * BobRoss.TILE_HEIGHT;
		int chunksX = (int) Math.ceil((double) width / (double) chunkWidth);
		int chunksY = (int) Math.ceil((double) height / (double) chunkHeight);
		Chunk[][] chunks = new Chunk[chunksX][chunksY];
		float progress = 0;
		float increment = 100f / (chunks.length * chunks[0].length);
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				Random r = new Random();
				chunks[i][j] = new Chunk(i * chunkWidth, j * chunkHeight, r.nextInt(3), map);
				progress += increment;
				System.out.println("Generating Map!" + progress);
			}
		}
		System.out.println("Created new Map with data: ");
		System.out.println("Chunks: " + chunks.length * chunks[0].length);
		return chunks;
	}

	public Mob spawnMob(String mob, float x, float y) {
		Mob entity;
		
		switch (mob.toUpperCase()) {
		case "WOODCUTTER":
			entity = new Woodcutter(0, x, y, this);
			entities.add(entity);
			return entity;
		case "ZOMBIE":
			entity = new Zombie(0, x, y, this);
			entities.add(entity);
			return entity;
		default:
			System.out.println("Failed to spawn mob at " + x + ", " + y + "!");
			return null;
		}
	}

	public Chunk[][] getChunks() {
		return chunks;
	}

	public void setChunks(Chunk[][] chunks) {
		this.chunks = chunks;
	}

	public static ArrayList<Entity> getEntities() {
		return entities;
	}

	public static void setEntities(ArrayList<Entity> entities) {
		Map.entities = entities;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
