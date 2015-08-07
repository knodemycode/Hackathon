import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ButtonChoices {
	
	/*
	 * This class demonstrates the use of buttons to interact
	 * Given text choices
	 */
	
	//set up variables
	static String aText = "First Text";
	static String bText = "Second Text";
	
	static JFrame myFrame;
	static JPanel upPanel;
	static JTextArea textBox;
	static JPanel downPanel;
	
	static boolean aPress;
	static boolean bPress;
	
	public static void main(String[] args) {
		
		setup(); //sets up the frame and buttons
		
		game(); //begins the text adventure game
		
	}

	public static void setup(){
		/*
		 * Function to set up Frame, Panels, and Buttons
		 */
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
				 	//when button A is pressed, aPress is true
				 	aPress = true;
	            }
		});

		
		
		JButton bButton = new JButton("Option B");
		bButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
	            {
				 	//when button B is pressed, bPress is true
				 	bPress = true;
	            }
		});
		
		//set up frame
		myFrame.setSize(600,  200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
		//add buttons to lower panel
		downPanel.add(aButton);
		downPanel.add(bButton);
		
		//add text box to upper panel
		upPanel.add(textBox);
		
		//add panels to frame
		myFrame.add(downPanel, BorderLayout.CENTER);
		myFrame.add(upPanel, BorderLayout.NORTH);
		
	}
	
	
	public static void game(){
		/*
		 * this function presents a text to the frame and waits for a selection
		 */
		
		textBox.setText("You come across a Hallway.  (a) Go left  (b) Go right");
		while(!aPress && !bPress){
			System.out.println("");
		}
		if(aPress){			//if a was pressed, they lose
			aPress = false;
			textBox.setText("You lose");	
		}
		else if(bPress){	//if b was pressed, they continue
			bPress = false;
			textBox.setText("You win");
			//to continue the game instead, copy the code into this condition
			//or call a function with similar code to game()
		}
	}
	

}