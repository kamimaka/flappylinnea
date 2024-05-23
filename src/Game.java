import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
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
	private boolean start;
	private boolean lost;
	private Pictures linneaa;
	private int collision;
	private double time;
	private double ctime;
	private double dx;
	private ArrayList <Box> obs;
	private boolean win;
	public boolean reset;
	private boolean music;
	
	public Game() {
		back=null;
		new Thread(this).start();
		this.addKeyListener(this);
		bi=new Pictures("linnea.png",0,0,800,600);
		score=0;
		key=-1;
		time=System.currentTimeMillis();
		ctime=0;
		r3= new Box();
		r4=new Box(240,380);
		r5=new Box(390,400);
		r6=new Box(530,400);
		r7=new Box(670,400);
		reset=true;
		music=true;
		Sound p=new Sound();
		p.playmusic("mario.wav");
		
		Sound linneaay= new Sound();
		linneaay.playmusic("linneaay.wav");
						
		obs= setObs();
		dx=0;
		win=false;
		
		linneaa=new Pictures("linneaa.png",10,300,1,1,50,50,true,false);
		collision=1;
		start=false;
			}
	
	private ArrayList<Box> setObs() {
		
		ArrayList <Box> temp = new ArrayList <Box> ();
		temp.add(new Box(150, 0, 60, 310));
		temp.add(new Box(150,470, 60, 310));
		
		temp.add(new Box(270, 0, 60,270));
		temp.add(new Box(270, 410, 60, 400));	
		
		temp.add(new Box(390,00,60,340));
		temp.add(new Box(390,460,60,160));	
		
		temp.add(new Box(510,0,60,380));
		temp.add(new Box(510,495,60,290));
		
		temp.add(new Box(630,0,60,360));
		temp.add(new Box(630,440,60,170));
	      
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
			
			if (reset) {
				reset();
			}
				
			g2d.clearRect(0, 0, getSize().width, getSize().height);
			g2d.drawImage(new ImageIcon(bi.getPic()).getImage(),bi.getX(),bi.getY(), bi.getwidth(), bi.getheight(), this);
			g2d.setColor(Color.orange );
			g2d.setFont(new Font("chiller",Font.BOLD,25));
			
			g2d.drawString(new DecimalFormat("#0.00").format(ctime), 15, 55);
			g2d.drawString("SCORE " +score,0,30);

				if(win) {
					g2d.setFont(new Font("chiller", Font.BOLD,90));
					g2d.drawString("Game Over", 210, 300);
					g2d.drawString("Press Shift to Resart",100,380);
					music=false;
					reset=false;
}
			else {
				move();
				ctime=(System.currentTimeMillis()-time)/1000;
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
			music=false;
			reset=false;
	}
}
	dx+=.6;

twoDgraph.drawImage (back, 0, 0, null);

}

public void move() {
    if (start) {
       // linneaa.move((int) dx);
    	linneaa.setX(linneaa.getX()+linneaa.getDx());
    	linneaa.setY(linneaa.getY()+linneaa.getDy());
    }
}
public void reset() {
	start=false;
	music=true;
	key=-1;
	reset=false;
	win=false;
	linneaa.setX(10);
	linneaa.setY(300);
	score=0;
	 time = System.currentTimeMillis();
	obs = setObs();
	r3= new Box();
	r4=new Box(240,380);
	r5=new Box(390,400);
	r6=new Box(530,400);
	r7=new Box(670,400);
	
}
	public void keyTyped(KeyEvent e){
		}
		public void keyPressed(KeyEvent e){
			key=e.getKeyCode();
				System.out.println(key);
	
		if(key==32) {
			linneaa.setDy(-1);
		}		
		if(key==16) {
			reset=true;
		}
		if(key==32) {
			start=true;
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
		
		
		{}}}



