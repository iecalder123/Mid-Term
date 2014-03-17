import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Zelda extends JFrame implements KeyListener, ActionListener {
	
	private Timer time;
	private JFrame win;
	private GraphicsPanel gp;
	
	public Zelda(){
	int ix = 0, iy = 0;
	win = new JFrame("Zelda");
	gp = new GraphicsPanel();
	win.add(gp);
	win.setSize(250 + ix, 272 +iy);
	win.setVisible(true);
	time = new Timer(100,this);
	time.start();
	win.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		gp.update();
		gp.repaint();
     //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/**
	 * @param args
	 **/
	public static void main(String Args[]){
		new Zelda();
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		//TODO Auto-Generated method stub
		//System.out.println("K"+e.getKeyCode());
		if(e.getKeyCode()==38){gp.hero.direction='u'; gp.hero.isMoving=true;}
		else if(e.getKeyCode()==40){gp.hero.direction='d'; gp.hero.isMoving=true;}
		else if(e.getKeyCode()==39){gp.hero.direction='r'; gp.hero.isMoving=true;}
		else if(e.getKeyCode()==37){gp.hero.direction='l'; gp.hero.isMoving=true;}
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		// TODO Auto-generated method stub
		if(e.getKeyCode()==38){gp.hero.isMoving=false;}
		else if(e.getKeyCode()==40){gp.hero.isMoving=false;}
		else if(e.getKeyCode()==39){gp.hero.isMoving=false;}
		else if(e.getKeyCode()==37){gp.hero.isMoving=false;}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}