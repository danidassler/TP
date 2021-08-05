package tp.p1.plant;

import tp.p1.Game;

public class Peashooter extends Plant{

	private int damage=1;
	
	public Peashooter( int x, int y) {
		super(x, y, 3, 50, 0);
	}

	public int getDamage() {return damage;}
	@Override
	public String toStringRelease() {
		String aux;
		aux = "P["+getLife()+"]";
		return aux;
		
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		actuaObjeto( getX(), getY(),  game);
		
		
	}

	@Override
	public void actuaObjeto(int x, int y, Game game) {
		// TODO Auto-generated method stub
		game.actuaObj(x, y);
	}



	@Override
	public String toStringDebug() {
		// TODO Auto-generated method stub
		return "P["+"l:"+getLife()+",x:"+getX()+",y:"+getY()+",t:"+cuenta+"]";
	}


	


	
}

