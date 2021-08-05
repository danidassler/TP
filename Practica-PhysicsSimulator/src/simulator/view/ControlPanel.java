package simulator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;

import org.json.JSONObject;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.GravityLaws;
import simulator.model.SimulatorObserver;

public class ControlPanel extends JPanel implements SimulatorObserver{
    private Controller _ctrl;
   
    private JFileChooser fc;
    private  JButton exit, PSimulator, FileChooser, run, stop;
    private JSpinner spinner, spinner2;
    private JTextField tf3;
    private volatile Thread _thread;

    public ControlPanel(Controller control){
    	_ctrl=control;
    	
    	
    	initGUI();
    	_ctrl.addObserver(this);
    	
    }
    private void initGUI() {
    	
        fc = new JFileChooser();
    	
        this.setLayout(new BorderLayout());
        
    	JToolBar toolBar = new JToolBar();
    	this.add(toolBar, BorderLayout.PAGE_START);
    	
    	FileChooser=createButton("resources/icons/open.png");
    	exit=createButton("resources/icons/exit.png");
    	run=createButton("resources/icons/run.png");
    	stop=createButton("resources/icons/stop.png");
    	PSimulator=createButton( "resources/icons/physics.png");
    	
    	FileChooser.setToolTipText("Elegir un fichero");
    	fc.setCurrentDirectory(new File("C:\\Users\\T430\\Documents\\hlocal\\TP\\PhysicsSimulator\\resources"));
    	exit.setToolTipText("Salir de la aplicacion");
    	run.setToolTipText("Iniciar la aplicacion");
    	stop.setToolTipText("Parar la aplicacion");
    	PSimulator.setToolTipText("Elegir leyes de gravedad");
    	
    	toolBar.add(FileChooser);
    	toolBar.add(run);
    	toolBar.add(stop);
    	toolBar.add(PSimulator);
    	JLabel tf = new JLabel("Steps:");
    	tf.setFont(new Font("Dialog", Font.BOLD , 15));
    	JLabel tf2 = new JLabel("Delta Time");
    	tf2.setFont(new Font("Dialog", Font.BOLD , 15));
    	spinner = new JSpinner();
    	spinner2 = new JSpinner(new SpinnerNumberModel(new Integer(1),new Integer(0),new Integer(1000),new Integer(1) ));
    	spinner2.setValue(1);
    	spinner.setValue(10000);
    	tf.setMinimumSize(new Dimension(50, 20));
    	tf.setPreferredSize(new Dimension(50, 20));
    	tf.setMaximumSize(new Dimension(50, 20));
    	
    	JLabel delay = new JLabel("Delay:");
    	delay.setFont(new Font("Dialog", Font.BOLD , 15));
    	delay.setMinimumSize(new Dimension(50, 20));
    	delay.setPreferredSize(new Dimension(50, 20));
    	delay.setMaximumSize(new Dimension(50, 20));
    	
    	spinner.setMinimumSize(new Dimension(80, 40));
    	spinner.setPreferredSize(new Dimension(80, 40));
    	spinner.setMaximumSize(new Dimension(80, 40));
    	spinner2.setMinimumSize(new Dimension(80, 40));
    	spinner2.setPreferredSize(new Dimension(80, 40));
    	spinner2.setMaximumSize(new Dimension(80, 40));
    	toolBar.add(delay);
    	toolBar.add(spinner2);
    	toolBar.add(tf);
    	toolBar.add(spinner);
    	tf2.setMinimumSize(new Dimension(75, 20));
    	tf2.setPreferredSize(new Dimension(85, 20));
    	tf2.setMaximumSize(new Dimension(175, 20));
    	toolBar.add(tf2);
    	tf3 = new JTextField("10000.0");
    	tf3.setMinimumSize(new Dimension(80, 40));
    	tf3.setPreferredSize(new Dimension(80, 40));
    	tf3.setMaximumSize(new Dimension(80, 40));
    	toolBar.add(tf3);
    	toolBar.add(Box.createHorizontalGlue()); 
    	toolBar.add(exit);
    	 psimulatorListener();
    	 runListener();
    	 stopListener();
    	 fileListener();
    	 exitListener();
    	
    	toolBar.setAlignmentX(LEFT_ALIGNMENT);
 
    }
    private JButton createButton(String icon) {
    	JButton button = new JButton();

    	if(icon!=null)button.setIcon(new ImageIcon(icon));

    	return button;

    }
   
    	private void loadFile() throws Exception {
    	
    	
    	 int returnVal = fc.showOpenDialog(null);
    	 if (returnVal == JFileChooser.APPROVE_OPTION) {
    	 File file = fc.getSelectedFile();
    	 InputStream is = new FileInputStream(file);
    	 _ctrl.reset();
         _ctrl.loadBodies(is);
    	 }
    	}

    	
    	
    	private void run_sim(int n, long delay) {
    		
    		int n1 = n;
        	while ( n1>0 && !Thread.interrupted()) {
        	    try {
        	    _ctrl.run(1);
        	    Thread.sleep(delay);
        	    } catch(InterruptedException e) {
        	    	SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
		        	    	 PSimulator.setEnabled(true);
		            		 FileChooser.setEnabled(true);
		            		 // exit.setEnabled(true); ??

						}
        	    	});
        	        Thread.currentThread().interrupt();
        	    }catch (Exception e) {
        	    	SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
	        	    		JOptionPane.showMessageDialog(null, "Error 404!", "Ventana de Error",JOptionPane.ERROR_MESSAGE );

						}
        	    	});
        	    	SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
		        	    	 PSimulator.setEnabled(true);
		            		 FileChooser.setEnabled(true);
		            		 // exit.setEnabled(true); ??

						}
        	    	});
        	        
        	        Thread.currentThread().interrupt();
        	    }
        	    n1--;
        	} 
    			}
    	
    	
  
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
		// TODO Auto-generated method stub
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				tf3.setText(Double.toString(dt));
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
				tf3.setText(Double.toString(dt));
			}
		});
		
				
		
		
	}
	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAdvance(List<Body> bodies, double time) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDeltaTimeChanged(double dt) {
		// TODO Auto-generated method stub
    SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				tf3.setText(Double.toString(dt));
			}
		});
	
				
				
	
		
		
	}
	@Override
	public void onGravityLawChanged(String gLawsDesc) {
		// TODO Auto-generated method stub
		
	}
    
	public void fileListener() {
		FileChooser.addActionListener(new ActionListener(){ @Override 
     		public void actionPerformed(ActionEvent e) {
         	 
             	 try {
 					loadFile();
 				} catch (Exception e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
             
     	} });
	}
	public void exitListener() {
		exit.addActionListener(new ActionListener(){ @Override 
     		public void actionPerformed(ActionEvent e) {
         	 
         		int n = JOptionPane.showOptionDialog(new JFrame(),
         				 "¿ Estas seguro de que quieres salir ?", "Salir",
         				 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         				 null, null);
         				 if (n == 0) { System.exit(0); }
             
     	} });

		
	}
	public void stopListener() {
		stop.addActionListener(new ActionListener(){ @Override 
    		public void actionPerformed(ActionEvent e) {
        	
        		
        		 PSimulator.setEnabled(true);
        		 FileChooser.setEnabled(true);
        		 
        		 try {
        		 if(_thread!=null)_thread.interrupt();
        		 }catch(Exception e1) {//por si acaso
        			 
        		 }
            
    	} });
	}
    public void runListener() {
    	run.addActionListener(new ActionListener(){
    		@Override 
        		public void actionPerformed(ActionEvent e) {
            	
            		 PSimulator.setEnabled(false);
            		 FileChooser.setEnabled(false);
            		 //exit.setEnabled(false); ??
            		 
            		  
            		  try {
            			  
            		_ctrl.setDeltaTime(Double.parseDouble(tf3.getText()));
            		int spinner1 = (int) spinner.getValue();
            		long spinner_2 = Long.parseLong(spinner2.getValue().toString());
            		if(_thread==null) {
            		_thread= new Thread(new Runnable(){
            			public void run() {
            		run_sim(spinner1, spinner_2);
            		SwingUtilities.invokeLater(new Runnable() {

            			@Override
            			public void run() {
            				// TODO Auto-generated method stub
            				PSimulator.setEnabled(true);
                    		FileChooser.setEnabled(true);
                    		_thread = null;
            			}
            		});
            		
            			}
            		});
            		_thread.start();
            		}
            		  }catch (Exception o) {
            			 
            			  PSimulator.setEnabled(true);
                 		 FileChooser.setEnabled(true);
            			  JOptionPane.showMessageDialog(new JFrame(),"No se puede poner un valor igual o menor a 0 en Delta Time","ERROR",JOptionPane.ERROR_MESSAGE);
    					// TODO: handle exception
    				}
            		  
                
        	} });
    	
    }
    public void psimulatorListener() {
    	PSimulator.addActionListener(new ActionListener(){ @Override 
    		public void actionPerformed(ActionEvent e) {
        	 
        		 int size = _ctrl.getGravityLawsFactory().getInfo().size();
        		 JSONObject info = null;
                 String[] posibilidades = new String[size];
                 for(int i = 0;i < size;i++) {
                	 posibilidades[i] = _ctrl.getGravityLawsFactory().getInfo().get(i).get("desc").toString();
                	 
                 }
                 String n = "";
                 n = (String) JOptionPane.showInputDialog(null,"Elige una ley de gravedad:",  "Leyes de gravedad", 
                		 JOptionPane.INFORMATION_MESSAGE, null,posibilidades, "Newton universal gravity law");
                 for(int i = 0;i<size;i++) {
                	 if(n != null)
                	 if(n.equals(posibilidades[i])) {
                		 
                		 info = _ctrl.getGravityLawsFactory().getInfo().get(i);
                		 _ctrl.setGravityLaws(info);
                	 }
                	 
                 }
                
                 
            
    	} });
    	
    }
}
