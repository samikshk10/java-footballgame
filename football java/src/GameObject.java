package com.game.footballgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
////			if(e.getKeyCode()==KeyEvent.VK_UP) {
////				setYDirection(-speed);
////			}
//			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
//				setYDirection(speed);
//			}
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
//			if(e.getKeyCode()==KeyEvent.VK_UP) {
//				setYDirection(0);
//			}
//
//			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
//				setYDirection(0);
//			}
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

	public void imageOptimization(int xc ,int yc, String imagename,int widths,int heights,Graphics g){
		Image image ;
		image = Toolkit.getDefaultToolkit().getImage(imagename);
		Graphics2D g2d = (Graphics2D) g;
		GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image buffer = config.createCompatibleImage(widths,heights, Transparency.TRANSLUCENT);
		Graphics2D bufferGraphics = (Graphics2D) buffer.getGraphics();
		bufferGraphics.drawImage(image, 0, 0, null);
		g2d.drawImage(buffer, xc, yc, null);
	}

	public void draw(Graphics g) throws IOException {

		if(id==1) {
		imageOptimization(x,y,"carimage1.png",100,50,g);
		}
		else if(id==2) {
		imageOptimization(x,y,"carimage2.png",100,50,g);


		} else if (id == 3) {
			BufferedImage image = ImageIO.read(new File( "goal1.png"));

			g.drawImage(image, x, y, width,height,null);

		}
		else if(id==4){
			BufferedImage image = ImageIO.read(new File( "goal2.png"));

			g.drawImage(image, x, y, width,height,null);
		}



	}
}
