package paint;

import java.awt.event.KeyEvent;

public class ManipulatorOvalStrategy extends ShapeManipulatorStrategy{
	private Oval oval;
	
	public void mousePressed(Point p, View view, PaintModel model) {
		this.oval = new Oval(p, p);
		this.oval.setFillStatus(view.getFillChooserPanel().getFillMode());
		this.oval.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness()); 
		this.oval.setColor(ColorChooserPanel.getColor());
		model.addShape(this.oval);
	}
	
	void mouseClicked(Point p, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}
	
	void mouseReleased(Point p, View view, PaintModel model) {
		this.oval.setEndPoint(p);
		this.oval.setShowShapeBox(true);
		view.getPaintPanel().setMode(new ManipulatorRefactorStrategy(this.oval));
		view.getPaintPanel().repaint();
		this.oval = new Oval(new Point(0,0), new Point(0,0));
		
	}
	
	void mouseDragged(Point p, View view) {
		this.oval.setEndPoint(p);
		view.getPaintPanel().repaint();
		
	}

	void keyPressed(KeyEvent e, View view, PaintModel model) {
		
	}

	@Override
	void mouseMoved(Point p, View view) {
		// TODO Auto-generated method stub
		
	}
}
