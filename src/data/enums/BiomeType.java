package data.enums;

public enum BiomeType {

	Water("1,1,1,1,1,0");
	
	public int[] tiles;
	
	//General tile data
	BiomeType(String input) {
		String[] temp = input.split(",");
		
		tiles = new int[temp.length];
		try {
			for(int i = 0; i < tiles.length; i++) {
				tiles[i] = Integer.parseInt(temp[i]);
			}
		} catch(NumberFormatException e) {
			System.err.println("Invalid biome");
			e.printStackTrace();
		}
	}
	
}
