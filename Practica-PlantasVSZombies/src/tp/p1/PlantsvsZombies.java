package tp.p1;
// Alvaro Casado Molinero y Daniel Sanz Mayo
import java.util.Random;
import java.util.Scanner;

public class PlantsvsZombies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Random r;
		Controller control;
		boolean salir = false;
		if(args.length==2) {
			r = new Random(Integer.parseInt(args[1]));
		}else if (args.length==1) {
			
			r = new Random();
			
		}else {r = new Random();}
		
		
		while(!salir) {
		control = new Controller(r, args[0]);
		salir = control.getExit();
		}

	}

}
