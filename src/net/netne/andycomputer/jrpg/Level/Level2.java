package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level2 extends Level {
	private Image grass, dirt, stone, roof, door;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	
	public Level2(){
		grass = super.GetGrass();
		stone = super.GetStone();
		dirt = super.GetDirt();
		roof = super.GetRoof();
		door = super.GetDoor();
		xTiles = (Toolkit.getDefaultToolkit().getScreenSize().width)/10;
		yTiles = (Toolkit.getDefaultToolkit().getScreenSize().height)/10;
	}
	
	@Override
	public ArrayList<Tile> CreateTiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int x = 0; x<xTiles; x++){
			for(int y = 0; y<yTiles; y++){
				//Create teleport stones to level1 left side of screen
				if(x == 79 && y >= 29 && y <= 31)
					array.add(new Tile(stone, x, y, 4));
				
				//Create stone path from left to middle
				else if(y == 30 && x >= 40)
					array.add(new Tile(stone, x, y, 2));
				
				//Create dirt path north from middle
				else if(x == 40 && y < 30 && y > 20)
					array.add(new Tile(dirt, x, y, 2));
				
				//Create dirt path west from the north dirt path
				else if(y == 20 && x < 41 && x > 20)
					array.add(new Tile(dirt, x, y, 2));
				
				//Create dirt path father north to the slumber forest
				else if(x == 20 && y <= 20 && y >= 1)
					array.add(new Tile(dirt, x, y, 2));
				
				//Create dirt path to the house in the upper left corner
				else if(x == 20 && y == 21)
					array.add(new Tile(dirt, x, y, 2));
				
				//Create door to the house in the upper left corner
				else if(x == 20 && y == 22)
					array.add(new Tile(door, x, y, 4));
				
				//Create the roof for the house in the upper left corner
				else if(x >= 15 && x <= 25 && y >= 22 && y <= 32)
					array.add(new Tile(roof, x, y, 3));
				
				//Create grass elsewhere
				else
					array.add(new Tile(grass, x, y, 0));
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
