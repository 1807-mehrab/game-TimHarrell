package Game;
import java.util.Random;
public class Start {

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
	
	public static start() {
		
	}
	
	public static Room makeRooms() {
		
	}
	
	public static Room makeRoom() {
		Room temp = new Room();
		
	}
}
