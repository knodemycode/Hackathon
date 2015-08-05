package HelloWorld;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MoarThings {
	
	static String aText = "First Text";
	static String bText = "Second Text";
	
	static JFrame myFrame;
	static JPanel upPanel;
	static JTextArea textBox;
	static JPanel downPanel;
	
	static boolean aPress;
	static boolean bPress;

	public static void main(String[] args) {
		myFrame = new JFrame();
		upPanel = new JPanel();
		textBox = new JTextArea();
		downPanel = new JPanel();
		aPress = false;
		bPress = false;
		
		JButton aButton = new JButton("Option A");
		aButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	            {
				 	aPress = true;
	            }
		});

		
		JButton bButton = new JButton("Option B");
		bButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	            {
				 	bPress = true;
	            }
		});
		
		myFrame.setSize(600,  200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		downPanel.add(aButton);
		downPanel.add(bButton);
		myFrame.add(downPanel, BorderLayout.CENTER);
		upPanel.add(textBox);
		myFrame.add(upPanel, BorderLayout.NORTH);
		
		function1();
	}
	
	public static void function1(){
		textBox.setText("You come across a Hallway.  (a) Go left  (b) Go right");
		while(!aPress && !bPress){
			System.out.println("");
		}
		if(aPress){
			aPress = false;
			function2();	
		}
		else if(bPress){
			bPress = false;
			function3();
		}
	}
	
	public static void function2(){
		textBox.setText("You lose");
	}
	
	public static void function3(){
		textBox.setText("You win");
	}

}