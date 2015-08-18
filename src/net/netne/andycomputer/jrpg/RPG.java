package net.netne.andycomputer.jrpg;

import java.util.ArrayList;

public class RPG {
	
	public static void main(String[] args){
		new Engine();
	}
	
	public static void Test(){
		ArrayList<ArrayList<Object>> init = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> in = new ArrayList<Object>();
		ArrayList<Object> inn = new ArrayList<Object>();
		in.add(new Integer(1));
		in.add(new Integer(2));
		in.add(new Integer(3));
		inn.add(new Integer(5));
		inn.add(new Integer(6));
		inn.add(new Integer(7));
		for(int i = 0; i < init.size(); i++){
			System.out.println(init.get(i));
		}
		init.remove(0);
		for(int i = 0; i < init.size(); i++){
			System.out.println(init.get(i));
		}
	}
}
