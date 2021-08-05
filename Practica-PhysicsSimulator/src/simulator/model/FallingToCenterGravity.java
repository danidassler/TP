package simulator.model;

import java.util.List;

import simulator.misc.Vector;

public class FallingToCenterGravity implements GravityLaws {

	private static final double g = 9.81;
	
	public FallingToCenterGravity() {}
	
	@Override
	public void apply(List<Body> bodies) { // esto es un metodo generico
		// MIRAR DIAPOSITIVAS DE 11 EN ADELANTE DEL TEMA COLECCIONES
		for( Body b : bodies) {
		   Vector o = b.getPosicion().direction();
		   b.setAceleracion(o.scale(-g));
		}
	}
	
	@Override
	public String toString() {
		return "Falling to center gravity. ";
	}
}
