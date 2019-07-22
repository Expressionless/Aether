package data.entity.user;

import data.entity.Mob;
import data.states.gameState.world.Map;

public abstract class Villager extends Mob {

	private String role;

	public Villager() {
		super(0, 0, 0, 0, 0, null, 0, null);
	}

	public Villager(int id, float x, float y, int width, int height, String textureName, float speed, Map map) {
		super(id, x, y, width, height, textureName, speed, map);
		String[] temp = textureName.split("/");
		role = temp[temp.length-1];
		role = role.substring(0, role.length()-2);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
