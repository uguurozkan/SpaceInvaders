package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelScreen extends JPanel{
	public LevelScreen(GameWindow gameWindow){
		JLabel level = new JLabel("Level " + 1);
		level.setFont(new Font(Font.DIALOG, Font.BOLD|Font.ITALIC, 20));
		level.setPreferredSize(level.getPreferredSize());
		level.setHorizontalAlignment(JLabel.CENTER);
		this.add(level);
	}
	

}
