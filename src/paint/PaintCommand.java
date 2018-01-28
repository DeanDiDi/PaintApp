package paint;

import java.awt.Graphics2D;

public class PaintCommand implements Command {
	private Shape shape; // receiver
	
	public PaintCommand(Shape shape) {
		this.shape = shape;
	}
	
	public Shape getShape() {
		return this.shape;
	}
	
	public void execute(Graphics2D g2d) {
		this.shape.paint(g2d);
	}

}
