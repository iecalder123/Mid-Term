import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class CombatPanel extends JPanel {

	private Tank t,t2;
	private Level l;
	
	public void Fire(int tank){
		Tank temp;
		if(tank==1)temp=t;
		else temp=t2;
		temp.fire();
	}
	
	public void update(){
		t.moveBullet();
		t2.moveBullet();
		
		Bullet b1,b2;
		b1=t.getBullet();
		b2=t2.getBullet();
		
		if(bounding_box_collision(t2.getTopX(),t2.getTopY(),t2.getWidth(),t2.getHeight(),
				b1.getTopX(),b1.getTopY(),b1.getWidth(),b1.getHeight())){
				  t.setX(300);t.setY(360);
				  t2.setX(500);t2.setY(210);
				  b1.setisFired(false);    
				}
		
		if(bounding_box_collision(t.getTopX(),t.getTopY(),t.getWidth(),t.getHeight(),
				b2.getTopX(),b2.getTopY(),b2.getWidth(),b2.getHeight())){
				t.setX(300);t.setY(360);
				t2.setX(500);t2.setY(210);
				b2.setisFired(false);    
				}
		
		if(bounding_box_collision(b1.getTopX(),b1.getTopY(),b1.getWidth(),b1.getHeight(),
				355,80,90,400)){
				  b1.setisFired(false);   
		}
		if(bounding_box_collision(b2.getTopX(),b2.getTopY(),b2.getWidth(),b2.getHeight(),
				355,80,90,400)){
				  b2.setisFired(false);   
		}
		
		if(bounding_box_collision(b1.getTopX(),b1.getTopY(),b1.getWidth(),b1.getHeight(),
				100,240,600,90)){
				  b1.setisFired(false);   
		}
		if(bounding_box_collision(b2.getTopX(),b2.getTopY(),b2.getWidth(),b2.getHeight(),
				100,240,600,90)){
				  b2.setisFired(false);   
		}
		
	}
	

	
//Tank Collision
	public void moveDir(char c,int tank){
		Tank temp;
		if(tank==1)temp=t;
		else temp=t2;
		temp.move(c);
		if(bounding_box_collision(t.getTopX(),t.getTopY(),t.getWidth(),t.getHeight(), //Tank Collision
		t2.getTopX(),t2.getTopY(),t2.getWidth(),t2.getHeight())){
		if(c=='u')temp.setY(temp.getY()+8);
		if(c=='d')temp.setY(temp.getY()-8);
		if(c=='l'){temp.setX(temp.getX()+8);
		}
		if(c=='r'){temp.setX(temp.getX()-8);
		}

		}
		//Tank on Level Collision
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				355,80,90,400)){
				if(c=='u')temp.setY(temp.getY()+8);
				if(c=='d')temp.setY(temp.getY()-8);
				if(c=='l'){temp.setX(temp.getX()+8);
				}
				if(c=='r'){temp.setX(temp.getX()-8);
				}

				}
		
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				100,240,600,90)){
				if(c=='u')temp.setY(temp.getY()+8);
				if(c=='d')temp.setY(temp.getY()-8);
				if(c=='l'){temp.setX(temp.getX()+8);
				}
				if(c=='r'){temp.setX(temp.getX()-8);
				}

				}
		//Sides
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				0,0,800,0)){
				if(c=='u')temp.setY(temp.getY()+8);
				if(c=='d')temp.setY(temp.getY()-8);
				if(c=='l'){temp.setX(temp.getX()+8);
				}
				if(c=='r'){temp.setX(temp.getX()-8);
				}

				}
		
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				0,0,0,600)){
				if(c=='u')temp.setY(temp.getY()+8);
				if(c=='d')temp.setY(temp.getY()-8);
				if(c=='l'){temp.setX(temp.getX()+8);
				}
				if(c=='r'){temp.setX(temp.getX()-8);
				}

				}
		
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				800,0,0,600)){
				if(c=='u')temp.setY(temp.getY()+8);
				if(c=='d')temp.setY(temp.getY()-8);
				if(c=='l'){temp.setX(temp.getX()+8);
				}
				if(c=='r'){temp.setX(temp.getX()-8);
				}

				}
		
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				0,580,800,0)){
				if(c=='u')temp.setY(temp.getY()+8);
				if(c=='d')temp.setY(temp.getY()-8);
				if(c=='l'){temp.setX(temp.getX()+8);
				}
				if(c=='r'){temp.setX(temp.getX()-8);
				}
		}
		
		Bullet b;
		if(tank==2)b=t.getBullet();
		else b=t2.getBullet();
		
		if(bounding_box_collision(temp.getTopX(),temp.getTopY(),temp.getWidth(),temp.getHeight(),
				b.getTopX(),b.getTopY(),b.getWidth(),b.getHeight())){
				  t.setX(300);t.setY(360);
				  t2.setX(500);t2.setY(210);
				  
			        
				}
	}

	public CombatPanel(){

	   t=new Tank(300,360);
	   t2=new Tank(500,210);
	   l=new Level(1);
	}

	boolean bounding_box_collision(int b1_x, int b1_y, int b1_w, int b1_h, int b2_x, int b2_y, int b2_w, int b2_h)
	{
	    if ((b1_x > b2_x + b2_w - 1) || // is b1 on the right side of b2?
	        (b1_y > b2_y + b2_h - 1) || // is b1 under b2?
	        (b2_x > b1_x + b1_w - 1) || // is b2 on the right side of b1?
	        (b2_y > b1_y + b1_h - 1))   // is b2 under b1?
	    {
	        // no collision
	        return false;
	    }

	    // collision
	    return true;
}

	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE); 
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.black);
		l.draw(g);
		t.draw(g);
		t2.draw(g);

	}

}
