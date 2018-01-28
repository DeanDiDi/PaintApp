package paint;

import java.awt.event.KeyEvent;

public abstract class ShapeManipulatorStrategy {
	
	abstract void mousePressed(Point p, View view, PaintModel model);
	abstract void mouseClicked(Point p, View view, PaintModel model);
	abstract void mouseReleased(Point p, View view, PaintModel model);
	abstract void mouseDragged(Point p, View view);
	abstract void keyPressed(KeyEvent e, View view, PaintModel model);
	abstract void mouseMoved(Point p, View view);
}
