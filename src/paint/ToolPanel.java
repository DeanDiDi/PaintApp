package paint;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ToolPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private String[] buttonLabels;

	public ToolPanel(View view) {
		this.view = view;
		this.buttonLabels = new String[] {"Selector", "Eraser"};
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		
		for (String label : this.buttonLabels) {
			JButton button = new JButton();
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.enableAllButtons();
		this.view.getShapeChooserPanel().enableAllButtons();
		JButton selectedButton = (JButton)e.getSource();
		selectedButton.setEnabled(false);
		this.view.setChoosedButton(e.getActionCommand());
		ShapeManipulatorFactory fac = new ShapeManipulatorFactory();
		this.view.getPaintPanel().setMode(fac.getShapeManipulator(e.getActionCommand()));
		view.getPaintPanel().resetShapeBox();
		System.out.println(e.getActionCommand());
	}	
}
