package data.enums;

import data.entity.Mob;

public enum VillagerType {

	Woodcutter("entity/villager/woodcutter64", Mob.MOB_WIDTH, Mob.MOB_HEIGHT, true, 0.5f);
	
	public String textureName;
	public boolean controllable;
	public int width, height;
	public float speed;
	
	//General tile data
	VillagerType(String textureName, int width, int height, boolean controllable, float speed) {
		this.textureName = textureName;
		this.controllable = controllable;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
}
