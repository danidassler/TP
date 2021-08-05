package simulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import simulator.control.Controller;

public class BodiesTable extends JPanel{
	private Controller _ctrl;
	private boolean _stopped;

    
    private BodiesTableModel modelTable;
    public BodiesTable(Controller ctrl) {

    	setLayout(new BorderLayout());
    	setBorder(BorderFactory.createTitledBorder(
    	BorderFactory.createLineBorder(Color.black, 2),
    	"Bodies",
    	TitledBorder.LEFT, TitledBorder.TOP));
    	this.setPreferredSize(new Dimension(1000, 200));
    	_ctrl = ctrl;
    	modelTable = new BodiesTableModel(_ctrl);
    	
    	JTable tabla = new JTable(modelTable);
    	tabla.setShowHorizontalLines(true);
    	tabla.setFont(new Font("Dialog", 0 , 15));
    	tabla.setGridColor(Color.LIGHT_GRAY);
        JScrollPane s = new JScrollPane(tabla);
        this.add(s);

    	// TODO complete
    	}
}
