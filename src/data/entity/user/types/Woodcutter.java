package data.entity.user.types;

import java.util.ArrayList;

import data.entity.Entity;
import data.entity.doodads.Item;
import data.entity.doodads.Tree;
import data.entity.user.Villager;
import data.enums.VillagerType;
import data.helpers.BobRoss;
import data.menu.Text;
import data.states.gameState.world.Chunk;
import data.states.gameState.world.Map;
import data.util.Point;

public class Woodcutter extends Villager {

	VillagerType type = VillagerType.Woodcutter;

	ArrayList<Text> UIText;

	String[] info = {};// { "Position: ", "Target Tree: " };

	private Entity target = null;

	public Woodcutter(int id, float x, float y, Map map) {
		super(id, x, y, VillagerType.Woodcutter.width, VillagerType.Woodcutter.height,
				VillagerType.Woodcutter.textureName, VillagerType.Woodcutter.speed, map);
		// TODO Auto-generated constructor stub
		UIText = new ArrayList<Text>();
	}

	@Override
	public void manageState() { //Manage the Woodcutters State
		switch (state.toUpperCase()) {
		case "IDLE":

			break;
		case "WORK":
			work();
			break;
		case "CHOPPING":

			break;
		case "COLLECTING":

			if (map.getItems().size() > 0) {
				target = findClosestItem();
				if (pickup((Item) target) == ERR_NOT_IN_RANGE) {
					moveTo(target.getPos());
				}
			}

			break;
		}
	}

	public void work() {
		if (map.getItems().size() == 0) {
			target = findClosestTree();
			if (harvest(target) == ERR_NOT_IN_RANGE) {
				moveTo(target.getPos());
			}
		} else {
			state = "collecting";
		}
	}

	@Override
	public void render() {
		BobRoss.drawQuadTex(texture, pos.getX(), pos.getY(), width, height);
		if (target != null) {
			double distance = Point.findDistanceTo(getPos(), target.getPos());
			BobRoss.drawText(Double.toString(distance), target.getPos().getX(), target.getPos().getY());
		}
	}

	// Tree Find Code
	public Tree findClosestTree() {
		int[] chunkCoord = getChunkCoord();
		ArrayList<Tree> trees;
		if (map != null) {
			Chunk[][] chunks = map.getChunks();
			Chunk chunk = chunks[(int) Math.abs(chunkCoord[0] - 1)][(int) Math.abs(chunkCoord[1] - 1)];
			trees = chunk.getTrees();
			Tree closestTree = trees.get(0);

			for (int i = 0; i < trees.size(); i++) {
				Point closestPos = closestTree.getPos();
				Point nextPos = trees.get(i).getPos();
				double currentDistance = Point.findDistanceTo(getPos(), closestPos);
				double newDistance = Point.findDistanceTo(getPos(), nextPos);
				if (newDistance < currentDistance) {
					closestTree = trees.get(i);
				}
			}
			return closestTree;
		}
		return null;
	}

	// Item Find Code
	public Item findClosestItem() {
		Item closestItem = null;
		if (map != null) {
			ArrayList<Item> items = map.getItems();
			closestItem = items.get(0);
			for (int i = 0; i < items.size(); i++) {
				Point closestPos = closestItem.getPos();
				Point nextPos = items.get(i).getPos();
				double currentDistance = Point.findDistanceTo(getPos(), closestPos);
				double newDistance = Point.findDistanceTo(getPos(), nextPos);
				if (newDistance < currentDistance) {
					closestItem = items.get(i);
				}
			}
		}
		return closestItem;
	}
}