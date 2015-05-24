import java.awt.Color;
import java.awt.Graphics;

public abstract class Circle {
	private double x, y, diameter, mass;
	private Color color;

	public boolean contains(Circle c) {
		double dx = c.getX();
		double dy = c.getY();

		double dist = Math.sqrt(Math.pow(dx - x, 2) + Math.pow(dy - y, 2));
		if (dist < getRadius() + c.getRadius())
			return true;

		return false;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getRadius() {
		return diameter / 2;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
		setDiameter(10 * Math.log1p(getMass()));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int) (x - diameter / 2), (int) (y - diameter / 2), (int) diameter, (int) diameter);
	}
}
