package data.entity.doodads;

import java.util.Collections;
import java.util.HashMap;

import data.enums.DoodadType;
import data.enums.ItemType;
import data.helpers.BobRoss;
import data.states.gameState.world.Map;

public abstract class Item extends Doodad {
	
	public static HashMap<String, Item> ITEM = new HashMap<String, Item>();
	public static final int ITEM_WIDTH = 24, ITEM_HEIGHT = 24;
	
	public Item(float x, float y, ItemType type, Map map) {
		super(x, y, ITEM_WIDTH, ITEM_HEIGHT, DoodadType.Item, map);
		map.getItems().add(this);
		texture = BobRoss.quickLoad(type.textureName);
	}
	
	public static void initItems() {
		Collections.unmodifiableMap(ITEM);
	}
	
}
