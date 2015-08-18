package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;

public class Tile {
	private Image texture;
	private int xPos;
	private int yPos;
	public int type;
	public boolean taken = false;
	public int coin = 0;
	public static final int BATTLE = 0;
	public static final int SM_CHEST = 1;
	public static final int WALKABLE = 2;
	public static final int NOT_WALKABLE = 3;
	public static final int TELEPORT = 4;
	public static final int SHOP = 5;
	public static final int LG_CHEST = 6;
	public Tile(Image tex, int x, int y, int t){
		xPos = x;
		yPos = y;
		texture = tex;
		type = t;
		if(type == SM_CHEST)
			coin = (int)((Math.random() * (15-5))+1);
		else if(type == LG_CHEST)
			coin = (int)((Math.random() * (40-20))+1);
	}
	
	public int GetXPos(){
		return xPos;
	}
	
	public int GetYPos(){
		return yPos;
	}
	
	public Image GetTexture(){
		return texture;
	}
}
