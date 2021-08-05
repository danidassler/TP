package tp.p2;


import tp.p1.Game;
import tp.p1.plant.PlantFactory;

public class ListCommand extends NoParamsCommand{

	public ListCommand() {
		super("List", "[L]ist", "Prints the list of available plants.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		
		System.out.println(PlantFactory.listOfPlants());
		
		return false;
	}




}
