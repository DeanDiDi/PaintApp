package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class DrawString extends Shape{
	private int x;
	private int y;
	private int fontsize;
	private String str;
	private Color color;
	private int fonttype;
	
	
	public DrawString(String str, int x, int y) {
		this.str = str;
		this.x = x;
		this.y = y;
		this.fonttype = Font.PLAIN;
		
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setString(String str) {
		this.str = str;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getString() {
		return this.str;
	}
	public void setFont(int type) {
		this.fonttype = type;
	}
	
	public void setSize(String str) {
		this.fontsize = Integer.parseInt(str);
	}
	public int getSize() {
		return this.fontsize;
	}
	public void setColor(Color color) {
		this.color =  color;
	}
	@Override
	public void paint(Graphics2D g2d) {
		Font f = new Font("Times New Roman", this.fonttype, this.fontsize);
		g2d.setColor(this.color);
		g2d.setFont(f);
		g2d.drawString(getString(), this.x, this.y);
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