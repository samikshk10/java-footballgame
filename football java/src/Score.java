package com.game.footballgame;

import java.awt.*;

public class Score extends Rectangle{

	static int gamewidth;
	static int gameheight;

	int player1;
	int player2;

	Score(int gamewidth, int gameheight){
		Score.gamewidth = gamewidth;
		Score.gameheight = gameheight;
	}

	public void draw(Graphics g) {

		g.setColor(Color.white);
//		g.drawLine(gamewidth/2, 0, gamewidth/2, gameheight);
		g.setFont(new Font("Impact", Font.PLAIN, 40));

//		g.drawString("SCORE(RACE TO 5)", (gamewidth/2)-70, 20);
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (gamewidth/2)-100, 50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (gamewidth/2)+100, 50);


	}

}
