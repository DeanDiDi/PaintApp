package paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class ShapeBox extends Shape{
	private Point[] transformationPoints = new Point[8];
	private Point paintPoint;
	private int width;
	private int height;
	
	public ShapeBox(Point paintPoint, int width, int height) {
		this.paintPoint = paintPoint;
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(Graphics2D g2d) {
		int x = paintPoint.getX();
		int y = paintPoint.getY();
		float dash1[] = {10.0f};
		BasicStroke dashed =
		        new BasicStroke(1.0f,
		                        BasicStroke.CAP_BUTT,
		                        BasicStroke.JOIN_MITER,
		                        10.0f, dash1, 0.0f);
		g2d.setStroke(dashed);
		g2d.drawRect(x, y, width, height);
		g2d.setStroke(new BasicStroke());
		g2d.drawRect(x-4, y-4, 8, 8);
		g2d.drawRect(x+width/2-4, y-4, 8, 8);
		g2d.drawRect(x+width-4, y-4, 8, 8);
		g2d.drawRect(x+width-4, y+height/2-4, 8, 8);
		g2d.drawRect(x+width-4, y+height-4, 8, 8);
		g2d.drawRect(x+width/2-4, y+height-4, 8, 8);
		g2d.drawRect(x-4, y+height-4, 8, 8);
		g2d.drawRect(x-4, y+height/2-4, 8, 8);
	}

	public Point[] getTransformationPoints(){
		int x = paintPoint.getX();
		int y = paintPoint.getY();
		transformationPoints[0] = new Point(x,y);
		transformationPoints[1] = new Point(x+width/2,y);
		transformationPoints[2] = new Point(x+width,y);
		transformationPoints[3] = new Point(x+width,y+height/2);
		transformationPoints[4] = new Point(x+width,y+height);
		transformationPoints[5] = new Point(x+width/2,y+height);
		transformationPoints[6] = new Point(x,y+height);
		transformationPoints[7] = new Point(x,y+height/2);
		return transformationPoints;
	}
	
	public Point getPaintPoint() {
		return paintPoint;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	
	public Point getCenter() {
		return new Point(paintPoint.getX()+width/2, paintPoint.getY()+height/2);
	}


	@Override
	public boolean hasPoint(Point p) {
		return this.getCenter().hasPointNearby(p, this.width/2, this.height/2);
	}


	@Override
	public void move(Line vector) {
		paintPoint.movePoint(vector);		
	}


	public void setPaintPoint(Point paintPoint) {
		this.paintPoint = paintPoint;
	}


	public void setWidthIncrement(int dWidth) {
		this.width += dWidth;
	}


	public void setHeightIncrement(int dHeight) {
		this.height += dHeight;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
