package gameFiles;
/**
 * 
 * @author Frederi(c|k) and Marley
 * @version 1.0 alpha
 */
public class SnakesAndLadders {
	
	private Board gameBoard;
	private Die gameDie;
	
	public SnakesAndLadders(int boardDimension, int amountOfPlayers){
		this.gameBoard = new Board(boardDimension, amountOfPlayers);
		gameDie = new Die(6);
	}
	
	public void printPlayers(){
		gameBoard.printPlayers();
	}
	
	public void doTurn(int playerNb){
		gameBoard.movePlayer(playerNb,gameDie.roll());
	}

}
