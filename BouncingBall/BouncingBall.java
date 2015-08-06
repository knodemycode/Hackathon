import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class BouncingBall extends JPanel {
    // Properties of the bouncing ball
    private int x, y;
    private int width, height;
    private int dx, dy;

    // Timer that is used by the ball
    java.util.Timer ballTimer;

    public BouncingBall() {
        // Some parameters of the ball
        x = 200;
        y = 200;
        width = 50;
        height = 50;
        dx = 1;
        dy = 1;

        setForeground(Color.RED);
        ballTimer = new java.util.Timer();

        // Run the timer
        ballTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (x < 0)
                    dx = 1;
                if (x >= getWidth() - 45)
                    dx = -1;
                if (y < 0)
                    dy = 1;
                if (y >= getHeight() - 45)
                    dy = -1;

                x += dx;
                y += dy;
                repaint(); // Very important! Render constantly
            }
        }, 0, 5);
    }

    public void paint(Graphics g) {
        super.paint(g); // Draw the panel
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For better graphics
        g2d.fillOval(x, y, width, height); // Draw the oval

    }

    public static void main(String[] args) {
        // Set properties of window
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall ballPanel = new BouncingBall();
        // Add the JPanel to the frame
        frame.getContentPane().add(ballPanel);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.add(ballPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

