package tp.p1.zombie;

import tp.p1.Game;

public class ZombieNormal extends Zombie{

	public ZombieNormal( int x, int y) {
		super(x, y, 5, 1);
	}
	@Override
	public String toStringRelease() {
		String aux;
		aux = "Z["+getLife()+"]";
		return aux;
		
	}
	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		if(game.zAtaca(getX(), getY())) {
			if(remainingCicles()==0 && getCiclo()!=0) {
				if(game.compareNot(getX(), getY()-1)) {
					
					if(getY()>0) {setXandY(getX(),getY()-1);}
					
				}
				
				
			}
		}
		if(getY()==0) {game.zGana(true);}
	}
	@Override
	public String toStringDebug() {
		// TODO Auto-generated method stub
		return "Z["+"l:"+getLife()+",x:"+getX()+",y:"+getY()+",t:"+cuenta+"]";
	}
	
	

	
}

