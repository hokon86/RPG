package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level1House1 extends Level {
	private Image roof, door, black;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	
	public Level1House1(){
		roof = super.GetRoof();
		door = super.GetDoor();
		black = super.GetBlack();
		xTiles = (Toolkit.getDefaultToolkit().getScreenSize().width)/10;
		yTiles = (Toolkit.getDefaultToolkit().getScreenSize().height)/10;
	}
	
	@Override
	public ArrayList<Tile> CreateTiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int x = 0; x<xTiles; x++){
			for(int y = 0; y<yTiles; y++){
				if(x == 40 && y == 38)
					array.add(new Tile(door, x, y, 5));
				else if(x >= 39 && x <= 41 && y == 39 || x == 39 && y == 40 || x == 41 && y == 40)
					array.add(new Tile(roof, x, y, 3));
				else if(x == 40 && y == 38)
					array.add(new Tile(door, x, y, 5));
				else if(x >= 30 && x <= 50 && y >= 20 && y <= 40)
					array.add(new Tile(door, x, y, 2));
				else if(y == 30 && x == 29)
					array.add(new Tile(door, x, y, 4));
				else if(x >= 28 && x <= 52 && y >= 18 && y <= 42)
					array.add(new Tile(roof, x, y, 3));
				else
					array.add(new Tile(black, x, y, 3));
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
