package tp.p2;

import tp.exceptions.CommandExecuteException;
import tp.exceptions.NoArgumentsException;

import tp.p1.Game;

public class PrintModeCommand extends Command{

	String strcommand;;
	
	public PrintModeCommand() {
		super("Printmode", "[P]rintMode <mode>", " change print mode [Release|Debug].");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		
		switch(strcommand) {
		case "release":
		case "r":{game.setPrintType(0); return true;}
		case "debug":
		case "d":{game.setPrintType(1); return true;}
		default :{
			
			throw new CommandExecuteException("Unknown print mode: "+strcommand+".");
		}
		
		
		}
		
	}

	@Override
	public Command parse(String[] commandWords) throws NoArgumentsException {
		// TODO Auto-generated method stub
		String str = String.valueOf(commandName.toLowerCase().charAt(0));
		if(commandWords[0].equals(commandName.toLowerCase())|| commandWords[0].equals(str)) {
			
			if(commandWords.length!=2) {
				
				throw new NoArgumentsException("Incorrect number of arguments for "+commandName+" command: "+getHelpText());
				
			}else {
				
			strcommand = commandWords[1];
			return this;
			}
			
		}
		
		return null;
	}


}

