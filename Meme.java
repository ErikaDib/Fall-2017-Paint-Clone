package pack1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.JTextField;



import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;


public class Meme extends JFrame implements ActionListener {

	//JFrame frame;
	JPanel panel;
	JLabel lblNewLabel;
	JTextArea textArea;
	JRadioButton radioButton;
	JRadioButton radioButton_1;
	JRadioButton radioButton_2;
	JRadioButton radioButton_3;
	JButton button;
	Font font1;
	JMenuBar menuBar;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meme window = new Meme();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	public Meme() {
		//frame = new JFrame();
	    setBounds(100, 100, 463, 405);
	    setTitle("Meme Maker");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\eri_k\\Desktop\\iconPaint.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setBounds(0, 0, 447, 366);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 79, 280, 265);
		panel.add(lblNewLabel);
		
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		

		textArea = new JTextArea();
		textArea.setFont(font1);
		textArea.setBounds(10, 41, 280, 36);
		panel.add(textArea);
		
		radioButton = new JRadioButton("GOT");
		radioButton_1 = new JRadioButton("Futurama");
		radioButton_2 = new JRadioButton("Doggo");
		radioButton_3 = new JRadioButton("Esponge Bob");
		
		button=new JButton("save");
		button.setBounds(317, 300, 109, 23);
		
		
		button.addActionListener(this);
		radioButton.addActionListener(this);
		radioButton_1.addActionListener(this);
		radioButton_2.addActionListener(this);
		radioButton_3.addActionListener(this);
		
		ButtonGroup group=new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		group.add(radioButton_2);
		group.add(radioButton_2);
		
		radioButton.setBounds(317, 101, 109, 23);
		panel.add(radioButton);
		radioButton_1.setBounds(317, 181, 109, 23);
		panel.add(radioButton_1);
		radioButton_2.setBounds(317, 231, 109, 23);
		panel.add(radioButton_2);
		radioButton_3.setBounds(317, 137, 109, 23);
		panel.add(radioButton_3);
		panel.add(button);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String face =e.getActionCommand();
		switch (face){
		case "GOT":
			lblNewLabel.setIcon(new ImageIcon(Meme.class.getResource("/pack1/egg.jpg")));
			break;
		case"Futurama":
			lblNewLabel.setIcon(new ImageIcon(Meme.class.getResource("/pack1/fry.jpg")));
			break;
		case"Doggo":
			lblNewLabel.setIcon(new ImageIcon(Meme.class.getResource("/pack1/dog.jpg")));
			break;
		case"Esponge Bob":
			lblNewLabel.setIcon(new ImageIcon(Meme.class.getResource("/pack1/image4.jpg")));
			break;
		case"save":
			
		            Dimension size = getSize ();
		            BufferedImage img = new BufferedImage (size.width, size.height, BufferedImage.TYPE_3BYTE_BGR);
		            Graphics g = img.getGraphics ();
		            paint (g);
		            g.dispose ();
		            try
		            {
		                ImageIO.write (img, "png", new File ("screenshot1.png"));
		            }
		            catch (IOException ex)
		            {
		                ex.printStackTrace ();
		            }
		        
		            
			
			break;
			
			default:
				
		}
		
	}

	
	
}

