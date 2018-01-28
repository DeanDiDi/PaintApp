package paint;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorChooserPanel colorChooserPanel;
	private LineThicknessChooserPanel lineThicknessChooserPanel; 
	private FillChooserPanel fillChooserPanel;
	private String choosedButton;
	private ToolPanel toolPanel;
	private DrawStringChooserPanel drawStringChooserPanel;
	private BufferedImage img = null;
	private boolean isBGimage = false;

	
	public String getChoosedButton() {
		return choosedButton;
	}

	public void setChoosedButton(String choosedButton) {
		this.choosedButton = choosedButton;
	}

	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		this.model=model;
		
		Container c=this.getContentPane();
		// c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		// create westPanel which holds shapeChooserPanel, lineThicknessChooserPanel and fillChooserPanel
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.lineThicknessChooserPanel = new LineThicknessChooserPanel();
		this.fillChooserPanel = new FillChooserPanel(this);
		this.toolPanel = new ToolPanel(this);
		this.drawStringChooserPanel = new DrawStringChooserPanel(this);
		westPanel.add(this.shapeChooserPanel);
		westPanel.add(this.drawStringChooserPanel);
		westPanel.add(this.lineThicknessChooserPanel);
		westPanel.add(fillChooserPanel);
		westPanel.add(this.toolPanel);
		c.add(westPanel,BorderLayout.WEST);
	
		// add paintPanel
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		// add colorChooserPanel
		this.colorChooserPanel = new ColorChooserPanel(this.paintPanel);
		c.add(this.colorChooserPanel, BorderLayout.EAST);
		
		this.pack();
		// this.setSize(200,200);
		this.setVisible(true);
	}

	
	
	public ToolPanel getToolPanel() {
		return toolPanel;
	}

	public LineThicknessChooserPanel getLineThicknessChooserPanel() {
		return lineThicknessChooserPanel;
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	public ColorChooserPanel getColorChooserPanel() {
		return colorChooserPanel;
	}
		
	public FillChooserPanel getFillChooserPanel() {
		return fillChooserPanel;
	}
	public DrawStringChooserPanel getDrawStringChooserPanel() {
		return drawStringChooserPanel;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		
		menu = new JMenu("Clear");
		// a group of JMenuItems
		menuItem = new JMenuItem("Clear Canvas");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Clear Drawings");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		

		return menuBar;
		
		
	}
	private static BufferedImage getScreenShot(Component com) {
		BufferedImage image = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage.TYPE_INT_RGB);
		com.paint(image.getGraphics());
		return image;
		
	}
	public BufferedImage getFilePNG() {
		return this.img;
	}
	public void setBRtoImage(File file, Component com)throws Exception {
		if(file != null) {
			this.img = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage.TYPE_INT_RGB);
			this.img = ImageIO.read(file);
			this.isBGimage = true;
		}
		
	}
	public boolean getisBGimage() {
		return this.isBGimage;
	}
	public void setisBGimage(boolean b) {
		this.isBGimage = b;
	}
	private static void saveScreenShot(Component com, File file) throws Exception{
		BufferedImage img = getScreenShot(com);
		ImageIO.write(img, "png", file);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		
		if(e.getActionCommand()=="New") {
			this.model.clearCanvas();
			this.paintPanel.repaint();
		}
		if(e.getActionCommand()=="Open") {
			JFileChooser choose = new JFileChooser();
			choose.showOpenDialog(null);
			File file = choose.getSelectedFile();
			this.isBGimage = true;
			try {
				setBRtoImage(file, this.paintPanel);
				this.paintPanel.repaint();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getActionCommand()=="Save") {
			JFileChooser choose = new JFileChooser();
			choose.showSaveDialog(null);
			File file = choose.getSelectedFile();
			
			try {
				saveScreenShot(this.paintPanel, file);
				JOptionPane.showMessageDialog(rootPane, "Image is captured");
			} catch (Exception e1) {
			}
		}
		
		if(e.getActionCommand()=="Undo") {
			this.model.getCommandInvoker().undo();
			this.paintPanel.repaint();
		}
		if(e.getActionCommand()=="Redo") {
			this.model.getCommandInvoker().redo();
			this.paintPanel.repaint();
		}
		
		if(e.getActionCommand()=="Clear Canvas") {
			this.model.clearCanvas();
			this.isBGimage = false;
			this.paintPanel.repaint();
		}
		if(e.getActionCommand()=="Clear Drawings") {
			this.model.clearDrawings();
			this.paintPanel.repaint();
		}
	}
}
