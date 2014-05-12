package gui;

import java.awt.Color;

import javax.swing.JPanel;

public class AlienView extends JPanel{
int x;
int y;
String path= "Assets/Invaders/Invader1.png"; 
Color color;
public AlienView(int x , int y){
	this.x=x;
	this.y=y;
	this.color=Color.blue;
}

}
