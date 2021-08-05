package tp.p1.plant;

public class SunflowerList {
    
    private Sunflower[] sunflower;
    private int con;
    private int cost = 20;
     
    public SunflowerList(int a){
        
        sunflower = new Sunflower[a];
        con = 0;
    }
    public int getCost() {return cost;}//
    
    public int contSunflowers() {return con;}//
    
    
    public int getSLCiclo(int num) {//
    	int ciclo = sunflower[num].getCiclo();
    	
    	return ciclo;
    	
    }
    public boolean restaVida(int x, int y) {//
        boolean b = false;
        for (int i = 0; i < con; i++) {
            
            if(sunflower[i].getX()==x && sunflower[i].getY()==y) {b = true;
            
          if(sunflower[i].getLife()>0&&sunflower[i].getCiclo()!=0)  {
        	  sunflower[i].setLife(sunflower[i].getLife()-1);
        	  }
            }
            if(sunflower[i].getLife()==0) {
            	sunflower[i].setXandY(-1,-1);
            	
            }
        }
		return b;
    }
    
    public void añadirS(int x, int y) {//
        sunflower[con]= new Sunflower(x, y);
        con++;
    
    }//////////////////
    
    public boolean buscaSunflower(int x, int y ,int i) { //ahora//
		boolean ok=false;
		if(sunflower[i].getX()==x&&sunflower[i].getY()==y) { ok=true;}
		else { ok=false;}
		return ok;
	}
    
    //////////
    public String toString(int i, int j) {//
    	String str= "";
    	
    	for(int e=0;e<con;e++) {
    		
    	if(sunflower[e].getX()==i&&sunflower[e].getY()==j) {
    		if(sunflower[e].getLife()!=0) {
    		str=sunflower[e].toString();}
    	}
    	
    	}
    	
    	return str;
    }
    //////////
    
    
    public void actualizarCiclos() {//
    	
    	for(int i = 0;i<con;i++) {
    		sunflower[i].incrementarCiclo();
    		
    	}
    }
    
    
    
    
}

