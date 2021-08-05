package simulator.launcher;

import simulator.control.Controller;
import simulator.view.MainWindow;

public class Maintest {
	private static Controller ctrl;
       public static void main(String[] args) {

    	   new MainWindow(ctrl);
       }
}
