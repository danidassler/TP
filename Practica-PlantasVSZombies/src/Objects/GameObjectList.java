package Objects;

import tp.p1.Game;
import tp.p1.zombie.ZombieFactory;
import tp.p1.plant.Plant;
import tp.p1.plant.PlantFactory;


public class GameObjectList {

	private GameObject[] ObjectList;
	private int contador;
	private int zombiesmuertos;
	
	public GameObjectList(int a) {
		
		ObjectList = new GameObject[a];
		contador = 0;
		zombiesmuertos = 0;
	}
    public int getCiclo(int num) {return ObjectList[num].getCiclo();}
	
	public int getContador() {return contador;}
	public void actualizarCiclos() {
	    	
	    	for(int i = 0;i<contador;i++) {
	    		ObjectList[i].incrementarCiclo();
	    		
	    	}
	    }
	public void incrementarcontador() {contador++;}
	
	public void addZombie(String nombre, int x, int y) {
		
		ObjectList[contador] = ZombieFactory.getZombie(nombre, x, y);
		
		contador++;
	}
	
	public void addPlant(Plant plant) {
		
		ObjectList[contador] = plant;
		
		contador++;
	}
	 public boolean comparepos2(int x) {
        boolean b = false;
  for(int i = 0;i < contador;i++) {
            if(ObjectList[i].comparepos2(x)) {
            	b = true;
            
            }
            }
		return b;
	}
	
	 public int primeraY(int x, int y) {
		 int y2 = 0;
		 for(int i = 0; i< contador;i++) {
			if(y2==0)y2 = ObjectList[i].primeraY(x, y);
		 }
		 return y2;
	 }
	 public boolean restaVida(int x, int y, int danio, String obj) {//es la posicion a la que va a hacer el ataque
	     boolean b = false;
	   
	     for (int i = 0; i < contador; i++) {
	        if(ObjectList[i].whoIs().equals(obj)) {
	        
	         if(ObjectList[i].getX()==x && ObjectList[i].getY()==y) {b = true;//comprueba que objeto tiene esa posicion
	         
	       if(ObjectList[i].getCiclo()!=0)  ObjectList[i].setLife(ObjectList[i].getLife()-danio);//si el objeto acaba de aparecer que no se le ataque
	         }
	         }

	         if(ObjectList[i].getLife()<=0) {
	        	 if(ObjectList[i].whoIs().equals("zombie")) {zombiesmuertos++;}
	            eliminarobj(i); // para que no aparezcan en el tablero
	            }
	     }
			return b;
	 }
	 public boolean buscarObjeto(int x, int y ,int i) { //ahora
			boolean ok=false;
			if(ObjectList[i].getX()==x&&ObjectList[i].getY()==y) { ok=true;}
			
			return ok;
		}
	 public void update(Game game) {//

			for(int i = 0; i < contador;i++) {

				
				ObjectList[i].update(game);
				
			}
	
	 }
	 public boolean comparenot(int x, int y) {

	        boolean b = true;
	        for (int i = 0; i < contador; i++) {
	            
	            if(ObjectList[i].getY()==y && ObjectList[i].getX()==x) {b = false;}
	            
	        }
	        if(contador==0) b = true;
	        
	        
	        return b;
	        
	    }
	 public boolean comparepos(int x, int y, int i) {
	        boolean b = false;
	      
	            
	            if(ObjectList[i].getX()==x && ObjectList[i].getY()==y) {b = true;}
	            
	        
	            if(contador==0) b = true;
	        
	        
	        return b;
	        
	    }
	 public void eliminarobj(int e) {
		 for(int i = e; i< contador;i++) {
			 ObjectList[i] = ObjectList[i + 1];
			 
		 }
		 contador--;
		 
	 }
     public boolean jugadorgana(int zombiestotal) {
    	 boolean gana = false;
 
    	
    	 if(zombiesmuertos==zombiestotal) gana = true;
    	 
    	 
    	 return gana;
    	 
    	 
     }
	 public String toStringRelease(int i, int j) {
		 String str = "";
		 for(int e = 0;e<contador;e++) {
			 if(ObjectList[e].getX()==i&&ObjectList[e].getY()==j) {
				 if(ObjectList[e].getLife()!=0) {
					 str = ObjectList[e].toStringRelease();
				 }
			 }
		 }
		 
		 return str;
	 }
	 
	 public String toStringDebug(int i) {
		 String str = "";
		 
		 str = ObjectList[i].toStringDebug();
		 
		 return str;
	 }
 }

