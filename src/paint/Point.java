package paint;

import java.awt.Graphics2D;

public class Point{
	int x, y;
	private boolean isEnd;
	
	Point(int x, int y){
		this.isEnd = false; 
		this.x=x; this.y=y;
	}
	
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void movePoint(Line l) {
		int dx = l.getEndPoint().getX() - l.getStartPoint().getX();
		int dy = l.getEndPoint().getY() - l.getStartPoint().getY();
		this.x += dx; this.y += dy;
	}
	
	public void movePointX(int dx) {
		this.x += dx;
	}
	
	public void movePointY(int dy) {
		this.y += dy;
	}
	
	public boolean hasPointNearby(Point p, float dx, float dy) {
		float x = p.getX();
		float y = p.getY();
		if (this.x-dx<=x && x<=this.x+dx && this.y-dy<=y && y<=this.y+dy) return true;
		return false;
	}
}
