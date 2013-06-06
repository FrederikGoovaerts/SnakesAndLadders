package gameFiles;
/**
 * 
 * @author Frederi(c|k) and Marley
 * @version 1.0 alpha
 */
public class SnakesAndLadders {
	
	Board gameBoard;
	
	public SnakesAndLadders(int boardDimension, int amountOfPlayers){
		this.gameBoard = new Board(boardDimension, amountOfPlayers);
	}
	
	public void printPlayers(){
		gameBoard.printPlayers();
	}
	
	public void gameRound(){
		
	}

}
