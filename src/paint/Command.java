package paint;

import java.awt.Graphics2D;

public interface Command {
	
	public abstract void execute(Graphics2D g2d); 
}
