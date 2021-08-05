package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;
import simulator.misc.Vector;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class Viewer extends JComponent implements SimulatorObserver{

	private int _centerX;
	private int _centerY;
	private double _scale;
	private List<Body> _bodies;
	private boolean _showHelp;
	private String HelpMessage = "h: Toggle Help, +: zoom in, -: zoom out, =: fit";
	private String HelpMessage2 = "Scaling ratio: "+_scale;
	
	public Viewer(Controller ctrl) {
		ctrl.addObserver(this);
		initGUI();
		
		
	}
	
	private void initGUI() {
		 JPanel mainPanel=new JPanel();
		
    	 setBorder(BorderFactory.createTitledBorder(
    	 BorderFactory.createLineBorder(Color.black, 2),
    	 "Viewer",
    	 TitledBorder.LEFT, TitledBorder.TOP));
    	 setMinimumSize(new Dimension(500, 300));
    	 mainPanel.setPreferredSize(new Dimension(500, 300));
    	
    	 repaint();
    	this.add(mainPanel);
    	
		_bodies = new ArrayList<>();
		_scale = 1.0;
		_showHelp = true;
		addKeyListener(new KeyListener() {// ...
			@Override 
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) {
				case '-':_scale = _scale*1.1;break;
				case '+':_scale = Math.max(1000.0, _scale / 1.1);break;
				case '=':autoScale();;break;
				case 'h':_showHelp = !_showHelp;break;
				default:}
				HelpMessage2 = "Scaling ratio: "+_scale;
				repaint();
				
				}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			});
		addMouseListener(new MouseListener() {// ...
			@Override public void mouseEntered(MouseEvent e) {
				requestFocus();
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		setMaximumSize( new Dimension(10000,10000));
		setPreferredSize( new Dimension(200,200));
	
	}

		@Override 
		protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		gr.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
		_centerX = getWidth() / 2;
		_centerY = getHeight() / 2;

		gr.setColor(Color.RED);
		gr.drawLine(_centerX-10, _centerY, _centerX+10, _centerY);
		gr.drawLine(_centerX, _centerY+10, _centerX, _centerY-10);
	
		for(Body b :_bodies) {
			int x = (int) (b.getPosicion().coordinate(0)/_scale) + _centerX;
			int y = _centerY - (int) (b.getPosicion().coordinate(1)/_scale);
			gr.setColor(Color.BLUE);
			gr.fillOval(x -2, y-2, 5, 5);
			gr.drawString(b.getId(), x, y);
		}
		
		if(_showHelp) {
			gr.setColor(Color.RED);
			gr.drawString(HelpMessage, 7,26);
			gr.drawString(HelpMessage2, 7, 40);
		}
		else {
			
		}
		// TODO draw a cross at center
		// TODO draw bodies
		// TODO draw help if _showHelp is true
	}
	
	private void autoScale() {
		double max = 1.0;
		for (Body b : _bodies) {
			Vector p = b.getPosicion();
			for (int i = 0; i < p.dim(); i++)
				max = Math.max(max,Math.abs(b.getPosicion().coordinate(i)));
			}
		double size = Math.max(1.0, Math.min((double) getWidth(),(double) getHeight()));
		_scale = max > size ? 4.0*max / size : 1.0;
			}
	

	
		
	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				_bodies = bodies;
				autoScale();
				repaint();
			}
		});
			
		
				
	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				_bodies = bodies;
		autoScale();
		repaint();
	
			}
		});
			
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBodyAdded(List<Body> bodies, Body b) {
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				_bodies = bodies;
					autoScale();
					repaint();
			}
		});
			
			

		
		
		
	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {
		// TODO Auto-generated method stub
SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				_bodies = bodies;
		repaint();
				
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

}
