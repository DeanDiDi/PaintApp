package paint;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LineThicknessChooserPanel extends JPanel implements ChangeListener{
	private float lineThickness;
	private JSlider lineThicknessChooser;
	
	
	public float getLineThickness() {
		return lineThickness;
	}

	public LineThicknessChooserPanel() {
		this.lineThicknessChooser = new JSlider(1, 10, 1); // integers: min, max, initial
		this.lineThicknessChooser.setPreferredSize(new Dimension(100, 45)); // set the preferred size for slider
		this.lineThicknessChooser.setMajorTickSpacing(3);
		this.lineThicknessChooser.setMinorTickSpacing(1); 
		this.lineThicknessChooser.setPaintTicks(true);
		this.lineThicknessChooser.setPaintLabels(true);
		
		this.lineThicknessChooser.addChangeListener(this);
		
		this.add(this.lineThicknessChooser);
		
		this.setBorder(BorderFactory.createTitledBorder("Thickness"));
		this.setPreferredSize(new Dimension(120, 80)); // set the preferred size for panel
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		this.lineThickness = (float) this.lineThicknessChooser.getValue();
	}
}
