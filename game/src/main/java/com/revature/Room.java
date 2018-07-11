package com.revature;

import java.util.Random;

public class Room {
    private String name;
    private Room []next;
    private String description;
    private Room parent;
    private Monster monster;
    private Boolean lastRoom;
    private static final int NUMBERNEXTS = 2;
    private static final String[] names = {
    		"room0", 
    		"room1", 
    		"room2", 
    		"room3", 
    		"room4"
    	};
    private static final String[] descriptions = { 
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
    	if(monster != null && monster.getHealth() < 1) {
    		monster = null;
    	}
    }
    
    public Boolean isMonsterDead() {
    	ValidateMonsterExistence();
    	return monster == null;
    }
    
   public void setNext(Room ...args) {
    	next = args;
    }
   
   private Monster generateRandMonster() {
		Random rand = new Random();
		int random = rand.nextInt(5);
		return new Monster(random);
	}
   
   public Boolean hasLeft() {
	   try {
		   return next[0] != null;
	   }
	   catch(ArrayIndexOutOfBoundsException a ) {
		   return false;
	   }
   }
   
   public Boolean hasRight() {
	   
	   try {
		   return next[1] != null;
	   }
	   catch(ArrayIndexOutOfBoundsException a ) {
		   return false;
	   }
   }
   
   public Boolean hasParent() {
	   return parent != null;
   }
   
   public Room left() {
	   return next[0];
   }
   
   public Room right() {
	   return next[1];
   }
   
   public Room parent() {
	   return parent;
   }
   
   public String monsterName() {
	   return monster.getName();
   }
   
   public int monsterHealth() {
	   return monster.getHealth();
   }
   public void MonsterTalk() {
	   if(monster != null) {
		   monster.talk();
	   }
	   else {
		   System.out.println("monster is dead.");
	   }
   }
   
   public void attackMonster(int attack) {
	   monster.hurtMonster(attack);
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
		int random = rand.nextInt(names.length);
		this.parent = parent;
        name = names[random];
        description = descriptions[random];
        this.lastRoom = lastRoom;
        next = new Room[2];
        monster = generateRandMonster();
    }
}