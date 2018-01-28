package paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener, KeyListener  {

	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private ShapeManipulatorStrategy mode = new ManipulatorSquiggleStrategy();

	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500,500));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		setFocusable(true);
		this.model = model;
		this.model.addObserver(this);
		this.view=view;
	}
	
	// View aspect of this
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 								//paint background
        Graphics2D g2d = (Graphics2D) g; 						// lets use the advanced api
        super.setBackground(ColorChooserPanel.getBGColor());
        if(this.view.getisBGimage()) {
        	g.drawImage(this.view.getFilePNG(), 0, 0, null);
        }     // Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.WHITE);
		this.model.getCommandInvoker().executeAll(g2d); // Draw all shapes
		g2d.dispose();
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	//Controller aspect of this
	public void setMode(ShapeManipulatorStrategy mode){
		this.mode = mode;
	}
	
	public void resetShapeBox() {
		model.resetShapeBox();
		this.repaint();
	}
	
	// MouseMotionListener below
	public void mouseMoved(MouseEvent e) {
		this.mode.mouseMoved(new Point(e.getX(), e.getY()), this.view);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.mode.mouseDragged(new Point(e.getX(), e.getY()), this.view);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.mode.mouseClicked(new Point(e.getX(), e.getY()), this.view, this.model);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.mode.mousePressed(new Point(e.getX(), e.getY()) ,this.view, this.model);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.mode.mouseReleased(new Point(e.getX(), e.getY()),this.view, this.model);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	public void keyPressed(KeyEvent e) { 
		this.mode.keyPressed(e, this.view, this.model);
		
	}


	public void keyReleased(KeyEvent e) {
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
