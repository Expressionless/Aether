package data.entity.doodads;

import data.enums.DoodadType;
import data.states.gameState.world.Map;

public class Tree extends Doodad {
	
	public Tree(float x, float y, Map map) {
		super(x, y, DoodadType.Tree.width, DoodadType.Tree.height, DoodadType.Tree, map);
	}

	public void tick() {
		
	}

}
