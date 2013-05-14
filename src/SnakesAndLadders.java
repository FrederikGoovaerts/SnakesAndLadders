import java.util.Scanner;

/**
 * 
 * @author Frederic and Marley
 * @version 1.0 alpha
 */
public class SnakesAndLadders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board(10, 10);
		System.out.println("How many players?");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if(i == 2){
			Pion speler1 = new Pion(0, 0);
			Pion speler2 = new Pion(0, 0);
		}
		
		if(i == 3){
			Pion speler1 = new Pion(0, 0);
			Pion speler2 = new Pion(0, 0);
			Pion speler3 = new Pion(0, 0);
		}
		
		if(i >= 4){
			Pion speler1 = new Pion(0, 0);
			Pion speler2 = new Pion(0, 0);
			Pion speler3 = new Pion(0, 0);
			Pion speler4 = new Pion(0, 0);
		}
		
		

	}
	
	public void spelVerloop(){
		
	}

}
