import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelLoader {
	public static void main(String[] args){
		System.out.println(new LevelLoader().loadLevel());
	}

	public Level loadLevel() {
		Map map = createMap();
		Level level = createLevel(map);
		return level;
	}

	private Map createMap() {
		ArrayList<char[]> charList = readMapFile();
		char[][] tileChars = new char[charList.size()][];
		for (int row = 0; row<tileChars.length; row++) {
			tileChars[row] = charList.get(row);
		}
		return new Map(tileChars);
	}

	private ArrayList<char[]> readMapFile() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("demoStage.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read stage file");
			System.exit(1);
		}

		return loopOverMapFile(fileScanner);
	}

	private ArrayList<char[]> loopOverMapFile(Scanner fileScanner) {
		ArrayList<char[]> charMap = new ArrayList<char[]>();
		while(fileScanner.hasNextLine()) {
			char[] c =fileScanner.nextLine().toCharArray();
			//System.out.println(c);
			charMap.add(c);
		}
		return charMap;
	}

	private Level createLevel(Map map) {
		char[][] charMap = map.getCharMap();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		for (int row = 0; row < charMap.length; row++) {
			for (int column = 0; column < charMap.length; column++) {
				Enemy enemy = getEnemy(charMap[row][column], column, row);
				if(enemy != null) {
					enemies.add(enemy);
				}
			}
		}

		Level level = new Level(map, enemies);
		return level;
	}

	private Enemy getEnemy(char tileChar, int column, int row) {
		Enemy enemy = null;
		switch(tileChar) {
		case 'x':
			return new Enemy();
		}
		return enemy;
	}
}