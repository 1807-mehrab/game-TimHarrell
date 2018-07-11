package com.revature;
import java.util.Random;
public class Start {

	private Room startRoom;
	
	
	public static void start() {
		
	}
	
	private void makeAllRooms() {
		startRoom = new Room();
	}
	private Room makeRooms(Room start) {
		Random rand = new Random();
		int random = rand.nextInt() % 5;
		
		if(random < 1) {
			
		}
		else {
			Room temp = new Room(start, false);
			return .setParent(temp);
		}
	}
	
	private Monster generateMonster() {
		Random rand = new Random();
		int random = rand.nextInt() % 5;
		return new Monster(random);
	}
	
	
	private Room generateRooms() {
		startRoom = new Room();
		
		makeRooms();
		return startRoom;
	}
}
