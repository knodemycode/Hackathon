import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveShapeMouse {
	 public static void main(String[] args) {
		 	//create frame and add panel to it
	    	JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        frame.add(new MyPanel());
	        frame.pack();
	        frame.setVisible(true);
	    }
}

class MyPanel extends JPanel {
	//define what is in panel/what it does
	
	//these are the starting position of the square
    private int squareX = 50;
    private int squareY = 50;
      
    //these are the dimensions of the square
    private int squareW = 20;
    private int squareH = 20;   

    public MyPanel() {

        setBorder(BorderFactory.createLineBorder(Color.black));
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	//when the mouse is clicked, get the location of the click
                moveSquare(e.getX(),e.getY()); 
            }
        });     
    }

    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) { //if the square has moved
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET); //remove the trail
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET); //draw it again
        } 
    }
    

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        //draw a red square
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        
    }  
}
