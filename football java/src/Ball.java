package com.game.footballgame;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;

	Ball(int x, int y, int width, int height){
		super(x,y,width,height);

		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;

	}


	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}

	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}

	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	static final int gamewidth = 1000;
	static final int gameheight = (int)(gamewidth * (0.5555));
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
		g.setColor(Color.white);
		g.drawOval((gamewidth/2)-75,(gameheight/2)-70,150,150);

	}
}
