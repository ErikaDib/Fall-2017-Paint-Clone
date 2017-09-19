package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel implements ActionListener {
	///JButton Jbutton_1;
   // JButton Jbutton_2;
   private int number_Of_Buttons=20;
   private JButton[] arr;
   private String[] arrtwo={"Line","Color","Circle","Square","Triangle","","","","","","","","","","","","","","",""};
   private int buttonControl=0;

	public ButtonsPanel() {
		
		setLayout(new GridLayout(2,number_Of_Buttons));
		setBackground(Color.pink);

		arr=new JButton[number_Of_Buttons];
		for(int i=0;i<number_Of_Buttons;i++){
			arr[i]=new JButton();
			arr[i].setFont(new Font("Verdana ", Font.PLAIN, 20));
			arr[i].setFocusPainted(false);
			arr[i].setBackground(new Color(195, 155, 211));
			arr[i].setForeground(Color.WHITE);
			arr[i].setText(arrtwo[i]);
			arr[i].addActionListener(this);
			add(arr[i]);
		}
	
	
	}
	public int getButtonControl(){
		return buttonControl;
	}
	
	public void setButtonControl(int buttonControl){
		this.buttonControl=buttonControl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String face =e.getActionCommand();
		for(int i=0;i<arrtwo.length;i++){
			if(face.equalsIgnoreCase(arrtwo[i])){
				buttonControl=i;
			
			}else{
				return;
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
}
