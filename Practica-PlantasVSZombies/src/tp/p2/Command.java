package tp.p2;

import tp.exceptions.CommandExecuteException;
import tp.exceptions.NoArgumentsException;
import tp.p1.Game;

public abstract class Command {

	private String helpText;

	private  String helpInfo;

	protected final String commandName; 
	
	public Command(String commandText, String commandTextMsg, String helpTextMsg){

		helpText = commandTextMsg;

		helpInfo = helpTextMsg;

		commandName = commandText;
}
// Some commands may generate an error in the execute or parse methods.
// In the absence of exceptions , they must the tell  the controller  not to print  the board
public abstract boolean execute(Game game) throws CommandExecuteException;
public String getHelpInfo() {
	return helpInfo;
}
public abstract Command parse(String[] commandWords) throws NoArgumentsException;
public String getCommandName() {
	return commandName;
}
public String getHelpText() {
	return helpText;
}
public String helpText(){ return "  " + helpText + ": " + helpInfo + "\r\n";}
}
