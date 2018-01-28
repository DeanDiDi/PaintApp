package paint;

import java.awt.event.KeyEvent;

public class ManipulatorSquiggleStrategy extends ShapeManipulatorStrategy{
	private SquiggleLine squig = new SquiggleLine();
	
	public void mousePressed(Point p, View view, PaintModel model) {
		this.squig.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness());
		this.squig.setColor(ColorChooserPanel.getColor());
		this.squig.addPoint(p);
		model.addShape(this.squig);
	}
	
	public void mouseClicked(Point p, View view, PaintModel model) {
		this.squig.addPoint(p);
		this.squig.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness());
		this.squig.setColor(ColorChooserPanel.getColor());
		model.addShape(this.squig);
		this.squig = new SquiggleLine();
	}

	
	public void mouseReleased(Point p, View view, PaintModel model) {
		this.squig = new SquiggleLine();
		
	}

	@Override
	void mouseDragged(Point p, View view) {
		this.squig.addPoint(p);
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
