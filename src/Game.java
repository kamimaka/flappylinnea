import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable,KeyListener{
	private BufferedImage back;
	private int key;
	private Box r3;
	private Box r4;
	private Box r5;
	private Box r6;
	private Box r7;
	private Sound p;
	private Pictures bi;
	private Sound linneaay;
	private int score;
	private Pictures linneaa;
	private int collision;
	private double dx;
	private ArrayList <Box> obs;
	private boolean win;
	
	public Game() {
		back=null;
		new Thread(this).start();
		this.addKeyListener(this);
		bi=new Pictures("fpb.png",0,0,800,600);
		score=0;
		key=-1;
		r3= new Box();
		r4=new Box(240,380);
		r5=new Box(390,400);
		r6=new Box(530,400);
		r7=new Box(670,400);
		
		Sound p=new Sound();
		p.playmusic("mario.wav");
		
		Sound linneaay= new Sound();
		linneaay.playmusic("linneaay.wav");
						
		obs= setObs();
		dx=0;
		win=false;
		
		linneaa=new Pictures("linneaa.png",10,300,1,1,50,50,true,false);
		collision=1;
			}
	
	private ArrayList<Box> setObs() {
		
		ArrayList <Box> temp = new ArrayList <Box> ();
		temp.add(new Box(90, 0, 70, 310));
		temp.add(new Box(90,430, 70, 310));
		
		temp.add(new Box(240, 0, 70,270));
		temp.add(new Box(240, 400, 70, 400));
		
		temp.add(new Box(390,0,70,320));
		temp.add(new Box(390,440,70,160));
		
		temp.add(new Box(530,0,70,380));
		temp.add(new Box(530,500,70,290));
		
		temp.add(new Box(670,0,70,360));
		temp.add(new Box(670,460,70,170));
	      
		return temp;
	}

	public void run() {
		try {
            			while(true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e) {}
	}
public void paint (Graphics g)
{

	Graphics2D twoDgraph = (Graphics2D)g;
		
			if (back==null) {

				back =(BufferedImage) (createImage(getWidth(), getHeight()));
			}
				

			Graphics g2d = back.createGraphics();
				
			g2d.clearRect(0, 0, getSize().width, getSize().height);
			g2d.drawImage(new ImageIcon(bi.getPic()).getImage(),bi.getX(),bi.getY(), bi.getwidth(), bi.getheight(), this);
			g2d.setColor(Color.orange );
			g2d.setFont(new Font("chiller",Font.BOLD,25));
			g2d.drawString("SCORE " +score,0,30);

				if(win) {
					g2d.setFont(new Font("chiller", Font.BOLD,100));
					g2d.drawString("Game Over", 220, 300);
}
			else {
				move();
        	}
							
				
	if(linneaa.Collision(r3)&&collision==1) {
	collision++;
		score+=10;}
	
	if(linneaa.Collision(r4)&&collision==2) {
	collision++;
	score+=10;
}
	if(linneaa.Collision(r5)&&collision==3) {
		collision++;
		score+=10;
	}
	if(linneaa.Collision(r6)&&collision==4) {
		collision++;
		score+=10;
	}
	if(linneaa.Collision(r7)&&collision==5) {
		collision++;
		score+=10;
	}
	
	g2d.drawImage(new ImageIcon(linneaa.getPic()).getImage(),linneaa.getX(),linneaa.getY(),linneaa.getwidth(),linneaa.getheight(),this);
	g2d.setColor(Color.ORANGE);

	for(int i=0; i<obs.size(); i++) {
		g2d.fillRect(obs.get(i).getX(),obs.get(i).getY(), obs.get(i).getW(), obs.get(i).getH());
		if(linneaa.Collision(obs.get(i))) {
			obs.clear();
			win=true;
		
	}
}
	dx+=.6;

twoDgraph.drawImage (back, 0, 0, null);

}

public void move() {
	linneaa.move((int)dx);
}
	public void keyTyped(KeyEvent e){
		
}

		public void keyPressed(KeyEvent e){
			key=e.getKeyCode();
				System.out.println(key);
	
		if(key==32) {
			linneaa.setDy(-1);
		}			

}
	public void keyReleased(KeyEvent e){
		key=e.getKeyCode();
		if(key==39) {
		
		}
		if(key==37) {
		
		}
		if(key==40){
		
		}
		if(key==32){
			linneaa.setDy(1);
		}

{
}
}}