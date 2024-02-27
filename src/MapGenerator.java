import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

//this entire project came from: https://youtu.be/K9qMm3JbOH0?feature=shared’ 

public class MapGenerator {

	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	public MapGenerator(int row, int col) {
		
		map = new int[row][col];
		
		for(int i = 0; i < map.length; i++) {
			
			for(int j = 0; j < map[0].length; j++) {
				
				map[i][j] = 1;
				
			}
			
		}
		
		//can change, but he recommends don't
		
		brickWidth = 540/col;
		brickHeight = 150/row;
		
	}
	
	public void draw(Graphics2D g) {
		
		for(int i = 0; i < map.length; i++) {
			
			for(int j = 0; j < map[0].length; j++) {
				
				if(map[i][j] > 0) {
					
					g.setColor(Color.white);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.blue);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
				}
				
			}
		
		}
		
		
	}
	
	public void setBrickValue(int value, int row, int col) {
		
		map[row][col] = value;
		
		
	}
	
	
	
	
}
