package simulator.model;

import simulator.misc.Vector;

public class Body { 
	
	private String id;
	private double masa;
	private Vector velocidad;
	private Vector aceleracion;
	private Vector posicion;
	
   // constructor
	public Body(String id, Vector speed, Vector pos , Vector hp, double mass) {
		this.id=id;
		velocidad= speed;
		aceleracion=hp;
		posicion=pos;
		masa=mass;
	}
	
	// getters y setters
	public Vector getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Vector velocidad) {
		this.velocidad = velocidad;
	}

	public Vector getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(Vector aceleracion) {
		this.aceleracion = aceleracion;
	}

	public String getId() {
		return id;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) { // preguntar si se puede hacer o no para implementar la funcion de move en masslossingbody
		this.masa = masa;
	}

	public Vector getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Vector posicion) {
		this.posicion = posicion;
	}
	
	//metodo move: mueve el cuerpo durante t segundos utilizando los atributos del mismo
	public void move(double t) {
		Vector auxp= posicion;
		
		double mitad= 0.5*t*t;
		
		auxp= posicion.plus(velocidad.scale(t));
		posicion= auxp.plus(aceleracion.scale(mitad));
		
		
		velocidad= velocidad.plus(aceleracion.scale(t));
		
		
	}
	// metodo to string : devuelve un string con la info del cuerpo
	public String toString() {
		
		return "{ \"id\": "+"\""+getId()+"\""+", \"mass\":"+getMasa()+", \"pos\": " +getPosicion()+", \"vel\": "+getVelocidad().toString()+" , \"acc\": "+getAceleracion().toString()+ " }";
		
	}
	
	
	
}
