package data.states;

import data.Game;
import data.helpers.BobRoss;
import data.states.gameState.generators.MapGenerator;
import data.states.gameState.world.Map;

public class LoadState extends State {

	String saveName;

	private Game game;
	
	public LoadState(Game game, int state, String[] args) {
		super(game, "load");
		switch (state) 
		{
		case 0:
			saveName = args[0];
			break;
		case 1:
			switch (args[0]) 
			{
			case "goto":
				switch(args[1])
				{
				case "game":
					Map m = MapGenerator.generateMap(MapGenerator.CHUNK_SIZE, BobRoss.TILE_WIDTH, BobRoss.TILE_HEIGHT);
					game.setCurrentState("game", m);
					break;
				case "menu":
					break;
				}
				break;
			}
			
			break;
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
