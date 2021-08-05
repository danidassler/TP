package simulator.model;

import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class PhysicsSimulator {
	
	private double _dt = 0.0;
	private List<Body> _bodies;
	

	
	
	private GravityLaws _gravityLaws;
	private double _time;
	private List<SimulatorObserver> _simulatorObserver;
	
	
      public PhysicsSimulator(double time, GravityLaws gl) {
    	  
    	  _gravityLaws = gl;
    	  if(gl==null) {
    		  throw new IllegalArgumentException("null") ;    	  
    		  }
    	  if(time < 0) {
    		  throw new IllegalArgumentException("valor no valido") ;  
    	  }
    	  _dt = time;
    	  
    	  _bodies = new ArrayList<Body>();
    	  _simulatorObserver = new ArrayList<SimulatorObserver>();
    	  
      }
      
      public void addBody(Body b) throws IllegalAccessException {
    	  if(_bodies != null) {
    	  for(Body  body: _bodies) {
     		 if(body.getId().equals(b.getId())) {
     			 throw new IllegalAccessException("This body is already added");
     		 }
     	 }
    	 }
    	  _bodies.add(b);
    	  for(SimulatorObserver o: _simulatorObserver) {
    		  o.onBodyAdded(_bodies, b);
    	  }
      }
      
      public void advance() {
    	  
    	 _gravityLaws.apply(_bodies);
    	 for(Body  b: _bodies) {
    		 b.move(_dt);
    		 
    	 }
    	 _time += _dt;
    	 for(SimulatorObserver o: _simulatorObserver) {
   		  o.onAdvance(_bodies, _time);
   	  }
    	 
      }
      
      public String toString() {//FALTA ESTO
    	  String devuelve = "{ \"time\": "+_time+", \"bodies\": [";
    	int i = _bodies.size()-1;
    	int e = 0;
    	  for(Body b: _bodies) {
    		  
    		 if(e==i) devuelve = devuelve + b.toString();
    		 else devuelve = devuelve + b.toString()+", ";
    		  e++;
    	  }
    	  devuelve = devuelve + " ] }";
    	  
    	  return devuelve;
      }
      
      // nuevo p5
      
      public void reset() {
    	  _bodies.clear();
    	  
    	  _time = 0.0; // CREO QUE EL ERROR ES POR EL DELTA TIME QUE LO PONEMOS A 0.0 Y PETA YA QUE EN SET DELTA TIME SI DT=0 LANZA EXCEPCION ( hay mas fallos tambien )
    	  for(SimulatorObserver o: _simulatorObserver) {
    		  o.onReset(_bodies, _time, 2500.0, _gravityLaws.toString());
    	  }
      }
      
      public void setDeltaTime(double dt) throws IllegalArgumentException {
    	  if(dt<=0) {
    		  throw new IllegalArgumentException();
    	  }
    	_dt=dt;  
    	 for(SimulatorObserver o: _simulatorObserver) {
   		  o.onDeltaTimeChanged(_dt);
   	  }
      }
      
      public void setGravityLaws(GravityLaws gravityLaws) throws IllegalArgumentException {
    	  if(gravityLaws==null) {
    		  throw new IllegalArgumentException();
    	  }
    	  _gravityLaws=gravityLaws;
    	  for(SimulatorObserver o: _simulatorObserver) {
    		  o.onGravityLawChanged(_gravityLaws.toString());
    	  }
      }
      
      public void addObserver(SimulatorObserver o) throws IllegalArgumentException {
    	  if(o==null) {
    		  throw new IllegalArgumentException();
    	  }
    	  if(_simulatorObserver==null) {
    		  _simulatorObserver.add(o);
    	  }
          if(!_simulatorObserver.contains(o)) {
        	  _simulatorObserver.add(o);
        	  
        	 
        	  
          }
          for(SimulatorObserver s: _simulatorObserver) {
    		  s.onRegister(_bodies, _time, _dt, _gravityLaws.toString());
    	  }
          
    	  
      }
      
}