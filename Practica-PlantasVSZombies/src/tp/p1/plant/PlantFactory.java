package tp.p1.plant;

import tp.exceptions.NoPlantException;

public class PlantFactory {
/*	
	private static Plant[] avaliablePlants = {
			new Peashooter(0,0),
			new Sunflower(0,0),
			new Petacereza(0,0),
			new Nuez(0,0)
			
	
			
	};*/

	public static Plant getPlant( String nombre, int x, int y) throws NoPlantException {
		Plant Plant = null;
		
			
			switch (nombre) {
			
				
				case "peashooter":
				case "p": {Plant = new Peashooter(x, y);}break;
				case "nuez":
				case "n":{Plant = new Nuez(x, y);}break;	
				case "sunflower":
				case "s":{Plant = new Sunflower(x, y);}break;
				case "petacereza":
				case "c" :{Plant = new Petacereza(x, y);}break;
			default: {
				
				throw new NoPlantException("Unknown plant name: "+nombre+".");
			}
			}
			
			
			return Plant;
			}
	
	
	public static String listOfPlants() {
		
		return "[S]unflower: Cost: 30 suncoins  Harm: 0\r\n" + 
				"[P]eashooter: Cost: 50 suncoins  Harm: 1\r\n" + 
				"[C]herrybomb: Cost: 50 suncoins Harm: 10\r\n" + 
				"[N]ut: Cost: 50 suncoins Harm: 0";
		
	}
	
	
	
}

	



	

