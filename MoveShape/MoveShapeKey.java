import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveShapeKey {
	
    public static void main(String[] args) {
    	//Create frame and add panel to it
    	JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.add(new MyPanel2());
        frame.pack();
        frame.setVisible(true);
    }
	
}



class MyPanel2 extends JPanel {
    //define what is in the panel/what it does
	
    //these are the starting position of the circle
    private int circleX = 15;
    private int circleY = 15;
    
    //these are the dimensions of the circle
    private int circleW = 20;
    private int circleH = 20;
    
    public MyPanel2() {

        setBorder(BorderFactory.createLineBorder(Color.black));
        setFocusable(true); //must have this for key press!!
        
        addKeyListener(new KeyAdapter(){
        	 public void keyPressed(KeyEvent e) {
        	        //VK_UP  VK_LEFT  VK_RIGHT   VK_DOWN
        		 //these are the codes for the arrow keys
        		 if(e.getKeyCode() == KeyEvent.VK_UP){
        			 moveCircle(0, -5);
        		 }
        		 else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        			 moveCircle(5, 0);
        		 }
        		 else if(e.getKeyCode() == KeyEvent.VK_LEFT){
        			 moveCircle(-5, 0);
        		 }
        		 else if(e.getKeyCode() == KeyEvent.VK_DOWN){
        			 moveCircle(0, 5);
        		 }
        	    }
        });

    }
    private void moveCircle(int x, int y){
    	
        int OFFSET = 1;
        repaint(circleX,circleY,circleW+OFFSET,circleH+OFFSET); //removes the trail
        circleX+=x;
        circleY+=y;
        repaint(circleX, circleY,circleW+OFFSET,circleH+OFFSET); //draws the circle
       
    	
    }


    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        //draw a blue circle
        g.setColor(Color.BLUE);
        g.fillOval(circleX,circleY,circleW,circleH);
        
    }  
}
