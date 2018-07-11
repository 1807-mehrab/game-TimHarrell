package com.revature;
import java.util.Random;
public class Start {

	private Room startRoom;
	
	
	public static void start() {
		
	}
	
	private void makeAllRooms() {
		startRoom = new Room();
	}
	private Room makeRooms() {
		Random rand = new Random();
		int random = rand.nextInt() % 3;
		
		if(random == 0) {
			
		}
	}
	
	
	
	private Room generateRooms() {
		startRoom = new Room();
		
		return startRoom;
	}
}
