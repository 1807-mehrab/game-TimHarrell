package com.revature;
import java.util.Random;
import java.util.Scanner;
public class Start {

	private Room startRoom;
	private Room currRoom;
	private Boolean exit = false;
	private final int ATTACKPOWER = 1;
	public void start() {
		generateRooms();
		
		while(!exit) {
			if(currRoom.isLastRoom() && currRoom.isMonsterDead()) break;
			
			currRoom.MonsterTalk();
			fight();
			Scanner in = new Scanner(System.in);
			System.out.println("type 1 to go left or 2 to go right. type 3 to go back");
			int input = in.nextInt();
			exit = checkOptions(input);
			
		}
		
		System.out.println("That's the last room. \nGAME OVER");
	}
	
	private Boolean checkOptions(int input) {
		if(!currRoom.isLastRoom()) {
			if(input == 1) {
				if(currRoom.hasLeft()) {
					System.out.println("you went left");
					currRoom = currRoom.left();
				}
				else {
					System.out.println("Fake door. Choose another route.");
				}
			}
			
			if(input == 2) {
				if(currRoom.hasRight()) {
					System.out.println("you went right");
					currRoom = currRoom.right();
				}
				else {
					System.out.println("Fake door. Choose another route.");
				}
			}
			if(input == 3) {
				if(currRoom.hasParent()) {
					System.out.println("you went back");
					currRoom = currRoom.parent();
				}
				else {
					System.out.println("Can't go back");
				}
			}
			else {
				System.out.println("Invalid, try again.");
			}
			
			return false;
		}
		else {
			
			if(currRoom.isMonsterDead() && currRoom.isLastRoom()) {
				return true;
			}
			return false;
		}
		
	}
	
	
	public void fight() {
		while(!currRoom.isMonsterDead()) {
			System.out.println(currRoom.monsterName() + " health: " + currRoom.monsterHealth());
			Scanner fightIn = new Scanner(System.in);
			
			System.out.println("type 1 to fight.");
			int input = fightIn.nextInt();
			
			if(input == 1) {
				currRoom.attackMonster(ATTACKPOWER);
			}
		}
		
		System.out.println("You kill the monster");
			
	}
	public Room makeRooms(Room start) {
		Random rand = new Random();
		int random = rand.nextInt(2);
		
		if(random == 0) {
			start.setAsLastRoom();
		}
		else {
			Room nexts[] = new Room[random];
			for(int i = 0; i < random; i++) {
				nexts[i] = new Room(start, false);
				nexts[i].setParent(start);
			}
			for(int i = 0; i < random; i++ )
			makeRooms(nexts[i]);
			start.setNext(nexts);
		}
		return start;
	}
	
	private Room generateRooms() {
		startRoom = new Room();
		currRoom = startRoom;
		makeRooms(startRoom);
		return startRoom;
	}
}
