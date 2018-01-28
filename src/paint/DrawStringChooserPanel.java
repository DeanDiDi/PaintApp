package paint;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DrawStringChooserPanel extends JPanel implements ActionListener{

	private String[] fontsizes = {"12", "14", "16", "18", "20","25", "30"};
	private JComboBox sizebox;
	private JButton bold;
	private JButton italic;
	private String fontsize;
	private int fontype;
	private View view;
	public DrawStringChooserPanel(View view) {
		this.view = view;
		sizebox = new JComboBox(this.fontsizes);
		sizebox.addActionListener(this);
		bold = new JButton("B");
		bold.addActionListener(this);
		italic = new JButton("I");
		italic.addActionListener(this);
		this.add(sizebox);
		this.add(bold);
		this.add(italic);
		this.fontype = Font.PLAIN;
		this.fontsize = "12";
	}
	public String getFontSize() {
		return this.fontsize;
	}
	public int getFontType() {
		return this.fontype;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.fontsize = fontsizes[sizebox.getSelectedIndex()];
		if(e.getActionCommand() == "B") {
			if (this.fontype == Font.PLAIN) {
				this.fontype = Font.BOLD;
			}
			else if(this.fontype == Font.ITALIC) {
				this.fontype = Font.BOLD + Font.ITALIC;
			}
			else if(this.fontype == Font.ITALIC + Font.BOLD) {
				this.fontype = Font.ITALIC;
			}
			else {
				this.fontype = Font.PLAIN;
			}
		}
		else if(e.getActionCommand() == "I") {
			if (this.fontype == Font.PLAIN) {
				this.fontype = Font.ITALIC;
			}
			else if(this.fontype == Font.BOLD) {
				this.fontype = Font.BOLD + Font.ITALIC;
			}
			else if(this.fontype == Font.ITALIC + Font.BOLD) {
				this.fontype = Font.BOLD;
			}
			else {
				this.fontype = Font.PLAIN;
			}
		}
	}
}
	
	


