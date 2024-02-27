import javax.swing.JFrame;


//this entire project came from: https://youtu.be/K9qMm3JbOH0?feature=shared’ 
public class Main {

	public static void main(String[] args) {
		//create frame
		JFrame obj = new JFrame();
		
		//create panel and add to frame
		GamePlay gamePlay = new GamePlay();
		obj.add(gamePlay);
		
		//set frame properties
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Better Brick Breaker");
		obj.setResizable(false);
		obj.setVisible(true);
		
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		

	}

}
