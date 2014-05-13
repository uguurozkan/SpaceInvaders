import elements.Controller;
import gui.GameFrame;

public class SpaceInvaders {
	public static void main(String[] args) throws InterruptedException {
		Controller controller = new Controller();

		while (true) {
			controller.refresh();
			Thread.currentThread().sleep(300);
		}

	}

}
