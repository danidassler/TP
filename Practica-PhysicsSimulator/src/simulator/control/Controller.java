package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.GravityLaws;
import simulator.model.PhysicsSimulator;
import simulator.model.SimulatorObserver;

public class Controller {

	PhysicsSimulator _sim;
	Factory<Body> _bodiesFactory;
	Factory<GravityLaws> _lawsFactory;
	public Controller(PhysicsSimulator s, Factory<Body> b, Factory<GravityLaws> g) {
		_sim = s;
		_bodiesFactory = b;
		_lawsFactory=g;
	}
	
	public void loadBodies(InputStream in) throws IllegalAccessException, JSONException {
		JSONObject jsonInput = new JSONObject(new JSONTokener(in));
		JSONArray bodies = jsonInput.getJSONArray("bodies");
		for (int i = 0; i < bodies.length(); i++) 
			_sim.addBody(_bodiesFactory.createInstance(bodies.getJSONObject(i)));
	}
	
	public void run(int n, OutputStream out) {
		String info="{\"states\": [";
		
		PrintStream p = (out == null) ? null : new PrintStream(out);
		p.println(info);
		for (int i = 0; i < n; i++) {
			p.println(_sim.toString() + ", ");
			System.out.println(_sim.toString() + ", ");
    		_sim.advance();
		
		}
		p.println(_sim.toString()+ "] }");
		
		
	}
	
	// nuevo p5
	
	public void reset() {
		_sim.reset();
	}
	
	public void setDeltaTime(double dt) {
		
		_sim.setDeltaTime(dt);
	}
	
	public void addObserver(SimulatorObserver o) throws IllegalArgumentException {
		_sim.addObserver(o);
	}
	
	public void run(int n) {
		for (int i = 0; i < n; i++) {
    		_sim.advance();
    		
		}
	}
	
	public Factory<GravityLaws> getGravityLawsFactory(){
		return _lawsFactory;
		
	}
	
	public void setGravityLaws(JSONObject info) {
		_sim.setGravityLaws(_lawsFactory.createInstance(info));
		
	}

}


