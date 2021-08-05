package simulator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import simulator.control.Controller;
import simulator.model.Body;
import simulator.model.SimulatorObserver;

public class StatusBar extends JPanel implements SimulatorObserver {
	private JLabel _currTime; // for current time
	private JLabel _currLaws; // for gravity laws
	private JLabel _numOfBodies; // for number of bodies

	StatusBar(Controller ctrl) {

		// _numOfBodies;

		initGUI();
		ctrl.addObserver(this);
		// falta hacerlo
	}

	private void initGUI() {
		JLabel tf = new JLabel("Time: ");
		tf.setFont(new Font("Dialog", Font.BOLD, 15));
		_currTime = new JLabel("0");
		_currTime.setFont(new Font("Dialog", Font.BOLD, 15));
		JLabel tf4 = new JLabel("Laws: ");
		tf4.setFont(new Font("Dialog", Font.BOLD, 15));
		_currLaws = new JLabel("null");
		_currLaws.setFont(new Font("Dialog", Font.BOLD, 15));
		JLabel tf2 = new JLabel("Bodies: ");
		tf2.setFont(new Font("Dialog", Font.BOLD, 15));
		_numOfBodies = new JLabel("0");
		_numOfBodies.setFont(new Font("Dialog", Font.BOLD, 15));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(BorderFactory.createBevelBorder(1));
		this.add(tf);
		this.add(_currTime);
		this.add(Box.createHorizontalGlue());
		this.add(tf2);
		this.add(_numOfBodies);
		this.add(tf4);
		this.add(_currLaws);

	}

	@Override
	public void onRegister(List<Body> bodies, double time, double dt, String gLawsDesc) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				_currTime.setText(Double.toString(time));
				_numOfBodies.setText(Integer.toString(bodies.size()));
				_currLaws.setText(gLawsDesc);
			}
		});

		// TODO Auto-generated method stub

	}

	@Override
	public void onReset(List<Body> bodies, double time, double dt, String gLawsDesc) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				_currTime.setText("0");
				_numOfBodies.setText("0");
				_currLaws.setText(gLawsDesc);

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
				_numOfBodies.setText(Integer.toString(bodies.size()));

			}
		});

	}

	@Override
	public void onAdvance(List<Body> bodies, double time) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				_currTime.setText(Double.toString(time));
				_numOfBodies.setText(Integer.toString(bodies.size()));
			}
		});

		// TODO Auto-generated method stub

	}

	@Override
	public void onDeltaTimeChanged(double dt) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});

		// TODO Auto-generated method stub

	}

	@Override
	public void onGravityLawChanged(String gLawsDesc) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				_currLaws.setText(gLawsDesc);
			}
		});

		// TODO Auto-generated method stub

	}
}
