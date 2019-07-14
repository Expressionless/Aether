package data.entity.doodads;

import data.enums.DoodadType;
import data.states.gameState.world.Map;

public abstract class Item extends Doodad {

	public Item(float x, float y, DoodadType type, Map map) {
		super(x, y, type.width, type.height, type, map);
	}

}
