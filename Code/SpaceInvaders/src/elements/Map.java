package elements;

public class Map {
	private char[][] charMap;
	public Map(char[][] mapRepresentation) {
		this.charMap = mapRepresentation;
	}

	public char[][] getCharMap() {
		return charMap;
	}
	
	public String toString() {
		String str="";
		for (int i = 0; i < charMap.length; i++) {
			for (int j = 0; j < charMap[0].length; j++) {
				str+=charMap[i][j];
			}
			str+="\n";
		}
		return str;
	}
}