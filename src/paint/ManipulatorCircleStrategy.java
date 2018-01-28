package paint;

import java.awt.event.KeyEvent;

public class ManipulatorCircleStrategy extends ShapeManipulatorStrategy{
	private Circle circle;
	
	public void mousePressed(Point p, View view, PaintModel model) {
		this.circle = new Circle(p, 0);
		this.circle.setFillStatus(view.getFillChooserPanel().getFillMode());
		this.circle.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness()); 
		this.circle.setColor(ColorChooserPanel.getColor());
		model.addShape(this.circle);	
	}
	
	public void mouseClicked(Point p, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseReleased(Point p, View view, PaintModel model) {
		this.circle.setShowShapeBox(true);
		view.getPaintPanel().setMode(new ManipulatorRefactorStrategy(this.circle));
		view.getPaintPanel().repaint();
		this.circle = new Circle(new Point(0,0), 0);
	}


	void mouseDragged(Point p, View view) {
		Point center = this.circle.getCentre();
		Line radius = new Line(center, p);
		this.circle.setRadius(radius.getLength());
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
