package data.enums;

public enum TileType {

	Grass("terrain/grass64", true), Dirt("terrain/dirt64", true), Water("water/64/full", false);
	
	public String textureName;
	public boolean walkable;
	
	//General tile data
	TileType(String textureName, boolean walkable) {
		this.textureName = textureName;
		this.walkable = walkable;
	}
	
}
