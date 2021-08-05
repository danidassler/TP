package tp.p1;

import java.util.Random;
import java.util.Scanner;

import tp.exceptions.CommandExecuteException;
import tp.exceptions.CommandParseException;
import tp.p2.Command;
import tp.p2.Commandparser;
import tp.printGame.BoardPrinter;
import tp.printGame.DebugPrinter;
import tp.printGame.ReleasePrinter;





public class Controller {

	public Game game;
	
	
	private String  Umessage = "Unknown command. Use ’help’ to see the available commands.";
	private BoardPrinter tablero;
	
	
	
	public Controller(Random r, String args) {
		
		Scanner sc = new Scanner("x");
		
		game = new Game(sc, args);
		
		
		printGame();
		while(!game.getreset() && !game.isExit()) {
			
			System.out.print("Command>");
			sc = new Scanner(System.in);
			String[] words = sc.nextLine().toLowerCase().trim().split("\\s+");
			
			
				try {
					
					Command command = Commandparser.parseCommand(words);
						if(command != null) {
								if(command.execute(game)) {printGame();
									game.addZombie(r.nextInt(3), 7, r);}
					
						}else {System.out.format(Umessage + "%n%n");}	
						
				} catch (CommandExecuteException e) {
					
					
					System.out.format(e.getMessage() +"%n%n");
				}catch(CommandParseException e) {
					
					System.out.format(e.getMessage() +"%n%n");
				}
				
				
			
			if(!game.isExit())game.setExit(game.gameOver());
		}
		
		if(game.isExit()) System.out.println(game.getMensaje());
		
		
		
		
	}
	
	public void printGame() {
		
		
		switch(game.getPrintType()) {
		case 0: {tablero = new ReleasePrinter(4, 8, game);} break;
		
		case 1: {tablero = new DebugPrinter(4, 8, game);} break;
		
		default:{tablero = new ReleasePrinter(4, 8, game);}
		}
		System.out.println(game.impCC());
		System.out.println("Zombies restantes: "+ game.getZleft());
		System.out.println(tablero.PrintGame());
		}
	
	
	


	public boolean getExit() {return game.isExit();}





	public String getUmessage() {
		return Umessage;
	}


	public void setUmessage(String umessage) {
		Umessage = umessage;
	}

	public void showUmessage() {
		System.out.println(Umessage);
	}
	
	
}