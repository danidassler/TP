package simulator.model;

import simulator.misc.Vector;

public class MassLossingBody extends Body{

	private double lossFactor;
	private double lossFrecuency;
	private double contador=0.0;
	
	public MassLossingBody(String id, Vector speed, Vector pos, Vector hp, double mass, double lossFactor, double lossFrecuency) {
		super(id, speed, pos, hp, mass);
		this.lossFactor = lossFactor;
		this.lossFrecuency= lossFrecuency;
		// TODO Auto-generated constructor stub
	}

	public void move(double t) {
		
		 super.move(t);

		
		
		if(cuenta(t)) {
			setMasa(getMasa()*(1-lossFactor)); 
		}
	}
	
	private boolean cuenta(double t) {
		contador=+t;
		if(contador>=lossFrecuency) {
			contador=0;
			return true;
		}
		return false;
	}
	
	public String toString() {
			
		return "{ \"id\": "+"\""+getId()+"\""+", \"mass\":"+getMasa()+", \"pos\": " +getPosicion()+", \"vel\": "+getVelocidad().toString()+" , \"acc\": "+getAceleracion().toString()+ " }";
			//return "{ \"id\": "+getId()+", \"pos\": " +getPosicion()+", \"vel\": "+getVelocidad().toString()+", \"mass\":"+getMasa()+", \"freq\" : "+lossFrecuency+ ", \"factor\" : "+ lossFactor+ " }";
	}

}

