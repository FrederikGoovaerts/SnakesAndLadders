package gameFiles;
import java.util.Random;


public class Die {
	
	private int nbOfSides;
	Random random = new Random();
	
	public Die(int nbOfSides){
		this.nbOfSides = nbOfSides;
	}
	
	public int roll(){
		int eyes = random.nextInt(nbOfSides - 1);
		return (eyes + 1);
	}

}
