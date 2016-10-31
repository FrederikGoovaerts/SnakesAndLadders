package gameFiles;
import java.util.Random;

/**
 * Die class that represents a standard die with a variable amount of sides.
 * 
 * @author Frederi(c|k)
 *
 */
public class Die {
	
	private int nbOfSides;
	
	private Random random = new Random();
	
	/**
	 * Make a Die with given number of sides
	 * 
	 * @param nbOfSides
	 * 		The number of sides
	 */
	public Die(int nbOfSides){
		if(nbOfSides<1)
			throw new IllegalArgumentException("Cannot have less sides than 1");
		this.nbOfSides = nbOfSides;
	}
	
	/**
	 * @return a random number between 1 and the number of sides
	 */
	public int roll(){
		return (random.nextInt(nbOfSides) + 1);
	}

}
