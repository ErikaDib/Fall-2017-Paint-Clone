package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



import java.awt.Color;

public class PaintCloneGUI extends JFrame implements ActionListener{
	JPanel jpanel_1;
	JLabel newlabel;
	private JScrollPane jsp;
	JMenuBar menuBar;
	Font font;
	public PaintCloneGUI(){
		jpanel_1 = new JPanel();
		//ImageIcon icon=new ImageIcon(PaintCloneJP.class.getResource("/pack1/back2.png"));
		//Image img = icon.getImage();
		//newlabel = new JLabel("New label");
		//newlabel.setIcon(new ImageIcon(PaintCloneGUI.class.getResource("/pack1/back2.jpg")));
		//jpanel_1.add(newlabel);
		
		///menu
		menuBar = new JMenuBar(); 
		//setJMenuBar(menuBar); // Add the menu bar to the window
	    
	    JMenu fileMenu = new JMenu("File"); // Create File menu
	    fileMenu.setOpaque(true);
	    fileMenu.setBackground(Color.lightGray);
	    fileMenu.setForeground(Color.BLUE);
	    font = new Font("Century Gothic", Font.PLAIN, 20);
	    fileMenu.setFont(font);
	    //JMenu elementMenu = new JMenu("Elements"); // Create Elements menu
	    JMenuItem save = new JMenuItem("Save");
	    save.addActionListener(this);
	    fileMenu.add(save);
	    menuBar.add(fileMenu); // Add the file menu
	   // menuBar.add(elementMenu); // Add the element 
		
	    setJMenuBar(menuBar);
		
		//
		
		jpanel_1.setBackground(new Color(0,51,153));
		//jpanel_1.setLayout(new BorderLayout());
		PaintCloneJP jpanel_2=new PaintCloneJP();
	
		//jpanel_2.setLayout(new BorderLayout());//
		jpanel_1.add(jpanel_2,BorderLayout.CENTER);
		//getContentPane().add(jpanel_1, BorderLayout.CENTER);
		add(jpanel_1);
		setSize(1250,700);
		setTitle("Paint Clone");
		//setBackground(Color.pink);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eri_k\\Desktop\\iconPaint.png"));
		jsp=new JScrollPane(jpanel_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jsp,BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				PaintCloneGUI gui = new PaintCloneGUI();
				//Meme window = new Meme();
				//window.setVisible(false);
				
			}
		});


	}



	@Override
	public void actionPerformed(ActionEvent e) {
	String face=e.getActionCommand();
	if(face.equalsIgnoreCase("save")){
	 Dimension size = getSize ();
     BufferedImage img = new BufferedImage (size.width, size.height, BufferedImage.TYPE_3BYTE_BGR);
     Graphics g = img.getGraphics ();
     paint (g);
     g.dispose ();
     try
     {
         ImageIO.write (img, "png", new File ("GuiScreen.png"));
     }
     catch (IOException ex)
     {
         ex.printStackTrace ();
     }
	}
		
	}

}
