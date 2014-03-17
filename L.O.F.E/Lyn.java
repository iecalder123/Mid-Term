import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Lyn{
	public int x,y;
	private int xspeed,yspeed;
	private BufferedImage img[];
	private int currframe;
	private int maxframe;
	public char direction;
	private int tick;
	private final int maxtick=1;
	private BufferedImage[] up=new BufferedImage[3];
    private BufferedImage[] down=new BufferedImage[3];
    private BufferedImage[] left=new BufferedImage[3];
    private BufferedImage[] right=new BufferedImage[3];
	public boolean isMoving;
	public Lyn(){
		x=115;
		y=180;
		tick=0;
		xspeed=2;
		yspeed=0;
		currframe=0;
		isMoving=false;
		maxframe=2;
	try{
	for(int i=0;i<3;i++){        
                down[i] = ImageIO.read(new File("Lyn_Down/Lyn_Down_"+i+".png"));
                }
            for(int i=0;i<2;i++){
          
            left[i] = ImageIO.read(new File("Lyn_Right/Lyn_Right_"+i+".png"));
            }
            for(int i=0;i<2;i++){
                    
            up[i] = ImageIO.read(new File("Lyn_Forward/Lyn_Forward_"+i+".png"));
            }
            for(int i=0;i<2;i++){

            right[i] = ImageIO.read(new File("Lyn_Left/Lyn_Left_"+i+".png"));
            }
    
}catch (IOException e)
{e.printStackTrace();}
}

	
	public int getX(){return x;}
	public void setX(int _x){x=_x;}
	public int getY(){return y;}
	public void setY(int _y){y=_y;}
	
	public void update(){
		tick++;
		if(tick>maxtick){
			tick=0;
			currframe++;
			if(currframe>=maxframe){
				currframe=0;
			}
		}
		if(isMoving){
			switch(direction){
				case 'u': y-=5; break;
				case 'r': x+=5; break;
				case 'l': x-=5; break;
				case 'd': y+=5; break;
			}
		}
	}
	
	public void draw(Graphics g){
		switch (direction){
			case 'u': g.drawImage(up[currframe],x,y,null); break;
			case 'd': g.drawImage(down[currframe],x,y,null); break;
			case 'l': g.drawImage(left[currframe],x,y,null); break;
			case 'r': g.drawImage(right[currframe],x,y,null); break;
		}
	}
	
	private int top_x,top_y,width,height;

	public int getTopX(){if(direction=='u'||direction=='d')return x; return x;}
	public int getTopY(){if(direction=='u'||direction=='d')return y; return y;}
	public int getWidth(){if(direction=='u'||direction=='d')return 25; return 25;}
	public int getHeight(){if(direction=='u'||direction=='d')return 25; return 25;}

}