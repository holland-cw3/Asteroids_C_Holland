import java.awt.Graphics;

public class Stars {
	public Point position;
	private int radius;
	int og = radius;
	
	public Stars(Point pos, int rad) {
		this.position = pos;
		this.radius = rad;
		this.og = rad;
	}
	
	public void paint(Graphics brush) {
		Point pos = this.position;
        brush.drawOval((int)pos.x, (int)pos.y, this.radius, this.radius);
    }
	
	public void paintFill(Graphics brush) {
		Point pos = this.position;
        brush.fillOval((int)pos.x, (int)pos.y, this.radius, this.radius);
    }
	
	
	
	public void setRadius(int x) {
		this.radius = x;
	}
	
	public int getRadius() {
		return radius;
	}
	
	 
	
	
	
	

}
