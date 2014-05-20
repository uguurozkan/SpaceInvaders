package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		setBackground(Color.red);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setScore(0);
		setLife(3);
		add(scoreLabel);
		add(lifeLabel);
	}

	private void setLife(int life) {
		this.life = life;
		if (this.lifeLabel == null){
			this.lifeLabel = new JLabel("LIFE: " + life);
			lifeLabel.setAlignmentX(JLabel.CENTER);
			lifeLabel.setHorizontalAlignment(JLabel.CENTER);
		}else
			this.lifeLabel.setText("LIFE: " + life);
	}

	private void setScore(int score) {
		this.score = score;
		if (this.scoreLabel == null){
			this.scoreLabel = new JLabel("SCORE: " + score);
			scoreLabel.setAlignmentX(JLabel.CENTER);
			scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		}else
			this.scoreLabel.setText("SCORE: " + score);
	}

	public void scoreUp() {
		setScore(score + 1);
	}

	public boolean lifeDown() {
		setLife(life - 1);
		if(life==0){
			return false;
		}else{
		return true;}
	}

}
