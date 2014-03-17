import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GraphicsPanel extends JPanel{
	
	private Screen s;
	public Hero hero;
	
	public GraphicsPanel(){
		s = new Screen();
		hero = new Hero();
	}
	
	public void update(){
		hero.update();
		
		//level 1 hubs
			if(s.getLevel()==1){
				 if ((hero.getTopY()<0)){
					 s.setLevel(2);
					 hero.setY(272-25);
				 }//going up
			}//end level 1 hubs
		//level 2 hubs
			if(s.getLevel()==2){
				 if ((hero.getTopY()<0)){
					 s.setLevel(3);
					 hero.setY(272-25);
				 }//going up
				 else if ((hero.getTopY()>272-25)){
					 s.setLevel(1);
					 hero.setY(0);
				 }//going down
			}//end level 2 hubs
			//level 3 hubs
			if(s.getLevel()==3){
				 if((hero.getTopX()>250)){
					 s.setLevel(4);
					 hero.setX(0);
					 hero.setY(hero.getTopY());
				 }//going right
				 else if ((hero.getTopY()>272-25)){
					 s.setLevel(2);
					 hero.setY(0);
				 }//going down
			}//end level 3 hubs
			//level 4 hubs
			if(s.getLevel()==4){
				 if((hero.getTopX()<0)){
					 s.setLevel(3);
					 hero.setX(248);
					 hero.setY(hero.getTopY());
				 }//going left
			}//end level 4 hubs
			
	if(s.level_collision(hero.getTopX(), hero.getTopY(), hero.getWidth(), hero.getHeight())){
		
		
		
	}
			
	}

	public void paint(Graphics g){
		s.draw(g);
		hero.draw(g);
	}
}