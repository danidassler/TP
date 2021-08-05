package simulator.factories;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Builder<T> {
     
	protected String _typeTag; // indica el tipo de objeto a construir
	protected String _desc;  // descripcion del objeto
	
	public String get_desc() {
		return _desc;
	}
	public Builder() {}
	public Builder( String _t, String _d) {
		_typeTag=_t;
		_desc=_d;
	}
	
	public T createInstance(JSONObject info){// aqui obtenemos el string que nos indica y miramos si coincide con el atributo haciendo equals
      T instance = null;
		if(info.getString("type").equals(_typeTag) && _typeTag != null) {
    	  instance = createTheInstance(info.getJSONObject("data"));
      }
	return instance;
	}// para construir una ley de gravedad o un body
		//JSONObjet/*(por defecto)*/ getBuilderInfo() {    

	protected abstract T createTheInstance(JSONObject jsonObject);
	
	protected double[] jsonArrayTodoubleArray(JSONArray json) {
		double[] ArrayJSON = new double[json.length()];
	    for(int i = 0 ; i< ArrayJSON.length; i++) {
	    	ArrayJSON[i] = json.getDouble(i);
	    }
		return ArrayJSON;
	}
	
	public JSONObject getBuilderinfo() {
		JSONObject informacion = new JSONObject();
		informacion.put("type", _typeTag);
		informacion.put("data", createData());
		informacion.put("desc", _desc);
		return informacion;
	}

	protected JSONObject createData() { // como las leyes de gravedad no tienen data lo creamos vacio
		return new JSONObject();
	}
	
			
			//las leyes no sobreescriben en el contructor del builder
	}
		
		
	// el estring hay  que transformarlo en un JSON object para despues crear la ley de gravedad 
	




//clase basic body builder : usar jason array to double array

//string id= data.getstring(id) para pillar el string asociado a id por ejemplo
// b= new body(id, new Vector(p), new Vector(a)...)
//desde el main se crea una lista con los builder por defecto y se le pasan desde el main a la clase BuilderBasedFactory
//y ahi se crea una lista de jasonObjects, se recorre la lista de builders y se llama al info para introducir su info

// en el main necesitaremos una factorya para cuerpos y una para leyes:
// private static Factory<Body> _bodyFactory
//para inicializarlo

// en el create the instance solo hay que hacerlo en los bodys porque en las leyes de gravedad no solo hay que llamar al constructor porque en el campo data no tienen nada 
// b = createtheinstance(info.getJSONObject("data")