package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.netne.andycomputer.jrpg.Engine;

public class Level1SpookyHouse1 extends Level {
	private Image roof, door, black, grass, stone, dirt, stair, blank;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	
	public Level1SpookyHouse1(){
		roof = super.GetRoof();
		door = super.GetDoor();
		black = super.GetBlack();
		grass = super.GetGrass();
		dirt = super.GetDirt();
		stone = super.GetStone();
		stair = super.GetStair();
		blank = super.GetBlank();
		xTiles = (Toolkit.getDefaultToolkit().getScreenSize().width)/10;
		yTiles = (Toolkit.getDefaultToolkit().getScreenSize().height)/10;
	}
	
	@Override
	public ArrayList<Tile> CreateTiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int x = 0; x<xTiles; x++){
			for(int y = 0; y<yTiles; y++){
				if(y == 30 && x == 29)
					array.add(new Tile(door, x, y, Tile.TELEPORT));
				else if(x == 49 && y == 39)
					array.add(new Tile(stair, x, y, Tile.WALKABLE));
				else if(x == 49 && y == 40)
					array.add(new Tile(blank, x, y, Tile.WALKABLE));
				else if(x == 50 && y == 39|| x == 50 && y == 40)
					array.add(new Tile(blank, x, y, Tile.TELEPORT));
				else if(x >= 49 && y == 38 && x <= 50)
					array.add(new Tile(roof, x, y, Tile.NOT_WALKABLE));
				else if(x == 35 && y >= 25 && y <= 40 || y == 31 && x >= 38 && x <= 50)
					array.add(new Tile(roof, x, y, Tile.NOT_WALKABLE));
				else if(x >= 30 && x <= 50 && y >= 20 && y <= 40){
					array.add(new Tile(door, x, y, Tile.WALKABLE));
				}
				else if(x >= 28 && x <= 52 && y >= 18 && y <= 42)
					array.add(new Tile(roof, x, y, Tile.NOT_WALKABLE));
				else
					array.add(new Tile(black, x, y, Tile.NOT_WALKABLE));
			}
		}
		imageArray = array;
		return array;
	}
	
	@Override
	public BufferedImage GetLayout(){
		int rows = xTiles;   //we assume the no. of rows and cols are known and each chunk has equal width and height
        int cols = yTiles;
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
}
