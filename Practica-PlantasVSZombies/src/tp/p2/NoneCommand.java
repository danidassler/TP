package tp.p2;


import tp.p1.Game;

public class NoneCommand extends NoParamsCommand{

	public NoneCommand() {
		super("None", "[N]one", "Skips cycle.");
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.update(game);
		return true;
		
	}


}
