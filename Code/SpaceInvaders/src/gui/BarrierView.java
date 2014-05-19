package gui;

import java.awt.Point;

import javax.swing.ImageIcon;

import elements.Barrier;

public class BarrierView extends EntityView {

	public BarrierView(Barrier barrier, GamePanel gamePanel) {
		super(barrier, gamePanel);
	}
	@Override
	public Bullet getBullet() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getHit() {
		super.getHit();
		setIcon(new ImageIcon("Assets/Barriers/Barrier1.png"));
	}

}
