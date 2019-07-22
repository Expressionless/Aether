package data.util;

public class Point {

	private float x, y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Point(double x, double y) {
		this.x = (float) x;
		this.y = (float) y;
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

	public static double findDistanceTo(Point point1, Point point2) {
		double[] p1 = { (double) point1.getX(), (double) point2.getY() };
		double[] p2 = { (double) point2.getX(), (double) point2.getY() };

		double dX = Math.pow(p2[0] - p1[0], 2);
		double dY = Math.pow(p2[1] - p1[1], 2);

		return Math.pow(dX + dY, 0.5);
	}
	public static double getPointDirection(Point p1, Point p2) {
		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(p2);
		Vector v3 = Vector.subtract(v2, v1); // Work with this one

		float dot = v3.getPoint("end").getX(); // Dotted with (1, 0)
		double mag = v3.getLength();

		return Math.acos(dot / mag) * 180 / Math.PI; // Angle between 2 vectors
	}
}
