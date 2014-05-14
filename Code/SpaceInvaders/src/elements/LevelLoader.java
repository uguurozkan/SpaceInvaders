package elements;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelLoader {
	
	public static Level loadLevel(int x) {
		Level level = createLevel(x);
		return level;
	}

	private static ArrayList<char[]> createMap(int x) {
		ArrayList<char[]> charList = readMapFile();
		char[][] tileChars = new char[charList.size()][];
		for (int row = 0; row<tileChars.length; row++) {
			tileChars[row] = charList.get(row);
		}
		return charList;
	}

	private static ArrayList<char[]> readMapFile() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("demoStage.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read stage file");
			System.exit(1);
		}

		return loopOverMapFile(fileScanner);
	}

	private static ArrayList<char[]> loopOverMapFile(Scanner fileScanner) {
		ArrayList<char[]> charMap = new ArrayList<char[]>();
		while(fileScanner.hasNextLine()) {
			char[] c =fileScanner.nextLine().toCharArray();
			charMap.add(c);
		}
		return charMap;
	}

	private static Level createLevel(int x) {
		ArrayList<char[]> charMap = createMap(x);
		ArrayList<Alien> alienEntities = new ArrayList<Alien>();
		ArrayList<Barrier>barrierEntities = new ArrayList<Barrier>();
		for (int row = 0; row < charMap.size(); row++) {
			for (int column = 0; column < charMap.get(0).length; column++) {
				Entity entity = getEntity(charMap.get(row)[column], row, column);
				if(entity != null) {
					if(entity instanceof Alien)
						alienEntities.add((Alien) entity);
					else
						barrierEntities.add((Barrier) entity);
				}
			}
		}

		Level level = new Level();
		level.setAlliens(alienEntities);
		level.setBarriers(barrierEntities);
		return level;
	}

	private static Entity getEntity(char tileChar, int row, int column) {
		Entity entity = null;
		switch(tileChar) {
		case 'x':
			return new Alien(row, column);
		case 'b':
			return new Barrier(row, column);
		}
		return entity;
	}
	
}