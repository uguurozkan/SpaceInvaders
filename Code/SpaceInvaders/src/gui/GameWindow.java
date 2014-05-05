package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{
	public GameWindow(){
	MenuPanel menu=new MenuPanel();
	JPanel menuPanel=menu.getMenuPanel();
	add(menuPanel);
	setSize(1000,800);
	setVisible(true);
	}
	
}
