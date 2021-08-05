package simulator.factories;

import org.json.JSONObject;

import simulator.model.FallingToCenterGravity;
import simulator.model.GravityLaws;
import simulator.model.NoGravity;

public class NoGravityBuilder extends Builder<GravityLaws> {
	 private static String type = "ng";
	 private static String desc = "No gravity law";
		@Override
		protected GravityLaws createTheInstance(JSONObject jsonObject) {
			return new NoGravity();
		}
	    public NoGravityBuilder() {
	    	super(type, desc);
		}
}
