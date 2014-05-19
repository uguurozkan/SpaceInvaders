package elements;

import gui.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BackButtonHandler implements ActionListener{
	public GameFrame frame;
	
	public BackButtonHandler(GameFrame frame){
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.backToMenuClicked();
		
	}

}
