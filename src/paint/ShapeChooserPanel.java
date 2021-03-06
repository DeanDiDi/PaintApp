package paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private String[] buttonLabels;
	
	public ShapeChooserPanel(View view) {
		this.view=view;
	    this.buttonLabels = new String[] {"Squiggle", "Circle", "Oval", "Rectangle", "Square", "Polyline", "DrawString"};
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		
		for (String label : this.buttonLabels) {
			JButton button = new JButton();
			if(label == this.buttonLabels[0]) button.setEnabled(false);
			button.setActionCommand(label);
			Image img = new ImageIcon(this.getClass().getResource("/"+label+".png")).getImage();
			button.setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			button.addActionListener(this);
			this.add(button);
		}	
	}
	
	public void enableAllButtons() {
		for (Component button : this.getComponents()) button.setEnabled(true);
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.enableAllButtons();
		this.view.getToolPanel().enableAllButtons();
		JButton selectedButton = (JButton)e.getSource();
		selectedButton.setEnabled(false);
		this.view.setChoosedButton(e.getActionCommand());
		ShapeManipulatorFactory fac = new ShapeManipulatorFactory();
		this.view.getPaintPanel().setMode(fac.getShapeManipulator(e.getActionCommand()));
		view.getPaintPanel().resetShapeBox();
		System.out.println(e.getActionCommand());
	}
	
}
