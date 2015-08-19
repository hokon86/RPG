package net.netne.andycomputer.jrpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.netne.andycomputer.jrpg.Battle.Battle;
import net.netne.andycomputer.jrpg.Characters.NPC;
import net.netne.andycomputer.jrpg.Characters.Player;
import net.netne.andycomputer.jrpg.Level.*;
import net.netne.andycomputer.jrpg.Menu.StatsScreen;

public class Engine extends JFrame {
	public static Random random = new Random();
	private JPanel content;
	
	public StatsScreen stats = new StatsScreen();
	public Player player;
	public Thread mainThread;
	public Level level;
	public BufferedImage background;
	public ArrayList<Tile> textureArray;
	public Image[] textures = new Image[3];
	public NPC npc = null;
	public Teleport teleport = new Teleport();
	public boolean running = false;
	public boolean inBattle = false;
	public boolean inStat = false;
	public boolean sceneContainNPC = false;
	public boolean levelCreated = false;
	public boolean inShop = false;
	public boolean gameLoaded = false;
	public boolean drawStatsBottom = true;
	public boolean outDoor = true;
	public boolean drawBackground = true;
	public boolean playerMoved = true;
	public Dimension size = new Dimension(800, 600);
	public String area = Level.Level1;
	public int[] typeArray;
	public int timeSinceBattle = 0;
	public long messageTimeLeft = 0;
	public long lastTime = 0;
	
	public static void TellPlayer(String s){
		JOptionPane.showMessageDialog(null, s, "Message", JOptionPane.PLAIN_MESSAGE);
	}
	
	public Engine(){
		content = new JPanel(){
			
			@Override
			public void paintComponent(Graphics g){
				//super.paintComponent(g);
				g = paintPanel(g);
				repaint();
			}
		};
		JOptionPane.showMessageDialog(this, "Game Start!", "You are in game!", JOptionPane.PLAIN_MESSAGE);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
		player = new Player((size.width/2)/10, (size.height/2)/10);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(content);
		setVisible(true);
		this.setResizable(false);
		this.addKeyListener(listener);
		running = true;
		StartGame();
	}
	
	public KeyListener listener = new KeyAdapter(){
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_L && !gameLoaded)
					LoadGame();
			timeSinceBattle++;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
				MovePlayer(1);
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
				MovePlayer(2);
			}
			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
				MovePlayer(3);
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
				MovePlayer(4);
			}
			if(e.getKeyCode() == KeyEvent.VK_B){
				Shop();
			}
			if(e.getKeyCode() == KeyEvent.VK_0){
				Use();
			}
			if(e.getKeyCode() == KeyEvent.VK_Q)
				Jump();
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				SaveGame();
			if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				DeleteSave();
			if(e.getKeyCode() == KeyEvent.VK_K)
				ShowStats();
		}
	};
	
	public void ShowStats(){
		if(!inStat)
			inStat = true;
		else
			inStat = false;
	}
	
	public void Jump(){
		area = Level.Level2Cave1;
		level = new Level2Cave1();
		player.SetXPos(20);
		player.SetYPos(16);
		if(area == Level.Level1){
			sceneContainNPC = false;
			npc = null;
		}
		textureArray = level.CreateTiles();
		textures = level.GetTextures();
		levelCreated = true;
		background = level.GetLayout();
	}
	
	protected void SaveGame(){
		Properties props = new Properties();
		props.setProperty("HP", Integer.toString(player.GetHP()));
		props.setProperty("Coin", Integer.toString(player.GetCoin()));
		props.setProperty("Level", Integer.toString(player.GetLevel()));
		props.setProperty("XP", Integer.toString(player.GetXP()));
		props.setProperty("XPNext", Integer.toString(player.GetXPToNextLevel()));
		FileWriter writer = null;
		try{
			writer = new FileWriter("game.properties");
			props.store(writer, "Author: Andreas Hammer");
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if(writer != null){
				try{
					writer.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	protected boolean CheckLoadable(){
		try{
			File in = new File("game.properties");
			if(!in.exists())
				return false;
		} catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	protected void DeleteSave(){
		try{
			File file = new File("game.properties");
			int answer = 98332478;
			if(file.exists())
				answer = JOptionPane.showConfirmDialog(this, file);
			if(answer == JOptionPane.CANCEL_OPTION || answer == JOptionPane.NO_OPTION){
				return;
			}
			if(file.delete()){
				System.out.println("You succsessfully deleted the save");
			}
			else if(!file.delete() || !file.exists())
				System.out.println("You can't delete that file, or you don't have any saves!");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void LoadGame() {
		if(!CheckLoadable())
			return;
		try{
			FileReader in = new FileReader("game.properties");
			Properties props = new Properties();
			props.load(in);
			player.SetHP(Integer.parseInt(props.getProperty("HP")));
			player.SetCoin(Integer.parseInt(props.getProperty("Coin")));
			player.SetLevel(Integer.parseInt(props.getProperty("Level")));
			player.SetXP(Integer.parseInt(props.getProperty("XP")));
			player.SetXPNext(Integer.parseInt(props.getProperty("XPNext")));
		} catch(IOException e){
			e.printStackTrace();
		}
		ArrayList<Object> obj = teleport.TeleportOnLoad(area, level);
		level = (Level)obj.get(0);
		sceneContainNPC = (Boolean) obj.get(1);
		npc = (NPC)obj.get(2);
		outDoor = (Boolean)obj.get(3);
		textureArray = level.CreateTiles();
		textures = level.GetTextures();
		background = level.GetLayout();
		gameLoaded = true;
	}

	public void Shop(){
		if(!inShop){
			int currentTileType = Step().type;
			if(currentTileType == 5){
				inShop = true;
			}
		}
		else if(inShop){
			if(player.GetCoin() >= npc.price){
				player.SetHP(player.GetMaxHealth());
			}
			else{
				JOptionPane.showMessageDialog(this, "Can't you read? It says 10 Cr. and you don't have that kind of money!", "Shop error", JOptionPane.PLAIN_MESSAGE);
			}
			inShop = false;
		}
	}
	
	public void Inventory(){
		
	}
	
	public void Use(){
		StartGame();
	}
	
	public void MovePlayer(int i){
		playerMoved = true;
		if(player.GetYPos() > 30)
			drawStatsBottom = false;
		else
			drawStatsBottom = true;
		int lastX = player.GetXPos();
		int lastY = player.GetYPos();
		if(i == 1){
			player.moveRight();
		}
		if(i == 2){
			player.moveLeft();
		}
		if(i == 3){
			player.moveUp();
		}
		if(i == 4){
			player.moveDown();
		}
		Tile curTile = Step();
		int currentTileType = curTile.type;
		if(currentTileType == Tile.NOT_WALKABLE){
			player.SetXPos(lastX);
			player.SetYPos(lastY);
		}
		else if(currentTileType == Tile.TELEPORT && timeSinceBattle > 5)
			Teleport();
		if(currentTileType == Tile.BATTLE){
			int chance = (int)(Math.random()*((10-1)+1));
			if(chance == 4){
				StartBattle();
			}
			System.out.println(player.GetXPos()*player.GetYPos());
		}
		else if(currentTileType == Tile.SM_CHEST && !curTile.taken || currentTileType == Tile.LG_CHEST && !curTile.taken){
			player.SetCoin(player.GetCoin() + curTile.coin);
			curTile.taken = true;
		}
		System.out.println("X: " + player.GetXPos() + " Y: " + player.GetYPos());
	}
	
	public void Teleport(){
		levelCreated = false;
		ArrayList<Object> obj = teleport.TeleportPlayer(area, player, level);
		area = (String)obj.get(0);
		player = (Player)obj.get(1);
		level = (Level)obj.get(2);
		sceneContainNPC = (Boolean) obj.get(3);
		npc = (NPC)obj.get(4);
		outDoor = (Boolean)obj.get(5);
		if(area == Level.Level1){
			sceneContainNPC = false;
			npc = null;
		}
		textureArray = level.CreateTiles();
		textures = level.GetTextures();
		levelCreated = true;
		background = level.GetLayout();
		this.changeDrawBackground();
	}
	
	public void StartBattle(){
		timeSinceBattle = 0;
		inBattle = true;
		new Battle(this, player, area);
	}
	
	public void BattleIsFinished(){
		inBattle = false;
	}
	
	public Tile Step(){
		Tile tile = null;
		for(int i = 0; i<textureArray.size(); i++){
			if(textureArray.get(i).GetXPos() == player.GetXPos() && textureArray.get(i).GetYPos() == player.GetYPos()){
				tile = textureArray.get(i);
				break;
			}
		}
		if(tile == null)
			System.out.println("Player is floating in the air!");
		return tile;
	}
	
	public void StartGame(){
		if(area == Level.Level1){
			level = new Level1();
			textureArray = level.CreateTiles();
			textures = level.GetTextures();
			levelCreated = true;
			background = level.GetLayout();
		}
		if(area == Level.Level1Cave1){
			level = new Level1Cave1();
			textureArray = level.CreateTiles();
			textures = level.GetTextures();
			levelCreated = true;
			background = level.GetLayout();
		}
	}
	
	public void changeDrawBackground(){
		if(drawBackground)
			drawBackground = false;
		else
			drawBackground = true;
	}
	
	public Graphics paintPanel(Graphics g){
		if(!levelCreated)
			return g;
		Graphics2D g2d = (Graphics2D)g;
		if(!inShop && !inStat){
			if(background == null){
				for(Tile t : textureArray){
					g2d.drawImage(t.GetTexture(), t.GetXPos()*10, t.GetYPos()*10, this);
				}
			}
			//if(drawBackground){
				g2d.drawImage(background, 0, 0, this);
				drawBackground = false;
			//}
			g2d.drawImage(player.img, player.GetXPos()*10, player.GetYPos()*10, this);
			if(sceneContainNPC && npc != null)
				g2d.drawImage(npc.image, npc.xPos*10, npc.yPos*10, this);
			if(outDoor)
				g2d.setColor(Color.BLACK);
			else
				g2d.setColor(Color.WHITE);
			if(drawStatsBottom){
				g2d.drawString("XP remaining: " + Integer.toString((player.GetXPToNextLevel() - player.GetXP())), 10, size.height-30);
				g2d.drawString("Health: " + Integer.toString(player.GetHP()), 10, size.height-70);
				g2d.drawString("Coin: " + Integer.toString(player.GetCoin()), 10, size.height-50);
			}
			else{
				g2d.drawString("XP remaining: " + Integer.toString((player.GetXPToNextLevel() - player.GetXP())), size.width-150, 90);
				g2d.drawString("Health: " + Integer.toString(player.GetHP()), size.width-150, 50);
				g2d.drawString("Coin: " + Integer.toString(player.GetCoin()), size.width-150, 70);
			}
		}
		else if(inStat && !inShop){
			g2d.drawString("Health: ", (size.width/2)-60, 100);
			g2d.drawImage(stats.outline, (size.width/2), 100, null);
			g2d.drawImage(stats.bar, (size.width/2)+4, 105, (player.GetMaxHealth()/player.GetHP())*100, 20, null);
		}
		else{
			FontMetrics fm = g.getFontMetrics();
			Rectangle2D rect = fm.getStringBounds(npc.salery, g);
			g2d.drawString(npc.salery, (int)(size.width-rect.getWidth())/2, 150);
			g2d.drawImage(npc.viewImage, size.width/2-(npc.viewImage.getWidth(this)/2), size.height/2-(npc.viewImage.getHeight(this)/2), this);
		}
		playerMoved = false;
		return g;
	}
}
