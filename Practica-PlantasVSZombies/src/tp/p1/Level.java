package tp.p1;

import java.util.Scanner;

public class Level {

	private double frecuencia;
	//public enum levels{EASY, HARD, INSANE};
	public String n;
	public String getN() {
		return n;
	}
	public Level(Scanner sc,String args) {
		
		/*System.out.println("En que nivel quieres jugar?\n EASY = 0\n HARD = 1\n INSANE = 2");
		sc = new Scanner(System.in);
		
			 n = levels.HARD ;
			int i = sc.nextInt();
			switch(i) {
			case 0: n = levels.EASY; break;
			case 1: n = levels.HARD; break;
			case 2: n = levels.INSANE;break;}
		
		switch (n) {
		case EASY: frecuencia = 0.1; break;
		
		case HARD: frecuencia = 0.2; break;
		
		case INSANE: frecuencia = 0.3; break;
		
		default: frecuencia = 0.2; break;
		}
		*/
		switch (args) {
		case "EASY": {frecuencia = 0.1; n = "EASY";} break;
		
		case "HARD": {frecuencia = 0.2; n = "HARD";} break;
		
		case "INSANE": {frecuencia = 0.3; n = "INSANE";} break;
		
		default: {frecuencia = 0.2; n = "HARD";} break;
		}
		
		
	}
	public double getFrecuencia() {
		return frecuencia;
	}

	
	
	
	
}

