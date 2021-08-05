package tp.p1.plant;

import Objects.GameObject;
import tp.p1.Game;
import tp.p2.*;

abstract public class Plant extends GameObject{//abstract

	
	public Plant(int x, int y, int life, int cost, int ciclo) {
		super(x,y,life,ciclo);
		coste = cost;
	}
	
	private int coste;
	
	
	public abstract void actuaObjeto(int x, int y, Game game);
	@Override
	public String whoIs() {
		return "plant";}
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	@Override
	public boolean comparepos2(int x) {return false;}
	@Override
	public int primeraY(int x, int y) {return -1;}
	
	// HE TENIDO QUE CREAR ESTO PORQUE NO ME IBA 
	public String getNombre() {
		// TODO Auto-generated method stub
		return AddCommand.getPlantName();
	}


}
