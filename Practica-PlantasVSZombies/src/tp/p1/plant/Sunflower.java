package tp.p1.plant;

import tp.p1.Game;

public class Sunflower extends Plant {

	
	
	public Sunflower( int x, int y) {
		super(x, y, 1, 30, 1);
	}
	
	
	@Override
	public String toStringRelease() {
		String aux;
		aux = "S["+getLife()+"]";
		return aux;
		
	}



	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
		
		
			if(remainingCicles()==0 && getCiclo()!=0) {
			
				game.moreSuncoins();}
	}



	@Override
	public void actuaObjeto(int x, int y, Game game) {
		// TODO Auto-generated method stub
	
	}





	@Override
	public String toStringDebug() {
		// TODO Auto-generated method stub
		return "S["+"l:"+getLife()+",x:"+getX()+",y:"+getY()+",t:"+cuenta+"]";
	}






	
	
	
	
}

