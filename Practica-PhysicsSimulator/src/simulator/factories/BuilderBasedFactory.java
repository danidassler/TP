package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T> {
	List<Builder<T>> _builders;
	List<JSONObject> _factoryElements;
	
    public BuilderBasedFactory(List<Builder<T>> builders) { //CONFIRMAR SI ESTA BIEN
    	_builders= new ArrayList<Builder<T>>(builders);
    	_factoryElements= new ArrayList<JSONObject>();
    	for(Builder<T> b : builders ) {
    		_factoryElements.add(b.getBuilderinfo());
    	}
    }
	@Override
	public T createInstance(JSONObject info) {
		if(info == null) {
			throw new IllegalArgumentException("null");
		}
		for(Builder<T> bb: _builders) {
			T o = bb.createInstance(info);
			if(o != null)
				return o;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JSONObject> getInfo() {
		
		//List<JSONObject> r =new ArrayList<JSONObject>();
		
		return new ArrayList<JSONObject>(_factoryElements);
	}
	@Override
	public List<String> get_desc() {
		// TODO Auto-generated method stub
		List<String> desc = new ArrayList<>();
		for(Builder<T> b: _builders) {
			desc.add(b.get_desc());
			} 
		
		return desc;
	}
	

}
