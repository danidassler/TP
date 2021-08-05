package tp.p1;

import java.util.Random;

public class ZombieManager {

	
	
	private int zombiesleft;
	private int zombiestotal;
	
	public ZombieManager(String nivel) {
		
	switch (nivel) {
	case "EASY": {zombiesleft = 3; zombiestotal = 3;} break;
	case "HARD": {zombiesleft = 5; zombiestotal = 5;} break;
	case "INSANE": {zombiesleft = 10; zombiestotal = 10;} break;
	default:{ zombiesleft = 5; zombiestotal = 5;} break;
	
	
	}
	
	}
	public int getZombiestotal() {
		return zombiestotal;
	}
	public boolean zombiesLeftToAppear (Random r, double frec) {
		boolean b = false;
		if(zombiesleft>0) {
		if(r.nextInt(9)<frec*10) {
			zombiesleft--;
			b = true;
			
		}
		}
		
		return b;
		
	}
	public int getZombiesleft() {
		return zombiesleft;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
