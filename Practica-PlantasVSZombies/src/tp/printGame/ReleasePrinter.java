package tp.printGame;

import tp.p1.Game;
import tp.pr1.util.MyStringUtils;

public class ReleasePrinter extends BoardPrinter {

	public ReleasePrinter(int dimx, int dimy, Game board) {
		super(dimx, dimy, board);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void encodeGame(Game board) {
		// TODO Auto-generated method stub

		tablero = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {

				tablero[i][j] =  board.toStringRelease(i, j);
				
				// TODO Fill the board with simulation objects
				
			}
		}
	}
		
	

	@Override
	public String PrintGame() {
		// TODO Auto-generated method stub
		
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(tablero[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
		
	}

}
