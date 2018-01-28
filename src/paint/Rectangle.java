package paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
	private Point begPoint;
	private Point endPoint;
	private Point paintPoint;
	
	public Rectangle(Point begPoint, Point endPoint) {
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
	
	public Point getPaintPoint() {
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
		g2d.drawRect((int)(this.shapeBox.getPaintPoint().getX()+lineThickness/2), 
				(int)(this.shapeBox.getPaintPoint().getY()+lineThickness/2), 
				this.shapeBox.getWidth()-(int)(lineThickness), this.shapeBox.getHeight()-(int)(lineThickness));
		if (this.fillStatus == "Solid Color") {
			g2d.fillRect((int)(this.shapeBox.getPaintPoint().getX()+lineThickness/2), 
					(int)(this.shapeBox.getPaintPoint().getY()+lineThickness/2), 
					this.shapeBox.getWidth()-(int)(lineThickness), this.shapeBox.getHeight()-(int)(lineThickness));
		}
		if(this.showShapeBox) shapeBox.paint(g2d); // draw shape box
	}

	@Override
	public boolean hasPoint(Point p) {
		int minX = this.paintPoint.getX();
		int maxX = minX + Math.abs(this.getWidth());
		int minY = this.paintPoint.getY();
		int maxY = minY + Math.abs(this.getHeight());
		float border = this.lineThickness/2;
		if(p.getX()>=minX-border-4 && p.getX()<=maxX+border+4 
				&& p.getY()>=minY-border-4 && p.getY()<=maxY+border+4) {
			if (this.fillStatus == "No Fill") {
				if(p.getX()>=minX+border+4 && p.getX()<=maxX-border-4 
						&& p.getY()>=minY+border+4 && p.getY()<=maxY-border-4) return false;
				return true;
			}
			return true;
		}
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
