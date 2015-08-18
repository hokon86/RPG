package net.netne.andycomputer.jrpg.Menu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import net.netne.andycomputer.jrpg.Engine;
import net.netne.andycomputer.jrpg.Characters.BattleMonster;
import net.netne.andycomputer.jrpg.Characters.BattlePlayer;
import net.netne.andycomputer.jrpg.Characters.MonsterSelector;
import net.netne.andycomputer.jrpg.Characters.Player;

public class StatsScreen {
	public Image outline, bar;
	
	public StatsScreen(){
		InputStream in = getClass().getResourceAsStream("outline.png");
		try{
			outline = ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
		in = getClass().getResourceAsStream("bar.png");
		try{
			bar = ImageIO.read(in);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
