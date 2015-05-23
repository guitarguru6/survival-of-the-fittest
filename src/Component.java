import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Component extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private static boolean isRunning = false;

	private static Graphics g;
	private static Image screen;

	private static ArrayList<Dot> dots = new ArrayList<Dot>();

	public static Window w;

	public static void main(String[] args) {
		Component component = new Component();

		w = new Window(800, 600, "Survival of the Fittest");
		w.add(component);

		component.init();
	}

	public void init() {
		isRunning = true;
		new Thread(this).start();
	}

	private int x = 0;

	public void run() {
		while (isRunning) {
			tick();
			render(g);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void tick() {
		x++;
//		if (x % 30 == 0) {
//			for (Dot d : dots) {
//				d.tick();
//			}
//		}
		if (x % 20 == 0) {
			dots.add(new Dot());
		}
	}

	public void render(Graphics g) {
		screen = createImage(WIDTH, HEIGHT);
		g = screen.getGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (Dot d : dots) {
			d.render(g);
		}

		g = getGraphics();
		g.drawImage(screen, 0, 0, null);
	}

}
