package tp.p2;

import tp.exceptions.CommandExecuteException;
import tp.exceptions.NoArgumentsException;
import tp.exceptions.NoCoinsException;
import tp.exceptions.NoPlantException;
import tp.exceptions.OutOfBoardException;
import tp.exceptions.PlaceNoFreeException;
import tp.p1.Game;
import tp.p1.plant.Plant;
import tp.p1.plant.PlantFactory;

public class AddCommand extends Command {
	private int x;
	private int y;
	private static String plantName;
	

	public AddCommand() {
		super("Add", "[A]dd <plant> <x> <y>", "Adds a plant in position x, y.");
	
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
	
		
		
		
			try {
				Plant plant =PlantFactory.getPlant(plantName,x,y);
				
				
				game.meterPlanta(plant);
			} catch (PlaceNoFreeException e) {
				
				throw new CommandExecuteException(e.getMessage(), e);
				
			}catch(NoCoinsException e){
				
				throw new CommandExecuteException(e.getMessage(), e);

			} catch (NoPlantException e) {
				
				throw new CommandExecuteException(e.getMessage(), e);
			} catch (OutOfBoardException e) {
				
				throw new CommandExecuteException(e.getMessage(), e);
			}
			game.update(game);
			return true;
		
	
		
		
		
	}

	@Override
	public Command parse(String[] commandWords) throws NoArgumentsException{
		
		
		
		String str = String.valueOf(commandName.toLowerCase().charAt(0));
		
		if(commandWords[0].equals(commandName.toLowerCase())|| commandWords[0].equals(str)) {
			
			
			if(4!=commandWords.length) {
				
				throw new NoArgumentsException("Incorrect number of arguments for "+commandName+" command: "+getHelpText());
				
				
			}else {
			try {	
			plantName = commandWords[1];
			
			x = Integer.parseInt(commandWords[2]);
			y = Integer.parseInt(commandWords[3]);
					
			return this;
			}catch(NumberFormatException e) {
				throw new NumberFormatException("Invalid argument for "+commandName+" command, number expected: "+getHelpText());
			}
			}
			}else {return null;}

	}

	// HE TENIDO QUE CREAR ESTO PORQUE NO ME IBA , HE TENIDO QUE CAMBIARLO A ESTATICO
	public static String getPlantName() {
		return plantName;
	}
}
