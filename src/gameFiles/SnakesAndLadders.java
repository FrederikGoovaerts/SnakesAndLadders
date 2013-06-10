package gameFiles;

import java.util.Scanner;

/**
 * 
 * @author Frederi(c|k) and Marley
 * @version 1.0 alpha
 */
public class SnakesAndLadders {
	
	private Board gameBoard;
	private Die gameDie;
	
	public SnakesAndLadders(int boardDimension, int amountOfPlayers, Scanner input){
		this.gameBoard = new Board(boardDimension, amountOfPlayers, input);
		gameDie = new Die(6);
	}
	
	public void printPlayers(){
		gameBoard.printPlayers();
	}
	
	public void doTurn(int playerNb){
		int roll = gameDie.roll();
		System.out.println(gameBoard.getPlayerName(playerNb) + " rolls a " + roll + ".");
		gameBoard.movePlayer(playerNb,roll);
		
	}

}
