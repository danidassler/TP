package tp.printGame;

import tp.p1.Game;
import tp.pr1.util.MyStringUtils;

public class  DebugPrinter extends BoardPrinter {

	public DebugPrinter(int dimx, int dimy, Game board) {
		super(1, board.getPlantlistCont()+board.getZombielistCont(), board);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void encodeGame(Game board) {
		// TODO Auto-generated method stub
		
		tablero = new String[1][dimY];
		int plants = board.getPlantlistCont();
		int zombies = board.getZombielistCont();
		int e = 0;
		for(int i = 0; i < plants ; i++) {
			
			tablero[0][e] = board.toStringDebugPlantlist(i);
			e++;
		}
		for(int j = 0; j < zombies ;j++) {
			
			tablero[0][e] = board.toStringDebugZombielist(j);
			e++;
		}
	}
	

	@Override
	public String PrintGame() {
		// TODO Auto-generated method stub
		int cellSize = 18;
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
