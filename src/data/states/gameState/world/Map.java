package data.states.gameState.world;

import java.util.ArrayList;
import java.util.Random;

import data.entity.Entity;
import data.entity.Mob;
import data.entity.user.types.Woodcutter;
import data.helpers.BobRoss;

public class Map {

	public static ArrayList<Entity> entities;

	public static final int CHUNK_SIZE = 20;

	private Chunk[][] chunks;

	public Map() {
		chunks = generateChunkData(CHUNK_SIZE, BobRoss.WIDTH, BobRoss.HEIGHT, this);
		if (chunks.length == 0)
			System.out.println("Failed to Generate Map!");
	}

	public Map(Chunk[][] chunks) {
		this.chunks = chunks;
	}

	public static Map generateMap(int chunkSize, int width, int height) {
		System.out.println("Generating new map with: ");
		System.out.println("ChunkSize: " + chunkSize);
		System.out.println("Dimensions: " + width + "," + height);

		entities = new ArrayList<Entity>();

		Map m = new Map(new Chunk[chunkSize / width][chunkSize / height]);
		m.setChunks(generateChunkData(chunkSize, width, height, m));
		return m;
	}

	public void tick() {
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				chunks[i][j].tick();
			}
		}
	}

	public void render() {
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				chunks[i][j].renderTerrain();
			}
		}
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				chunks[i][j].renderEntities();
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

	public Chunk[][] getChunks() {
		return chunks;
	}

	public void setChunks(Chunk[][] chunks) {
		this.chunks = chunks;
	}

	public Mob spawnMob(String mob, float x, float y) {
		int xPos, yPos;
		Mob entity;
		Random r = new Random();
		xPos = r.nextInt(CHUNK_SIZE);
		yPos = r.nextInt(CHUNK_SIZE);
		switch (mob.toUpperCase()) {
		case "WOODCUTTER":
			entity = new Woodcutter(0, x + xPos * BobRoss.TILE_WIDTH, y + yPos * BobRoss.TILE_HEIGHT, this);
			entities.add(entity);
			return entity;
		case "ZOMBIE":
			entity = new Woodcutter(0, x + xPos * BobRoss.TILE_WIDTH, y + yPos * BobRoss.TILE_HEIGHT, this);
			entities.add(entity);
			return entity;
		default:
			return null;
		}
	}

}
