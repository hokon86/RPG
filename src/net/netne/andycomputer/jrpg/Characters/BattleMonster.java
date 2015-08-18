package net.netne.andycomputer.jrpg.Characters;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class BattleMonster {
	public Image image;
	public int xPos, yPos, hp, level, damage, xp, coin;
	public String name;
	public BattleMonster(int x, int y, int level, int def, Image image1, String name){
		this.xPos = x;
		this.name = name;
		this.yPos = y;
		this.hp = 5*level;
		this.xp = 2*level;
		this.level = (int)(Math.random() * ((level+1)-(level-2))+1);
		if(this.level < 1)
			this.level = 1;
		this.damage = (int)((Math.random() * (((3*this.level)+level)-(3*this.level)-level))+1);
		this.damage -= def;
		if(this.damage<1)
			damage = level;
		image = image1;
	}
}
