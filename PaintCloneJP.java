package pack1;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class PaintCloneJP extends JPanel implements MouseListener,ActionListener,KeyListener, MouseMotionListener,WindowListener,ChangeListener{
	
	private int lastX;
	private int lastY;
	private int number_Of_Buttons=20;
	private JButton[] arr;
	private String[] arrtwo={"Line","Eraser","Clear","Square","Triangle","Rect","Star","Poligon","Meme","Book","Free","Text","Back","Oval","Arc","Mandala","Circle","Pokeball","Anim","Dragon"};
    private ImageIcon[] icons=new ImageIcon[20];
    private Image[] imagesA=new Image[20];

	
	//private int buttonControl=0;
	private String ControlBtn="";
    private Color color;
    private Color eraserColor;
    
    ///text
    private Font font;
   // private Font font1;
    private Font font2;
   // private Font font3;

    
	private FontMetrics fm;


	protected boolean mouseIsPressed;
	protected Color lineColor;
	
	///meme
	protected JPanel memePanel;
	//JFrame memeFrame;
	
	//private JScrollPane jsp;
	
	///panels
	protected JPanel controlLine;
	protected JPanel btnPanel2;
	protected JButton colorLinebtn;
	protected JSlider slider;
	protected JLabel sliderLabel;
	protected JLabel sliderLabel2;
	protected JLabel sliderColorLabel;
	protected Color color2;
	///	//JButton fontChooser;
	
	///extras
	protected int slidervalue=0; 
	protected String fontType="";
	////meme
	Meme window;
	private boolean isBeingUsed;
	private String stroke;
	//
	protected int xDragged=0;
	protected int yDragged=0;
	
	public PaintCloneJP(){
		color=Color.BLACK;
		isBeingUsed=true;
		 lastX=0;
		 lastY=0;
		 addMouseListener(this);
		 ////
		 addMouseMotionListener(this);
		 mouseIsPressed=false;
		 ///
		 
		 setLayout(new BorderLayout());
		 
		 
		 ////text
		 font = new Font("TimesRoman", Font.BOLD, 50);
		 fm = getFontMetrics(font);
		 
		 font2 = new Font("Century Gothic", Font.PLAIN, 20);
		
		 ///keylistener
		 addKeyListener(this);
		 //////
		 
		 
		
		 setBackground(Color.WHITE);
		// setSize(1000,700);
		 
		 JPanel btnPanel = new JPanel();
		 btnPanel.setLayout(new GridLayout(2,number_Of_Buttons));
		 
		 ////button panel
		 btnPanel2 = new JPanel();
		 btnPanel2.setLayout(new GridLayout(number_Of_Buttons,2));
		 btnPanel2.setVisible(true);
		 
		 JPanel radioPanel=new JPanel();
		 radioPanel.setLayout(new GridLayout(2,2) );
		 
		 ///MEME
		 window = new Meme();
		 window.setVisible(false);
		 
		 /*
		// memeFrame=new JFrame();
		 memePanel=new JPanel();
		 JPanel memePanel2=new JPanel();
		 memePanel2.setLayout(new GridLayout(3,1));
		// memeFrame.setSize(100, 100);
		 memePanel.setLayout(new BorderLayout());
		 memePanel.setBackground(Color.BLUE);
		 //memePanel.setPreferredSize(new Dimension(80,80));                     /////meme

		 JLabel memeLabel=new JLabel("label");
		 JLabel memeLabel2=new JLabel("label2");
		 memeLabel.setOpaque(true);
		 memeLabel.setBackground(Color.YELLOW);
		 memePanel2.add(memeLabel2);
		 memePanel.add(memePanel2,BorderLayout.WEST);
		 memePanel.add(memeLabel, BorderLayout.PAGE_START);
		// memeFrame.add(memePanel);
		 
		 */
		 ///
		 
		 //control panel
		 controlLine=new JPanel();
		 controlLine.setLayout(new GridLayout(6,2));
		 controlLine.setVisible(false);
		  //////
		 sliderLabel=new JLabel("Adjust Size:");
		 sliderLabel2=new JLabel("Choose Color:");
		 sliderLabel.setOpaque(true);
		 sliderLabel2.setOpaque(true);
		 sliderLabel.setBackground(new Color(169, 204, 227));
		 sliderLabel2.setBackground(new Color(169, 204, 227));
		 sliderLabel.setFont(font2);
		 sliderLabel2.setFont(font2);
		 
		 sliderColorLabel=new JLabel("");
		 sliderColorLabel.setOpaque(true);
		 slider=new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
		 slider.setMinorTickSpacing(2);
		 slider.setMinorTickSpacing(10);
		 slider.setPaintTicks(true);
		 slider.setPaintLabels(true);
		 slider.setLabelTable(slider.createStandardLabels(10));
		 slider.setFont(font2);
		 slider.setForeground(Color.BLACK);
		 slider.setBackground(new Color(210, 180, 222));
		 
		 //
		 //JButton fontChooser=new JButton("font");
		 //fontChooser.addActionListener(this);
		
		 slider.addChangeListener(this);
		 
		 colorLinebtn=new JButton("Color");
		 colorLinebtn.setBackground(new Color(195, 155, 211));

		 colorLinebtn.setFont(font2);
		 colorLinebtn.addActionListener(this);
		 //adds
		
		 JRadioButton shape1=new JRadioButton("Gradient");
		 JRadioButton shape2=new JRadioButton("Brush");
		 JRadioButton shape3=new JRadioButton("Spray");
		 JRadioButton shape4=new JRadioButton("Pencil");
		 
		 shape1.setFont(font2);
		 shape2.setFont(font2);
		 shape3.setFont(font2);
		 shape4.setFont(font2);
		 
		 shape1.addActionListener(this);
		 shape2.addActionListener(this);
		 shape3.addActionListener(this);
		 shape4.addActionListener(this);
		 
		 ButtonGroup group=new ButtonGroup();

		 
		 group.add(shape1);
		 group.add(shape2);
		 group.add(shape3);
		 group.add(shape4);
		 
		 radioPanel.add(shape1);
		 radioPanel.add(shape2);
		 radioPanel.add(shape3);
		 radioPanel.add(shape4);
		 
		 ///
		 controlLine.add(sliderLabel);
		 controlLine.add(slider);
		 controlLine.add(radioPanel);
		 controlLine.add(sliderLabel2);
		 controlLine.add(colorLinebtn);
		 controlLine.add(sliderColorLabel);
		
		 //radiobutton
		 ///
		 
		 //ButtonsPanel bt=new ButtonsPanel();
		 //add(bt);
		// ImageIcon icon1=new ImageIcon(PaintCloneJP.class.getResource("/pack1/ProjectIcon2.png"));
		// Image img = icon1.getImage();
		 
		 for(int i=0;i<20;i++){
			 String valueOfNum=Integer.toString(i);
			 String contry="Image"+valueOfNum+".png";
			 icons[i]=new ImageIcon(PaintCloneJP.class.getResource("/pack1/"+contry));
			 imagesA[i]=icons[i].getImage();
			
		 }
		 
		    arr=new JButton[number_Of_Buttons];
			for(int i=0;i<number_Of_Buttons;i++){
				//arr[i].setIcon();//
				arr[i]=new JButton();
				arr[i].setFont(new Font("Century Gothic", Font.PLAIN, 16));
				arr[i].setFocusPainted(false);
				//arr[i].setIcon(new ImageIcon(img));
				if(i==0||i==1||i==10||i==11){
					arr[i].setBackground(new Color(195, 155, 211 ));
				}else if(i==8||i==9||i==18||i==19){
					arr[i].setBackground(new Color(169, 204, 227 ));
				}else{
					arr[i].setBackground(new Color(210, 180, 222 ));
				}
			
				arr[i].setForeground(Color.BLACK);
				arr[i].setText(arrtwo[i]);
				arr[i].addActionListener(this);
				btnPanel.add(arr[i]);
			}
			///icons
			/*
			arr[12].setIcon(new ImageIcon(img));
			ImageIcon icon2=new ImageIcon(PaintCloneJP.class.getResource("/pack1/lineIcon.png"));
			Image img2 = icon2.getImage();
			arr[0].setIcon(new ImageIcon(img2));
			
		  // String iconB="Image"+0+".png";
		   ImageIcon icon=new ImageIcon(PaintCloneJP.class.getResource("/pack1/Image0.png"));
	       Image image = icon.getImage();
		   arr[0].setIcon(new ImageIcon(image));
		   ImageIcon icon1=new ImageIcon(PaintCloneJP.class.getResource("/pack1/Image1.png"));
	       Image image1 = icon1.getImage();
		   arr[1].setIcon(new ImageIcon(image1));
		   */
			for(int i=0;i<20;i++){
			arr[i].setIcon(new ImageIcon(imagesA[i]));
			}
		    
			for(int i=0;i<number_Of_Buttons;i++){
				arr[i]=new JButton();
				arr[i].setPreferredSize(new Dimension(5,30));
				arr[i].setFocusPainted(false);
				arr[i].setBackground(new Color(102, 204, 255));
				arr[i].setForeground(Color.WHITE);
				btnPanel2.add(arr[i]);
			}
		
		add(btnPanel,BorderLayout.PAGE_START);
		add(btnPanel2,BorderLayout.EAST);
		add(controlLine,BorderLayout.WEST);
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		 int y = e.getY();
		
		//fix
		if(ControlBtn.equalsIgnoreCase("star")){
			//int[] arr1  = {x+42,x+52,x+72,x+52,x+60,x+40,x+15,x+28,x+9,x+32,x+42};
		    //int [] arr2 = {y+38,y+62,y+68,y+80,y+105,y+85,y+102,y+75,y+58,y+20,y+38};
			Graphics g = getGraphics();
			Graphics2D g2 = (Graphics2D) g;

	       
	        Point2D.Double pt1 = new Point2D.Double(x+100,y+ 10);
	        Point2D.Double pt2 = new Point2D.Double(x+125,y+ 75);
	        Point2D.Double pt3 = new Point2D.Double(x+200,y+ 85);
	        Point2D.Double pt4 = new Point2D.Double(x+150,y+ 125);
	        Point2D.Double pt5 = new Point2D.Double(x+160, y+190);
	        Point2D.Double pt6 = new Point2D.Double(x+100,y+ 150);
	        Point2D.Double pt7 = new Point2D.Double(x+40, y+190);
	        Point2D.Double pt8 = new Point2D.Double(x+50,y+ 125);
	        Point2D.Double pt9 = new Point2D.Double(x+0, y+85);
	        Point2D.Double pt10 = new Point2D.Double(x+70, y+75);
	       

	  
	        Line2D.Double ln1 = new Line2D.Double(pt1, pt2);
	        Line2D.Double ln2 = new Line2D.Double(pt2, pt3);
	        Line2D.Double ln3 = new Line2D.Double(pt3, pt4);
	        Line2D.Double ln4 = new Line2D.Double(pt4, pt5);
	        Line2D.Double ln5 = new Line2D.Double(pt5, pt6);
	        Line2D.Double ln6 = new Line2D.Double(pt6, pt7);
	        Line2D.Double ln7 = new Line2D.Double(pt7, pt8);
	        Line2D.Double ln8 = new Line2D.Double(pt8, pt9);
	        Line2D.Double ln9 = new Line2D.Double(pt9, pt10);
	        Line2D.Double ln10 = new Line2D.Double(pt10, pt1);
	        
	        g2.setColor(color);

	       
	        g2.draw(ln1);
	        g2.draw(ln2);
	        g2.draw(ln3);
	        g2.draw(ln4);
	        g2.draw(ln5);
	        g2.draw(ln6);
	        g2.draw(ln7);
	        g2.draw(ln8);
	        g2.draw(ln9);
	        g2.draw(ln9);
	        g2.draw(ln10);

			///g.fillPolygon(arr1,arr2,5);
		}
		
        if(ControlBtn.equalsIgnoreCase("oval")){
        	Graphics g = getGraphics();
        	Graphics2D g2 = (Graphics2D) g;
        	g.setColor(color);
        	g2.drawOval(x-35, y-25, slidervalue+100,slidervalue+50 );
			
		}
        if(ControlBtn.equalsIgnoreCase("mandala")){
        	int diameter = 200;
        	Graphics g = getGraphics();
        	//g.setColor(color);
        	//g.setColor(color);
        	//g.fillOval(x - diameter/2, y - diameter/2, diameter, diameter);
        	g.drawOval(x - diameter/2, y - diameter/2, diameter,diameter );
        	g.drawOval(x - diameter/4, y - diameter/4, diameter/2,diameter/2 );
        	//g.drawOval(x+50, y-110, 10, 200);
        	//g.drawLine(x, y, diameter, diameter);
        	g.drawArc(x-diameter/2, y-diameter/2, diameter,diameter/2, 200, 140);
        	g.drawArc(x-diameter/2, y, diameter,diameter,30,120);
        	g.drawArc(x-diameter, y-diameter/2, diameter,diameter,60,-120);
        	//g.drawArc((x-diameter/2)-100, (y-diameter/2)-100, diameter,diameter,60,-120);
        	g.drawArc(x, y-diameter/2, diameter,diameter,120,120);
			g.dispose();
        	
        }
        
        if(ControlBtn.equalsIgnoreCase("pokeball")){
        	int diameter = 200;
        	Graphics g = getGraphics();
        	Graphics2D poke = (Graphics2D)g;
        	Graphics h = getGraphics();
        	Graphics2D ball = (Graphics2D)h;
        	Graphics i = getGraphics();
        	Graphics2D pika = (Graphics2D)i;
        	Graphics t = getGraphics();
        	Graphics2D center = (Graphics2D)t;
        	Graphics a = getGraphics();
			Graphics2D circumference = (Graphics2D)a;
			circumference.setStroke(new BasicStroke(10));
			circumference.setColor(Color.BLACK);
        	poke.setColor(Color.red);
        	ball.setColor(new Color(255, 255, 204));
        	pika.setColor(Color.BLACK);
        	center.setColor(Color.white);
            poke.fillArc(x-diameter/2, y-diameter/2,diameter, diameter, 0, 180);
            ball.fillArc(x-diameter/2, y-diameter/2, diameter, diameter, 0, -180);
            pika.fillArc(x-diameter/8, y-diameter/8, diameter/4, diameter/4, 0, 360);
            center.fillArc(x-diameter/30, y-diameter/30, diameter/16, diameter/16, 0, 360);
            circumference.drawOval(x-diameter/2, y-diameter/2, diameter, diameter);
        	//g.fillOval(x - diameter/2, y- diameter/2, diameter, diameter);
			//g.dispose();
        	

        }
        if(ControlBtn.equalsIgnoreCase("Poligon")){
        	Graphics g = getGraphics();
        	int xpoints[] = {x+25, x+145, x+25, x+145, x+25};
            int ypoints[] = {y+25, y+25, y+145, y+145, y+25};
            int npoints = 5;
            
            g.drawPolygon(xpoints, ypoints, npoints);

        }
        if(ControlBtn.equalsIgnoreCase("anim")){
        	Graphics g = getGraphics();
        	Graphics2D g2 = (Graphics2D) g;
            Image img1 = Toolkit.getDefaultToolkit().getImage(Meme.class.getResource("/pack1/pikachu.png"));
            g2.drawImage(img1, x-64, y-64, this);
            g2.finalize();

        }
	
        if(ControlBtn.equalsIgnoreCase("arc")){
        	Graphics g = getGraphics();
        	g.setColor(color);
        	g.drawArc(x, y, slidervalue+100, slidervalue+100, 45, 200);

        }
		
		if(ControlBtn.equalsIgnoreCase("circle")){
			 int diameter = 50;
			 Graphics g = getGraphics();
				g.setColor(color);
				g.fillOval(x - diameter/2, y - diameter/2,slidervalue+diameter,slidervalue+diameter);
				g.dispose();
		}
		if(ControlBtn.equalsIgnoreCase("square")){
			Graphics a = getGraphics();
			a.setColor(color);
			a.fillRect(x, y,slidervalue+ 50,slidervalue+ 50);
			a.dispose();
		}
		if(ControlBtn.equalsIgnoreCase("rect")){
			Graphics a = getGraphics();
			a.setColor(color);
			a.fillRect(x, y,slidervalue+50,slidervalue+100);
			a.dispose();
		}
		if(ControlBtn.equalsIgnoreCase("triangle")){
			int[]arrx = new int[3];
			int[]arry = new int[3];
			int n;  // count of points
				
			arrx[0]=x+100; arrx[1]=x+150; arrx[2]=x+50;
			arry[0]=y+100; arry[1]=y+150; arry[2]=y+150;
			n = 3;
			Graphics b = getGraphics();
			b.setColor(color);
			b.fillPolygon(arrx, arry, n);
			b.dispose();
		}
			
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(ControlBtn.equalsIgnoreCase("text")){
			requestFocus();//request the focus on the jpanel when the mouse enters
			record(e.getX(), e.getY());
		}
		if(ControlBtn.equalsIgnoreCase("free")){
			requestFocus();//request the focus on the jpanel when the mouse enters
			record(e.getX(), e.getY());
			
		}
		if(ControlBtn.equalsIgnoreCase("image")){
			requestFocus();//request the focus on the jpanel when the mouse enters
			record(e.getX(), e.getY());
		}
		///eraser
		if(ControlBtn.equalsIgnoreCase("eraser")){
			requestFocus();//request the focus on the jpanel when the mouse enters
			record(e.getX(), e.getY());
			
		}
		
		if (ControlBtn.equalsIgnoreCase("line")){
		lastX = e.getX();
		lastY = e.getY();
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}
	
	//////////////////
	protected void record(int x, int y){
		lastX = x;
		lastY = y;
	}
	
	//////////////////////
	@Override
	public void mousePressed(MouseEvent e) {
		if(ControlBtn.equalsIgnoreCase("text")){
			mouseIsPressed = true;
			record(e.getX(), e.getY());
		}
		
		if(ControlBtn.equalsIgnoreCase("free")){
			mouseIsPressed = true;
			record(e.getX(), e.getY());
			
		}
		
		if(ControlBtn.equalsIgnoreCase("eraser")){
			mouseIsPressed = true;
			record(e.getX(), e.getY());
			
		}
		
		if (ControlBtn.equalsIgnoreCase("line")){
		lastX = e.getX();
		lastY = e.getY();
		//System.out.println("PRESSED AT: "+lastX+","+lastY);
		}
		
	}
	
	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(ControlBtn.equalsIgnoreCase("text")){
			mouseIsPressed = false;
			int x = e.getX();
			int y = e.getY();
			Graphics t=getGraphics();
			t.drawLine(lastX, lastY, x, y);
		}
		
		if(ControlBtn.equalsIgnoreCase("free")){  ////iwas here
			mouseIsPressed = false;
			int x = e.getX();
			int y = e.getY();
			Graphics g = getGraphics();
			g.drawLine(lastX, lastY, x, y);
			record(x, y);
			g.dispose();
		}
		
		if (ControlBtn.equalsIgnoreCase("line")){
			
		int x = e.getX();
		int y = e.getY();

		if(stroke.equalsIgnoreCase("brush")){
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(slidervalue));
			g2d.setColor(color);
			g2d.drawLine(lastX, lastY, x, y);
			g2d.drawLine(lastX, lastY, x+10, y+10);
			g2d.drawLine(lastX, lastY, x+20, y+20);
			lastX = x;
			lastY = y;
			g.dispose();
			
		}
		if(stroke.equalsIgnoreCase("spray")){
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(slidervalue));
			g2d.setColor(color);
			g2d.drawLine(lastX, lastY, x, y);
			lastX = x;
			lastY = y;
			g2d.dispose();
		}
		
		if(stroke.equalsIgnoreCase("gradient")){
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(slidervalue));
            GradientPaint gp = new GradientPaint(20f,20f,Color.RED,380f,280f,Color.orange);
            g2d.setPaint(gp);
			g2d.drawLine(lastX, lastY, x, y);
			lastX = x;
			lastY = y;
			record(x, y);
			g.dispose();
		}
		if(stroke.equalsIgnoreCase("pencil")){
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(slidervalue));
		g2d.setColor(color);
		g2d.drawLine(lastX, lastY, x, y);
		lastX = x;
		lastY = y;
		g.dispose();
	
		}
		}
	}
	
	public void isUsed(){
		isBeingUsed=false? true:false;
		controlLine.setVisible(isBeingUsed);
	}
	public void isUsed2(){
		isBeingUsed=true;
		controlLine.setVisible(isBeingUsed);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String face =e.getActionCommand();
		
		for(int i=0;i<arrtwo.length;i++){
			if(face.equalsIgnoreCase(arrtwo[i])){
				ControlBtn=arrtwo[i];
				//buttonControl=i;
			}
			
		}
		if(face.equalsIgnoreCase("square")){
			isUsed2();
		}
		if(face.equalsIgnoreCase("oval")){
			isUsed2();
		}
		if(face.equalsIgnoreCase("triangle")){
			isUsed2();
		}
		if(face.equalsIgnoreCase("arc")){
			isUsed2();
		}
		if(face.equalsIgnoreCase("rect")){
			isUsed2();
		}
		if(face.equalsIgnoreCase("circle")){
			isUsed2();
		}
		
		if(face.equalsIgnoreCase("gradient")){
			stroke="gradient";
		}
		if(face.equalsIgnoreCase("brush")){
			stroke="brush";
		}
		if(face.equalsIgnoreCase("spray")){
			stroke="spray";
		}
		if(face.equalsIgnoreCase("pencil")){
			stroke="pencil";
		}
		
		if(face.equalsIgnoreCase("clear")){
			isUsed();
			setBackground(Color.white);
			repaint();
		}
		if(face.equalsIgnoreCase("meme")){
			isUsed();
			window.setVisible(true);
			
		
			
			//add(memePanel,BorderLayout.CENTER);
			
		}
		if(face.equalsIgnoreCase("book")){
			 isUsed();
			 Graphics g = getGraphics();
	        	Graphics2D g2 = (Graphics2D) g;
	            Image img1 = Toolkit.getDefaultToolkit().getImage(Meme.class.getResource("/pack1/pikapika.png"));
	            g2.drawImage(img1,300 ,100 , this);
	            g2.finalize();
			
		}
		if(face.equalsIgnoreCase("text")){
			isUsed2();
			colorLinebtn.setEnabled(true);
			
		}
		if(face.equalsIgnoreCase("line")){
			isUsed2();
			colorLinebtn.setEnabled(true);
		}
		if(face.equalsIgnoreCase("free")){
			
			isUsed2();
			colorLinebtn.setEnabled(true);
		}
		if(face.equalsIgnoreCase("back")){
			color2 = JColorChooser.showDialog(this, "Color", Color.PINK);
			isUsed2();
			setBackground(color2);
		}
		
		if(face.equalsIgnoreCase("Color")){
			 color = JColorChooser.showDialog(this, "Color", Color.PINK);
			 sliderColorLabel.setBackground(color);
			 
			
		}
		if(face.equalsIgnoreCase("mandala")){
			isUsed();
		}
		if(face.equalsIgnoreCase("star")){
			isUsed2();
		}
		if(face.equalsIgnoreCase("pokeball")){
			isUsed();
		}
		
		if(face.equalsIgnoreCase("anim")){
			isUsed();
		}
		if(face.equalsIgnoreCase("dragon")){
			isUsed();
		}
		
		if(face.equalsIgnoreCase("eraser")){
			isUsed2();
             Component[] components = controlLine.getComponents(); 
             Component component = null; 
              for (int i = 0; i < components.length; i++) {
            	  component = components[i]; 
               if (component instanceof JButton){
            	   colorLinebtn.setEnabled(false);
               }
                   
             

              } 
              } 

			
		
			
			
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
	String s = String.valueOf(e.getKeyChar());
    if(ControlBtn.equalsIgnoreCase("text")){
    	if(!mouseIsPressed){
			Graphics g = getGraphics();
			lastX += fm.stringWidth(s);
			g.setFont(font);
			g.setColor(color);
			g.drawString(s, lastX, lastY);
			g.dispose();
    	}
    	System.out.println("In key typed "+ s);
		}
	}


	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(ControlBtn.equalsIgnoreCase("Dragon")){
			 mouseIsPressed = true;
			 Graphics g = getGraphics();
	        	Graphics2D g2 = (Graphics2D) g;
	            Image img1 = Toolkit.getDefaultToolkit().getImage(Meme.class.getResource("/pack1/dragon.png"));
	            g2.drawImage(img1, x-64, y-64, this);
	            g2.finalize();
		}
		if(ControlBtn.equalsIgnoreCase("eraser")){
            mouseIsPressed = true;
			Graphics a = getGraphics();
			Graphics2D eraser = (Graphics2D)a;
			eraser.setStroke(new BasicStroke(slidervalue));
			Color defaultColor = getBackground();
			//eraserColor.get
			eraser.setColor(defaultColor);
			eraser.drawLine(lastX, lastY, x, y);
		//	g.drawLine(10, 10, 100, 100);
			record(x, y);
			eraser.dispose();
		}
		
		if(ControlBtn.equalsIgnoreCase("line")){
			
			/*
			if(stroke.equalsIgnoreCase("pencil")){
				                                        ////// i was here
				Graphics g = getGraphics();
				g.drawLine(x, y, lastX, lastY);
				g.dispose();
			}
			*/
		}
		
		if(ControlBtn.equalsIgnoreCase("free")){
			mouseIsPressed = true;
			if(stroke.equalsIgnoreCase("brush")){
				Graphics g = getGraphics();
				Graphics2D g2d = (Graphics2D)g;
				g2d.setStroke(new BasicStroke(slidervalue));
				g2d.setColor(color);
				g2d.drawLine(lastX, lastY, x, y);
				g2d.drawLine(lastX, lastY, x+10, y+10);
				g2d.drawLine(lastX, lastY, x+20, y+20);
				record(x, y);
				g.dispose();
				
			}
			if(stroke.equalsIgnoreCase("spray")){
				int diameter=slidervalue+5;
				Graphics g = getGraphics();
				Graphics2D g2d = (Graphics2D)g;
				g2d.setStroke(new BasicStroke(slidervalue));
				g2d.setColor(color);
				g2d.fillOval(x - diameter/2, y - diameter/2, diameter, diameter);
				record(x, y);
				g2d.dispose();
			}
			
			if(stroke.equalsIgnoreCase("gradient")){
				Graphics g = getGraphics();
				Graphics2D g2d = (Graphics2D)g;
				g2d.setStroke(new BasicStroke(slidervalue));
                GradientPaint gp = new GradientPaint(20f,20f,Color.BLACK,380f,280f,Color.orange);
                g2d.setPaint(gp);
				//g2d.setColor(gp);
				g2d.drawLine(lastX, lastY, x, y);
			//	g.drawLine(10, 10, 100, 100);
				record(x, y);
				g.dispose();
			}
			if(stroke.equalsIgnoreCase("pencil")){
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(slidervalue));
			g2d.setColor(color);
			g2d.drawLine(lastX, lastY, x, y);
		//	g.drawLine(10, 10, 100, 100);
			record(x, y);
			g.dispose();
		}
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {
	
		
	}




	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


//////////////slider

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source=(JSlider)e.getSource();
		if(source==slider){
			slidervalue=(int)source.getValue();
		}
		
		
	
		
		
	}

}
