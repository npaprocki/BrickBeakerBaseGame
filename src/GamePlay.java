import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;


//this entire project came from: https://youtu.be/K9qMm3JbOH0?feature=shared’ 

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;	
	
	private int ballX = 120;
	private int ballY = 120;
	private int ballXDirection = -1;
	private int ballYDirection = -2;
	
	private MapGenerator map;
	
	public GamePlay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		timer = new Timer(delay, this);
		timer.start();
		
		map = new MapGenerator(3,7);
		
	}
	
	@Override
	public void paint(Graphics g) {

		//background
		g.setColor(Color.blue);
		g.fillRect(1, 1, 692, 592);
		
		//drawing map
		map.draw((Graphics2D) g);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//scores
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ballX, ballY, 20, 20);
		
		g.dispose();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(play) {
			
			if(new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				
				ballYDirection = -ballYDirection;
				
			}
			
			A: for(int i = 0; i < map.map.length; i++) {
				
				for (int j = 0; j < map.map[0].length; j++) {
					
					if(map.map[i][j] > 0) {
						
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							
							map.setBrickValue(0, i, j);
							totalBricks--;
							score = score + 5;
							
							if(ballX + 19 <= brickRect.x || ballX + 1 >= brickRect.x + brickRect.width) {
								
								ballXDirection = -ballXDirection;
								
							} else {
								
								ballYDirection = -ballYDirection;
								
							}
							
							break A;
							
						}
								
						
					}
					
				}
				
			}
			
			ballX += ballXDirection;
			ballY += ballYDirection;
			
			//left
			if(ballX < 0) {
				
				ballXDirection = -ballXDirection;
				
			}
			
			//top
			if(ballY < 0) {
				
				ballYDirection = -ballYDirection;
				
			}
			
			//right
			if(ballX > 670) {
				
				ballXDirection = -ballXDirection;
				
			}
			
		}
		
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(playerX >= 600) {
				
				playerX = 600;
				
			} else {
				
				moveRight();
				
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			if(playerX < 10) {
				
				playerX = 10;
				
			} else {
				
				moveLeft();
				
			}
			
			
		}
		
		
	}
	
	public void moveRight() {
		
		play = true;
		playerX+=20;
		
	}
	
	public void moveLeft() {
		
		play = true;
		playerX-=20;
		
	}
	
	
}