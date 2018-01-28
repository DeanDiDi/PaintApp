package paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Oval extends Shape{
	private Point begPoint;
	private Point endPoint;
	private Point paintPoint;
	
	public Oval(Point begPoint, Point endPoint) {
		this.begPoint = begPoint;
		this.paintPoint = new Point(begPoint.getX(), begPoint.getY());
		this.endPoint = endPoint;
		this.shapeBox = new ShapeBox(new Point(0,0), 0, 0);
	}
	
	public int getWidth() {
		int w = this.endPoint.getX() - this.begPoint.getX();
		return w;
	}
	public int getHeight() {
		int h = this.endPoint.getY() - this.begPoint.getY();
		return h;
	}
	
	public Point getPanitPoint() {
		return this.paintPoint;
	}
	
	public void setBegPoint(Point begPoint) {
		this.begPoint = begPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
		if(this.getWidth()<0) this.paintPoint.setX(this.endPoint.getX());
		if(this.getHeight()<0) this.paintPoint.setY(this.endPoint.getY());
		this.shapeBox.setPaintPoint(new Point((int)(this.paintPoint.getX()-lineThickness/2),(int)(this.paintPoint.getY()-lineThickness/2)));
		this.shapeBox.setWidth((int) (Math.abs(this.getWidth())+lineThickness));
		this.shapeBox.setHeight((int) (Math.abs(this.getHeight())+lineThickness));
	}

	@Override
	public void paint(Graphics2D g2d) {
		int x = this.paintPoint.getX();
		int y = this.paintPoint.getY();
		g2d.setStroke(new BasicStroke(this.lineThickness));
		g2d.setColor(this.color);
		g2d.drawOval((int)(this.shapeBox.getPaintPoint().getX()+lineThickness/2), 
				(int)(this.shapeBox.getPaintPoint().getY()+lineThickness/2), 
				this.shapeBox.getWidth()-(int)(lineThickness), this.shapeBox.getHeight()-(int)(lineThickness));
		if (this.fillStatus == "Solid Color") {
			g2d.fillOval((int)(this.shapeBox.getPaintPoint().getX()+lineThickness/2), 
					(int)(this.shapeBox.getPaintPoint().getY()+lineThickness/2), 
					this.shapeBox.getWidth()-(int)(lineThickness), this.shapeBox.getHeight()-(int)(lineThickness));
		}
		if(this.showShapeBox) shapeBox.paint(g2d); // draw shape bo
	}

	@Override
	public boolean hasPoint(Point p) {
		float border = this.lineThickness/2;
		Point center = new Point((this.begPoint.getX() + this.getWidth()/2), (this.begPoint.getY() + this.getHeight()/2));
		double a,b,c;
		Point f1,f2;
		int width = Math.abs(this.getWidth());
		int height =  Math.abs(this.getHeight());
		if (width >= height) {
			a = width/2;
			b = height/2;
			c = Math.sqrt(a*a-b*b);
			f1 = new Point(center.getX()+(int)c,center.getY());
			f2 = new Point(center.getX()-(int)c,center.getY());
		}else {
			a = height/2;
			b = width/2;
			c = Math.sqrt(a*a-b*b);
			f1 = new Point(center.getX(),center.getY()+(int)c);
			f2 = new Point(center.getX(),center.getY()-(int)c);
		}
		int d1 = new Line(f1, p).getLength();
		int d2 = new Line(f2, p).getLength();
		
		if(d1 + d2 <= 2*a+8+border && d1 + d2 >= 2*a-8-border) return true;
		return false;
	}

	@Override
	public void move(Line vector) {
		this.paintPoint.movePoint(vector);		
	}

	@Override
	public void reset() {
		this.paintPoint = new Point(shapeBox.getPaintPoint().getX()+(int)lineThickness/2, shapeBox.getPaintPoint().getY()+(int)lineThickness/2);
		this.begPoint = this.paintPoint;
		this.endPoint = new Point(this.paintPoint.getX()+shapeBox.getWidth()-(int)lineThickness, this.paintPoint.getY()+shapeBox.getHeight()-(int)lineThickness);
	}
}
