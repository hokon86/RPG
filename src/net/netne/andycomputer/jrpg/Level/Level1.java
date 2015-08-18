package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import net.netne.andycomputer.jrpg.Engine;

public class Level1 extends Level {
	private Image grass, dirt, stone, roof, door, stair, cobble, tree, blank, black, wall;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	private int[] treeBottomArray = new int[2];
	
	public Level1(){
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
				//Create left new world teleport
				if(x == treeBottomArray[0] && y == treeBottomArray[1] && treeBottomArray[0] != 0 && treeBottomArray[1] < 80){
					array.add(new Tile(blank, treeBottomArray[0], treeBottomArray[1], Tile.NOT_WALKABLE));
					treeBottomArray[0] = 0;
					treeBottomArray[1] = 0;
				}
				else if(x == 0 && y <= 31 && y >= 29)
					array.add(new Tile(stone, x, y, Tile.TELEPORT));
				
				//Create right new world teleport
				else if(x == 79 && y == 30)
					array.add(new Tile(stone, x, y, Tile.TELEPORT));
				//create normal stone grid
				else if(x == 40 || x == 41 || x == 39 || y == 30 || y == 31 || y == 29)
					array.add(new Tile(stone, x, y, Tile.WALKABLE));
				
				//create path two house top left corner
				else if(x == 10 && y < 30 || x == 11 && y < 30 || x == 12 && y == 7 || x == 13 && y == 7)
					array.add(new Tile(stone, x, y, Tile.WALKABLE));
				
				//Create path to spooky house top middle straight down
				else if(x == 31 && y >= 12 && y <= 18)
					array.add(new Tile(stone, x, y, Tile.WALKABLE));
				
				//Create path to spooky house top middle right angle
				else if(y == 18 && x >= 32 && x <= 38)
					array.add(new Tile(stone, x, y, Tile.WALKABLE));
				
				//Create roof house top left corner
				else if(x == 14 && y >= 5 && y <= 9  && y != 7 || x == 15 && y >= 5 && y <= 9 || x == 16 && y >= 5 && y <= 9 || x == 17 && y >= 5 && y <= 9 || x == 18 && y >= 5 && y <= 9)
					array.add(new Tile(roof, x, y, Tile.NOT_WALKABLE));
				
				//Create door house top left corner
				else if(x == 14 && y == 7)
					array.add(new Tile(door, x, y, Tile.TELEPORT));
				
				//Create door spooky house top middle
				else if(x == 31 && y == 11)
					array.add(new Tile(door, x, y, Tile.TELEPORT));
				
				//Create roof spooky house top middle
				else if(x >= 29 && x <= 33 && y >= 7 && y <= 11)
					array.add(new Tile(roof, x, y, Tile.NOT_WALKABLE));
				
				//Create forest north east
				else if(x >= 42 && x <= 80 && y >= 0 && y <= 28){
					if(x >= 42 && x <= 77 && y >= 4 && y <= 5)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x <= 77 && x >= 76 && y >= 5 && y <= 24)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 42 && x <= 79 && y <= 28 && y >= 27)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 42 && x <= 43 && y <= 28 && y >= 4)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 46 && x <= 75 && y >= 23 && y <= 24)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 46 && x <= 47 && y >= 8 && y <= 22)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 50 && x <= 51 && y >= 6 && y <= 20)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 52 && x <= 73 && y >= 19 && y <= 20)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 72 && x <= 73 && y <= 18 && y >= 8)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x >= 70 && x <= 71 && y >= 12 && y <= 16)
						array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
					else if(x >= 67 && x <= 69 && y >= 12 && y <= 14)
						array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
					else if(x >= 67 && x <= 68 && y >= 14 && y <= 16)
						array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
					else if(x == 69 && y == 15)
						array.add(new Tile(cobble, x, y, Tile.TELEPORT));
					else if(x >= 53 && x <= 71 && y == 10)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 65 && y >= 11 && y <= 16)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 71 && y == 11)
						array.add(new Tile(grass, x, y, Tile.SM_CHEST));
					else if(x == 70 && y >= 6 && y <= 8)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 68 && y >= 7 && y <= 9)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 66 && y >= 6 && y <= 8)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 64 && y >= 7 && y <= 9)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 62 && y >= 6 && y <= 8)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 60 && y >= 7 && y <= 9)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 58 && y >= 6 && y <= 8)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x <= 56 && x >= 55 && y >= 7 && y <= 9)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x <= 53 && x >= 52 && y >= 6 && y <= 8)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 54 && y >= 10 && y <= 17)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 57 && y >= 12 && y <= 18)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 60 && y >= 10 && y <= 17)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else if(x == 63 && y >= 12 && y <= 18)
						array.add(new Tile(tree, x, y, Tile.NOT_WALKABLE));
					else
						array.add(new Tile(grass, x, y, Tile.WALKABLE));
				}
				
				//Create all the other blocks to grass
				else{
					if(Engine.random.nextBoolean())
						array.add(new Tile(grass, x, y, Tile.WALKABLE));
					else
						array.add(new Tile(grass, x, y, Tile.BATTLE));
				}
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
