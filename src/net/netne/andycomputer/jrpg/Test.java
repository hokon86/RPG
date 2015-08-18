package net.netne.andycomputer.jrpg;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
	}
	
	public static void Test(){
		ArrayList<Object> init = new ArrayList<Object>();
		init.add(new Integer(1));
		init.add(new Integer(2));
		init.add(new Integer(3));
		for(int i = 0; i <= init.size(); i++){
			System.out.println(init.get(i));
		}
		init.remove(0);
		for(int i = 0; i<= init.size(); i++){
			System.out.println(init.get(i));
		}
	}
}
