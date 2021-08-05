package tp.p1.zombie;

import tp.p1.Game;

public class Caracubo extends Zombie {

	public Caracubo( int x, int y) {
		super(x, y, 8, 3);
	}
	@Override
	public String toStringRelease() {
		String aux;
		aux = "W["+getLife()+"]";
		return aux;
		
	}
	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		if(game.zAtaca(getX(), getY())) {
			if(remainingCicles()==0 && getCiclo()!=0) {
				if(game.compareNot(getX(), getY()-1)) {
					if(getY()>0)setXandY(getX(),getY()-1);
					
				}
				
				
			}
		}
		if(getY()==0) {game.zGana(true);}
		
	}
	@Override
	public String toStringDebug() {
		// TODO Auto-generated method stub
		return "W["+"l:"+getLife()+",x:"+getX()+",y:"+getY()+",t:"+cuenta+"]";
	}


	
}

