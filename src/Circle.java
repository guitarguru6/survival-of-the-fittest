import java.awt.Color;
import java.awt.Graphics;


public abstract class Circle {
	private int x, y, diameter;
	private Color color;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(x-diameter/2,y-diameter/2, diameter, diameter);
	}
}
