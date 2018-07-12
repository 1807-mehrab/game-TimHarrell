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
			exit = checkOptions();
			
		}
		
		System.out.println("That's the last room. \nGAME OVER");
	}
	
	private Boolean checkOptions() {
		if(!currRoom.isLastRoom()) {
			System.out.println("type 1 to go left or 2 to go right. type 3 to go back");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			
			if(input == 1) {
				if(currRoom.hasLeft()) {
					System.out.println("you went left");
					currRoom = currRoom.left();
				}
				else {
					System.out.println("Fake door. Choose another route.");
				}
			}
			else if(input == 2) {
				if(currRoom.hasRight()) {
					System.out.println("you went right");
					currRoom = currRoom.right();
				}
				else {
					System.out.println("Fake door. Choose another route.");
				}
			}
			else if(input == 3) {
				if(currRoom.hasParent()) {
					System.out.println("you went back");
					currRoom = currRoom.parent();
				}
				else {
					System.out.println("Can't go back");
				}
			}
			else {
				System.out.println("invalid input.");
			}
			
			in.close();
			return false;
		}
		else {
			
			if(currRoom.isMonsterDead()) {
				return true;
			}
			System.out.println("You are in the last room.");
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
			
			
			fightIn.close();
		}
		
		System.out.println("Monster is dead.");
			
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
