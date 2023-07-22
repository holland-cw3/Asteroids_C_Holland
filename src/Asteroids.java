
/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/

import java.util.ArrayList;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

class Asteroids extends Game {
	static boolean startScreen = true;
	static double counter = 0;
	int finalScore = 0;
	static boolean alive = true;
	File f = new File("D:\\Image\\Output.jpg");;
	
	
	  
	ArrayList<Asteroid> asts = new ArrayList<Asteroid>();
	ArrayList<shippy> bullets = new ArrayList<shippy>();
	ArrayList<Stars> stas = new ArrayList<Stars>();
	
	
	Point[] shipPoints = {new Point(0, 3), new Point(21, 10), new Point(0, 17), new Point(7, 10)};	
	Point[] astPoints = {new Point(0, 0), new Point(10, 15), new Point(20, 15), new Point(30, 0), new Point(20, -15), new Point(10, -15)};
	Point[] astPoints2 = {new Point(40, 40), new Point(58, 56), new Point(68, 47), new Point(60, 31), new Point(47, 38)};
	Point[] astPoints3 = {new Point(240, 240), new Point(250, 260), new Point(260, 260), new Point(270, 280), new Point(280, 260), new Point(270, 250), new Point(265, 230), new Point(260, 240)};
	Point[] shippyPoints = {new Point(0, 2), new Point(8, 2), new Point(8, 0), new Point(0, 0)};
	Point[] healthBar = {new Point(0, 10), new Point(190, 10), new Point(190, 30), new Point(0, 30)};
	Point[] healthBar2 = {new Point(0, 10), new Point(210, 10), new Point(210, 30), new Point(0, 30)};
	Point position = new Point(width/2, height/2);
	Point position2 = new Point(120, 432);
	Point position3 = new Point(width/5, height/5);
	Point position4 = new Point(500, 300);
	Point position5 = new Point(0, 0);
	Point position6 = new Point(80, 210);
	Point position7 = new Point(314, 34);
	Point position8 = new Point(200, 56);
	Point position9 = new Point(610, 432);
	Point position10 = new Point(43, 182);
	
	Point position11 = new Point(520, 70);
	Point position12 = new Point(360, 120);
	Point position13 = new Point(234, 423);
	
	
	Asteroid ast34 = new Asteroid(astPoints, position3, 0, width, height);
	Asteroid ast35 = new Asteroid(astPoints2, position2, 0, width, height);
	Asteroid ast36 = new Asteroid(astPoints3, position4, 0, width, height);
	Asteroid ast37 = new Asteroid(astPoints, position5, 0, width, height);
	Asteroid ast38 = new Asteroid(astPoints2, position6, 0, width, height);
	Asteroid ast39 = new Asteroid(astPoints3, position7, 0, width, height);
	Asteroid ast40 = new Asteroid(astPoints, position8, 0, width, height);
	Asteroid ast41 = new Asteroid(astPoints2, position9, 0, width, height);
	Asteroid ast42 = new Asteroid(astPoints3, position10, 0, width, height);
	Asteroid ast43 = new Asteroid(astPoints3, position11, 0, width, height);
	Asteroid ast44 = new Asteroid(astPoints2, position12, 0, width, height);
	Asteroid ast45 = new Asteroid(astPoints3, position13, 0, width, height);
	Asteroid playerHealth1 = new Asteroid(healthBar, new Point(645, 10), 0, width, height);
	Asteroid playerHealth2 = new Asteroid(healthBar2, new Point(870, 10), 0, width, height);

	Stars star = new Stars(new Point(210, 432), 2);
	Stars star2 = new Stars(new Point(width/5, height/5), 2);
	Stars star3 = new Stars(new Point(498, 300), 2);
	Stars star4 = new Stars(new Point(321, 78), 3);	
	Stars star5 = new Stars(new Point(500, 300), 2);
	Stars star6 = new Stars(new Point(54, 512), 3);
	Stars star7 = new Stars(new Point(87, 212), 2);
	Stars star8 = new Stars(new Point(600, 500), 2);
	Stars star9 = new Stars(new Point(700, 250), 3);
	Stars star10 = new Stars(new Point(750, 100), 2);
	Stars star11 = new Stars(new Point(135, 320), 3);
	Stars star12 = new Stars(new Point(373, 224), 2);
	Stars star13 = new Stars(new Point(427, 458), 3);
	Stars star14 = new Stars(new Point(587, 42), 2);
	
	
	Ship rocket = new Ship(shipPoints, position, 0, width, height, 100, false);
	shippy rocko = new shippy(shippyPoints,new Point(position.getX(), position.getY()), 0, width, height);
	
  public Asteroids(){
    super("Asteroids! By Caleb",800,600);
    this.setFocusable(true);
	this.requestFocus();
	this.addKeyListener(rocket);
	this.addKeyListener(rocko);

	asts.add(ast34);
	asts.add(ast35);
	asts.add(ast36);
	asts.add(ast37);
	asts.add(ast38);
	asts.add(ast39);
	asts.add(ast40);
	asts.add(ast41);
	asts.add(ast42);
	asts.add(ast43);
	asts.add(ast44);
	asts.add(ast45);
	
	stas.add(star);
	stas.add(star2);
	stas.add(star3);
	stas.add(star4);
	stas.add(star5);
	stas.add(star6);
	stas.add(star7);
	stas.add(star8);
	stas.add(star9);
	stas.add(star10);
	stas.add(star11);
	stas.add(star12);
	stas.add(star13);
	stas.add(star14);

	bullets.add(rocko);
	
	
  }
  
  
	public void paint(Graphics brush) {
		
		if(rocket.getAlive() == false && rocket.getStart() == false) {
			startScreen(brush);
    	}
		else if(rocket.getAlive() == true && rocket.getStart() == true) {
    		setGame(brush);
    		collision(brush);
    		shot(brush);
	    	check(brush);	
    	 }
    	else {
    		if(asts.size() == 0) {
    		gameOver(brush, counter, true);
    		this.addKeyListener(rocket);
    		}
			else {
			gameOver(brush, counter, false);
	    	this.addKeyListener(rocket);
			}
    	}}
    	 
	
	public void setGame(Graphics brush) {
		
		Font speed = new Font("Courier", Font.PLAIN,20);
		Font normal = new Font(null);
		Font score = new Font("Monospaced Bold Italic", Font.PLAIN,15);
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);
		
		if(counter > 10000) {
			for(int i = 0; i < asts.size(); i++) {
				brush.setFont(speed);
				brush.setColor(Color.black);
				brush.fillRect(350, 0, width/2, 0);
	    		Asteroid x = (Asteroid) asts.get(i);
	    		x.setStep(4.0);
	    		brush.setColor(Color.cyan);
	        	brush.drawString("FINAL ROUND!!!",350,20);
	        	
	    		
	    	}
		}
		
		else if(counter > 8000) {
			for(int i = 0; i < asts.size(); i++) {
				brush.setFont(speed);
				brush.setColor(Color.black);
				brush.fillRect(350, 0, width/2, 0);
	    		Asteroid x = (Asteroid) asts.get(i);
	    		x.setStep(2.0);
	    		brush.setColor(Color.cyan);
	        	brush.drawString("TRIPLE TIME!!!",350,20);
	    		
	    	}
		}
		else if(counter > 5000) {
			for(int i = 0; i < asts.size(); i++) {
				brush.setFont(speed);
	    		Asteroid x = (Asteroid) asts.get(i);
	    		x.setStep(1.5);
	    		brush.setColor(Color.cyan);
	        	brush.drawString("DOUBLE TIME",350,20);
	    		
	    	}
		}

		
		
		
    	
    	for(int i = 0; i < stas.size(); i++){
    		brush.setColor(Color.cyan);
    		Stars y = (Stars) stas.get(i);
    		y.paint(brush);
    		brush.setColor(Color.yellow);
    		y.paintFill(brush);
    		
    	}

	
    	
    	for(int i = 0; i < bullets.size(); i++) {
    		
    		shippy x = (shippy) bullets.get(i);
    		brush.setColor(Color.black);
    		x.paint(brush);
        	x.move();
    		
        	shot(brush);
    		
    	}
    	brush.setColor(Color.CYAN);
    	
    	rocket.paint(brush);
    	
    	brush.setColor(Color.YELLOW);
    	rocket.fillPoly(brush);
    	rocket.move();
	
	
    	
 
   
    	for(int i = 0; i < asts.size(); i++) {
    		Asteroid x = (Asteroid) asts.get(i);
    		//brush.setColor(Color.black);
    		//x.paint(brush);
        	x.move(i);
        	brush.setColor(Color.gray);
            x.fillPoly(brush);
            shot(brush);
        	}
    	
    	brush.setColor(Color.red);
		playerHealth1.fillPoly(brush);
		
		brush.setColor(Color.black);
		playerHealth2.fillPoly(brush);
		
		brush.setColor(Color.white);
		playerHealth1.paint(brush);
		
		playerHealth2.paint(brush);
		
		brush.setFont(normal);
	// sample code for printing message for debugging
	// counter is incremented and this message printed
	// each time the canvas is repainted
    	counter += 0.25;
    	
    	brush.setColor(Color.cyan);
    	brush.setFont(score);
    	brush.drawString("Score: " + (int)counter,10,13);
    	brush.setFont(normal);
    	brush.drawString("Health " + rocket.getLife(), 665 ,17);
    	
    	brush.drawString("Use Arrows to Move", 670 , 38);
    	brush.drawString("Spacebar to Shoot", 670 ,53);
	
    	}
    
	
	public void startScreen(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);
		
		rocket.paint(brush);
    	rocket.move();
    
    	
    	
    	for(int i = 0; i < stas.size(); i++){
    		brush.setColor(Color.cyan);
    		Stars y = (Stars) stas.get(i);
    		y.paint(brush);
    		brush.setColor(Color.yellow);
    		y.paintFill(brush);
    		
    	}
    	
    	
	
	
    	brush.setColor(Color.gray);
 
    	for(int i = 0; i < asts.size(); i++) {
    		Asteroid x = (Asteroid) asts.get(i);
    		brush.setColor(Color.black);
    		x.paint(brush);
        	x.move(i);
        	brush.setColor(Color.gray);
            x.fillPoly(brush);
        	
    	}
    	brush.setColor(Color.cyan);
    	Font big = new Font("Courier", Font.PLAIN,80);
    	Font normal = new Font(null);
    	brush.setFont(big);
    	brush.drawString("Asteroids",190,300);
    	
    	brush.setFont(normal);
    	brush.drawString("Press Enter to Start",350,330);
    	
		
	}


	public void collision(Graphics brush) {
		for(int i = 0; i < asts.size(); i++) {
		if(rocket.collides((Polygon) asts.get(i))) {
			brush.setColor(Color.red);
			brush.fillRect(0, 0, width, height);
			brush.setColor(Color.black);
	    	rocket.paint(brush);
	    	for(int k = 0; k < asts.size(); k++) {
	    		Asteroid x = (Asteroid) asts.get(k);
	    		x.paint(brush);
	        	x.move(1);
	    	}
	    
			rocket.setLife(rocket.getLife() - 0.5);
			playerHealth2.subtract(2.2);
			brush.setColor(Color.black);
			playerHealth2.fillPoly(brush);
			brush.setColor(Color.white);
			playerHealth2.paint(brush);
			}
		}
	}
	public void shot(Graphics brush) {
	
		Point rocketPos = rocket.getPos();
		Point bulletPos = new Point(rocketPos.getX(), rocketPos.getY());
		
		if(rocko.shiftPress()) {
			brush.setColor(Color.blue);
			rocko.paint(brush);
			brush.setColor(Color.cyan);
			rocko.fillPoly(brush);
			brush.setColor(Color.gray);
		}
		for(int i = 0; i < asts.size(); i++) {
			if(rocko.collides((Polygon) asts.get(i)) && rocko.shiftPress()) {	
					asts.remove(i); 
					counter += 1000;
				bullets.remove(0);
				rocko.setPosB(bulletPos, rocket.getRot());
				rocko.stopShot();
				bullets.add(rocko);	
				bullDistanceReset(rocko.getPosB(), rocket.getPos());
			}
	   }
			bullDistanceReset(rocko.getPosB(), rocket.getPos());
		
		
		}
	
	
	
	public void check(Graphics brush) {
		if(rocket.getLife() <= 0) {
    		rocket.setAlive(false);
    		double finalScore = counter;
    		gameOver(brush, finalScore, false);
		}
		if(asts.size() == 0) {
			rocket.setAlive(false);
    		double finalScore = counter;
    		gameOver(brush, finalScore, true);
		}
	}
	
	public void bullDistanceReset(Point rockoPos, Point rocketPos) {
		if(rockoPos.getX() > rocketPos.getX() + 180 || rockoPos.getY() > rocketPos.getY() + 180 || rockoPos.getX() < rocketPos.getX() - 180 || rockoPos.getY() < rocketPos.getY() - 180) {
			bullets.remove(0);
			
			rocko.setPosB(new Point(rocketPos.getX(), rocketPos.getY()), rocket.getRot());
			rocko.stopShot();
			bullets.add(rocko);	
		}
		
		
	}
	
 	public void gameOver(Graphics brush, double score, boolean win) {
		this.addKeyListener(rocket);
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);
		for(int i = 0; i < stas.size(); i++){
    		brush.setColor(Color.cyan);
    		Stars y = (Stars) stas.get(i);
    		y.paint(brush);
    		brush.setColor(Color.yellow);
    		y.paintFill(brush);
    		
    	}
		
		rocket.move();
		
		if(win == false) {
			brush.setColor(Color.red);
			brush.drawString("Game Over",width/2 - 20, height/2 - 35);
			brush.drawString("Final Score: " + (int)score ,width/2 - 33, height/2 - 15);
			brush.drawString("Hit Enter to Restart",width/2 - 40, height/2 + 5);
			
			if(rocket.getAlive() == true) {
				rocket.setLife(100);
				rocket.setPos(new Point(width/2, height/2));
				playerHealth2.reset(new Point(870, 10));
				counter = 0;
				setGame(brush);
			}
		}
		if(win == true) {
			brush.setColor(Color.green);
			brush.drawString("Congratulations!!!",width/2 - 34, height/2 - 35);
			brush.drawString("Final Score: " + (int)score ,width/2 - 35, height/2 - 15);
			brush.drawString("Hit Enter to Restart",width/2 - 40, height/2 + 5);
			
			if(rocket.getAlive() == true) {
				rocket.setLife(100);
				rocket.setPos(new Point(width/2, height/2));
				playerHealth2.reset(new Point(870, 10));
				counter = 0;
				asts.add(ast34);
				asts.add(ast35);
				asts.add(ast36);
				asts.add(ast37);
				asts.add(ast38);
				asts.add(ast39);
				asts.add(ast40);
				asts.add(ast41);
				asts.add(ast42);
				asts.add(ast43);
				asts.add(ast44);
				asts.add(ast45);
				setGame(brush);
				
			}
			win = false;
		}
		
		
	}
	
	
	
	public static void main (String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Asteroids a = new Asteroids();
		a.repaint();
		
		File file2 = new File("unreal3.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip clip2 = AudioSystem.getClip();
		clip2.open(audioStream2);
		
		clip2.start();
		
		
		
		
  }
}
