package data.tile;

import data.enums.TileType;
import data.helpers.BobRoss;

public class TileGrid {

	public Tile[][] map;
	public boolean loaded;;
	
	private int width, height;

	public TileGrid(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		map = new Tile[width][height];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(x + i * BobRoss.TILE_WIDTH,y + j * BobRoss.TILE_HEIGHT, BobRoss.TILE_WIDTH, BobRoss.TILE_HEIGHT, TileType.Dirt, this);
			}
		}
		loaded = true;
	}
	
	public TileGrid(float x, float y, int width, int height, int[][] newMap) {
		this.width = width;
		this.height = height;
		map = new Tile[width][height];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				switch(newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(x + i * BobRoss.TILE_WIDTH, y + j * BobRoss.TILE_HEIGHT, BobRoss.TILE_WIDTH, BobRoss.TILE_HEIGHT, TileType.Dirt, this);
					break;
				case 1:
					map[i][j] = new Tile(x + i * BobRoss.TILE_WIDTH, y + j * BobRoss.TILE_HEIGHT, BobRoss.TILE_WIDTH, BobRoss.TILE_HEIGHT, TileType.Grass, this);
					break;
				case 2:
					map[i][j] = new Tile(x + i * BobRoss.TILE_WIDTH, y + j * BobRoss.TILE_HEIGHT, BobRoss.TILE_WIDTH, BobRoss.TILE_HEIGHT, TileType.Water, this);
					break;
				}
				
			}
		}
		loaded = true;
	}
	
	public void render() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j].draw();
			}
		}
	}
	
	public void tick() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j].tick();
			}
		}
	}
	
	public void setTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord * BobRoss.TILE_WIDTH, yCoord * BobRoss.TILE_HEIGHT, BobRoss.TILE_WIDTH, BobRoss.TILE_HEIGHT, type, this);
	}
	
	public Tile getTile(int xCoord, int yCoord) {
		return map[xCoord][yCoord];
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
