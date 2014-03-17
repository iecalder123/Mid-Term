import java.awt.*;


public class Tank {
    private Bullet b1;
	private int x;
	private int y;
	private char direction;
	private boolean box;
	public boolean isMoving;
	public void moveBullet(){
		b1.move();
	}
	public void fire(){
		if(b1.getIsFired())return;
		b1.fire(direction, x, y);
	}

	public int getX(){return x;}
	public void setX(int i){x=i;}
	public int getY(){return y;}
	public void setY(int i){y=i;}
	public void moveLeft(){
		x=x-5;
		}
	public void moveRight(){
		x=x+5;
	}
	public void moveUp(){
		y=y-5;
	}
	public void moveDown(){
		y=y+5;
	}
	public void move(char dir){
	direction=dir;
	 if(dir=='u'){y-=7;}
	 else if(dir=='d'){y+=7;}
	 else if(dir=='r'){x+=7;}
	 else if(dir=='l'){x-=7;}
	}

	public Tank(int _x,int _y) {
		x=_x;
		y=_y;
		direction='l';
		b1=new Bullet();
		// TODO Auto-generated constructor stub
	}

	
public Bullet getBullet(){
	return b1;
}
	public void draw(Graphics g){

		//box
		g.fillRect(x-10, y-10, 20, 20);
		//tread
		g.setColor(new Color(122,234,21));
		if(direction=='u'|| direction=='d'){
			g.fillRect(x-10, y-15, 5, 30);
			g.fillRect(x+10, y-15, 5, 30);
		}else if(direction=='l'||direction=='r'){
			g.fillRect(x-15, y-10, 30, 5);
			g.fillRect(x-15, y+10, 30, 5);

		}
		g.setColor(new Color(122,134,121));
		if(direction=='u'|| direction=='d')
		g.drawRect(x-10,y-15,25,30);
		else
		g.drawRect(x-15,y-10,30,25);
		//turret
		g.setColor(new Color(122,124,21));

		if(direction=='u')g.fillRect(x, y-15, 6, 15);
		if(direction=='d')g.fillRect(x, y, 6, 15);
		if(direction=='r')g.fillRect(x, y, 15, 6);
		if(direction=='l')g.fillRect(x-15, y, 15, 6);

		g.setColor(new Color(255,255,255));
		b1.draw(g);
	}
		private int top_x,top_y,width,height;

	public int getTopX(){if(direction=='u'||direction=='d')return x-10; return x-15;}
	public int getTopY(){if(direction=='u'||direction=='d')return y-15; return y-10;}
	public int getWidth(){if(direction=='u'||direction=='d')return 25; return 30;}
	public int getHeight(){if(direction=='u'||direction=='d')return 30; return 25;}


}

