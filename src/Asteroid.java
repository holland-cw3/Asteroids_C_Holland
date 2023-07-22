import java.awt.Graphics;

public class Asteroid extends Polygon {
	private int width;
	private int height;
	private double stepsize = 1.0;
	
	public Asteroid(Point[] inShape, Point inPosition, double inRotation, int width, int height) {
		super(inShape, inPosition, inRotation);
        this.width = width;
        this.height = height;
        
        
    }
	
	public void paint(Graphics brush) {
        int[] xCoordinates = new int[this.getPoints().length];
        int[] yCoordinates = new int[this.getPoints().length];
        for (int i = 0; i < this.getPoints().length; i++) {
            xCoordinates[i] = (int) this.getPoints()[i].getX();
            yCoordinates[i] = (int) this.getPoints()[i].getY();
        }
        brush.drawPolygon(xCoordinates, yCoordinates, this.getPoints().length);
    }
	
	public void fillPoly(Graphics brush) {
        int[] xCoordinates = new int[this.getPoints().length];
        int[] yCoordinates = new int[this.getPoints().length];
        for (int i = 0; i < this.getPoints().length; i++) {
            xCoordinates[i] = (int) this.getPoints()[i].getX();
            yCoordinates[i] = (int) this.getPoints()[i].getY();
        }
        brush.fillPolygon(xCoordinates, yCoordinates, this.getPoints().length);
    }
	
	public void move(int x) {
		
		Point pos = this.position;
		if(x == 11){
			pos.x = pos.getX() - 1 * stepsize;
			pos.y = pos.getY() - 2.5 * stepsize;
			rotation -= 1;
		}
		if(x % 7 == 0){
			pos.x = pos.getX() + 2 * stepsize;
			pos.y = pos.getY() - 1.5 * stepsize;
			rotation -= 1;
		}
		if(x % 5 == 0){
			pos.x = pos.getX() - 4 * stepsize;
			pos.y = pos.getY() + 1.5 * stepsize;
			rotation -= 1;
		}
		if(x % 4 == 0){
			pos.x = pos.getX() - 0.3 * stepsize;
			pos.y = pos.getY() + 2 * stepsize;
			rotation -= 1;
		}
		
		if(x % 3 == 0){
			pos.x = pos.getX() - 1 * stepsize;
			pos.y = pos.getY() + 1.5 * stepsize;
			rotation -= 1;
		}
		if(x % 2 == 0){
			pos.x = pos.getX() + 1.5 * stepsize;
			pos.y = pos.getY() - 1 * stepsize;
			rotation -= 1;
		}
		if(x == 0) {
		pos.x = pos.getX() - 1 * stepsize;
		pos.y = pos.getY() - 1 * stepsize;
		rotation += 1;
			
		}
		if(x == 1){
			pos.x = pos.getX() + 1.5 * stepsize;
			pos.y = pos.getY() + 1.5 * stepsize;
			rotation -= 1;
		}
		
		
		
		
		if (pos.getX() > width || pos.getX() < 0) {
			pos.setX(width - pos.x);
		}
		
		if (pos.getY() > height || pos.getY() < 0) {
			pos.setY(height - pos.y);
		}
				
	}
	public void setStep(double x) {
		stepsize = x;
	}

	public void subtract(double x) {
		Point pos = this.position;
		pos.setX(pos.getX() - x);
	}
	public void reset(Point z) {
		this.position = z;
		
	}
	
	
	
	
}
