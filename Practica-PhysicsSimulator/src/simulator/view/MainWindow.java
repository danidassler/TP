package simulator.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import simulator.control.Controller;

public class MainWindow extends JFrame{
      private Controller _ctrl;
      
      public MainWindow(Controller ctrl) {
    	  super("Physics Simulator");
    	  _ctrl=ctrl;
    	  initGUI();
      }
      private void initGUI() {
    	  JPanel mainPanel = new JPanel(new BorderLayout());
    	  //this.setContentPane(mainPanel);
         // ControlPanel supPanel=new ControlPanel(_ctrl);
          mainPanel.add(new ControlPanel(_ctrl), BorderLayout.NORTH);
          mainPanel.add( createMiddlePanel(), BorderLayout.CENTER);
          mainPanel.add(new StatusBar(_ctrl), BorderLayout.SOUTH);
          this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
          this.add(mainPanel);
          this.pack();
          this.setVisible(true);
          this.addWindowListener(new WindowListener() {
        	@Override
        	public void windowClosing(WindowEvent e) { salir();
        	
        	}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			
    	  });
      }
      
    
      private JPanel createMiddlePanel() {
    	  JPanel midPanel = new JPanel(new BorderLayout());
          midPanel.add(new Viewer(_ctrl), BorderLayout.CENTER);
          midPanel.add(new BodiesTable(_ctrl), BorderLayout.NORTH);
          this.add(midPanel);
          this.pack();
          this.setVisible(true);
    	  return midPanel;
    	  
      }
      
      private void salir() {
    	  int n = JOptionPane.showOptionDialog(new JFrame(),
    	  "¿ Estas seguro de que quieres salir ?", "Salir",
    	  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
    	  null, null);
    	  
    	  if (n == 0) { System.exit(0); }
      }
      
}
