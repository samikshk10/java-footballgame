package com.game.footballgame;

import java.awt.*;
import java.awt.event.*;

public class GameObject extends Rectangle{

	int id;
	int yVelocity;
	int xVelocity;
	int speed = 10;

	GameObject(int x, int y, int paddlewidth, int paddleheight, int id){
		super(x,y,paddlewidth,paddleheight);
		this.id=id;
	}

	public void keyPressed(KeyEvent e) {

		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
			}

			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
			}


			if(e.getKeyCode()==KeyEvent.VK_A){
				setXDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_D){
				setXDirection(speed);
			}
			break;

		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				setXDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				setXDirection(speed);
			}
			break;

		}
	}

	public void keyReleased(KeyEvent e) {

		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
			}

			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
			}


			if(e.getKeyCode()==KeyEvent.VK_A) {
				setXDirection(0);
			}

			if(e.getKeyCode()==KeyEvent.VK_D) {
				setXDirection(0);
			}


			break;

		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
			}

			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				setXDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				setXDirection(0);
			}
			break;

		}
	}

	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}

	public void setXDirection(int xDirection){
		xVelocity= xDirection;
	}

	public void move() {
		y= y + yVelocity;
		x= x+xVelocity;
	}

	public void draw(Graphics g) {

		if(id==1)
			g.setColor(Color.blue);
		else if(id==2) {
			g.setColor(Color.red);
		}else if(id==3)
		{
			g.setColor(Color.red);
		}
		else if(id==4) {
			g.setColor(Color.blue);
		}
		else if(id==5)
		{
			g.setColor(Color.GREEN);
		}

		g.fillRect(x, y, width, height);

	}
}
