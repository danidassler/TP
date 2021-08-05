package tp.printGame;

import tp.p1.Game;

public abstract class BoardPrinter implements GamePrinter{

	
	int dimX; 
	int dimY;
	final String space = " ";
	protected String[][] tablero;
	public BoardPrinter(int dimx, int dimy, Game board) {
		dimX = dimx;
		dimY = dimy;
		encodeGame(board);
	}
	
	
	public abstract void encodeGame(Game board);
	
}

