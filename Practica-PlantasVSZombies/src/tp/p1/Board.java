package tp.p1;

import Objects.GameObjectList;
import tp.p1.plant.Plant;


public class Board {

	private GameObjectList plantlist, zombielist;
	private boolean zombiesGanan = false;
	
	
	
	public Board(int zom) {
		
		plantlist = new GameObjectList(32);
		zombielist = new GameObjectList(32);
		
	}
	
	public void actualizarCiclos() {
		
		plantlist.actualizarCiclos();
		zombielist.actualizarCiclos();
	}
	public boolean compareZl(int x, int y) {
		
		return zombielist.comparenot(x, y);//CAMBIAR
	
	}
	
	
	
	
	public void addplant(Plant plant) {
		
		plantlist.addPlant(plant);
	}
	
	public void addzombie(String nombre, int x, int y) {
		
		zombielist.addZombie(nombre, x, y);
	}
	
	public void eliminarPlant(int e) {
		plantlist.eliminarobj(e);
	}
	public void eliminarZombie(int e) {
		zombielist.eliminarobj(e);
	}
	public boolean zAtaca(int x, int y) {
		boolean noataca = true;
		
		if(plantlist.restaVida(x, y-1, 1, "plant")) {
			noataca = false;
			
		}
			return noataca;
	}
	
	
	public void psAtaca(int x, int y) {
		int y2;
		if(zombielist.comparepos2(x)) {
			
			   y2=zombielist.primeraY(x , y);
			   zombielist.restaVida(x, y2, 1, "zombie");
			
			
		}
		
		
	}
	
	public boolean restaVidaZ(int x, int y, int danio, String obj) {
		
		return zombielist.restaVida(x, y, danio, obj);
	}
	public boolean restaVidaP(int x, int y, int danio, String obj) {
		
		return plantlist.restaVida(x, y, danio, obj);
	}
	public boolean compareNot(int x, int y) { return zombielist.comparenot(x, y);}
	public int compareplantpos(int x, int y) {
		int founded = -1;
		
		for(int e = 0; e < plantlist.getContador(); e++) {
			
			if(plantlist.comparepos(x, y, e)){
				founded = e;
				
			}			
		}
		return founded;
	}
		
	public int comparezombiepos(int x, int y) {
		int founded = -1;
		
		for(int e = 0; e < zombielist.getContador(); e++) {
			
			if(zombielist.comparepos(x, y, e)){
				founded = e;
				
			}			
		} 	
	return founded; }
	
	public void update(Game game) {
		

		plantlist.update(game);
		zombielist.update(game);
		
		
	}
	
	
	
	
	
	public boolean isThereAny(int x, int y) {
		boolean any = true;
		for(int i = 0;i<zombielist.getContador();i++) {
			
			
				if(zombielist.comparepos(x, y, i)) any = false;
			
		}
		for(int i = 0;i<plantlist.getContador();i++) {
			
			
			if(plantlist.comparepos(x, y, i)) any = false;
		
	}
		
		
		return any;
	}
	
	public boolean jugadorgana(int zombiestotal) {
		boolean gana = false;
		
		gana = zombielist.jugadorgana(zombiestotal);
		
		return gana;
	}

	public String toStringRelease(int i,int j) {
		String str="";
		
		String strO = plantlist.toStringRelease(i,j);
		String str1 = zombielist.toStringRelease(i,j);
		if(!strO.equals("")) {
			str = strO;
			}else if(!str1.equals("")) {
				str = str1;
			}
		
		
		return str;
	}
	
	public String toStringDebugPlantlist(int i) {
		
		return plantlist.toStringDebug(i);
	}
	public String toStringDebugZombielist(int i) {
		
		return zombielist.toStringDebug(i);
	}
	
	public boolean isZombiesGanan() {
		return zombiesGanan;
	}
	public void setZombiesGanan(boolean zombiesGanan) {
		this.zombiesGanan = zombiesGanan;
	}
	public int getPlantlistCont() { return plantlist.getContador();}
	
	public int getZombielistCont() {return zombielist.getContador();}
	
}
