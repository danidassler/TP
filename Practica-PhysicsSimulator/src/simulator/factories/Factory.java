package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public interface Factory<T> {
	public List<JSONObject> getInfo();
	public List<String> get_desc();
	public T createInstance(JSONObject info);
}
