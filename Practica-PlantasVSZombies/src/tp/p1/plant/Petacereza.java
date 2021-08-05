package tp.p1.plant;

import tp.p1.Game;

public class Petacereza extends Plant {
 
	private int damage=10;
	
	
	public Petacereza( int x, int y) {
		super(x, y, 2, 50, 1);
	}
	
	
    public int getDamage() {return damage;}
	
    @Override
	public String toStringRelease() {
		String aux;
		aux = "C["+getLife()+"]";
		return aux;
		
	}





	@Override
	public void update( Game game) {
		// TODO Auto-generated ma ethod stub
		if(remainingCicles()==0 && getCiclo()!=0) {
		actuaObjeto(getX(), getY(), game);
		
		game.eliminarPlant(game.compareplantpos(getX(), getY()));//SOLUCIONAR
		}
	}


	@Override
	public void actuaObjeto(int x, int y, Game game) {
		
		game.restaVida(x-1, y-1, damage, "zombie");
		game.restaVida(x-1, y, damage, "zombie");
		game.restaVida(x-1, y+1, damage, "zombie");
		game.restaVida(x, y+1, damage, "zombie");
		game.restaVida(x+1, y+1, damage, "zombie");
		game.restaVida(x+1, y, damage, "zombie");
		game.restaVida(x+1, y-1, damage, "zombie");
		game.restaVida(x, y-1, damage, "zombie");
		
		
		
	}





	@Override
	public String toStringDebug() {
		// TODO Auto-generated method stub
		return "C["+"l:"+getLife()+",x:"+getX()+",y:"+getY()+",t:"+cuenta+"]";
	}



	
	
	
	
}
