package tp.p1.plant;

import tp.p1.Game;

public class Nuez extends Plant {

	public Nuez( int x, int y) {
		super(x, y, 10, 50, 0);
	}
	@Override
	public String toStringRelease() {
		String aux;
		aux = "N["+getLife()+"]";
		return aux;
	}
	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actuaObjeto(int x, int y, Game game) {
		// TODO Auto-generated method stub
	}

	@Override
	public String toStringDebug() {
		// TODO Auto-generated method stub
		
		
		return "N["+"l:"+getLife()+",x:"+getX()+",y:"+getY()+",t:"+cuenta+"]";
	}

	

	
}
