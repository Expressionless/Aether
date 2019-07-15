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

	public static double getPointDirection(Point p1, Point p2) {
		float width = p2.getX() - p1.getX();
		float height = p2.getY() - p2.getX();
		float distance = (float) Math.pow(Math.pow(width, 2) + Math.pow(height, 2), 0.5);
		float sin = height / distance;
		return Math.sin((double) sin);
	}

	public static double getRatio(String ratio, Point p1, Point p2) {
		double width = (double)(p2.getX() - p1.getX());
		double height = (double)(p2.getY() - p2.getX());
		float distance = (float) Math.pow(Math.pow(width, 2) + Math.pow(height, 2), 0.5);
		
		double ratioVal = 0;
		
		switch (ratio) {
		case "sin":
			ratioVal = height/distance;
			break;
		case "cos":
			ratioVal = width/distance;
			break;
		case "tan":
			ratioVal = width/height;
			break;
		}
		
		return ratioVal;
	}
}
