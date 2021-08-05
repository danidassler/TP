package tp.p2;


import tp.p1.Game;

public class ResetCommand extends NoParamsCommand{

	public ResetCommand() {
		super("Reset", "[R]eset", "Starts a new game.");
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.setReset(true);
		return false;
	}


}
