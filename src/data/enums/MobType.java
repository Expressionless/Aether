package data.enums;

import data.entity.Mob;

public enum MobType {
	Zombie("entity/zombie/zombie64", false, Mob.MOB_WIDTH, Mob.MOB_HEIGHT, 0.5f);
	
	
	//Speed: Tiles/Second
	public String textureName;
	public int width, height;
	public boolean passive;
	
	public float speed;

	// General Mob data
	MobType(String textureName, boolean passive, int width, int height, float speed) {
		this.textureName = textureName;
		this.passive = passive;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
}
