package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.netne.andycomputer.jrpg.Engine;

public class Level2Cave1 extends Level{
	private Image grass, dirt, stone, roof, door, stair, cobble, tree, blank, black, wall;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	private int[] treeBottomArray = new int[2];
	
	public Level2Cave1(){
		grass = super.GetGrass();
		stone = super.GetStone();
		dirt = super.GetDirt();
		roof = super.GetRoof();
		door = super.GetDoor();
		stair = super.GetStair();
		cobble = super.GetCobble();
		tree = super.GetTree();
		blank = super.GetBlank();
		black = super.GetBlack();
		wall = super.GetWall();
		xTiles = (Toolkit.getDefaultToolkit().getScreenSize().width)/10;
		yTiles = (Toolkit.getDefaultToolkit().getScreenSize().height)/10;
		treeBottomArray[0] = 0;
		treeBottomArray[1] = 0;
	}
	
	@Override
	public ArrayList<Tile> CreateTiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int x = 0; x<xTiles; x++){
			for(int y = 0; y<yTiles; y++){
				if(x == 4 && y >= 5 && y <= 23)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x == 7 && y >= 5 && y <= 20)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x >= 4 && x <= 7 && y == 4)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x >= 5 && x <= 13 && y == 23)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x >= 8 && x <= 11 && y == 20)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x == 13 && y <= 22 && y >= 18)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x == 11 && y <= 19 && y >= 16)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				//else if(y == 18)
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
