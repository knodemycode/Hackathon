import javax.swing.*;
import java.awt.*;

// Extend JPanel for Functionality
public class DrawShapes extends JPanel {

    // Constructor sets background of the Panel
    public DrawShapes() {
        this.setBackground(Color.WHITE);
    }

    // Function which does the main work
    public void paint(Graphics g) {
        // Draw the panel
        super.paint(g);

        // Draw an oval at 25, 25 with width and height of 120 px (Circle)
        g.drawOval(25, 25, 120, 120);
        // Draw a line at (150, 150) to the location (200, 50)
        g.drawLine(200, 50, 300, 50);
        // Draw a rectangle at 150,150 with width and height of 75 px (Square)
        g.drawRect(150, 150, 75, 75);
        // Draw a rectangle at 250, 250 with width and height of 100 and 75 px resp.
        g.drawRect(250, 250, 100, 75);

        // Drawing Strings to screen
        g.drawString("Shapes that you see:", 500, 80);
        g.drawString("1.Circle(Outline)", 500, 100);
        g.drawString("2.Square(Outline)", 500, 120);
        g.drawString("3.Rectange(Outline)", 500, 140);
        g.drawString("4.Circle(Filled)", 500, 160);
        g.drawString("5.Square(Filled)", 500, 180);
        g.drawString("6.Line", 500, 200);

        // Set color to fill the shapes
        g.setColor(Color.CYAN);
        g.fillOval(10, 200, 120, 120);
        g.setColor(Color.RED);
        g.fillRect(400, 400, 50, 100);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new DrawShapes());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960,700);
        frame.setVisible(true);
    }
}

