package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body> {
	private static String type = "mlb";
	private static String desc = "Mass losing body";
	
	public MassLosingBodyBuilder() {
		super(type, desc);
	}

	@Override
	protected Body createTheInstance(JSONObject jsonObject) {
		double[] p = jsonArrayTodoubleArray(jsonObject.getJSONArray("pos"));
		double m = jsonObject.getDouble("mass"); // obtenemos la masa
		String id = jsonObject.getString("id"); // obtenemos id
		double[] v = jsonArrayTodoubleArray(jsonObject.getJSONArray("vel"));
		double f = jsonObject.getDouble("freq");
		double fa = jsonObject.getDouble("factor");
		return new MassLossingBody(id, new Vector(v), new Vector(p), new Vector(p.length)/*preguntar aceleracion*/, m,fa,f);
		
	}
	protected JSONObject createData() { // aqui metemos las cosas que hay dentro del campo data
		JSONObject json = new JSONObject();
		json.put("id", "the identifier");
		json.put("vel", 0);
		json.put("pos", 0);
		json.put("mass", 0);
		json.put("factor", 0);
		json.put("freq", 0);
		return json;
	}
	
	
}
