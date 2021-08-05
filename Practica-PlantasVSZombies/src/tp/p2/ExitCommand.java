package tp.p2;



import tp.p1.Game;

public class ExitCommand extends NoParamsCommand{

	public ExitCommand() {
		super("Exit", "[E]xit", "Terminates the program.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		
		game.setExit(true);
		game.setMensaje("******  GAME OVER!: USER EXIT  *****");
		return false;
	}

	

	
	

	

}