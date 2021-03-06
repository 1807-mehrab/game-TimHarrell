package com.revature;

public class Monster {
	private String name;
	private String speech;
	private int strength;
	private int health;
	
	private static final String[] names = {
			"monster0",
			"monster1",
			"monster2",
			"monster3",
			"monster4"
	};
	
	private static final String[] speeches = {
		"monster0 desc",
		"monster1 desc",
		"monster2 desc",
		"monster3 desc",
		"monster4 desc"
	};
	
	private static final int[] strengths =  {
		1,
		2,
		3,
		4,
		5
	};
	
	private static final int[] healths =  {
		10,
		15,
		20,
		25,
		30
	};
	 
	private String generateName(int input) {
		return names[input];
	}
	
	private String generateSpeech(int input) {
		return speeches[input];
	}
	private int generateStrength(int input) {
		return strengths[input];
	}
	
	private int generateHealth(int input) {
		return healths[input];
	}
	
	public int getStrength() {
		return strength;
	}
	public void hurtMonster(int amount) {
		health -= amount;
	}
	
	public int getHealth() {
		return health;
	}
	
	public String getName() {
		return name;
	}
	
	public void talk() {
		System.out.println("I am a " + name + ".");
		System.out.println(speech);
	}
	Monster(int input) {
		this.name = generateName(input);
		this.speech = generateSpeech(input);
		this.strength = generateHealth(input);
		this.health = generateStrength(input);
	}
	
	
	
	
}
