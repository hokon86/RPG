package net.netne.andycomputer.jrpg.Characters;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import net.netne.andycomputer.jrpg.Level.Level;

public class MonsterSelector {
	
	public Image GetGhost(){
		InputStream in = getClass().getResourceAsStream("ghost.png");
		try{
			return ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public BattleMonster select(String area, int defence, int level, boolean boss) {
		BattleMonster monster = null;
		if(area == Level.Level1)
			monster = Level1Monster(defence, level);
		else if(area == Level.Level1Cave1)
			monster = Level1Cave(defence, level);
		else
			monster = Level1Monster(defence, level);
		return monster;
	}
	
	private BattleMonster Level1Cave(int def, int lvl){
		int chance = (int)(Math.random() * (3+1)+1);
		if(chance == 1)
			return new BattleMonster(0, 4, lvl, def, GetGMew(), "Green Mew");
		else if(chance == 2)
			return new BattleMonster(0, 4, lvl, def, GetSquirrel(), "Squirrel");
		return null;
	}
	
	private BattleMonster Level1Monster(int def, int lvl){
		int chance = (int)(Math.random() * (3-1)+1);
		if(chance == 1)
			return new BattleMonster(0, 4, lvl, def, GetGhost(), "Ghost");
		else if(chance == 2)
			return new BattleMonster(0, 4, lvl, def, GetSquirrel(), "Squirrel");
		return null;
	}
	
	private Image GetGMew(){
		InputStream in = getClass().getResourceAsStream("greenmew.png");
		try{
			return ImageIO.read(in);
		} catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	private Image GetSquirrel() {
		InputStream in = getClass().getResourceAsStream("Squirrel.png");
		try{
			return ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
