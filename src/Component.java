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

	private static Listening listening;

	private static ArrayList<Dot> dots = new ArrayList<Dot>();
	public static Player player;

	public static Window w;

	public static void main(String[] args) {
		Component component = new Component();

		w = new Window(800, 600, "Survival of the Fittest");
		w.add(component);

		component.init();
	}

	public void init() {
		listening = new Listening();
		addMouseListener(listening);
		addMouseMotionListener(listening);
		player = new Player();
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
		if (x % 20 == 0) {
			dots.add(new Dot());
		}
		player.tick();
		for (int i = 0; i < dots.size(); i++) {
			Dot d = dots.get(i);
			if (player.contains(d)) {
				player.eat(d.getMass());
				dots.remove(i);
			}
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
		player.render(g);
		g = getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		// g.fillRect(0, 0, 800, 600);
		g.drawImage(screen, 0, 0, null);
		g.dispose();
	}

}
