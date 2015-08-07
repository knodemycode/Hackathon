import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonImage {

	public static void main(String[] args) {
		//Create a JFrame to put the image in
		JFrame myFrame = new JFrame("PictureButton");
		myFrame.setSize(600,  600); //these are the dimensions of the frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set up an image icon and turn it into a label
		ImageIcon icon = new ImageIcon("milk.jpg"); //use a valid filename here
		//the image file must be in the Eclipse project
		
		JLabel myPicButton = new JLabel(icon);
		
		//a mouse listener listens for mouse click
		myPicButton.addMouseListener(new MouseAdapter(){
			@Override
			 public void mouseClicked(MouseEvent e)
	            {
					//this is what the image "button" does when pressed
	                System.out.println("Image button works!");
	            }
		});

		//add panel to the frame
		myFrame.add(myPicButton);
		myFrame.setVisible(true);
		
	}

}
