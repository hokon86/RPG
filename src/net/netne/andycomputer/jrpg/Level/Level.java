package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level {
	
	public static String Level1 = "Level1";
	public static String Level1Cave1 = "Level1Cave1";
	public static String Level1House1 = "Level1House1";
	public static String Level1SpookyHouse1 = "Level1SpookyHouse1";
	public static String Level1SpookyHouse1Basement1 = "Level1SpookyHouse1Basement1";
	public static String Level2 = "Level2";
	public static String Level2House1 = "Level1House1";
	public static String Level3 = "Level3";
	public static String Level2Cave1 = "Level2Cave1";
	
	public Level(){
		
	}
	
	private ArrayList<Tile> imageArray;
	
	public Image GetBoss(){
		InputStream in = getClass().getResourceAsStream("boss.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Image GetGrass(){
		InputStream in = getClass().getResourceAsStream("Grass.png");
		try {
			return ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Image GetDirt(){
		InputStream in = getClass().getResourceAsStream("dirt.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Image GetStone(){
		InputStream in = getClass().getResourceAsStream("stone.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Image GetStair(){
		InputStream in = getClass().getResourceAsStream("stair.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Tile> CreateTiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int x = 1; x<=80; x++){
			for(int y = 1; y<=60; y++){
				array.add(new Tile(GetDirt(), x, y, 1));
			}
		}
		imageArray = array;
		return array;
	}
	
	public BufferedImage GetLayout(){
		int rows = 80;   //we assume the no. of rows and cols are known and each chunk has equal width and height
        int cols = 60;
        int chunks = rows * cols;

        int chunkWidth, chunkHeight;
        int type;

        //creating a bufferd image array from image files
        BufferedImage[] buffImages = new BufferedImage[chunks];
        for (int i = 0; i < chunks; i++) {
            buffImages[i] = (BufferedImage)imageArray.get(i).GetTexture();
        }
        type = buffImages[0].getType();
        chunkWidth = buffImages[0].getWidth();
        chunkHeight = buffImages[0].getHeight();

        //Initializing the final image
        BufferedImage finalImg = new BufferedImage(chunkWidth*cols, chunkHeight*rows, type);

        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * i, chunkHeight * j, null);
                num++;
            }
        }
		return finalImg;
	}
	
	public Image[] GetTextures(){
		Image[] i = new Image[3];
		i[0] = GetGrass();
		i[1] = GetDirt();
		i[2] = GetStone();
		return i;
	}

	public Image GetRoof() {
		InputStream in = getClass().getResourceAsStream("roof.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public Image GetDoor() {
		InputStream in = getClass().getResourceAsStream("door.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public Image GetBlack() {
		InputStream in = getClass().getResourceAsStream("black.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public Image GetCobble() {
		InputStream in = getClass().getResourceAsStream("cobble.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public Image GetTree() {
		InputStream in = getClass().getResourceAsStream("tree.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Image GetWall(){
		InputStream in = getClass().getResourceAsStream("wall.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public Image GetBlank() {
		InputStream in = getClass().getResourceAsStream("blank.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
