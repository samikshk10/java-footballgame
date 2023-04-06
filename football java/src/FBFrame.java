package com.game.footballgame;

import java.awt.*;
import javax.swing.*;

public class FBFrame extends JFrame{
	GameGUI panel;

	FBFrame(){
		panel = new GameGUI();




		this.add(panel);
		this.setTitle("FOOTBALL Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}