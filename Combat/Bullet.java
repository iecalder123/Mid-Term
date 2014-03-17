import java.awt.Graphics;
import java.awt.*;

public class Bullet{

private int x,y;
private boolean isFired;
private int xspeed=8;
private int yspeed=8;
private final int BULLET_W=2;
private final int BULLET_H=2;

public void setX(int i){x=i;}
public void setY(int i){y=i;}

public void setisFired(boolean b){
	isFired=b;
}

public boolean getIsFired(){return isFired;}

public void fire(char tankDirection, int bulletx, int bullety){
	x=bulletx;
	y=bullety;
	int spd=8;
	if(tankDirection=='u'){xspeed = 0; yspeed = -spd;}
	else if(tankDirection=='d'){xspeed = 0; yspeed = spd;}
	else if(tankDirection=='r'){xspeed = spd; yspeed = 0;}
	else if(tankDirection=='l'){xspeed = -spd; yspeed = 0;}
	isFired=true;
}

public Bullet(){
x=0;
y=0;
isFired=false;
xspeed=0;
yspeed=0;
}

public Bullet(int _x, int _y, boolean _isFired){
	x=_x;
	y=_y;
	isFired=_isFired;
	xspeed=0;
	yspeed=0;
}

public void move(){
	x+=xspeed;
	y+=yspeed;
	if(x>800) {isFired=false; x=0; y=0;}
	if(x<0) {isFired=false; x=0; y=0;}
	if(y>600) {isFired=false; x=0; y=0;}
	if(y<0) {isFired=false; x=0; y=0;}
}

public void draw(Graphics g){
	if(isFired){
	g.drawRect(x,y,BULLET_W,BULLET_H);
	}
}

public int getTopX(){return x;}
public int getTopY(){return y;}
public int getWidth(){return BULLET_W;}
public int getHeight(){return BULLET_H;}

}