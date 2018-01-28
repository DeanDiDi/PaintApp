package paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	private CommandInvoker commandInvoker = new CommandInvoker();	// command stack
	private ArrayList<Shape> shapes = new ArrayList<Shape>();		// logical shapes	
	
	public CommandInvoker getCommandInvoker() {
		return commandInvoker;
	}

	public void addShape(Shape s) {
		this.commandInvoker.add(new PaintCommand(s));
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Shape> getShapes() {
		return this.shapes;
	}
	
	public void clearCanvas() {
		commandInvoker = new CommandInvoker();
		shapes = new ArrayList<Shape>();		
		ColorChooserPanel.setBGColor(Color.WHITE);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void clearDrawings() {
		commandInvoker = new CommandInvoker();
		shapes = new ArrayList<Shape>();		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void resetShapeBox() {
		for(Shape s : shapes) s.setShowShapeBox(false);
	}
}

