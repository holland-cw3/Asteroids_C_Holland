import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

	public class Ship extends Polygon implements KeyListener{
		private int width;
		private int height;
		private int life;
		private boolean alive = true;
		private boolean forward = false;
		private boolean left = false;
		private boolean right = false;
		private boolean enter = false;
		private boolean start = false;
		
		
		public Ship(Point[] inShape, Point inPosition, double inRotation, int width, int height, int life, boolean alive) {
	        super(inShape, inPosition, inRotation);
	        this.width = width;
	        this.height = height;
	        this.alive = alive;
	        this.life = life;
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
		
		public void move() {
			
			Point pos = this.position;
			double stepSize = 4;
			
			
			
			if (pos.getX() > width || pos.getX() < 0) {
				pos.setX(width - pos.x);
			}
			
			if (pos.getY() > height || pos.getY() < 0) {
				pos.setY(height - pos.y);
			}
			
			if (forward) {
				pos.setX(pos.x +Math.cos(Math.toRadians(rotation))*stepSize);
				pos.setY(pos.y +Math.sin(Math.toRadians(rotation))*stepSize);
				
			}
			
			if (right) {
				rotation += stepSize;
				
			}
			if (left) {
				rotation -= stepSize;
				
			}
			if (enter) {
				setStart(true);
				setAlive(true);				
			}
			
			
			
			
			
			
		}

		public void keyTyped(KeyEvent e) {
			//leave blank
		}
		
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == (KeyEvent.VK_UP)) {
				forward = true;
			}
			if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
				right = true;
			}
			if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
				left = true;
			}
			if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
				enter = true;
			}
			
			
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == (KeyEvent.VK_UP)) {
				forward = false;
			}
			if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
				right = false;
			}
			if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
				left = false;
			}
			if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
				enter = false;
			}
			
		}
		
		public boolean collides(Polygon other) {
			
			 if (other.contains(this.position)) {
				    return true;				  
			 }
			 else {
				 return false;
			 }

		
		}



		public int getLife() {
			return life;
		}



		public void setLife(double d) {
			this.life = (int) d;
		}
		
		public boolean getAlive() {
			return alive;
		}

		public boolean getStart() {
			return start;
		}


		public void setAlive(boolean x) {
			this.alive = x;
		}
		public void setStart(boolean x) {
			this.start = x;
		}
		
		public Point getPos() {
			return position;
		}
		
		public void setPos(Point p) {
			this.position = p;
		}
		
		public double getRot() {
			return rotation;
		}
		
		
}
