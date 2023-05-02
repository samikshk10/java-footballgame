package com.game.footballgame;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FBFrame extends JFrame{
	GameGUI panel;

	FBFrame() throws IOException {
		panel = new GameGUI();
		this.add(panel);
		this.setTitle("FOOTBALL Game");
		this.setResizable(false);
	this.setBackground(Color.white);
	//	this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("stadiumimage.png")))));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}