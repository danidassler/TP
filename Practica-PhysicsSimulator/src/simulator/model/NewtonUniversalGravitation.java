package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class NewtonUniversalGravitation implements GravityLaws{
	static private final double G = 6.67E-11;
	public NewtonUniversalGravitation(){}
	@Override
	public void apply(List<Body> bodies) {
 
		for( Body b : bodies) {
			Vector fuerzaTotal = new Vector(b.getPosicion().dim());
			if(b.getMasa()==0) {
				
				b.setAceleracion(new Vector(b.getPosicion().dim()));
				
			}else {
			   for( Body a : bodies) {
				   if(!a.equals(b)) {
					   
					 
					 fuerzaTotal = fuerzaTotal.plus(force(b,a));
				   }
			   }
			   
			  
			   b.setAceleracion(fuerzaTotal.scale(1/b.getMasa()));  
			}
			}
		
	}
	
	private Vector force(Body a, Body b) {
		double aux2 = a.getPosicion().distanceTo(b.getPosicion());
		
		double f = ((G)*(b.getMasa()*a.getMasa()))/(aux2*aux2);
		Vector dir = b.getPosicion().minus(a.getPosicion()).direction();
		
		Vector fuerza = dir.scale(f);
		return fuerza;
	}

	public String toString() {
		return " Newton Universal Gravitation. ";
	}
}
