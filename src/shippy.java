

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class shippy extends Polygon implements KeyListener{
		private int width;
		private int height;
		private boolean forward = false;
		private boolean left = false;
		private boolean right = false;
		private boolean shift = false;
		
		
		public shippy(Point[] inShape, Point inPosition, double inRotation, int width, int height) {
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
		
		public void move() {
			
			Point pos = this.position;
			double stepSize = 4;
			
			
			
			if (pos.getX() > width || pos.getX() < 0) {
				if(shift) {
					
				}
				else {
				pos.setX(width - pos.x);
				}
			}
			
			if (pos.getY() > height || pos.getY() < 0) {
				if(shift) {
					
				}
				pos.setY(height - pos.y);
			}
			
			if (forward) {
				pos.setX(pos.x +Math.cos(Math.toRadians(rotation))*stepSize);
				pos.setY(pos.y +Math.sin(Math.toRadians(rotation))*stepSize);
				
			}
			
			if (right) {
				if(shift) {		
					//nothing
				}
				else {
				rotation += stepSize;
				}
			}
			if (left) {
				if(shift) {
					//nothing
				}
				
				else {
				rotation -= stepSize;
				}
				
			}
			if (shift) {
				
				moveAlone(stepSize + 5);
								
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
			if (e.getKeyCode() == (KeyEvent.VK_SPACE)) {
				shift = true;
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
			if (e.getKeyCode() == (KeyEvent.VK_SPACE)) {
				shift = true;
			}
			
		}
		
		public void moveAlone(double stepSize) {
			
			Point pos = this.position;
			pos.setX(pos.x +Math.cos(Math.toRadians(rotation))*stepSize);
			pos.setY(pos.y +Math.sin(Math.toRadians(rotation))*stepSize);
				
			}
		
		public boolean collides(Polygon other) {
			
			 if (other.contains(this.position)) {
				    return true;				  
			 }
			 else {
				 return false;
			 }

		
		}
		public void setPosB(Point x, double rot) {
			this.position = x;
			this.rotation = rot;
		}
		public Point getPosB() {
			return position;
			
		}
		public void stopShot() {
			shift = false;
		}
		public boolean shiftPress() {
			return shift;
		}


		
}

