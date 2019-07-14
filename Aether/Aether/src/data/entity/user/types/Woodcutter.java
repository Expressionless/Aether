package data.entity.user.types;

import java.util.ArrayList;

import data.entity.doodads.Doodad;
import data.entity.doodads.Tree;
import data.entity.user.Villager;
import data.enums.VillagerType;
import data.states.gameState.world.Chunk;
import data.states.gameState.world.Map;
import data.util.Point;

public class Woodcutter extends Villager {

	VillagerType type = VillagerType.Woodcutter;

	public Woodcutter(int id, float x, float y, Map map) {
		super(id, x, y, VillagerType.Woodcutter.width, VillagerType.Woodcutter.height,
				VillagerType.Woodcutter.textureName, VillagerType.Woodcutter.speed, map);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		Doodad target = findClosestTree();
		
	}

	public Tree findClosestTree() {
		Chunk chunk = getCurrentChunk();
		ArrayList<Tree> trees = chunk.getTrees();

		Tree closestTree = trees.get(0);

		for (int i = 0; i < trees.size(); i++) {
			Point closestPos = closestTree.getPos();
			Point nextPos = trees.get(i).getPos();
			if (Point.findDistanceTo(getPos(), closestPos) < Point.findDistanceTo(getPos(), nextPos)) {
				closestTree = trees.get(i);
			}
		}
		return closestTree;
	}
}