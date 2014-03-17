import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Combat implements KeyListener, ActionListener{

	private JFrame window;
	private CombatPanel cp;
	private Timer timer;

	public Combat() {
		window=new JFrame("Combat Game");
		cp=new CombatPanel();
		window.add(cp);
		window.setSize(800, 600);
		timer=new Timer(100,this);
		timer.start();
		window.setVisible(true);
		window.addKeyListener(this);
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e){
		cp.update();
		cp.repaint();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Combat();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("K"+e.getKeyCode());
		if(e.getKeyCode()==38){cp.moveDir('u',1);}  //W-UP
		else if(e.getKeyCode()==40){cp.moveDir('d',1);}	  
		else if(e.getKeyCode()==39){cp.moveDir('r',1);}	 
		else if(e.getKeyCode()==37){cp.moveDir('l',1);}   
	
			
		else if(e.getKeyCode()==65){cp.moveDir('l',2);}
		else if(e.getKeyCode()==83){cp.moveDir('d',2);}
		else if(e.getKeyCode()==68){cp.moveDir('r',2);}
		else if(e.getKeyCode()==87){cp.moveDir('u',2);}
		
		else if(e.getKeyCode()==10){cp.Fire(1);}
		else if(e.getKeyCode()==32){cp.Fire(2);}


		cp.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}