package data.entity.hostile;

import data.entity.Mob;
import data.enums.MobType;
import data.states.gameState.world.Map;

public class Zombie extends Mob {

	MobType type = MobType.Zombie;
	
	public Zombie(int id, float x, float y, Map map) {
		super(id, x, y, MobType.Zombie.width, MobType.Zombie.height, MobType.Zombie.textureName, MobType.Zombie.speed, map);
	}

	@Override
	public void tick() {
		
	}

}
