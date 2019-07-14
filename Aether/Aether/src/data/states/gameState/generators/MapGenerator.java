package data.states.gameState.generators;

import data.helpers.BobRoss;
import data.states.gameState.world.Chunk;
import data.states.gameState.world.Map;

public class MapGenerator {

	public static final int CHUNK_SIZE = 16;

	public MapGenerator() {

	}

	public static Chunk[][] generateChunkData(int chunkSize, int width, int height, Map map) {
		int chunkWidth = CHUNK_SIZE * BobRoss.TILE_WIDTH;
		int chunkHeight = CHUNK_SIZE * BobRoss.TILE_HEIGHT;
		Chunk[][] chunks = new Chunk[width / chunkWidth][height / chunkHeight];
		float progress = 0;
		float increment = 100f/(chunks.length*chunks[0].length);
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				chunks[i][j] = new Chunk(i * chunkWidth, j * chunkHeight, 0,map);
				progress+=increment;
				System.out.println("Generating Map!" + progress);
			}
		}
		System.out.println("Created new Map with data: ");
		System.out.println("Chunks: " + chunks.length * chunks[0].length);
		return chunks;
	}
	
	public static Map generateMap(int chunkSize, int width, int height) {
		Map m = new Map();
		m.setChunks(generateChunkData(chunkSize, width, height, m));
		return m;
	}
}
