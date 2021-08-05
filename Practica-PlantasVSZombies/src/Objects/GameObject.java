package Objects;

import tp.p1.Game;

abstract public class GameObject {
	
	private int x;
	private int y;
	private int life;
	private int ciclo = 0;
	protected int cuenta = 0;
    int auxcuenta;
	
	public GameObject(int x, int y, int life, int ciclo) {
		
		this.x = x;
		this.y = y;
		this.life = life;
		this.ciclo = 0;
		this.auxcuenta = ciclo;
	}
	
	public int getLife() {return life;}
	public void setLife(int nlife) {this.life = nlife;}
	public int getX() {return x;}
	public int getY() {return y;}
    public void setXandY(int x, int y) {
		
		this.x=x;
		this.y=y;
	}
	
    public void setCiclo(int st_actual) { ciclo=st_actual;}
	public int getCiclo() {return ciclo;}
	public void incrementarCiclo() {ciclo++;} 
	////METODOS
	
	public void actuaObj() {}
	
	public abstract void update(Game game);
	public abstract String whoIs();
 
	public abstract void actuaObjeto(int x, int y, Game game);
	public abstract boolean comparepos2(int x);//preguntar si ponr abstracto
    public abstract int primeraY (int x, int y);
	public abstract String toStringRelease();
	public abstract String toStringDebug();
	public int remainingCicles() {
		if(cuenta==0) {
			cuenta=auxcuenta;
		}else cuenta--;
		
		return cuenta;
	}
	
}


