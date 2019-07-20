package data.entity.user.types;

import java.util.ArrayList;

import data.entity.doodads.Doodad;
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

	private Doodad target = null;

	public Woodcutter(int id, float x, float y, Map map) {
		super(id, x, y, VillagerType.Woodcutter.width, VillagerType.Woodcutter.height,
				VillagerType.Woodcutter.textureName, VillagerType.Woodcutter.speed, map);
		// TODO Auto-generated constructor stub
		UIText = new ArrayList<Text>();
	}

	public void updateInfo() {
		// info[0] = "Position: (" + pos.getX() + "," + pos.getY() + ")";
		for (int i = 0; i < UIText.size(); i++) {
			UIText.get(i).setPos(new Point(32, 32 + i * 64));
			UIText.get(i).setText(info[i]);
		}
	}

	@Override
	public void manageState() {
		switch (state) {
		case "idle":

			break;
		case "work":
			work();
			break;
		case "chopping":

			break;
		}
	}

	public void work() {
		updateInfo();
		target = findClosestTree();
		if (Point.findDistanceTo(target.getPos()) > 32.0) {
			moveTo(target.getPos());
		} else
			moveTo(getPos());
	}

	@Override
	public void render() {
		BobRoss.drawQuadTex(texture, pos.getX(), pos.getY(), width, height);
		if (target != null) {
			double distance = Point.findDistanceTo(target.getPos());
			BobRoss.drawText(Double.toString(distance), target.getPos().getX(), target.getPos().getY());
		}
	}

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
}