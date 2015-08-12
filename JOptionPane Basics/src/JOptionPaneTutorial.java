import javax.swing.*;
public class JOptionPaneTutorial {
	public static void main(String[] args){
		
		
		/* This is the basic JOptionPane dialog that displays 
		   a statement and asks for user confirmation */
		JOptionPane.showMessageDialog(null //This the type of frame
				, "Hello!" //This is the string you want to print
				); //does not return anything
		
		
		/* This is the basic JOptionPane dialog that gives the user 
		 * a choice between 3 confirmation buttons: "Yes", "No", "Cancel"
		 */
		int x = JOptionPane.showConfirmDialog(null //Frame type
				, "Can you read this message?" //message
				); //returns the index of the option selected
				   /* Options can be denoted with JOptionPane.YES_OPTION 
					* or the corresponding option
					*/
		
		
		/* This is the basic JOptionPane dialog that gives the user 
		   a choice using buttons */
		Object[] options = {"Yes, please",
			"No, thanks",
            "No eggs, no ham!"};  //Different choices for buttons
			int n = JOptionPane.showOptionDialog(null, //type of frame
			"Would you like some green eggs to go with that ham?", // Text you want to print
			"A Silly Question", //Header text
			JOptionPane.YES_NO_CANCEL_OPTION, //Type of options. This is for multiple options
			JOptionPane.PLAIN_MESSAGE, //Type of message, generally use JOptionPane.PLAIN_MESSAGE
			null, // Icon to go with the frame
			options, //List of options
			options[2] //Default option
			); //returns the index of the button that was pressed
			
			
		/* This is the basic JOptionPane dialog that uses a dropdown menu 
		   and/or asks for user input */
		Object[] possibilities = {"ham", "spam", "yam"}; //Choices for the dropdown menu
		String s = (String)JOptionPane.showInputDialog(
			null, //Type of frame
			"Complete the sentence:\n" + "\"Green eggs and...\"",  // Text to be printed
			"Customized Dialog",  //header
			JOptionPane.PLAIN_MESSAGE, //Type of message, generally use JOptionPane.PLAIN_MESSAGE
			null, //icon
			possibilities, //strings in the dropdown menu; This is null if the user is to input whatever they want
			"ham" //default option
			); //returns the string that the user inputted
	}
}
