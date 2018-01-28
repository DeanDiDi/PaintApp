package paint;

import java.awt.event.KeyEvent;

public class ManipulatorSelectorStrategy extends ShapeManipulatorStrategy{
	private Shape shape;
	
	@Override
	void mousePressed(Point p, View view, PaintModel model) {
		
	}

	@Override
	void mouseClicked(Point p, View view, PaintModel model) {
		shape = null;
		
		for(Command c : model.getCommandInvoker().getCommands()) {
			PaintCommand pc = (PaintCommand)c;
			if(pc.getShape().hasPoint(p)) {
				shape = pc.getShape();
			}
		}
		if(shape!=null) {
			shape.setShowShapeBox(true);
			view.getPaintPanel().repaint();
			if((shape.getClass().getName() != "ca.utoronto.utm.paint.SquiggleLine") &&
					(shape.getClass().getName() != "ca.utoronto.utm.paint.Polyline")	) {
				view.getPaintPanel().setMode(new ManipulatorRefactorStrategy(shape));
			}
		}
	}

	@Override
	void mouseReleased(Point p, View view, PaintModel model) {
		
	}

	@Override
	void mouseDragged(Point p, View view) {
		
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
