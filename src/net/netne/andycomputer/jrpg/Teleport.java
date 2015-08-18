package net.netne.andycomputer.jrpg;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import net.netne.andycomputer.jrpg.Characters.NPC;
import net.netne.andycomputer.jrpg.Characters.Player;
import net.netne.andycomputer.jrpg.Level.Level;
import net.netne.andycomputer.jrpg.Level.Level1;
import net.netne.andycomputer.jrpg.Level.Level1Cave1;
import net.netne.andycomputer.jrpg.Level.Level1House1;
import net.netne.andycomputer.jrpg.Level.Level1SpookyHouse1;
import net.netne.andycomputer.jrpg.Level.Level1SpookyHouse1Basement1;
import net.netne.andycomputer.jrpg.Level.Level2;
import net.netne.andycomputer.jrpg.Level.Level2House1;
import net.netne.andycomputer.jrpg.Level.Level3;

public class Teleport {
	public Teleport(){
		
	}
	
	public ArrayList<Object> TeleportOnLoad(String area, Level level){
		ArrayList<Object> array = new ArrayList<Object>();
		boolean sceneContainNPC = false;
		NPC npc = null;
		boolean outDoor = false;
		if(area == Level.Level1){
			level = new Level1();
			outDoor = true;
			sceneContainNPC = false;
		}
		else if(area == Level.Level1House1){
			level = new Level1House1();
			npc = new NPC(40, 40, "Do you want to heal? 10 Cr", 10);
			sceneContainNPC = true;
			outDoor = false;
		}
		else if(area == Level.Level2){
			level = new Level2();
			outDoor = true;
		}
		else if(area == Level.Level1SpookyHouse1){
			level = new Level1SpookyHouse1();
			sceneContainNPC = false;
			outDoor = false;
		}
		else if(area == Level.Level3){
			level = new Level3();
		}
		else if(area == Level.Level1SpookyHouse1Basement1){
			level = new Level1SpookyHouse1Basement1();
		}
		else{
			level = new Level1();
		}
		array.add(level);
		array.add(sceneContainNPC);
		array.add(npc);
		array.add(outDoor);
		return array;
	}
	
	public ArrayList<Object> TeleportPlayer(String area, Player player, Level level){
		ArrayList<Object> array = new ArrayList<Object>();
		boolean sceneContainNPC = false;
		NPC npc = null;
		boolean outDoor = false;
		if(area == Level.Level1){
			if(player.GetXPos() == 14 && player.GetYPos() == 7){
				area = Level.Level1House1;
				level = new Level1House1();
				player.SetXPos(30);
				player.SetYPos(30);
				npc = new NPC(40, 40, "Do you want to heal? 10 Cr", 10);
				sceneContainNPC = true;
				outDoor = false;
			}
			else if(player.GetXPos() == 0 && player.GetYPos() == 29 || player.GetXPos() == 0 && player.GetYPos() == 30 || player.GetXPos() == 0 && player.GetYPos() == 31){
				area = Level.Level2;
				level = new Level2();
				player.SetXPos(79);
				outDoor = true;
			}
			else if(player.GetXPos() == 31 && player.GetYPos() == 11){
				area = Level.Level1SpookyHouse1;
				level = new Level1SpookyHouse1();
				player.SetXPos(30);
				player.SetYPos(30);
				sceneContainNPC = false;
				outDoor = false;
			}
			else if(player.GetXPos() == 79 && player.GetYPos() >= 29 && player.GetYPos() <= 31){
				area = Level.Level3;
				level = new Level3();
				player.SetXPos(0);
				outDoor = true;
			}
			else if(player.GetXPos() == 69 && player.GetYPos() == 15){
				area = Level.Level1Cave1;
				level = new Level1Cave1();
				player.SetXPos(21);
				player.SetYPos(18);
				outDoor = false;
			}
		}
		else if(area == Level.Level1House1 && player.GetYPos() == 30 && player.GetXPos() == 29){
			area = Level.Level1;
			level = new Level1();
			player.SetXPos(13);
			player.SetYPos(7);
			outDoor = true;
		}
		else if(area == Level.Level1SpookyHouse1){
			if(player.GetYPos() == 30 && player.GetXPos() == 29){
				area = Level.Level1;
				level = new Level1();
				player.SetXPos(31);
				player.SetYPos(12);
				outDoor = true;
			}
			if(player.GetXPos() == 50 && player.GetYPos() == 39 || player.GetXPos() == 50 && player.GetYPos() == 40){
				area = Level.Level1SpookyHouse1Basement1;
				level = new Level1SpookyHouse1Basement1();
				player.SetXPos(2);
				player.SetYPos(30);
				outDoor = false;
			}
		}
		else if(area == Level.Level1SpookyHouse1Basement1){
			if(player.GetYPos() == 30 && player.GetXPos() == 2 || player.GetXPos() == 2 && player.GetYPos() == 31){
				area = Level.Level1SpookyHouse1;
				level = new Level1SpookyHouse1();
				player.SetXPos(46);
				player.SetYPos(38);
				outDoor = false;
			}
			else if(player.GetXPos() == 8 && player.GetYPos() == 51){
				player.SetXPos(52);
				player.SetYPos(26);
			}
			else if(player.GetXPos() == 58 && player.GetYPos() == 30 || player.GetXPos() == 58 && player.GetYPos() == 31){
				player.SetXPos(14);
				player.SetYPos(43);
				Engine.TellPlayer("You made it through the spooky house!");
			}
		}
		else if(area == Level.Level2){
			if(player.GetXPos() == 20 && player.GetYPos() == 22){
				area = Level.Level2House1;
				level = new Level2House1();
				player.SetXPos(30);
				player.SetYPos(30);
				outDoor = false;
			}
			else if(player.GetXPos() == 79 && player.GetYPos() >= 29 && player.GetYPos() <= 31){
				area = Level.Level1;
				level = new Level1();
				player.SetXPos(0);
				outDoor = true;
			}
		}
		else if(area == Level.Level1Cave1){
			if(player.GetXPos() == 10 && player.GetYPos() == 44 || player.GetXPos() == 10 && player.GetYPos() == 45){
				player.SetXPos(57);
				player.SetYPos(48);
			}
			else if(player.GetXPos() == 56 && player.GetYPos() == 48 || player.GetXPos() == 56 && player.GetYPos() == 49){
				player.SetXPos(11);
				player.SetYPos(44);
			}
			else if(player.GetXPos() == 39 && player.GetYPos() == 50 || player.GetXPos() == 39 && player.GetYPos() == 51){
				player.SetXPos(56);
				player.SetYPos(14);
			}
			else if(player.GetXPos() == 20 && player.GetYPos() == 18 || player.GetXPos() == 20 && player.GetYPos() == 19){
				player.SetXPos(69);
				player.SetYPos(16);
				area = Level.Level1;
				level = new Level1();
				outDoor = true;
			}
		}
		
		array.add(area);
		array.add(player);
		array.add(level);
		array.add(sceneContainNPC);
		array.add(npc);
		array.add(outDoor);
		return array;
	}
}
