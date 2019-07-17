package data.entity.user.types;

import java.util.ArrayList;

import data.entity.doodads.Doodad;
import data.entity.doodads.Tree;
import data.entity.user.Villager;
import data.enums.VillagerType;
import data.menu.Component;
import data.menu.Text;
import data.states.gameState.world.Chunk;
import data.states.gameState.world.Map;
import data.util.Point;

public class Woodcutter extends Villager {

	VillagerType type = VillagerType.Woodcutter;

	ArrayList<Text> UIText;

	String[] info = {};//{ "Position: ", "Target Tree: " };

	public Woodcutter(int id, float x, float y, Map map) {
		super(id, x, y, VillagerType.Woodcutter.width, VillagerType.Woodcutter.height,
				VillagerType.Woodcutter.textureName, VillagerType.Woodcutter.speed, map);
		// TODO Auto-generated constructor stub
		UIText = new ArrayList<Text>();
		for (int i = 0; i < info.length; i++) {
			int size = 24;
			//Component text = new Text(32, 32 + i * (size + 32), info[i], size, map.getGame().getUI());
			//UIText.add((Text) text);
		}
	}

	public void updateInfo() {
		//info[0] = "Position: (" + pos.getX() + "," + pos.getY() + ")";
		for (int i = 0; i < UIText.size(); i++) {
			UIText.get(i).setPos(new Point(32, 32 + i * 64));
			UIText.get(i).setText(info[i]);
		}
	}

	@Override
	public void work() {
		updateInfo();
		Doodad target = findClosestTree();
		if (target != null) {
			float targetX = target.getPos().getX();
			float targetY = target.getPos().getY();
			//info[1] = "Target Tree: (" + targetX + "," + targetY + ")";
			//UIText.get(1).setPos(new Point(targetX-32, targetY));
			double disTo = Point.findDistanceTo(getPos(), target.getPos());
			if(disTo>32) {
				
			}
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
				if (Point.findDistanceTo(getPos(), closestPos) < Point.findDistanceTo(getPos(), nextPos)) {
					closestTree = trees.get(i);
				}
				return closestTree;
			}
		}
		return null;
	}
}