package com.revature;

import java.util.Random;

public class Room {
    private String name;
    private Room []next;
    private String description;
    private Room parent;
    private Monster monster;
    private Boolean lastRoom;
    private final int NUMBERNEXTS = 2;
    private final String[] names = {
    		"room0", 
    		"room1", 
    		"room2", 
    		"room3", 
    		"room4"
    	};
    private final String[] descriptions = { 
    		"desc for room0",
    		"desc for room1",
    		"desc for room2",
    		"desc for room3",
    		"desc for room4"
    	};
    
    public void setParent(Room room) {
    	parent = room;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public Monster getMonster() {
    	return monster;
    }
    
    public Boolean isLastRoom() {
    	return lastRoom;
    }
    
    public void setAsLastRoom() {
    	lastRoom = true;
    }
    
    public void ValidateMonsterExistence() {
    	if(monster.getHealth() < 1) {
    		monster = null;
    	}
    }
    
    public Boolean isMonsterPresent() {
    	return monster != null;
    }
    
   public void setNext(Room ...args) {
    	next = args;
    }
    
    Room() {
    	name ="Start Room";
    	description="The room you start in.";
    	parent = null;
    	monster = null;
    	lastRoom = false;
    }
    
   
    
    Room(Room parent, Boolean lastRoom) {
    	Random rand = new Random();
		int random = rand.nextInt() % names.length ;
		this.parent = parent;
        name = names[random];
        description = descriptions[random];
        this.lastRoom = lastRoom;
        next = new Room[3];
       
        
    }
}