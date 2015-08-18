package net.netne.andycomputer.jrpg.Battle;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import net.netne.andycomputer.jrpg.Engine;
import net.netne.andycomputer.jrpg.Battle.Properties.Exit;
import net.netne.andycomputer.jrpg.Characters.BattleMonster;
import net.netne.andycomputer.jrpg.Characters.BattlePlayer;
import net.netne.andycomputer.jrpg.Characters.MonsterSelector;
import net.netne.andycomputer.jrpg.Characters.Player;
import net.netne.andycomputer.jrpg.Level.Level;

public class Battle extends JFrame implements Runnable {
	private Engine sender;
	private BattlePlayer player;
	private Thread battleThread;
	private Dimension size = new Dimension(800, 600);
	private BattleMonster monster;
	private int animationTime = 0;
	private boolean underAnimation = true;
	private boolean playerTurn = true;
	private Player pp;
	private String area = "";
	
	private boolean animating = false;
	private boolean inBattle = false;
	
	public Battle(Engine e, Player p, String area){
		sender = e;
		pp = p;
		this.area = area;
		player = new BattlePlayer(0, size.height/20, p.defence);
		player.hp = p.GetHP();
		player.xp = p.GetXP();
		player.level = p.GetLevel();
		player.damage = p.damage;
		setVisible(true);
		setResizable(false);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
		monster = new MonsterSelector().select(area, player.defence, player.level, isBoss(player.xPos, player.yPos, area));
		if(monster == null)
			this.BattleIsFinished(false);
		this.addKeyListener(k1);
		Start();
	}
	
	public boolean isBoss(int x, int y, String area){
		if(area == Level.Level1Cave1)
			return false;
		return false;
	}
	
	public KeyListener k1 = new KeyAdapter(){
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_A && playerTurn && inBattle){
				Attack();
				MonsterTurn();
			}
			else if(e.getKeyCode() == KeyEvent.VK_S && playerTurn && inBattle){
				Heal();
				MonsterTurn();
			}
		}
	};
	
	public void MonsterTurn(){
		player.hp -= (int)((Math.random()*(monster.damage+1-monster.damage-1))+1);
	}
	
	public void Attack(){
		monster.hp -= (int)((Math.random()*(player.damage+1-player.damage-1))+1);
	}
	
	public void Heal(){
		System.out.println("Heal");
	}
	
	public void Start(){
		battleThread = new Thread(this);
		battleThread.start();
	}
	
	public void run(){
		System.out.println(true);
		animating = true;
		while(true){
			tick();
			render();
			if(underAnimation){
				try{
					battleThread.sleep(25);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void tick(){
		if(underAnimation){
			if(monster.xPos > (size.width/2)/20){
				underAnimation = false;
				inBattle = true;
			}
			monster.xPos += 1;
			animationTime++;
			if(animationTime == 2){
				player.yPos -= 1;
				player.xPos += 1;
				animationTime = 0;
			}
		}
		if(inBattle){
			if(player.hp <= 0){
				exit();
			}
			if(monster.hp <= 0){
				inBattle = false;
				BattleIsFinished(true);
			}
		}
	}
	
	public void render(){
		
	}
	
	private void BattleIsFinished(boolean win){
		System.out.println("VOID");
		if(win){
			player.xp += monster.xp;
			sender.BattleIsFinished();
			pp.BattleDone(player, monster.coin);
			exit();
		}
		else{
			sender.BattleIsFinished();
			exit();
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(monster.image, monster.xPos*20, monster.yPos*20, this);
		g2d.drawImage(player.image, (int)player.xPos*20, (int)player.yPos*20, this);
		if(inBattle){
			g2d.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g2d.drawString("A - Attack", size.width-200, size.height-150);
			g2d.drawString("S - Heal", size.width-200, size.height-100);
			g2d.drawString("Monster", 20, 50);
			g2d.drawString("Health: " + monster.hp, 20, 80);
			g2d.drawString("Level: " + monster.level, 20, 110);
			g2d.drawString("Player", 20, 150);
			g2d.drawString("Health: " + player.hp, 20, 180);
			g2d.drawString("Level: " + player.level, 20, 210);
		}
		repaint();
	}
	
	private void exit() {
	    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		try{
			battleThread.join();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
