package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.netne.andycomputer.jrpg.Engine;

public class Level1Cave1 extends Level {
	private Image grass, dirt, stone, roof, door, stair, cobble, tree, blank, black, wall, boss;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	private int[] treeBottomArray = new int[2];
	
	public Level1Cave1(){
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
		boss = super.GetBoss();
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
				//Create line 1
				if(x >= 8 && x <= 9 && y >= 40 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 2
				else if(x >= 10 && x <= 11 && y >= 26 && y <= 41 || x >= 10 && x <= 11 && y == 43 || x >= 10 && x <= 11 && y == 46 || x >= 10 && x <= 11 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 3
				else if(x >= 12 && x <= 13 && y >= 26 && y <= 27 || x >= 12 && x <= 13 && y >= 40 && y <= 41 || x >= 12 && x <= 13 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 4
				else if(x >= 14 && x <= 15 && y >= 26 && y <= 27 || x >= 14 && x <= 15 && y >= 34 && y <= 35 || x == 14 && y >= 40 && y <= 41 || x >= 14 && x <= 15 && y >= 42 && y <= 43 || x >= 14 && x <= 15 && y >= 48 && y <= 49)
						array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 5
				else if(x >= 16 && x <= 17 && y >= 4 && y <= 23 || x >= 16 && x <= 17 && y >= 26 && y <= 27 || x >= 16 && x <= 17 && y >= 30 && y <= 31 || x >= 16 && x <= 17 && y >= 36 && y <= 39 || x >= 16 && x <= 17 && y >= 42 && y <= 43 || x >= 16 && x <= 17 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 6
				else if(x >= 18 && x <= 19 && y >= 4 && y <= 5 || x >= 18 && x <= 19 && y >= 12 && y <= 15 || x >= 18 && x <= 19 && y >= 22 && y <= 31 || x >= 18 && x <= 19 && y >= 36 && y <= 43 || x >= 18 && x <= 19 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 7
				else if(x >= 20 && x <= 21 && y >= 4 && y <= 5 || x >= 20 && x <= 21 && y >= 12 && y <= 15 || x >= 20 && x <= 21 && y >= 36 && y <= 43 || x >= 20 && x <= 21 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 8
				else if(x >= 22 && x <= 23 && y >= 4 && y <= 5 || x >= 22 && x <= 23 && y >= 12 && y <= 15 || x >= 22 && x <= 23 && y >= 22 && y <= 27 || x >= 22 && x <= 23 && y >= 34 && y <= 39 || x >= 22 && x <= 23 && y >= 42 && y <= 43 || x >= 22 && x <= 23 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 9
				else if(x >= 24 && x <= 25 && y >= 4 && y <= 9 || x >= 24 && x <= 25 && y >= 12 && y <= 17 || x >= 24 && x <= 25 && y >= 20 && y <= 23 || x >= 24 && x <= 25 && y >= 26 && y <= 27 || x >= 24 && x <= 25 && y >= 42 && y <= 43 || x >= 24 && x <= 25 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 10
				else if(x >= 26 && x <= 27 && y >= 8 && y <= 9 || x >= 26 && x <= 27 && y >= 22 && y <= 23 || x >= 26 && x <= 27 && y >= 26 && y <= 27 || x >= 26 && x <= 27 && y >= 30 && y <= 33 || x >= 26 && x <= 27 && y >= 48 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 11
				else if(x >= 28 && x <= 29 && y >= 8 && y <= 9 || x >= 28 && x <= 29 && y >= 16 && y <= 23 || x >= 28 && x <= 29 && y >= 26 && y <= 27 || x >= 28 && x <= 29 && y >= 32 && y <= 33 || x >= 28 && x <= 29 && y >= 36 && y <= 37 || x >= 28 && x <= 29 && y >= 40 && y <= 41 || x >= 28 && x <= 29 && y >= 46 && y <= 49)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 12
				else if(x >= 30 && x <= 31 && y >= 8 && y <= 9 || x >= 30 && x <= 31 && y >= 26 && y <= 27 || x >= 30 && x <= 31 && y >= 36 && y <= 37 || x >= 30 && x <= 31 && y >= 40 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 13
				else if(x >= 32 && x <= 33 && y >= 8 && y <= 23 || x >= 32 && x <= 33 && y >= 26 && y <= 27 || x >= 32 && x <= 33 && y >= 36 && y <= 37 || x >= 32 && x <= 33 && y >= 44 && y <= 45 || x == 33 && y >= 48 && y <= 49 || x >= 32 && x <= 33 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 14
				else if(x >= 34 && x <= 35 && y >= 22 && y <= 23 || x >= 34 && x <= 35 && y >= 26 && y <= 27 || x >= 34 && x <= 35 && y >= 32 && y <= 37 || x == 35 && y >= 40 && y <= 41 || x >= 34 && x <= 35 && y >= 44 && y <= 45 || x >= 34 && x <= 35 && y >= 48 && y <= 49 || x >= 34 && x <= 35 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 15
				else if(x >= 36 && x <= 37 && y >= 22 && y <= 23 || x >= 36 && x <= 37 && y >= 26 && y <= 33 || x >= 36 && x <= 37 && y >= 40 && y <= 41 || x >= 36 && x <= 37 && y >= 44 && y <= 45 || x >= 36 && x <= 37 && y >= 48 && y <= 49 || x >= 36 && x <= 37 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 16
				else if(x >= 38 && x <= 39 && y >= 22 && y <= 23 || x >= 38 && x <= 39 && y >= 32 && y <= 33 || x >= 38 && x <= 39 && y >= 40 && y <= 41 || x >= 38 && x <= 39 && y >= 48 && y <= 49 || x >= 38 && x <= 39 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 17
				else if(x >= 40 && x <= 41 && y >= 22 && y <= 23 || x >= 40 && x <= 41 && y >= 32 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 18
				else if(x >= 42 && x <= 43 && y >= 22 && y <= 33)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create floor
				else if(x == 20 && y == 8 || x == 27 && y == 21 || x == 24 && y == 24 || x == 41 && y == 24 || x == 17 && y == 29 || x == 39 && y == 34 || x == 17 && y == 41)
					array.add(new Tile(cobble, x, y, Tile.SM_CHEST));
				else if(x == 10 && y == 44)
					array.add(new Tile(stair, x, y, Tile.TELEPORT));
				else if(x == 10 && y == 45)
					array.add(new Tile(blank, x, y, Tile.TELEPORT));
				else if(x == 11 && y == 44 || x == 11 && y == 45)
					array.add(new Tile(blank, x, y, Tile.WALKABLE));
				else if(x == 20 && y == 18)
					array.add(new Tile(stair, x, y, Tile.TELEPORT));
				else if(x == 20 && y == 19)
					array.add(new Tile(blank, x, y, Tile.TELEPORT));
				else if(x == 21 && y == 18 || x == 21 && y == 19)
					array.add(new Tile(blank, x, y, Tile.WALKABLE));
				else if(x == 19 && y >= 18 && y <= 20 || x >= 20 && x <= 21 && y == 20 || x >= 19 && x <= 21 && y == 17)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x >= 10 && x <= 41 && y >= 28 && y <= 47 || x >= 16 && x <= 24 && y >= 4 && y <= 27 || x >= 25 && x <= 32 && y >= 8 && y <= 27 || x >= 32 && x <= 41 && y >= 24 && y <= 51)
					array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				
				//Create line 19
				else if(x >= 52 & x <= 53 && y >= 12 && y <= 17)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 20
				else if(x >= 54 && x <= 55 && y >= 12 && y <= 13 || x >= 54 && x <= 55 && y >= 16 && y <= 17 || x >= 54 && x <= 55 && y >= 46 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 21
				else if(x >= 56 && x <= 57 && y >= 10 && y <= 13 || x >= 56 && x <= 57 && y >= 16 && y <= 27 || x >= 56 && x <= 57 && y >= 46 && y <= 47 || x >= 56 && x <= 57 && y == 50  || x >= 56 && x <= 57 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 22
				else if(x >= 58 && x <= 59 && y >= 10 && y <= 11 || x >= 58 && x <= 59 && y >= 26 && y <= 27 || x >= 58 && x <= 59 && y >= 46 && y <= 47 || x >= 58 && x <= 59 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 23
				else if(x >= 60 && x <= 61 && y >= 10 && y <= 11 || x >= 60 && x <= 61 && y >= 26 && y <= 27 || x >= 60 && x <= 61 && y >= 46 && y <= 47 || x >= 60 && x <= 61 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 24
				else if(x >= 62 && x <= 63 && y >= 10 && y <= 11 || x >= 62 && x <= 63 && y >= 26 && y <= 27 || x >= 62 && x <= 63 && y >= 46 && y <= 47 || x >= 62 && x <= 63 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 25
				else if(x >= 64 && x <= 65 && y >= 10 && y <= 11 || x >= 64 && x <= 65 && y >= 26 && y <= 27 || x >= 64 && x <= 65 && y >= 46 && y <= 47 || x >= 64 && x <= 65 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 26
				else if(x >= 66 && x <= 67 && y >= 10 && y <= 11 || x >= 66 && x <= 67 && y >= 26 && y <= 27 || x >= 66 && x <= 67 && y >= 32 && y <= 47 || x >= 66 && x <= 67 && y >= 52 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 27
				else if(x >= 68 && x <= 69 && y >= 10 && y <= 11 || x >= 68 && x <= 69 && y >= 26 && y <= 27 || x >= 68 && x <= 69 && y >= 32 && y <= 33 || x >= 68 && x <= 69 && y >= 52 && y <= 55)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 28
				else if(x >= 70 && x <= 71 && y >= 10 && y <= 11 || x >= 70 && x <= 71 && y >= 26 && y <= 27 || x >= 70 && x <= 71 && y >= 32 && y <= 33 || x >= 70 && x <= 71 && y >= 54 && y <= 55)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 29
				else if(x >= 72 && x <= 73 && y >= 10 && y <= 11 || x >= 72 && x <= 73 && y >= 26 && y <= 27 || x >= 72 && x <= 73 && y >= 32 && y <= 33 || x >= 72 && x <= 73 && y >= 40 && y <= 41 || x >= 72 && x <= 73 && y >= 54 && y <= 55)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 30
				else if(x >= 74 && x <= 75 && y >= 10 && y <= 11 || x >= 74 && x <= 75 && y >= 26 && y <= 27 || x >= 74 && x <= 75 && y >= 32 && y <= 33 || x >= 74 && x <= 75 && y >= 40 && y <= 41 || x >= 74 && x <= 75 && y >= 54 && y <= 55)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 30
				else if(x >= 76 && x <= 77 && y >= 10 && y <= 27 || x >= 76 && x <= 77 && y >= 32 && y <= 33 || x >= 76 && x <= 77 && y >= 40 && y <= 41 || x >= 76 && x <= 77 && y >= 54 && y <= 55)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 31
				else if(x >= 78 && x <= 79 && y >= 32 && y <= 55)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Add boss
				else if(x == 60 && y == 16)
					array.add(new Tile(boss, x, y, Tile.BATTLE));
				else if(x == 60 && y == 17)
					array.add(new Tile(blank, x, y, Tile.BATTLE));
				else if(x == 61 && y == 16)
					array.add(new Tile(blank, x, y, Tile.BATTLE));
				else if(x == 61 && y == 17)
					array.add(new Tile(blank, x, y, Tile.BATTLE));
				
				//Cover with cobblestone
				else if(x == 56 && y == 48)
					array.add(new Tile(stair, x, y, Tile.TELEPORT));
				else if(x == 57 && y >= 48 && y <= 49)
					array.add(new Tile(blank, x, y, Tile.WALKABLE));
				else if(x == 56 && y == 49)
					array.add(new Tile(blank, x, y, Tile.TELEPORT));
				else if(x >= 56 && x <= 77 && y >= 12 && y <= 25)
					array.add(new Tile(cobble, x, y, Tile.BATTLE));
				else if(x >= 54 && x <= 55 && y >= 12 && y <= 15)
					array.add(new Tile(cobble, x, y, Tile.BATTLE));
				else if(x >= 68 && x <= 77 && y >= 32 && y <= 55)
					array.add(new Tile(cobble, x, y, Tile.BATTLE));
				else if(x >= 54 && x <= 67 && y >= 46 && y <= 51)
					array.add(new Tile(cobble, x, y, Tile.BATTLE));
				
				//Create the black areas0
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
