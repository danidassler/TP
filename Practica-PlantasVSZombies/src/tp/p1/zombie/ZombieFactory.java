package tp.p1.zombie;

import Objects.GameObject;

public class ZombieFactory {
	
	public static GameObject getZombie( String nombre, int x, int y) {
		GameObject Zombie = null;
		
			
			switch (nombre) {
			
				
				case "zombieNormal":{Zombie = new ZombieNormal(x, y);}break;
				case "caracubo":{Zombie = new Caracubo(x, y);}break;	
				case "deportista":{Zombie = new Deportista(x, y);}break;
			
		
			}
			return Zombie;
			}
	
	public String infoAvaliableZombies() {
		
		return "[Z]ombie comun: speed: 2 Harm: 1 Life: 5\r\n" + 
				"[Z]ombie deportista: speed: 1 Harm: 1 Life: 2\r\n" + 
				"[Z]ombie caracubo: speed: 4 Harm: 1 Life: 8";
	}
}