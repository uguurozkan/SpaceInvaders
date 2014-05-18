package elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelLoader {

	private int levelNo;
	private static LevelLoader instance;

	private LevelLoader() {
		levelNo = 0;
		instance = this;
	}

	public static LevelLoader getInstance() {
		if (instance == null)
			new LevelLoader();

		return instance;
	}

	public Level loadNextLevel() {
		Level level = new Level();
		ArrayList<char[]> charMap = createMap();
		for (int row = 0; row < charMap.size(); row++) {
			for (int col = 0; col < charMap.get(0).length; col++) {
				Entity entity = Entity.getEntity(charMap.get(row)[col], row, col);
				if (entity == null)
					continue;
				addEntityToLevel(entity, level);
			}
		}
		return level;
	}

	private ArrayList<char[]> createMap() {
		ArrayList<char[]> charList = readMapFile();
		char[][] tileChars = new char[charList.size()][];
		for (int row = 0; row < tileChars.length; row++) {
			tileChars[row] = charList.get(row);
		}
		return charList;
	}

	private ArrayList<char[]> readMapFile() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("demoStage_" + (levelNo++) + ".txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read stage file");
			System.exit(1);
		}

		return loopOverMapFile(fileScanner);
	}

	private ArrayList<char[]> loopOverMapFile(Scanner fileScanner) {
		ArrayList<char[]> charMap = new ArrayList<char[]>();
		while (fileScanner.hasNextLine()) {
			char[] tileRow = fileScanner.nextLine().toCharArray();
			charMap.add(tileRow);
		}
		return charMap;
	}

	private void addEntityToLevel(Entity entity, Level level) {
		if (entity instanceof Alien)
			level.addAllien((Alien) entity);
		else if (entity instanceof Barrier)
			level.addBarrier((Barrier) entity);
		else
			throw new IllegalArgumentException("Unexpected entity");
	}
}