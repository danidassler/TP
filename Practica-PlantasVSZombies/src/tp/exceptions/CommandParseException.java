package tp.exceptions;

public class CommandParseException extends Exception{

	public CommandParseException(String ex, Throwable cause) {
		super(ex, cause);
		
	}

	public CommandParseException(String ex) {
		super(ex);
		
	}
}
