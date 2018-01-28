package paint;

import java.awt.event.KeyEvent;

public class ManipulatorPolylineStrategy extends ShapeManipulatorStrategy{

	private Polyline polyline = new Polyline();
	private Point escapepoint;
	
	public void mousePressed(Point p, View view, PaintModel model) {
	}
		
	public void mouseClicked(Point p, View view, PaintModel model) {
		this.escapepoint = p;
		this.polyline.setStartPoint(p);
		this.polyline.setEndPoint(p);
		this.polyline.setLineThickness(view.getLineThicknessChooserPanel().getLineThickness());
		this.polyline.setColor(ColorChooserPanel.getColor());
		this.polyline.addPoints(p);
		model.addShape(this.polyline);
		view.getPaintPanel().requestFocusInWindow();
	}
	
	public void mouseReleased(Point p, PaintModel model) {
	}

	public void mouseDragged(Point p, View view) {
	}
	
	public void mouseMoved(Point p, View view) {
		this.polyline.setEndPoint(p);
		view.getPaintPanel().repaint();
		view.getPaintPanel().requestFocusInWindow();
	}

	@Override
	void keyPressed(KeyEvent e, View view, PaintModel model) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("yes");
			this.polyline.setEndPoint(this.escapepoint);
			this.polyline = new Polyline();
			view.getPaintPanel().repaint();
		}
		
	}

	@Override
	void mouseReleased(Point p, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}
}
