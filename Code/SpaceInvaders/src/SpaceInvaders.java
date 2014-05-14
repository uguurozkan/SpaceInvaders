import elements.Controller;
import gui.GameFrame;

public class SpaceInvaders {
	public static void main(String[] args) throws InterruptedException {
		Controller controller = new Controller();
		GameFrame frame = new GameFrame(controller);
	}

}
