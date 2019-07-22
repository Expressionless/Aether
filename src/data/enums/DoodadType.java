package data.enums;

public enum DoodadType {
	Item("doodad/missingtex", 24, 24, false), Tree("doodad/tree64", 64, 64, true);
	//Speed: Tiles/Second
	public String textureName;
	public int width, height;
	public boolean breakable;

	// General Mob data
	DoodadType(String textureName, int width, int height, boolean breakable) {
		this.textureName = textureName;
		this.width = width;
		this.height = height;
		this.breakable = breakable;
	}
}
