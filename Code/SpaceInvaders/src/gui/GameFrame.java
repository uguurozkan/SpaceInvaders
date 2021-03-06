package gui;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioPermission;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import elements.LevelLoader;
import elements.Player;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	private Timer gameTimer;

	private GamePanel gamePanel;
	private InfoPanel infoPanel;
	private WelcomePanel welcomePanel;
	private AboutPanel aboutPanel;
	private HowToPanel howToPanel;

	public static void main(String[] args) {
		new GameFrame();
	}

	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		printWelcomePanel();
	}

	public void printPanel(JPanel panel) {
		getContentPane().removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		validate();
		pack();
		setVisible(true);
	}

	public void newGameClicked() {
		MusicPlayer.getInstance();
		printGamePanel();
	}

	private void printWelcomePanel() {
		if (welcomePanel == null)
			welcomePanel = new WelcomePanel(this);
		printPanel(welcomePanel);
	}

	private void printGamePanel() {
		if (gamePanel == null)
			gamePanel = new GamePanel(this);
		printPanel(gamePanel);
		gamePanel.paintAliens();
		gamePanel.paintBarriers();
		gamePanel.paintPlayer(createPlayer());
		add(getInfoPanel(), BorderLayout.EAST);
		repaint();
		validate();
		pack();
		setVisible(true);
		run();
	}

	private Component getInfoPanel() {
		if (infoPanel == null)
			infoPanel = new InfoPanel();
		return infoPanel;
	}

	private Player createPlayer() {
		return new Player(30, 14);
	}

	public void run() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gamePanel.isRunning()) {
					gamePanel.run();
				} else {
					gameTimer.stop();
					if(gamePanel.win){
						printVictoryLabel();
					}
					else{
						printDefeatLabel();
					}
				}
			}
		};
		gameTimer = new Timer(5, listener);
		gameTimer.start();

	}

	public void aboutClicked() {
		printAboutPanel();
	}

	private void printAboutPanel() {
		if (aboutPanel == null)
			aboutPanel = new AboutPanel(this);
		printPanel(aboutPanel);

	}

	public void backToMenuClicked() {
		printPanel(welcomePanel);

	}

	public void printHowToPanel() {
		if (howToPanel == null)
			howToPanel = new HowToPanel(this);
		printPanel(howToPanel);
	}

	public void printDefeatLabel() {
		JLabel label = new JLabel("You Lost!!!");
		label.setFont(new Font("Serif", Font.BOLD, 30));
		label.setForeground(Color.WHITE);
		label.setLocation(new Point((int) getBounds().getCenterX()-100,
				(int) getBounds().getCenterY() - 100));
		label.setSize(500, 100);
		gamePanel.add(label);
		int result = JOptionPane.showConfirmDialog(this, " Would you like to play again?","Game over!", JOptionPane.YES_NO_OPTION);
			
		if (result == JOptionPane.YES_OPTION) {
				LevelLoader.getInstance().reset();
				gamePanel=null;
				infoPanel=null;
				printGamePanel();
				
		} else {
			System.exit(0);
		}
	}

	public void printVictoryLabel() {
		JLabel label = new JLabel("You Win!!!");
		label.setFont(new Font("Serif", Font.BOLD, 30));
		label.setForeground(Color.WHITE);
		label.setLocation(new Point((int) getBounds().getCenterX() - 100,
				(int) getBounds().getCenterY() - 100));
		label.setSize(500, 100);
		gamePanel.add(label);
		// TODO ask for another game
		int result = JOptionPane.showConfirmDialog(this, " Would you like to play next level?","Victory!", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
				LevelLoader.getInstance().increaseLevel();
				gamePanel=null;
				printGamePanel();
				
		} else {
			System.exit(0);
		}
	}

	public void scoreUp() {
		infoPanel.scoreUp();
	}

	public boolean lifeDown() {
		return infoPanel.lifeDown();
	}

}
