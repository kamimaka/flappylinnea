public class Pictures {

	private String pic;
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private boolean movedn;
	private boolean movert;
	
	public Pictures() {
		pic="";
		x=0;
		y=0;
		width=0;
		height=0;
		dx=0;
		dy=0;
		}
	
	public Pictures(String s, int x1, int y1, int w1, int h1) {
		pic=s;
		x=x1;
		y=y1;
		dx=1;
		dy=1;
		movert=true;
		movedn=false;
		width=w1;
		height=h1;
			}
	
	
	public Pictures(String s, int x1, int y1, int dx1, int dy1,int w,int h,boolean r, boolean d)
	{
	pic=s;
	x=x1;
	y=y1;
	width=w;
	height=h;
	dx=dx1;
	dy=dy1;
	movert=r;
	movedn=d;
	}

	
	public void bounce() {
		if(movert) {
			x+=dx;
		}
		else {
			x-=dx;
		}
		if(movedn) {
			y+=dy;
		}
		else {
			y-=dy;
		}
			
		if(x<0)
			movert=true;
		if(x+width>800)
			movert=false;
		
		if (y<0)
			movedn=true;
		if(y+height>600)
			movedn=false;
			}
	

	public void move(int dx) {
		x=dx;
		y+=dy;
		//System.out.println(dx);
		
	}
	
	public String getPic() {
		return pic;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isMovedn() {
		return movedn;
	}

	public void setMovedn(boolean movedn) {
		this.movedn = movedn;
	}

	public boolean isMovert() {
		return movert;
	}

	public void setMovert(boolean movert) {
		this.movert = movert;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;	
	}
	public int getY() { 
		return y;
	}
	public int getwidth() {
		return width;
	}
	public int getheight() {
		return height;
	}
	
	public void setDx(int c) {
		dx=c;
	}
	
	public void setDy(int a) {
		dy=a;
	}
	

	public boolean Collision(Box bird) {
		return getX()+getwidth()>=bird.getX()&&getX()<=bird.getX()+bird.getW()&&getY()+getheight()>=bird.getY()&&getY()<=bird.getY()+bird.getH();
		

	}

	
	
}
