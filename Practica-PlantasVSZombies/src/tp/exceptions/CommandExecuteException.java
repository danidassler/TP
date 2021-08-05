package tp.exceptions;

public class CommandExecuteException extends Exception{



	public CommandExecuteException(String ex, Throwable cause) {
		super(ex, cause);
		
	}
	
	public CommandExecuteException(String ex) {
		super(ex);
		
	}
}
