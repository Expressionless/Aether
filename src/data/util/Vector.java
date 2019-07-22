package data.util;

public class Vector {

	private double length;
	private Point start, end;

	public Vector(Point p1, Point p2) {
		start = p1;
		end = p2;
		length = Point.findDistanceTo(p1, p2);
	}

	public Vector(Point p1) {
		start = new Point(0, 0);
		end = p1;
		length = Point.findDistanceTo(start, p1);
	}

	public static Vector subtract(Vector v1, Vector v2) {
		double x1 = v1.getPoint("end").getX() - v1.getPoint("start").getX();
		double y1 = v1.getPoint("end").getY() - v1.getPoint("start").getY();

		double x2 = v2.getPoint("end").getX() - v2.getPoint("start").getX();
		double y2 = v2.getPoint("end").getY() - v2.getPoint("start").getY();
		return new Vector(new Point(x1 - x2, y1 - y2));
	}

	public static Vector add(Vector v1, Vector v2) {
		double x1 = v1.getPoint("end").getX() - v1.getPoint("start").getX();
		double y1 = v1.getPoint("end").getY() - v1.getPoint("start").getY();

		double x2 = v2.getPoint("end").getX() - v2.getPoint("start").getX();
		double y2 = v2.getPoint("end").getY() - v2.getPoint("start").getY();
		return new Vector(new Point(x1 + x2, y1 + y2));
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Point getPoint(String point) {
		switch (point) {
		case "start":
			return start;
		case "end":
			return end;
		default:
			return null;
		}
	}

	public void setPoint(Point p, String point) {
		switch (point) {
		case "start":
			start = p;
			break;
		case "end":
			end = p;
			break;
		}
	}

}
