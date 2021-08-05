package simulator.factories;

import org.json.JSONObject;

import simulator.model.FallingToCenterGravity;
import simulator.model.GravityLaws;

public class FallingToCenterGravityBuilder extends Builder<GravityLaws> {
    private static String type = "ftcg";
    private static String desc = "Falling to center gravity";
	@Override
	protected GravityLaws createTheInstance(JSONObject jsonObject) {
		return new FallingToCenterGravity();
	}
    public FallingToCenterGravityBuilder() { // constructor
    	super(type, desc);
    }
}
