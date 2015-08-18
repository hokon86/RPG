package net.netne.andycomputer.jrpg.Level;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.netne.andycomputer.jrpg.Engine;

public class Level1SpookyHouse1Basement1 extends Level {
	private Image grass, dirt, stone, roof, door, stair, cobble, bush, wall, blank, black;
	private int xTiles;
	private int yTiles;
	private ArrayList<Tile> imageArray;
	
	public Level1SpookyHouse1Basement1(){
		grass = super.GetGrass();
		stone = super.GetStone();
		dirt = super.GetDirt();
		roof = super.GetRoof();
		door = super.GetDoor();
		stair = super.GetStair();
		cobble = super.GetCobble();
		bush = super.GetTree();
		wall = super.GetWall();
		blank = super.GetBlank();
		black = super.GetBlack();
		xTiles = (Toolkit.getDefaultToolkit().getScreenSize().width)/10;
		yTiles = (Toolkit.getDefaultToolkit().getScreenSize().height)/10;
	}
	
	
	@Override
	public ArrayList<Tile> CreateTiles(){
		ArrayList<Tile> array = new ArrayList<Tile>();
		for(int x = 0; x<xTiles; x++){
			for(int y = 0; y<yTiles; y++){
				//Create teleport back
				if(x == 2 && y == 30)
					array.add(new Tile(stair, x, y, Tile.TELEPORT));
				else if(x == 2 && y == 31)
					array.add(new Tile(blank, x, y, Tile.TELEPORT));
				else if(x == 3 && y >= 30 && y <= 31)
					array.add(new Tile(blank, x, y, Tile.WALKABLE));
				
				
				//Create starting area
				else if(x >= 4 && x <= 6 && y >= 30 && y <= 31)
					array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				else if(x >= 0 && x <= 6 && y >= 28 && y <= 33)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create main area part1
				//Create line 7
				else if(x >= 7 && x <= 8 && y >= 16 && y <= 45 && y != 30 && y != 31 && y != 32 && y != 29)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 8
				else if(x >= 9 && x <= 10 && y >= 16 && y <= 19 || x >= 9 && x <= 10 && y >= 38 && y <= 45)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 9
				else if(x >= 11 && x <= 12 && y >= 16 && y <= 19 || x >= 11 && x <= 12 && y >= 44 && y <= 45)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 10
				else if(x >= 13 && x <= 14 && y >= 12 && y <= 19 || x >= 13 && x <= 14 && y >= 38 && y <= 39 || x >= 13 && x <= 14 && y >= 44 && y <= 45)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 11
				else if(x >= 15 && x <= 16 && y >= 38 && y <= 39 || x >= 15 && x <= 16 && y >= 44 && y <= 45)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 12
				else if(x >= 17 && x <= 18 && y >= 20 && y <= 21 || x >= 17 && x <= 18 && y >= 24 && y <= 27 || x >= 17 && x <= 18 && y >= 30 && y <= 45)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 13
				else if(x >= 19 && x <= 20 && y >= 18 && y <= 21 || x >= 19 && x <= 20 && y >= 24 && y <= 27 || x >= 19 && x <= 20 && y >= 36 && y <= 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 14
				else if(x >= 21 && x <= 22 && y >= 16 && y <= 19 || x >= 21 && x <= 22 && y >= 26 && y <= 27 || x >= 21 && x <= 22 && y >= 36 && y <= 39)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));

				//Create line 15
				else if(x >= 23 && x <= 24 && y >= 12 && y <= 17 || x >= 23 && x <= 24 && y >= 26 && y <= 27 || x >= 23 && x <= 24 && y >= 36 && y <= 39)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 16
				else if(x >= 25 && x <= 26 && y >= 12 && y <= 19 || x >= 25 && x <= 26 && y >= 24 && y <= 39 || x == 25 && y >= 20 && y <= 21)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create live 17
				else if(x >= 27 && x <= 28 && y >= 18 && y <= 33 || x >= 27 && x <= 28 && y >= 38 && y <= 39)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Cover the area 1 with cobblestone
				else if(x == 22 && y == 33 || y == 20 && x == 26)
					array.add(new Tile(cobble, x, y, Tile.SM_CHEST));
				else if(x >= 7 && x <= 18 && y >= 16 && y <= 43){
					if(Engine.random.nextBoolean())
						array.add(new Tile(cobble, x, y, Tile.BATTLE));//
					else
						array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				}
				else if(x >= 19 && x <= 26 && y >= 16 && y <= 37){
					if(Engine.random.nextBoolean())
						array.add(new Tile(cobble, x, y, Tile.BATTLE));//
					else
						array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				}
				
				//Create main area part 2
				//Create line 11
				else if(x >= 15 && x <= 16 && y >= 4 && y <= 15)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 12
				else if(x >= 17 && x <= 18 && y >= 4 && y <= 9)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 13
				else if(x >= 19 && x <= 20 && y >= 4 && y <= 9 || x >= 19 && x <= 20 && y >= 58 && y <= 60)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 14
				else if(x >= 21 && x <= 22 && y >= 2 && y <= 7 || x >= 21 && x <= 22 && y >= 50 && y <= 53 || x >= 21 && x <= 22 && y >= 58 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 15
				else if(x >= 23 && x <= 24 && y >= 2 && y <= 3 || x >= 23 && x <= 24 && y >= 42 && y <= 47 || x >= 23 && x <= 24 && y >= 50 && y <= 53 || x >= 23 && x <= 24 && y >= 58 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 16
				else if(x >= 25 && x <= 26 && y >= 2 && y <= 3 || x >= 25 && x <= 26 && y >= 42 && y <= 43 || x >= 25 && x <= 26 && y >= 46 && y <= 47 || x >= 25 && x <= 26 && y >= 50 && y <= 53 || x >= 25 && x <= 26 && y >= 58 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 17
				else if(x >= 27 && x <= 28 && y >= 2 && y <= 3 || x >= 27 && x <= 28 && y >= 12 && y <= 15 || x >= 27 && x <= 28 && y >= 42 && y <= 43 || x >= 27 && x <= 28 && y >= 50 && y <= 53 || x >= 27 && x <= 28 && y >= 58 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 18
				else if(x >= 29 && x <= 30 && y >= 2 && y <= 3 || x >= 29 && x <= 30 && y >= 6 && y <= 27 || x >= 29 && x <= 30 && y >= 32 && y <= 39 || x >= 29 && x <= 30 && y >= 42 && y <= 53 || x >= 29 && x <= 30 && y >= 58 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 19
				else if(x >= 31 && x <= 32 && y >= 2 && y <= 3 || x >= 31 && x <= 32 && y >= 58 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 20
				else if(x >= 33 && x <= 34 && y >= 2 && y <= 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create main area part 3
				//Create line 6
				else if(x >= 5 && x <= 6 && y >= 46 && y <= 60)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 7
				else if(x >= 7 && x <= 9 && y == 49 || x == 9 && y >= 49 && y <= 50)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x >= 7 && x <= 10 && y == 52 || x == 9 && y == 53)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				else if(x == 8 && y == 51)
					array.add(new Tile(cobble, x, y, Tile.TELEPORT));
				else if(x >= 7 && x <= 8 && y >= 46 && y <= 47 || x >= 7 && x <= 8 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 8
				else if(x >= 9 && x <= 10 && y >= 46 && y <= 47 || x >= 9 && x <= 10 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 9
				else if(x >= 11 && x <= 12 && y >= 46 && y <= 47 || x >= 11 && x <= 12 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 10
				else if(x >= 13 && x <= 14 && y >= 46 && y <= 47 || x >= 13 && x <= 14 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 11
				else if(x >= 15 && x <= 16 && y >= 46 && y <= 47 || x >= 15 && x <= 16 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 12
				else if(x >= 17 && x <= 18 && y >= 46 && y <= 47 || x >= 17 && x <= 18 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 13
				else if(x >= 19 && x <= 20 && y >= 46 && y <= 51 || x >= 19 && x <= 20 && y == 59)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Cover the rest with cobblestone
				else if(y == 44 && x == 25)
					array.add(new Tile(cobble, x, y, Tile.SM_CHEST));
				else if(y == 53 && x == 10)
					array.add(new Tile(cobble, x, y, Tile.LG_CHEST));
				else if(x >= 27 && x <= 28 && y >= 16 && y <= 17)
					array.add(new Tile(black, x, y, Tile.NOT_WALKABLE));
				else if(x >= 27 && x <= 28 && y >= 34 && y <= 37)
					array.add(new Tile(black, x, y, Tile.NOT_WALKABLE));
				else if(x >= 15 && x <= 32 && y >= 4 && y <= 57){
					if(Engine.random.nextBoolean())
						array.add(new Tile(cobble, x, y, Tile.BATTLE));//
					else
						array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				}
				else if(x >= 7 && x <= 20 && y >= 48 && y <= 60){
					if(Engine.random.nextBoolean())
						array.add(new Tile(cobble, x, y, Tile.BATTLE));//
					else
						array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				}
				
				//Create the spiral area in the east
				//Create line 21
				else if(x >= 50 && x <= 51 && y >= 24 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 22
				else if(x >= 52 && x <= 53 && y >= 24 && y <= 25 || x >= 52 && x <= 53 && y >= 36 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 23
				else if(x >= 54 && x <= 55 && y >= 24 && y <= 33 || x >= 54 && x <= 55 && y >= 36 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 24
				else if(x >= 56 && x <= 57 && y >= 24 && y <= 25 || x >= 56 && x <= 57 && y >= 32 && y <= 33 || x >= 56 && x <= 57 && y >= 36 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 25
				else if(x >= 58 && x <= 59 && y >= 24 && y <= 25 || x >= 58 && x <= 59 && y >= 28 && y <= 29 || x >= 58 && x <= 59 && y >= 32 && y <= 33 || x >= 58 && x <= 59 && y >= 36 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 26
				else if(x >= 60 && x <= 61 && y >= 24 && y <= 25 || x >= 60 && x <= 61 && y >= 28 && y <= 33 || x >= 60 && x <= 61 && y >= 36 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 27
				else if(x >= 62 && x <= 63 && y >= 24 && y <= 25 || x >= 62 && x <= 63 && y >= 36 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Create line 28
				else if(x >= 64 && x <= 65 && y >= 24 && y <= 37)
					array.add(new Tile(wall, x, y, Tile.NOT_WALKABLE));
				
				//Cover with cobblestone
				else if(x == 58 && y == 30 || x == 58 && y == 31)
					array.add(new Tile(cobble, x, y, Tile.TELEPORT));
				else if(x >= 50 && x <= 65 && y >= 24 && y <= 37)
					array.add(new Tile(cobble, x, y, Tile.WALKABLE));
				
				//Create the black area that does not contain blocks
				else
					array.add(new Tile(black, x, y, Tile.WALKABLE));
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
