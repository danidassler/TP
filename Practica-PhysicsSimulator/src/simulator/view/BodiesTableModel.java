package simulator.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class BodiesTableModel extends AbstractTableModel implements SimulatorObserver {
     private List<Body> _bodies;
     private int size;
     String[] headers = {"Id", "Mass", "Position", "Velocity", "Acceleration"};

    public BodiesTableModel(Controller ctrl) {
    	 _bodies = new ArrayList<>();
    	 
    	 ctrl.addObserver(this);
    	 }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub SE HACE CON UN SWITCH
		Body b = _bodies.get(rowIndex);
		switch(columnIndex) {
		case 0: { 
			return b.getId();
		}
		case 1: { 
		 return b.getMasa();
	    }
		case 2: { 
			return b.getPosicion();
		}
		case 3: { 
			return b.getVelocidad();
		}
        case 4: { 
			return b.getAceleracion();
		}
        default:
        	return null;
        }
		
	}

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
						_bodies=bodies;
		size = _bodies.size();
		fireTableStructureChanged();
			}
		});
			
				


	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
		// TODO Auto-generated method stub
		
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				_bodies=bodies;
					size = 0;
					fireTableStructureChanged();
			}
		});
			
			
		
		
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
							_bodies=bodies;
		size= _bodies.size();
		fireTableStructureChanged();
			}
		});
			
			

	
	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				_bodies=bodies;
		
					fireTableStructureChanged();
			}
		});
			
			
					

		
	}

	@Override
	public void onDeltaTimeChanged(double dt) {
		// TODO Auto-generated method stub
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
			
	}

	@Override
	public void onGravityLawChanged(String gLawsDesc) {
		// TODO Auto-generated method stub
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
			
	}
	@Override
	public String getColumnName(int arg0) {
		
		return headers[arg0];
	}
}
