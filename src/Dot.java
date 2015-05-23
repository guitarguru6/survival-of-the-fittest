import java.awt.Color;
import java.util.Random;


public class Dot extends Circle{
//	private int x, y, diameter;
//	private Color color;
	
	public Dot() {
		Random r = new Random();
		setDiameter(10);
		setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
	    setX(r.nextInt(Component.w.getWidth()));
		setY(r.nextInt(Component.w.getHeight()));
	}
	
	public void tick() {

	}
}
