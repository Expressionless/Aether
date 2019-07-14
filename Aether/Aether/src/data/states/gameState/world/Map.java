package data.states.gameState.world;

import static data.states.gameState.generators.MapGenerator.CHUNK_SIZE;

import java.util.Random;

import data.helpers.BobRoss;

public class Map {

	private Chunk[][] chunks;

	public Map() {
		System.out.println("Generating Map");
		float progress = 0;
		int maxChunksX = (int) Math.ceil((double)BobRoss.WIDTH / (double)(CHUNK_SIZE * BobRoss.TILE_WIDTH));
		int maxChunksY = (int) Math.ceil((double)BobRoss.HEIGHT / (double)(CHUNK_SIZE * BobRoss.TILE_HEIGHT));
		chunks = new Chunk[maxChunksX][maxChunksY];
		float increment = 100f / (chunks.length * chunks[0].length);
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				Random r = new Random();
				chunks[i][j] = new Chunk(i * CHUNK_SIZE * BobRoss.TILE_WIDTH, j * CHUNK_SIZE * BobRoss.TILE_HEIGHT, r.nextInt(3), this);
				progress += increment;
				System.out.println("Generating Map!" + progress);
			}
		}
	}

	public Map(Chunk[][] chunks) {
		System.out.println("Generating Map");
		this.chunks = chunks;
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

	public Chunk[][] getChunks() {
		return chunks;
	}

	public void setChunks(Chunk[][] chunks) {
		this.chunks = chunks;
	}

}
