package paint;

public class ShapeManipulatorFactory {
	private ManipulatorCircleStrategy manipulatorCircleStrategy = new ManipulatorCircleStrategy();
	private ManipulatorRectangleStrategy manipulatorRectangleStrategy = new ManipulatorRectangleStrategy();
	private ManipulatorSquareStrategy manipulatorSquareStrategy = new ManipulatorSquareStrategy();
	private ManipulatorSquiggleStrategy manipulatorSquiggleStrategy = new ManipulatorSquiggleStrategy();
	private ManipulatorSelectorStrategy manipulatorSelectorStrategy = new ManipulatorSelectorStrategy();
	private ManipulatorPolylineStrategy manipulatorPolylineStrategy = new ManipulatorPolylineStrategy();
	private ManipulatorEraserStrategy manipulatorEraserStrategy = new ManipulatorEraserStrategy();
	private ManipulatorStringStrategy manipulatorStringStrategy = new ManipulatorStringStrategy();
	private ManipulatorOvalStrategy manipulatorOvalStrategy = new ManipulatorOvalStrategy();
	
	public ShapeManipulatorStrategy getShapeManipulator(String shape) {
		if (shape == "Circle") {
			return manipulatorCircleStrategy;
		}
		else if(shape == "Rectangle") {
			return manipulatorRectangleStrategy;
		}
		else if(shape == "Square") {
			return manipulatorSquareStrategy;
		}
		else if(shape == "Squiggle") {
			return manipulatorSquiggleStrategy;
		}
		else if(shape == "Eraser") {
			return manipulatorEraserStrategy;
		}
		else if(shape == "Selector") {
			return manipulatorSelectorStrategy;
		}
		else if(shape == "Polyline") {
			return manipulatorPolylineStrategy;
		}
		else if(shape == "DrawString") {
			return manipulatorStringStrategy;
		}
		else if(shape == "Oval") {
			return manipulatorOvalStrategy;
		}
		else {
			return null;
		}
	}
}
