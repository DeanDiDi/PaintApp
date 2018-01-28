package paint;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class CommandInvoker {	
	private ArrayList<Command> commands;
	private ArrayList<Command> undoCommands;
	
	public CommandInvoker() {
		this.commands = new ArrayList<Command>();
		this.undoCommands = new ArrayList<Command>();
	}
		
	public void executeAll(Graphics2D g2d) {
		for(Command c:commands) {
			c.execute(g2d);
		}
	}
	
	public void add(Command command) {
		this.commands.add(command);
		this.clearUndoCommands();	// whenever a new shape is added to the command stack
									// the undoCommand stack will be cleared.
	}
	
	public void undo() {
		if(this.commands.size() > 0) {
			Command lastCommand = this.commands.get(this.commands.size()-1);
			this.undoCommands.add(lastCommand);
			this.commands.remove(this.commands.size()-1);
		}
	}
	
	public void redo() {
		if(this.undoCommands.size() > 0) {
			Command lastCommand = this.undoCommands.get(this.undoCommands.size()-1);
			this.commands.add(lastCommand);
			this.undoCommands.remove(this.undoCommands.size()-1);
		}
	}
	
	public void clearUndoCommands() {
		if(this.undoCommands.size() != 0) this.undoCommands = new ArrayList<Command>();
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}
	
}
