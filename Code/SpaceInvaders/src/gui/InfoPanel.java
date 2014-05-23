package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	public static final int WIDTH = 100;
	public static int HEIGHT = 640;

	private JLabel scoreLabel;
	private JLabel lifeLabel;
	private int score;
	private int life;

	public InfoPanel() {
		setLayout(new GridLayout(0, 1));
		setBackground(Color.BLACK);
		setBorder(new LineBorder(Color.WHITE));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setScore(0);
		setLife(3);
		add(scoreLabel);
		add(lifeLabel);
	}

	private void setLife(int life) {
		this.life = life;
		if (this.lifeLabel == null)
			createLifeLabel(life);
		else
			setLabelText(lifeLabel, "LIFE: ", life);
	}

	private void createLifeLabel(int life) {
		this.lifeLabel = new JLabel("LIFE: " + life);
		lifeLabel.setForeground(Color.WHITE);
		lifeLabel.setAlignmentX(JLabel.CENTER);
		lifeLabel.setHorizontalAlignment(JLabel.CENTER);
	}

	private void setLabelText(JLabel label, String message, int value) {
		label.setText(message + value);
	}

	private void setScore(int score) {
		this.score = score;
		if (this.scoreLabel == null)
			createScoreLabel(score);
		else
			setLabelText(scoreLabel, "SCORE: ", score);
	}

	private void createScoreLabel(int score) {
		this.scoreLabel = new JLabel("SCORE: " + score);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setAlignmentX(JLabel.CENTER);
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
	}

	public void scoreUp() {
		setScore(score + 1);
	}

	public boolean lifeDown() {
		setLife(life - 1);
		return life == 0 ? false : true;
	}

}
