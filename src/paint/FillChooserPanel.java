package paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class FillChooserPanel extends JPanel implements ActionListener {

	private String[] fill = {"No Fill", "Solid Color"};
	private JComboBox fillCB;
	private String fillMode;
	private View view;
	
	public FillChooserPanel(View view) {
		this.view = view;
		fillCB = new JComboBox(this.fill);
		fillCB.addActionListener(this);
		this.add(fillCB);
		this.fillMode = "No Fill";
	}
	
	public String getFillMode() {
		return fillMode;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.fillMode = fill[fillCB.getSelectedIndex()];
	}		
}