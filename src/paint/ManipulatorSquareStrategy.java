package paint;

import java.awt.event.KeyEvent;

public class ManipulatorSquareStrategy extends ShapeManipulatorStrategy{

	private Square square;
	public void mousePressed(Point p, View view, PaintModel model) {
		this.square = new Square(p, p);
		this.square.setFillStatus(view.getFillChooserPanel().getFillMode());
		this.square.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness());
		this.square.setColor(ColorChooserPanel.getColor());
		model.addShape(this.square);
	}
	
	
	void mouseClicked(Point p, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}
	
	void mouseReleased(Point p, View view, PaintModel model) {
		this.square.setShowShapeBox(true);
		view.getPaintPanel().setMode(new ManipulatorRefactorStrategy(this.square));
		view.getPaintPanel().repaint();
		this.square = new Square(new Point(0,0),new Point(0,0));
		
	}
	
	void mouseDragged(Point p, View view) {
		this.square.setEndPoint(p);
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
