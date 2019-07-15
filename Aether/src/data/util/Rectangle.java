package data.util;

public class Rectangle {

	private Point[] points;

	private float width, height;

	public Rectangle(float x1, float y1, float width, float height) {
		points = new Point[4];
		points[0] = new Point(x1, y1);
		points[1] = new Point(x1 + width, y1);
		points[2] = new Point(x1 + width, y1 + height);
		points[3] = new Point(x1, y1 + height);
		this.width = width;
		this.height = height;
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}
	
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
