import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Screen{
	
	private BufferedImage img[];
	private final int SPRITE_WIDTH=25;
	private final int SPRITE_HEIGHT=25;
	public int level=0;
	private int map[][]={//Starting place
			{2, 2, 0, 1, 3, 3, 1, 0, 2, 2},
			{2, 6, 7, 1, 3, 3, 1, 6, 7, 2},
			{1, 4, 5, 0, 0, 0, 0, 4, 5, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 6, 7, 0, 0, 0, 0, 6, 7, 1},
			{2, 4, 5, 0, 0, 0, 0, 4, 5, 2},
			{2, 2, 1, 1, 1, 1, 1, 1, 2, 2}
	};//map
	private int map2[][]={//First Road
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2},
			{2, 2, 2, 1, 3, 3, 1, 2, 2, 2}
	};//Map2
	private int map3[][]={//Cross Road
			{0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
			{0, 0, 0, 0, 3, 3, 0, 0, 0, 0},
			{8, 0, 0, 0, 3, 3, 0, 0, 0, 8},
			{2, 8, 8, 8, 3, 3, 8, 8, 8, 2}
	};//map3
	private int map4[][]={//Snow Dungeon
			{0, 0, 0, 9,  10, 11, 12, 0, 0, 17},
			{0, 0, 0, 14, 13, 13, 15, 0, 0, 17},
			{0, 0, 0, 0,  16, 16, 0, 0, 0, 17},
			{3, 16, 16, 16, 16, 16, 0, 0, 0, 17},
			{3, 16, 16, 16, 16, 16, 0, 0, 0, 17},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 17},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 17},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 17},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 17},
			{8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
	};//map4
	private int map5[][]={//Inside Dungeon
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 18, 18, 18, 18, 18, 18},
			{18, 18, 18, 18, 16, 16, 18, 18, 18, 18}
	};//map5

	public Screen(){
		img = new BufferedImage[19];
		try {
			//Trees and Water
			img[1] = ImageIO.read(new File("Desert_Tree.png"));
			img[2] = ImageIO.read(new File("Water.png"));
			img[4] = ImageIO.read(new File("BottomLeft.png"));
			img[5] = ImageIO.read(new File("BottomRight.png"));
			img[6] = ImageIO.read(new File("TopLeft.png"));
			img[7] = ImageIO.read(new File("TopRight.png"));
			img[8] = ImageIO.read(new File("WaterBottom.png"));
			//Snow Dungeon
			img[9] = ImageIO.read(new File("TopLeftD.png"));
			img[10] = ImageIO.read(new File("Head1.png"));
			img[11] = ImageIO.read(new File("Head2.png"));
			img[12] = ImageIO.read(new File("TopRightD.png"));
			img[13] = ImageIO.read(new File("DDoor.png"));
			img[14] = ImageIO.read(new File("BottomLeftD.png"));
			img[15] = ImageIO.read(new File("BottomRightD.png"));
			//Road
			img[0] = ImageIO.read(new File("Small_Desert.png"));
			img[3] = ImageIO.read(new File("Road.png"));
			img[16] = ImageIO.read(new File("Grey_Tile.png"));
			img[18] = ImageIO.read(new File("D.Floor.png"));
			//Misc.
			img[17] = ImageIO.read(new File("Rock.png"));
		}catch (IOException e)
		{e.printStackTrace();}
		level=1;
		}
	public int getLevel(){return level;}
	public void setLevel(int i){level=i;}
	//public screen
	
	boolean bounding_box_collision(int b1_x, int b1_y, int b1_w, int b1_h, int b2_x, int b2_y, int b2_w, int b2_h){
	    if ((b1_x > b2_x + b2_w - 1) || 
	        (b1_y > b2_y + b2_h - 1) || 
	        (b2_x > b1_x + b1_w - 1) || 
	        (b2_y > b1_y + b1_h - 1)){
	        return false;
	    }
	    return true;
	}

	boolean level_collision(int lx,int ly,int lw,int lh){
		int x=0,y=0;
		 for(int i=0;i<10;i++){
		   x=0;
		   for(int j=0;j<10;j++){
			   switch(level){
				case 1:
					 if(map[i][j]==1||map[i][j]==2||map[i][j]==4||map[i][j]==5||map[i][j]==6||map[i][j]==7||map[i][j]==9||map[i][j]==10||
					   map[i][j]==11||map[i][j]==12||map[i][j]==13||map[i][j]==14||map[i][j]==15||map[i][j]==17){
						 	if(bounding_box_collision(lx,ly,lw,lh,x,y,img[map[i][j]].getWidth(),img[map[i][j]].getHeight())){
						 		return true;
						 	}return false;	  
					 } break;
	 	  		case 2: 					 
	 	  			if(map2[i][j]==1||map2[i][j]==2||map2[i][j]==4||map2[i][j]==5||map2[i][j]==6||map2[i][j]==7||map2[i][j]==9||
	 	  					map2[i][j]==10||map2[i][j]==11||map2[i][j]==12||map2[i][j]==13||map2[i][j]==14||map2[i][j]==15||map2[i][j]==17){
				 	if(bounding_box_collision(lx,ly,lw,lh,x,y,img[map[i][j]].getWidth(),img[map[i][j]].getHeight())){
				 		return true;
				 	}return false;	  
			 } break;
				case 3: 
					if(map3[i][j]==1||map3[i][j]==2||map3[i][j]==4||map3[i][j]==5||map3[i][j]==6||map3[i][j]==7||map3[i][j]==9||map3[i][j]==10||
						   map3[i][j]==11||map3[i][j]==12||map3[i][j]==13||map3[i][j]==14||map3[i][j]==15||map3[i][j]==17){
				 	if(bounding_box_collision(lx,ly,lw,lh,x,y,img[map[i][j]].getWidth(),img[map[i][j]].getHeight())){
				 		return true;
				 	}return false;	  
			 } break;
				case 4: if(map4[i][j]==1||map4[i][j]==2||map4[i][j]==4||map4[i][j]==5||map4[i][j]==6||map4[i][j]==7||map4[i][j]==9||map4[i][j]==10||
						   map4[i][j]==11||map4[i][j]==12||map4[i][j]==13||map4[i][j]==14||map4[i][j]==15||map4[i][j]==17){
				 	if(bounding_box_collision(lx,ly,lw,lh,x,y,img[map4[i][j]].getWidth(),img[map4[i][j]].getHeight())){
				 		return true;
				 	}return false;	  
			 } break;
				case 5: if(map5[i][j]==1||map5[i][j]==2||map5[i][j]==4||map5[i][j]==5||map5[i][j]==6||map5[i][j]==7||map5[i][j]==9||map5[i][j]==10||
						   map5[i][j]==11||map5[i][j]==12||map5[i][j]==13||map5[i][j]==14||map5[i][j]==15||map5[i][j]==17){
				 	if(bounding_box_collision(lx,ly,lw,lh,x,y,img[map5[i][j]].getWidth(),img[map5[i][j]].getHeight())){
				 		return true;
				 	}return false;	  
			 } break;
				}
			  
		      x=x+SPRITE_WIDTH;
		      }
		    y=y+SPRITE_HEIGHT;
		 	}
		    return false;

		 }
		
	public void draw(Graphics g){
		int x=0, y=0;
		for(int i=0; i<10; i++){
			x=0;
			for(int j=0; j<10; j++){
				switch(level){
				case 1: g.drawImage(img[map[i][j]],x,y,null);  break;
	 	  		case 2: g.drawImage(img[map2[i][j]],x,y,null); break;
				case 3: g.drawImage(img[map3[i][j]],x,y,null); break;
				case 4: g.drawImage(img[map4[i][j]],x,y,null); break;
				case 5: g.drawImage(img[map5[i][j]],x,y,null); break;
				}
				x=x+SPRITE_WIDTH;
			}//forloopJ
				y=y+SPRITE_HEIGHT;
			}//forloopI
		}//public void draw
}//public class screen