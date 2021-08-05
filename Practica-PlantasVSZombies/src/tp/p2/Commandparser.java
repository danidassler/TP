package tp.p2;

import tp.exceptions.CommandParseException;
import tp.exceptions.NoArgumentsException;


public class Commandparser {

	private static Command[] availableCommands = {
			new AddCommand(),
			new NoneCommand(),
			new HelpCommand(),
			new	ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new PrintModeCommand()

	};
	

	public static Command parseCommand(String[] words) throws CommandParseException {
	Command command = null;
		int i = 0;
		try {
	while(command==null && i<7) {
		command = availableCommands[i].parse(words);
		i++;
	}	
	
		return command;
		}catch(NumberFormatException e) {
			throw new CommandParseException("Invalid argument for "+availableCommands[i].getCommandName()+" command, number expected: "+availableCommands[i].getHelpText()+".",e);
		}catch(NoArgumentsException e) {
			throw new CommandParseException(e.getMessage(),e);
		}
	}
	
	public static String commandHelp() {
		String str = "";
		
		for (int i = 0; i < availableCommands.length; i++) {
			
			str = str + availableCommands[i].helpText();
					
		}
		return  str;
	}

}