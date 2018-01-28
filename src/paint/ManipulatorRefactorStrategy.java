package paint;

import java.awt.event.KeyEvent;

public class ManipulatorRefactorStrategy extends ShapeManipulatorStrategy{
	private Shape shape;
	private ShapeBox shapeBox;
	private Point pressedPoint;
	private int selectedMode = -1;
	
	public ManipulatorRefactorStrategy(Shape shape) {
		this.shape = shape;
		this.shapeBox = this.shape.getShapeBox();
	}

	@Override
	void mousePressed(Point p, View view, PaintModel model) {
		if(shapeBox.getCenter().hasPointNearby(p, shapeBox.getWidth()/2+4, shapeBox.getHeight()/2+4)) {
			pressedPoint = p;
			Point[] transformationPoints = shapeBox.getTransformationPoints();
			selectedMode = transformationPoints.length;
			for(int i = 0; i < transformationPoints.length; i++) {
				if(transformationPoints[i].hasPointNearby(p, 15, 15)) selectedMode = i;
			}
		}else {
			this.shape.setShowShapeBox(false);
			view.getPaintPanel().repaint();
		}
	}

	@Override
	void mouseClicked(Point p, View view, PaintModel model) {
		if(!shapeBox.getCenter().hasPointNearby(p, shapeBox.getWidth()/2+4, shapeBox.getHeight()/2+4)) {
			shape.setShowShapeBox(false);
			ShapeManipulatorFactory factory = new ShapeManipulatorFactory();
			// when clicked places other than box, set mode to current selected mode.
			view.getPaintPanel().setMode(factory.getShapeManipulator(view.getChoosedButton()));
			view.getPaintPanel().repaint();
		}
	}

	@Override
	void mouseReleased(Point p, View view, PaintModel model) {
		if(selectedMode == -1) {
			ShapeManipulatorFactory fac = new ShapeManipulatorFactory();
			view.getPaintPanel().setMode(fac.getShapeManipulator(view.getChoosedButton()));
		}
		this.shape.reset();
		selectedMode = -1;
		pressedPoint = null;
	}

	@Override
	void mouseDragged(Point p, View view) {
		if(pressedPoint != null && selectedMode != -1) {
			int dx = p.getX() - pressedPoint.getX();
			int dy = p.getY() - pressedPoint.getY();
			if(selectedMode == 0) {
				shapeBox.getPaintPoint().movePoint(new Line(pressedPoint, p));
				shapeBox.setWidthIncrement(-dx);
				shapeBox.setHeightIncrement(-dy);
			}else if(selectedMode == 1) {
				shapeBox.getPaintPoint().movePointY(dy);
				shapeBox.setHeightIncrement(-dy);
			}else if (selectedMode == 2){
				shapeBox.getPaintPoint().movePointY(dy);
				shapeBox.setWidthIncrement(dx);
				shapeBox.setHeightIncrement(-dy);
			}else if (selectedMode == 3){
				shapeBox.setWidthIncrement(dx);
			}else if (selectedMode == 4){
				shapeBox.setWidthIncrement(dx);
				shapeBox.setHeightIncrement(dy);
			}else if (selectedMode == 5){
				shapeBox.setHeightIncrement(dy);
			}else if (selectedMode == 6){
				shapeBox.getPaintPoint().movePointX(dx);
				shapeBox.setWidthIncrement(-dx);
				shapeBox.setHeightIncrement(dy);
			}else if(selectedMode == 7) {
				shapeBox.getPaintPoint().movePointX(dx);
				shapeBox.setWidthIncrement(-dx);
			}else if(selectedMode == 8) { // move shape
				shapeBox.getPaintPoint().movePoint(new Line(pressedPoint, p));
			}
			view.getPaintPanel().repaint();
			pressedPoint = p;	
		}	
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
