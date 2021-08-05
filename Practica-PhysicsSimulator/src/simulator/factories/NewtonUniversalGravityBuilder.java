package simulator.factories;

import org.json.JSONObject;

import simulator.model.FallingToCenterGravity;
import simulator.model.GravityLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravityBuilder extends Builder<GravityLaws>{
	 private static String type = "nlug";
	    private static String desc = "Newton universal gravity law";
		@Override
		protected GravityLaws createTheInstance(JSONObject jsonObject) {
			return new NewtonUniversalGravitation();
		}
	    public NewtonUniversalGravityBuilder() {
	    	super(type, desc);
		}
}
