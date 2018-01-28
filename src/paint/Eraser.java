package paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Eraser extends Shape{
	
	
private ArrayList<Point> points;
	
	public Eraser() {
		this.points = new ArrayList<Point>();
	}
	
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	@Override
	public void paint(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(this.lineThickness));
		g2d.setColor(ColorChooserPanel.getBGColor());
		if (this.points.size() == 1) {
			Point p = points.get(0);
			g2d.fillOval((int) (p.getX()-this.lineThickness/2),
						 (int) (p.getY()-this.lineThickness/2),
						 (int) this.lineThickness,
						 (int) this.lineThickness);
		} else {
			for(int i=0; i<this.points.size()-1; i++) {
				Point p1 = points.get(i);
				Point p2 = points.get(i+1);
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
		
	}

	@Override
	public boolean hasPoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Line vector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}


