package paint;

import java.awt.event.KeyEvent;

public class ManipulatorEraserStrategy extends ShapeManipulatorStrategy{
	private Eraser eraser;
	
	void mousePressed(Point p, View view, PaintModel model) {
		this.eraser = new Eraser();
		this.eraser.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness());
		this.eraser.setColor(ColorChooserPanel.getBGColor());
		model.addShape(this.eraser);
	}

	
	void mouseClicked(Point p, View view, PaintModel model) {
		this.eraser.addPoint(p);
		this.eraser.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness());
		this.eraser.setColor(ColorChooserPanel.getColor());
		model.addShape(this.eraser);
		this.eraser = new Eraser();
		
	}

	
	void mouseReleased(Point p, View view, PaintModel model) {
		this.eraser = new Eraser();
		
	}

	
	void mouseDragged(Point p, View view) {
		this.eraser.addPoint(p);
		view.getPaintPanel().repaint();
		
	}


	@Override
	void keyPressed(KeyEvent e, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	void mouseMoved(Point p, View view) {
		// TODO Auto-generated method stub
		
	}

}
