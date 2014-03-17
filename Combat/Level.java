import java.awt.Font;
import java.awt.Graphics;


public class Level {
  int level;
	public Level(int i) {
		level=i;
		// TODO Auto-generated constructor stub
	}
	
	
	public void draw(Graphics g){
	
		Font font = new Font("Impact", Font.PLAIN, 85);
		
//		g.drawString("DURDLE BEACH" 100, 70);
		
		g.fillRect(355,80,90,400);
	  g.fillRect(100, 240, 600, 90);
		
	}

}
