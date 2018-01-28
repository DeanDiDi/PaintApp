package paint;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
	protected float lineThickness;
	protected Color color;
	protected String fillStatus;
	protected ShapeBox shapeBox;
	protected boolean showShapeBox;
	
	public abstract void paint(Graphics2D g2d);
	
	public abstract boolean hasPoint(Point p);
	
	public abstract void reset();
	
	public void setShapeBox(ShapeBox shapeBox) {
		this.shapeBox = shapeBox;
	}

	public ShapeBox getShapeBox() {
		return shapeBox;
	}

	public abstract void move(Line vector);

	public void setLineThickness(float lineThickness) {
		this.lineThickness = lineThickness;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void setFillStatus(String status) {
		this.fillStatus = status;
	}
	
	public void setShowShapeBox(boolean showShapeBox) {
		this.showShapeBox = showShapeBox;
	}
	
	public boolean getShowShapeBox() {
		return this.showShapeBox;
	}
}
