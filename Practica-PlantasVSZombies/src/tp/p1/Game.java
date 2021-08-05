package tp.p1;

import java.util.Random;
import java.util.Scanner;

import tp.exceptions.NoCoinsException;
import tp.exceptions.OutOfBoardException;
import tp.exceptions.PlaceNoFreeException;
import tp.p1.plant.Plant;



public class Game {
	   
	private int cycleCount;
	private Board b;
	private SuncoinManager coins;
	private Level Lev;
	private ZombieManager zleft;
	private boolean reset = false;
	private boolean exit = false;
	private int printType = 0;
	String mensaje;
	
	




	public Game(Scanner sc, String args) {
		
		
		cycleCount = 0;
		coins = new SuncoinManager(50);
		Lev = new Level(sc, args);
		zleft = new ZombieManager(Lev.getN());
		b = new Board(zleft.getZombiesleft());
	}
	
	
	
	public void incrementarCyclecount() {cycleCount++;}
	
	
	
	
	public String impCC() {
		return "Ciclos > "+ cycleCount + "\r\n" + "Suncoins > "+ coins.getSuncoins();
	}
	public int showCycles() {
		return cycleCount;
	}
	
	
	public void addZombie(int x, int y, Random r) {// le pasamos como x = 0 , y = r.nextInt(3);
		int cualzombie;
		if(b.compareZl(x,y)) {
		if(zleft.zombiesLeftToAppear(r, Lev.getFrecuencia())) {
			cualzombie = r.nextInt(2);
			if(cualzombie == 0) {
				
				b.addzombie("zombieNormal", x, y);	
			}else if(cualzombie == 1) {
				
				b.addzombie("caracubo", x, y);
			}else {
				
				b.addzombie("deportista", x, y);
			}
			
			
				}
		}
	}
	
	
	public String toStringRelease(int i, int j) {
		String str = "";
		
		str = b.toStringRelease(i, j);
		
		return str;
	}
	
	public String toStringDebugPlantlist(int i) {
		
		return b.toStringDebugPlantlist(i);
	}
	public String toStringDebugZombielist(int i) {
		
		return b.toStringDebugZombielist(i);
	}
	
	public int getPlantlistCont() { return b.getPlantlistCont();}
	
	public int getZombielistCont() {return b.getZombielistCont();}

	public void eliminarPlant(int e) {
		b.eliminarPlant(e);
	}
	
	public void eliminarZombie(int e) {
		b.eliminarZombie(e);
	}
	public void update(Game game) {
		
		b.update(game);
		b.actualizarCiclos();
		cycleCount++;
		
	}
	public boolean zAtaca(int x, int y) {
	
		return	b.zAtaca(x, y);
		
	}
	
	public void actuaObj(int x, int y) {
		
		b.psAtaca(x ,y);
		
	}
	public boolean restaVida(int x, int y , int danio, String obj) {
		
		return b.restaVidaZ(x, y, danio, obj);
	}
	
	public boolean compareNot(int x, int y) {return b.compareNot(x, y);}
	
	public int compareplantpos(int x, int y) {return b.compareplantpos(x, y);} 
	
	
	public int comparezombiepos(int x, int y) {return b.comparezombiepos(x, y);} 
	
	public void zGana(boolean gana) {
		
		b.setZombiesGanan(gana);
		
	}
	
	public boolean gameOver() {//CAMBIAR
		boolean gameover = false;
		
			
		if(b.isZombiesGanan()) {gameover = true;
		
		setMensaje("TE HAN COMIDO EL CEREBRO!");
		}
		
		if(jugadorgana()) {gameover = true;
		setMensaje("HAS GANADO POR ESTA VEZ");
		}
		
		
		return gameover;
	}
	public String getMensaje() {
		return mensaje;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean getreset() {
		
		return reset;
		
	}
	public void moreSuncoins() {
		coins.incrementarCoins();
		
	}
	public boolean isExit() {
		return exit;
	}



	public void setExit(boolean exit) {
		this.exit = exit;
	}



	public void setReset(boolean reset) {
		this.reset = reset;
	}



	public boolean jugadorgana() {
		if(zleft.getZombiesleft()==0) {
			return b.jugadorgana(zleft.getZombiestotal());
			
		}else return false;
		
	}
	
	public boolean isThereAny(int x, int y) { return b.isThereAny(x, y);
	}
	public int getSuncoins() {return  coins.getSuncoins();}
	
	public int getZleft() {
		return zleft.getZombiesleft();
	}
	
	public void meterPlanta(Plant plant) throws PlaceNoFreeException, NoCoinsException, OutOfBoardException {
		//try catch aqui para las monedas
		int x = plant.getX();
		int y = plant.getY();
		if((x<4&&-1<x) && (y<7&&-1<y)) {
			if (b.isThereAny(x, y)) {
			
				if(coins.getSuncoins()>= plant.getCoste()) {
						
					b.addplant(plant);
					coins.decrementarCoins(plant.getCoste());	
					
				}else {throw new NoCoinsException("Failed to add "+plant.getNombre()+": not enough suncoins available.");}
					
			}else {throw new PlaceNoFreeException("Failed to add "+plant.getNombre()+": ("+x+", "+y+") is an ocupied position.");}
		}else {throw new OutOfBoardException("Failed to add "+plant.getNombre()+": ("+x+", "+y+") is an invalid position.");}
	 
		
	}



	public int getPrintType() {
		return printType;
	}



	public void setPrintType(int printType) {
		this.printType = printType;
	}
	
	
	
	
}
