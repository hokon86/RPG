package net.netne.andycomputer.jrpg.Characters;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class NPC {
	public Image image, viewImage;
	public int xPos, yPos, price;
	public String salery;
	public NPC(int x, int y, String salery, int pris){
		xPos = x;
		yPos = y;
		this.salery = salery;
		price = pris;
		InputStream in = getClass().getResourceAsStream("npc.png");
		try{
			image = ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		in = getClass().getResourceAsStream("npcView.png");
		try{
			viewImage = ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
