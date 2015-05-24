import java.awt.Color;
import java.awt.Graphics;

public class Player extends Circle {
	public Player() {
		setDiameter(20);
		setMass(10);
		setColor(Dot.genColor());
		setX(Listening.x);
		setY(Listening.y);
	}

	public void eat(double d) {
		setMass(getMass() + d);
		setDiameter(20 * Math.log1p(getMass() - 9));
	}

	public void tick() {
		double deltaX = Listening.x - getX();
		double deltaY = Listening.y - getY();
		double direction = Math.atan2(deltaY, deltaX);
		double speed = 100.0 / (getMass() / 2);
		setX(getX() + (speed * Math.cos(direction)));
		setY(getY() + (speed * Math.sin(direction)));
		if (Math.abs(deltaX) <= speed && Math.abs(deltaY) <= speed) {
			setX(Listening.x);
			setY(Listening.y);
		}
	}

	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.white);
		g.drawString(getMass() + "", (int) getX() - 10, (int) getY() - 10);
	}
}
