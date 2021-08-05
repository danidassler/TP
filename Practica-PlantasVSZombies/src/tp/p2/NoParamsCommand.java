package tp.p2;

import tp.exceptions.NoArgumentsException;


public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Command parse(String[] commandWords) throws NoArgumentsException {
		// TODO Auto-generated method stub
		
		String str = ""; 
		
		
			
			if(commandName!="None")str = commandName.toLowerCase().substring(0, 1);
			if(commandWords[0].equals(commandName.toLowerCase())|| commandWords[0].equals(str)) {
				if(commandWords.length>1) {
					
					throw new NoArgumentsException(commandName+" command has no arguments.");
				}
				
				return this;
				
				
			}else {
				
				return null;}
		
			
		
		
		
	}


}




