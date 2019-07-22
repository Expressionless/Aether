package data.enums;

public enum ItemType {
	
	Wood(0, "doodad/item/wood24", 24, 24, 2.0); //24x24 image. Basic wood, weighs 2.0kg
	
	public String textureName;
	public int width, height;
	public double weight;
	
	public final int ID;
	
	private ItemType(int ID, String textureName, int width, int height, double weight) {
		this.ID = ID;
		
		this.textureName = textureName;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}
	
}