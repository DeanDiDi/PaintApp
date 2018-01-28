package paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Polyline extends Shape {
	
	private ArrayList<Point> points;
	private Point startPoint;
	private Point endPoint;
	
	
	public Polyline() {
		this.points = new ArrayList<Point>();
	}
	
	@Override
	public void paint(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(this.lineThickness));
		g2d.setColor(this.color);
		g2d.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		for(int i=0; i<this.points.size()-1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}
	public void addPoints(Point p) {
		this.points.add(p);
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public boolean hasPoint(Point p) {
		return true;
	}

	@Override
	public void move(Line vector) {
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
}
