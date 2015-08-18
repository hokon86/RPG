package net.netne.andycomputer.jrpg.Characters;

import java.util.ArrayList;

public class Inventory {
	ArrayList<ArrayList<Object>> inventory;
	
	public static int EFFECT_HEAL = 1;
	public static int EFFECT_EAT = 2;
	public static int EFFECT_SELL = 3;
	
	public Inventory(){
		inventory = new ArrayList<ArrayList<Object>>();
		inventory.add(new ArrayList<Object>());
		inventory.add(new ArrayList<Object>());
	}
	
	public int Use(Object item){
		boolean found = false;
		int choosenArray = 0;
		int choosenObjectWithinArray = 0;
		for(int i = 0; i < inventory.size(); i++){
			for(int x = 0; x <= inventory.get(i).size(); i++){
				if(inventory.get(i).get(x).getClass().equals(item.getClass())){
					found = true;
					choosenArray = i;
					choosenObjectWithinArray = x;
					break;
				}
			}
		}
		if(!found)
			return 0;
		if(choosenArray == 0){
			inventory.get(0).remove(choosenObjectWithinArray);
			return this.EFFECT_HEAL;
		}
		else if(choosenArray == 1){
			inventory.get(1).remove(choosenObjectWithinArray);
			return this.EFFECT_EAT;
		}
		else if(choosenArray == 2){
			inventory.get(2).remove(choosenObjectWithinArray);
			return this.EFFECT_SELL;
		}
		else
			return 0;
	}
}
