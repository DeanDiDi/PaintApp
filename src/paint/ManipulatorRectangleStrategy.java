package paint;

import java.awt.event.KeyEvent;

public class ManipulatorRectangleStrategy extends ShapeManipulatorStrategy{
	private Rectangle rectangle;
	
	public void mousePressed(Point p, View view, PaintModel model) {
		this.rectangle = new Rectangle(p, p);
		this.rectangle.setFillStatus(view.getFillChooserPanel().getFillMode());
		this.rectangle.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness()); 
		this.rectangle.setColor(ColorChooserPanel.getColor());
		model.addShape(this.rectangle);
		
	}
	
	void mouseClicked(Point p, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}
	
	void mouseReleased(Point p, View view, PaintModel model) {
		this.rectangle.setEndPoint(p);
		this.rectangle.setShowShapeBox(true);
		view.getPaintPanel().setMode(new ManipulatorRefactorStrategy(this.rectangle));
		view.getPaintPanel().repaint();
		this.rectangle = new Rectangle(new Point(0,0), new Point(0,0));
	}
	
	void mouseDragged(Point p, View view) {
		this.rectangle.setEndPoint(p);
		view.getPaintPanel().repaint();
		
	}

	@Override
	void keyPressed(KeyEvent e, View view, PaintModel model) {
		
		
	}

	@Override
	void mouseMoved(Point p, View view) {
		// TODO Auto-generated method stub
		
	}

}
