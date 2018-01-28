package paint;

public class Line{
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		this(new Point(0, 0), new Point(0, 0));
	}
	
	public Line(Point startPoint) {
		this(startPoint, new Point(0, 0));
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public int getLength() {
		int dx = startPoint.getX()-endPoint.getX();
		int dy = startPoint.getY()-endPoint.getY();
		return (int) Math.sqrt(dx*dx+dy*dy);
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return this.endPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
}
