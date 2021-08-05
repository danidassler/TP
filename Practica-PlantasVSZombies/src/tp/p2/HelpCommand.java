package tp.p2;


import tp.p1.Game;

public class HelpCommand extends NoParamsCommand{

	public HelpCommand() {
		super("Help", "[H]elp", "Prints this help message.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		System.out.println(Commandparser.commandHelp());
		return false;
	}




	
}
