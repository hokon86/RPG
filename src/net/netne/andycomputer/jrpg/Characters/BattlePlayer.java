package net.netne.andycomputer.jrpg.Characters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class BattlePlayer {
	public BufferedImage image;
	public int xPos, yPos, hp, xp, level, damage, defence;
	public BattlePlayer(int x, int y, int def){
		this.xPos = x;
		this.yPos = y;
		this.defence = def;
		InputStream in = getClass().getResourceAsStream("battleplayer.png");
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
