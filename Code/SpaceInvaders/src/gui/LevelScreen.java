package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelScreen extends JPanel {
	public LevelScreen() {
		setSize(900, 500);
		JLabel level = new JLabel("Level " + 1);
		setLayout(new BorderLayout());
		level.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 40));
		level.setPreferredSize(level.getPreferredSize());
		level.setHorizontalAlignment(JLabel.CENTER);
		add(level, BorderLayout.CENTER);
	}

}
