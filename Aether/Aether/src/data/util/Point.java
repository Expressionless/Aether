package data.util;

public class Point {

	private float x, y;
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public static double findDistanceTo(Point p1, Point p2) {
		double dX = Math.pow(p1.getX(), 2) + Math.pow(p2.getX(), 2);
		double dY = Math.pow(p1.getY(), 2) + Math.pow(p2.getY(), 2);
		return Math.pow(dX + dY, 0.5);
	}
}
