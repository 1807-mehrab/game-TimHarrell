package com.revature;

import java.util.Random;

public class Room {
    private String name;
    private Room []next;
    private String description;
    private Room parent;
    private Monster monster;

    public void setNextRooms(Room... args) { // is varargs ok with setnextRom in constructor
        next = args;
    }
    
    public void setParent(Room room) {
    	parent = room;
    }

    private String generateDescription() {
		String[] temp = new String[5];
		temp[0] = "room0";
		temp[1] = "room1";
		temp[2] = "room2";
		temp[3] = "room3";
		temp[4] = "room4";
		
		Random rand = new Random();
		int random = rand.nextInt();
		
		
		return temp[random];
	}
    
    Room() {
    	name ="Start Room";
    	description="The room you start in.";
    }
    
    Room(String name, String desc, Room ...args) {
        this.name = name;
        description = desc;
        setNextRooms(args);
    }
}