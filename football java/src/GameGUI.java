package com.game.footballgame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameGUI extends JPanel implements Runnable{

	static final int gamewidth = 1000;
	static final int gameheight = (int)(gamewidth * (0.5));
	static final Dimension screensize = new Dimension(gamewidth,gameheight);
	static final int balldiameter = 20;
	static final int paddlewidth = 25;
	static final int paddleheight = 100;

	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	GameObject keeper1;
	GameObject keeper2;

	GameObject leftpanel;

	GameObject rightpanel;

	GameObject goalpostleft;
	GameObject goalpostright;
	Ball ball;
	Score score;

	GameGUI(){



		newPaddles();
		newBall();
		score = new Score(gamewidth,gameheight);

		this.setFocusable(true);
		this.addKeyListener(new KeyEventsAll());
		this.setPreferredSize(screensize);

		gameThread = new Thread(this);
		gameThread.start();

	}



	public void newBall() {

		random = new Random();
		ball = new Ball((gamewidth/2)-(balldiameter/2),(gameheight/2),balldiameter,balldiameter);

	}

	public void newPaddles() {

		keeper1 = new GameObject(0,(gameheight/2)-(paddleheight/2),paddlewidth,paddleheight,1);
		keeper2 = new GameObject(gamewidth-(paddlewidth+20*2),(gameheight/2)-(paddleheight/2),paddlewidth,paddleheight,2);

		goalpostleft= new GameObject(0,(gameheight/2)-(paddleheight/2),paddlewidth,paddleheight*2,3);
		goalpostright= new GameObject(gamewidth-paddlewidth,(gameheight/2)-(paddleheight/2),(paddlewidth*2),paddleheight*2,4);

		leftpanel= new GameObject(paddlewidth,0,2,gameheight*2,5);
		rightpanel= new GameObject(gamewidth-paddlewidth,0,2,gameheight*2,5);









	}

	public void paint(Graphics g) {

		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();

		draw(graphics);
		g.drawImage(image,0,0,this);

	}

	public void draw(Graphics g) {

		keeper1.draw(g);
		keeper2.draw(g);
		goalpostleft.draw(g);
		goalpostright.draw(g);
		leftpanel.draw(g);
		rightpanel.draw(g);
		ball.draw(g);


		score.draw(g);
		Toolkit.getDefaultToolkit().sync();

	}

	public void move() {

		keeper1.move();
		keeper2.move();
		ball.move();

	}

	public void checkCollision() {

		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}

		if(ball.y >= gameheight-balldiameter) {
			ball.setYDirection(-ball.yVelocity);
		}

		//bounce ball off paddles
		if(ball.intersects(keeper1) || ball.intersects(leftpanel)) {

			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity=ball.xVelocity+0.05;

			if(ball.yVelocity>0)
				ball.yVelocity=ball.yVelocity+0.05;
			else
				ball.yVelocity--;

			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);

		}



		if(ball.intersects(keeper2) || ball.intersects(rightpanel)) {

			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty

			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty

			else
				ball.yVelocity--;

			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);

		}

		//stops paddles at window edges

		if(keeper1.y<=0)
			keeper1.y=0;
		if(keeper1.y >= (gameheight-paddleheight))
			keeper1.y = gameheight-paddleheight;

		if(keeper1.x<=(goalpostleft.x+paddlewidth*2))
			keeper1.x=goalpostleft.x+(paddlewidth*2);


		if(keeper1.x >= (gamewidth-paddlewidth))
			keeper1.x = gameheight-paddlewidth;

		if(keeper1.x >= (gamewidth/2-paddlewidth))
		{
			keeper1.x= gamewidth/2-paddlewidth;
		}

		if(keeper2.x<= (gamewidth/2+paddlewidth/2-10))
		{
			keeper2.x= gamewidth/2+paddlewidth/2-10;
		}

		if(keeper2.x>= goalpostright.x-paddlewidth*2)
		{
			keeper2.x= goalpostright.x-paddlewidth*2;
		}




		if(keeper2.y<=0)
			keeper2.y=0;

		if(keeper2.y >= (gameheight-paddleheight))
			keeper2.y = gameheight-paddleheight;





		if(ball.intersects(goalpostleft)) {

			score.player2++;
			if(score.player2==5)
			{
				score.player2++;
				JOptionPane.showMessageDialog(this,"GAME OVER(PLAYER 2 WINS)");
			newPaddles();
			newBall();
			score.player1=0;
			score.player2=0;

				}
			newPaddles();
			newBall();
			}
			System.out.println("Player 2 score"+score.player2);



		if(ball.intersects(goalpostright)) {

			score.player1++;

			if(score.player1==5)
			{
				score.player1++;
				JOptionPane.showMessageDialog(this,"GAME OVER(PLAYER 1 WINS)");
				newPaddles();
				newBall();
				score.player1=0;
				score.player2=0;
			}
			newPaddles();
			newBall();
			System.out.println("Player 1 score"+score.player1);

		}

	}

	public void run() {

		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		while(true) {

			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;

			if(delta >=1) {

				move();
				checkCollision();
				repaint();
				delta--;
			}

		}
	}

	public class KeyEventsAll extends KeyAdapter{

		public void keyPressed(KeyEvent e) {

			keeper1.keyPressed(e);
			keeper2.keyPressed(e);

		}

		public void keyReleased(KeyEvent e) {

			keeper1.keyReleased(e);
			keeper2.keyReleased(e);

		}
	}
}
