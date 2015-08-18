package net.netne.andycomputer.jrpg.Characters;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player {
	private int coin, xp, hp, maxHp, xpToNextLevel, xPos, yPos, level;
	public int damage, defence;
	public Image img;
	public Inventory inventory = new Inventory();
	
	public Player(int x, int y){
		xPos = x;
		yPos = y;
		level = 1;
		hp = 20;
		damage = 2;
		defence = 1;
		maxHp = 20;
		xpToNextLevel = 10;
		InputStream in = getClass().getResourceAsStream("player.png");
		try {
			img = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(true);
	}
	
	public void BattleDone(BattlePlayer p, int c){
		this.xp = p.xp;
		this.hp = p.hp;
		this.coin += c;
		CheckLevelUp();
	}
	
	public void CheckLevelUp(){
		if(this.xp >= this.xpToNextLevel)
			LevelUp();
	}
	
	public void LevelUp(){
		level++;
		maxHp += (int)((Math.random() *(6-3))+1);
		hp = maxHp;
		damage += (int)(Math.random()*(2-1)+1);
		defence += (int)((Math.random() * (5-2)) + 1);
		xp = 0;
		xpToNextLevel += (int)((Math.random() * (10-6))+1);
	}
	
	public int GetXPos(){
		return xPos;
	}
	
	public int GetYPos(){
		return yPos;
	}
	
	public void moveUp(){
		yPos--;
		if(yPos < 3)
			yPos = 3;
	}
	
	public void moveDown(){
		yPos++;
		if(yPos > 60)
			yPos = 60;
	}
	
	public void moveLeft(){
		xPos--;
		if(xPos < 0)
			xPos = 0;
	}
	
	public void moveRight(){
		xPos++;
		if(xPos >= 79)
			xPos = 79;
	}
	
	public void SetHP(int h){
		hp = h;
	}
	
	public void AddXP(int x){
		xp += x;
	}
	
	public int GetHP(){
		return hp;
	}
	
	public int GetXP(){
		return xp;
	}
	
	public int GetLevel(){
		return level;
	}
	
	public void SetXPos(int x){
		this.xPos = x;
	}
	
	public void SetYPos(int y){
		this.yPos = y;
	}
	
	public void SetCoin(int c){
		this.coin = c;
	}
	
	public int GetCoin(){
		return this.coin;
	}

	public int GetMaxHealth() {
		return maxHp;
	}

	public int GetXPToNextLevel() {
		return this.xpToNextLevel;
	}

	public void SetLevel(int parseInt) {
		this.level = parseInt;
	}

	public void SetXP(int parseInt) {
		this.xp = parseInt;
	}

	public void SetXPNext(int parseInt) {
		this.xpToNextLevel = parseInt;
	}
}
