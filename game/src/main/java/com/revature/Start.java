package com.revature;
import java.util.Random;
public class Start {

	private Room startRoom;
	
	
	public static void start() {
		
	}
	
	private void makeAllRooms() {
		startRoom = new Room();
	}
	private void makeRooms(Room start) {
		Random rand = new Random();
		int random = rand.nextInt() % 3;
		
		if(random == 0) {
			start.setAsLastRoom();
		}
		else if(random == 1){
			Room temp = new Room(start, false);
			temp.setParent(start);
		}
		else if(random == 2) {
			Room temp1 = new Room(start, false);
			temp1.setParent(start);
			temp1.setNexts()
			Room temp2 = new Room(start, false);
			temp2.setParent(start);
		}
		else if(random == 3) {
			
		}
		
	}
	
	private Monster generateMonster() {
		Random rand = new Random();
		int random = rand.nextInt() % 5;
		return new Monster(random);
	}
	
	
	private Room generateRooms() {
		startRoom = new Room();
		
		makeRooms(startRoom);
		return startRoom;
	}
}
