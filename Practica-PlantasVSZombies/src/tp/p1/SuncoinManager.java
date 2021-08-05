package tp.p1;

public class SuncoinManager {

	private int suncoins;
	
	public SuncoinManager(int coins) {
		
		suncoins = coins;
	}
	
	
	public void setSuncoinManager(Board b) {

		}
	
	public int getSuncoins() {return suncoins;}
	public void decrementarCoins(int coste) {
		
		suncoins = suncoins - coste;
		
	}
	public void incrementarCoins() {
		
		suncoins = suncoins + 10;
		
	}
	
	
	
}
