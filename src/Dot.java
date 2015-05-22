import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Dot {
	private Color color;
	private int diameter = 10;
	private int x, y;
	
	public Dot() {
		Random r = new Random();
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		x = r.nextInt(Component.w.getWidth());
		y = r.nextInt(Component.w.getHeight());
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, diameter, diameter);
	}
}
