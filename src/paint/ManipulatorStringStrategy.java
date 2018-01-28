package paint;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ManipulatorStringStrategy extends ShapeManipulatorStrategy{
	private DrawString string;
	private ArrayList<DrawString> strings= new ArrayList<DrawString>();
	
	@Override
	//add drawstring to view with no text
	void mousePressed(Point p, View view, PaintModel model) {
		this.string = new DrawString("", p.getX(), p.getY());
		this.string.setColor(ColorChooserPanel.getColor());
		String fontsize = view.getDrawStringChooserPanel().getFontSize();
		this.string.setSize(fontsize);
		int fonttype = view.getDrawStringChooserPanel().getFontType();
		this.string.setFont(fonttype);
		model.addShape(this.string);
		
	}

	//mouse clicks creates a new object drawstring and places at the mouse click event point with no string. Also
	//there is a request to focus so the keylistener can be used in paintpanel
	void mouseClicked(Point p, View view, PaintModel model) {
		this.string = new DrawString("", p.getX(), p.getY());
		this.string.setColor(ColorChooserPanel.getColor());
		String fontsize = view.getDrawStringChooserPanel().getFontSize();
		this.string.setSize(fontsize);
		int fonttype = view.getDrawStringChooserPanel().getFontType();
		this.string.setFont(fonttype);
		this.strings.add(this.string);
		view.getPaintPanel().requestFocusInWindow();
		model.addShape(this.string);
		view.getPaintPanel().repaint();
		
	}

	@Override
	void mouseDragged(Point p, View view) {
		// TODO Auto-generated method stub
		
	}

	
	void keyPressed(KeyEvent e, View view, PaintModel model) {
		//key event for enter
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.strings.add(this.string);
			DrawString newstring = new DrawString("",this.string.getX(),this.string.getY()+this.string.getSize());
			newstring.setColor(ColorChooserPanel.getColor());
			String fontsize = view.getDrawStringChooserPanel().getFontSize();
			newstring.setSize(fontsize);
			int fonttype = view.getDrawStringChooserPanel().getFontType();
			newstring.setFont(fonttype);
			this.string = newstring;
		}
		//key event for backspace
		else if(e.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
			String str = this.string.getString();
			//if the drawstring has text in it
			if(str.length() >= 1) { 
				this.string.setString(str.substring(0,str.length()-1));
			}
			//checks if the string is empty, that there at least 2 strings in the array list so there is no 
			//syntax errors, then checks that the x coordinates are the same so you can backspace an aligned paragraph
			else if(str.length() < 1 && this.strings.size() >= 2 && (this.string.getX() == this.strings.get(this.strings.size()-1).getX())) {
				this.string = this.strings.get(this.strings.size()-1);
				this.strings.remove(this.strings.size()-1);
				}
		}
		//key event for caps lock has no output but still works
		else if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK){
		}
		else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		}
		else if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			
		}
		//key event for spacebar, add space to drawstring string
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.string.setString(this.string.getString() + " ");
		}
		//else add the key event character to the drawstring
		else {this.string.setString(this.string.getString() + e.getKeyChar());
			
		}
		model.addShape(this.string);
		view.getPaintPanel().repaint();
		
	}

	@Override
	void mouseMoved(Point p, View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void mouseReleased(Point p, View view, PaintModel model) {
		// TODO Auto-generated method stub
		
	}

}
