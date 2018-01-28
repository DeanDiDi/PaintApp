package paint;

import java.awt.*;

public class Circle extends Shape {
	private Point centre;
	private int radius;
	
	public Circle(Point centre, int radius){
		this.centre = centre;
		this.radius = radius;
		this.shapeBox = new ShapeBox(new Point(0,0), 0, 0);
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
		this.shapeBox.setPaintPoint(new Point((int)(centre.getX()-radius-lineThickness/2), (int)(centre.getY()-radius-lineThickness/2)));
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		this.shapeBox.setPaintPoint(new Point((int)(centre.getX()-radius-lineThickness/2), (int)(centre.getY()-radius-lineThickness/2)));
		this.shapeBox.setHeight((int)(radius+lineThickness/2)*2);
		this.shapeBox.setWidth((int)(radius+lineThickness/2)*2);
	}

	@Override
	public void paint(Graphics2D g2d) {
		int x = this.centre.getX();
		int y = this.centre.getY();
		g2d.setStroke(new BasicStroke(this.lineThickness));
		g2d.setColor(this.color);
		g2d.drawOval((int)(this.shapeBox.getPaintPoint().getX()+lineThickness/2), 
				(int)(this.shapeBox.getPaintPoint().getY()+lineThickness/2), 
				this.shapeBox.getWidth()-(int)(lineThickness), this.shapeBox.getHeight()-(int)(lineThickness));
		if(this.fillStatus == "Solid Color") {
			g2d.fillOval((int)(this.shapeBox.getPaintPoint().getX()+lineThickness/2), 
					(int)(this.shapeBox.getPaintPoint().getY()+lineThickness/2), 
					this.shapeBox.getWidth()-(int)(lineThickness), this.shapeBox.getHeight()-(int)(lineThickness));
		}
		if(this.showShapeBox) shapeBox.paint(g2d); // draw shape box
	}

	@Override
	public boolean hasPoint(Point p) {
		int distance = new Line(this.centre, p).getLength();
		if(this.fillStatus == "Solid Color") {
			if (distance <= this.radius + this.lineThickness/2 + 4) return true;
			return false;
		} else if(this.fillStatus == "No Fill"){
			if (distance <= this.radius + this.lineThickness/2 + 4 && distance >= this.radius - this.lineThickness/2 - 4) return true;
			return false;
		}
		return false;
	}

	@Override
	public void move(Line vector) {
		this.centre.movePoint(vector);
	}

	@Override
	public void reset() {
		this.radius = this.shapeBox.getWidth()/2-(int)(lineThickness)/2;
		this.centre = new Point(this.shapeBox.getPaintPoint().getX()+this.shapeBox.getWidth()/2,
				this.shapeBox.getPaintPoint().getY()+this.shapeBox.getHeight()/2);
		
	}

}
