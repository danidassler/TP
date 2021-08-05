package simulator.factories;



import org.json.JSONObject;

import simulator.misc.Vector;
import simulator.model.Body;


public class BasicBodyBuilder extends Builder<Body>{
	private static String type = "basic";
	private static String desc = "Default Body";
@Override
protected Body createTheInstance(JSONObject jsonObject) {
	double[] p = jsonArrayTodoubleArray(jsonObject.getJSONArray("pos"));
	double m = jsonObject.getDouble("mass"); // obtenemos la masa
	String id = jsonObject.getString("id"); // obtenemos id
	double[] v = jsonArrayTodoubleArray(jsonObject.getJSONArray("vel"));
	return new Body(id, new Vector(v), new Vector(p), new Vector(p.length)/*preguntar aceleracion*/, m);
};
	
	public BasicBodyBuilder() {
		super(type,desc);
	}
	
	
protected JSONObject createData() {
	JSONObject json = new JSONObject();
	json.put("id", "the identifier");
	json.put("vel", 0);
	json.put("pos", 0);
	json.put("mass", 0);
	return json;
}

}

