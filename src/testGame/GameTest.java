package testGame;

import java.util.Scanner;

import gameFiles.SnakesAndLadders;

public class GameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SnakesAndLadders game = new SnakesAndLadders(8, 4, input);
		while(true){
			game.printPlayers();
			System.out.println("Who will go next?");
			int playerNbWithoutOffset = input.nextInt();
			game.doTurn(playerNbWithoutOffset-1);
		}
	}

}
