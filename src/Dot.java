import java.awt.Color;
import java.util.Random;

public class Dot extends Circle {

	public Dot() {
		Random r = new Random();
		setDiameter(10);
		setMass(1);
		if (r.nextInt(50) == 0) {
			setMass(20);
			setDiameter(20);
		}
		setColor(genColor());
		setX(r.nextInt(Component.w.getWidth()));
		setY(r.nextInt(Component.w.getHeight()));
	}

	public static Color genColor() {
		Color[] colors = new Color[] { Color.BLUE, Color.RED, Color.CYAN, Color.GREEN, Color.YELLOW };
		Random r = new Random();
		return colors[r.nextInt(colors.length)];
	}
}
