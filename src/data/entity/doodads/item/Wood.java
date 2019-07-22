package data.entity.doodads.item;

import data.entity.doodads.Item;
import data.enums.ItemType;
import data.states.gameState.world.Map;

public class Wood extends Item {

	public Wood(float x, float y, Map map) {
		super(x, y, ItemType.Wood, map);
	}
}
