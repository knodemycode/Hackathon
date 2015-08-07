import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextArea {
	/*
	 * Example of creating text area
	 */
	public static void main(String[] args) {
		//set up the JFrame
		JFrame myFrame = new JFrame("text area");
		myFrame.setSize(300,  300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a text area
		JTextArea textBox = new JTextArea();
		
		//set some text in the text area.  \n creates a newline
		textBox.setText("A bunch of text here!!!!!!!!!!!\nAnd downhere!!!"); 
		
		textBox.append("\nMORE TEXT!!!!!!"); //append adds to the end
		//textBox.setText(""); //clears the text
		
		//add text area to the frame
		myFrame.add(textBox, BorderLayout.CENTER);
		myFrame.setVisible(true);

	}

}
