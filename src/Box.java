public class Box {
	private int x;
	private int y;
	private int width;
	private int height;

	
	
	public Box() {
		x=90;
		y=280;
		width=70;
		height=140;
	}
	public Box(int x1,int y1) {
		
		x=x1;
		y=y1;
		width=70;
		height=90;

		
	}
	public Box(int xV, int yV, int wV, int hV) {
		x=xV;
		y=yV;
		width=wV;
		height=hV;
		
	}
	
	public int getX() {
		return x;	
	}
	public int getY() { 
		return y;
	}
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
	
}

