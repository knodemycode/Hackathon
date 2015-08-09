import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Base implements ActionListener {
	public static Base base;
	public JPanel panel;
	Keyboard key;
	public static int width = 500, height = width; // height and width of the frame

	public final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3, PAUSE = 4, SCALE = 10; // initializes direction values

	public int direction = DOWN, score = 0, ticks = 0, tailLength = 0; // initializes variables

	ArrayList<Point> points = new ArrayList<Point>(); // the arraylist of points at where the snake is

	public static Point head, food; // certain points for the head and food

	boolean gameOver = false, paused = false;

	public Timer timer = new Timer(20, this); // creates a timer that runs the "ActionPerformed" method every 20 ms

	public static void main(String[] args) {
		base = new Base();
	}

	public void startGame() { // this method sets the variables to their default values
		ticks = 0;
		score = 0;
		tailLength = 0;
		direction = DOWN;
		gameOver = false;
		paused = false;
		points.clear();
		head = new Point(width / 2, height / 2);
		int origX = new Random().nextInt(width - 50);
		while (!((origX % 10) == 0)) {
			origX++;
		}
		int origY = new Random().nextInt(height - 50);
		while (!((origY % 10) == 0)) {
			origY++;
		}
		food = new Point(origX, origY);
		points.add(head);
	}

	public Base() {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel = new genPanel();
		frame.add(panel);
		key = new Keyboard();
		frame.addKeyListener(key);
		points.clear();
		// head = new Point(width / 2, height / 2);
		startGame(); // starts the game
		timer.start(); // starts the timer
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ticks++;
		key.update(); // for keyboard input
		setDirection(); // gets/sets keyboard values
		panel.repaint(); // re-runs the paint method

		if (ticks % 3 == 0) {
			points.add(new Point(head.x, head.y));

			if (head.x % 10 == 0 && head.y % 10 == 0) {
				if (direction == PAUSE) {
					head = new Point(head.x, head.y);
				}
				if (direction == UP) {
					if (!tailCheck(head.x, head.y - 10)) { // if there is no tail piece at the point where you are going to move to
						head = new Point(head.x, head.y - 10); // then you can move to that point
						if (head.x > width) head = new Point(head.x - width, head.y);
						if (head.x < 0) head = new Point(head.x + width, head.y);
						if (head.y > height) head = new Point(head.x, head.y - height);
						if (head.y < 0) head = new Point(head.x, head.y + height);
					} else { // or else, the game ends because you have collided
						gameOver = true;
					}
				}

				if (direction == RIGHT) {
					if (!tailCheck(head.x + 10, head.y)) {
						head = new Point(head.x + 10, head.y);
						if (head.x > width) head = new Point(head.x - width, head.y);
						if (head.x < 0) head = new Point(head.x + width, head.y);
						if (head.y > height) head = new Point(head.x, head.y - height);
						if (head.y < 0) head = new Point(head.x, head.y + height);
					} else {
						gameOver = true;
					}
				}
				if (direction == DOWN) {
					if (!tailCheck(head.x, head.y + 10)) {
						head = new Point(head.x, head.y + 10);
						if (head.x > width) head = new Point(head.x - width, head.y);
						if (head.x < 0) head = new Point(head.x + width, head.y);
						if (head.y > height) head = new Point(head.x, head.y - height);
						if (head.y < 0) head = new Point(head.x, head.y + height);
					} else {
						gameOver = true;
					}
				}
				if (direction == LEFT) {
					if (!tailCheck(head.x - 10, head.y)) {
						head = new Point(head.x - 10, head.y);
						if (head.x > width) head = new Point(head.x - width, head.y);
						if (head.x < 0) head = new Point(head.x + width, head.y);
						if (head.y > height) head = new Point(head.x, head.y - height);
						if (head.y < 0) head = new Point(head.x, head.y + height);
					} else {
						gameOver = true;
					}
				}
			}
			if (points.size() > tailLength) points.remove(0);

			if (head.equals(food)) { 
				int origX = new Random().nextInt(width - 50);
				while (!((origX % 10) == 0)) {
					origX++;
				}
				int origY = new Random().nextInt(height - 50);
				while (!((origY % 10) == 0)) {
					origY++;
				}
				food.setLocation(origX, origY);		//sets the new location of the food
				tailLength += 3; //adds tails
				score += 10;
			}
		}
	}

	public boolean tailCheck(int x, int y) {					//checks for tail collision
		if (base.tailLength > 0) {
			for (Point point : points) {
				if (point.equals(new Point(x, y))) {
					return true;
				}
			}
		}
		return false;
	}

	public void setDirection() {
		if (direction != DOWN && key.up) {
			direction = UP;
		} else if (direction != LEFT && key.right) {
			direction = RIGHT;
		} else if (direction != UP && key.down) {
			direction = DOWN;
		} else if (direction != RIGHT && key.left) {
			direction = LEFT;
		}
		if (key.P) direction = PAUSE;
		paused = true;
	}

}

class genPanel extends JPanel {
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Base.width, Base.height);
		Base base = Base.base;
		if (!base.gameOver) {
			g.setColor(Color.RED);
			g.fillRect(Base.food.x, Base.food.y, 10, 10);

			g.setColor(Color.BLUE);

			for (Point point : base.points) {
				g.fillRect(point.x, point.y, 10, 10);
			}
			g.setColor(new Color(new Random().nextInt()));
			g.setFont(new Font("Impact", 0, 30));
			g.setColor(Color.WHITE);
			g.drawString("Score: " + base.score, 30, 30);
		}
		if (base.gameOver) {
			g.setFont(new Font("Impact", 0, 30));
			g.setColor(Color.WHITE);
			g.drawString("You Lost!", 100, 100);
			g.drawString("Press Space to play again.", 100, 150);
			if ((base.gameOver) && base.key.shoot) {
				base.startGame();
			}
		}
	}

}

class Keyboard implements KeyListener {
	public boolean[] keys = new boolean[120];
	public boolean up;
	public boolean down;
	public boolean right;
	public boolean left;
	public boolean R;
	public boolean P;
	public boolean shoot;

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		R = keys[KeyEvent.VK_R];
		P = keys[KeyEvent.VK_P];
		shoot = keys[KeyEvent.VK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {

	}

}
