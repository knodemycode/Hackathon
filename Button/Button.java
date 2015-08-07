import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button{
	
	/* A basic example of adding buttons to program */
	
	public static void main(String[] args) {
		//Create a frame in which to place the button
		JFrame myFrame = new JFrame("Button");
		myFrame.setSize(50,  200); //these are the dimensions of the frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//create a button with some text on the button
		JButton myButton1 = new JButton("Click me!");
		myButton1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	            {
	                //This is what button 1 does when pressed
	                System.out.println("Button 1 works!");
	            }
		});

		//you can add button 1 directly to the frame
		//this one is on the TOP
		myFrame.add(myButton1, BorderLayout.NORTH); 
		
		JButton myButton2 = new JButton("Click me2!");
		myButton2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	            {
				 	//This is what button 2 does when pressed
	                System.out.println("Button 2 works!");
	            }
		});
		
		//add button 2 to the BOTTOM of the frame
		myFrame.add(myButton2, BorderLayout.SOUTH);
		
		//frame must be visible
		myFrame.setVisible(true);
		

	}

	


	 
	  
}