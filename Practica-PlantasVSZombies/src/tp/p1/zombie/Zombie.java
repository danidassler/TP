package tp.p1.zombie;

import Objects.GameObject;
import tp.p1.Game;

public abstract class Zombie extends GameObject{
	
	
	public Zombie(int x, int y, int life, int ciclo) {
		super(x, y, life, ciclo);
	}
		

 
	@Override
	public String whoIs() {
		return "zombie";}
	public void actuaObjeto(int x, int y, Game game) {
	}
	@Override
	public boolean comparepos2(int x) {//preguntar si hay que especificarlo o no
		if(getX()==x) {
			return true;
			
		}else return false;
		
	}
	@Override
	public int primeraY(int x, int y) {
		
		boolean si=false;
    	int i=0;
    	for(int e=y; e<8; e++) {
    		
    			if(si==false && getX()==x && getY()==e) {
        			i=e;
        			si=true;
        		}
    		
    		
    	}
    	
    	
    	return i;
	}
   
}
