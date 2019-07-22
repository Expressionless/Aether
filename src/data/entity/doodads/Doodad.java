package data.entity.doodads;

import data.entity.Entity;
import data.enums.DoodadType;
import data.states.gameState.world.Map;
import data.util.Point;

public abstract class Doodad extends Entity {
	
	protected Point pos;
	protected DoodadType type;
	
	public Doodad(float x, float y, int width, int height, DoodadType type, Map map) {
		super(0, x, y, width, height, type.textureName, map, map.getGame());
		pos = super.getPos();
	}
	
	public void tick() {
		
	}

}
