package paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


public class ColorChooserPanel extends JPanel implements ActionListener {
	private static Color color = (Color.BLACK);
	private static  Color BGColor = (Color.WHITE);
	private PaintPanel paintPanel;

	public static Color getColor() { 
		return color;
	}
	
	public static Color getBGColor() {
		return BGColor;
	}
	

	
	public static void setColor(Color color) {
		ColorChooserPanel.color = color;
	}

	public static void setBGColor(Color bGColor) {
		BGColor = bGColor;
	}

	public ColorChooserPanel(PaintPanel paintPanel) {	
		this.paintPanel = paintPanel;
		String[] buttonLabels = {"Choose Color", "BackGround"};
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (String label : buttonLabels) {
			JButton button = new JButton(label);
			this.add(button);
			button.addActionListener(this);
			Image img = new ImageIcon(this.getClass().getResource("/"+label+".png")).getImage();
			button.setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()== "Choose Color") {
			color = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
			
		}
		else if (e.getActionCommand()== "BackGround") {
		Color old = getBGColor(); 
		BGColor = JColorChooser.showDialog(null, "BackGround",Color.WHITE);
		if(BGColor == null) {
			setBGColor(old);
		}
		this.paintPanel.repaint();
		}
	}
}
