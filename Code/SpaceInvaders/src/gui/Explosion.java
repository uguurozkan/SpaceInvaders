package gui;

public class Explosion implements Runnable {

	private final int NUM_OF_FRAMES = 12;
	private final int DELAY = 45;
	private EntityView entity;
	private Thread runner;
	private int currentFrame = 1;

	public Explosion(EntityView entity) {
		this.entity = entity;
	}

	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}

	public void stop() {
		if (runner != null) {
			runner = null;
		}
	}

	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			checkStopCondition();
			changeFrame();
			waitNextFrame();
		}
	}

	private void checkStopCondition() {
		if (currentFrame > NUM_OF_FRAMES) {
			currentFrame = 0;
			stop();
		}
	}

	private void changeFrame() {
		entity.setEntityIcon("Assets/Explosion/explosion" + currentFrame + ".png");
		currentFrame++;
	}

	private void waitNextFrame() {
		try {
			Thread.sleep(DELAY);
		} catch (Exception e) {
			System.err.println("Problem while waiting.");
		}
	}

}
