package tp.p1.plant;

import tp.p1.Game;

public class PeashooterList {

    private Peashooter[] peashooter;
    private int cont;
    private int cost = 50;
    
    public PeashooterList(int a){
        
        peashooter = new Peashooter[a];
        cont = 0;
    }

    
 public void añadirP(int x, int y) {//
        
        peashooter[cont] = new Peashooter(x, y);
        cont++;
        
    }
 
 public boolean restaVida(int x, int y) {//
     boolean b = false;
     for (int i = 0; i < cont; i++) {
         
         if(peashooter[i].getX()==x && peashooter[i].getY()==y) {b = true;
         
         peashooter[i].setLife(peashooter[i].getLife()-1);
         }
         if(peashooter[i].getLife()==0) {
             peashooter[i].setXandY(-1, -1); // para que no aparezcan en el tablero
            }
         
     }
		return b;
 }
    
 public int getCost() {return cost;}
 
 public boolean buscaPeashooter(int x, int y ,int i) { //ahora//
		boolean ok=false;
		if(peashooter[i].getX()==x&&peashooter[i].getY()==y) { ok=true;}
		
		return ok;
	}

public void update(Game game) {//
	int x;
	int y;
	for(int i = 0; i < cont;i++) {
		x = peashooter[i].getX();
		y = peashooter[i].getY();
		game.actuaObj(x , y);
		
	}
	
	
}


public String toString(int i, int j) {
	String str= "";
	
	for(int e=0;e<cont;e++) {
		if(peashooter[e]!=null) {
	if(peashooter[e].getX()==i&&peashooter[e].getY()==j) {
		
		str=peashooter[e].toString();
	}
	}
	}
	
	return str;
}

public int getCont() {
	// TODO Auto-generated method stub
	return cont;
}
    
}
