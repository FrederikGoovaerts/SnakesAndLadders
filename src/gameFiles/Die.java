package gameFiles;
import java.util.Random;


public class Die {
	
	private int nbOfSides;
	private Random random = new Random();
	
	public Die(int nbOfSides){
		this.nbOfSides = nbOfSides;
	}
	
	public int roll(){
		int eyes = random.nextInt(nbOfSides);
		return (eyes + 1);
	}

}
