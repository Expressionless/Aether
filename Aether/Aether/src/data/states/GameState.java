package data.states;

import data.Game;
import data.helpers.Neo;
import data.states.gameState.world.Map;

public class GameState extends State {

	private Map map;

	public GameState(Game game, Map map) {
		super(game, "game");
	}

	public void init(Map map) {
		components.add(new Neo(32, 32, game));
	}
	
	@Override
	public void tick() {
		if (this == game.getCurrentState()) {
			if(map!=null) map.tick();
			for (int i = 0; i < components.size(); i++) {
				components.get(i).tick();
			}
		}
	}

	@Override
	public void render() {
		if (this == game.getCurrentState()) {
			if (map != null)
				map.render();
			for (int i = 0; i < components.size(); i++) {
				components.get(i).render();
			}
		}
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}
