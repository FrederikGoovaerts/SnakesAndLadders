package gameFiles;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Board {
	
	private int boardDimension;
	private HashSet<String> playerNames;
	private ArrayList<Player> players;
	
	//als het bord n op n groot is is de boarddimension n. Er zijn dus n^2 vakjes.
	public Board(int boardDimension, int amountOfPlayers, Scanner input){
		this.boardDimension = boardDimension;
		playerNames = new HashSet<String>();
		players = new ArrayList<Player>();
		int i = 1;
		while(i <= amountOfPlayers){
			System.out.println("Enter a name for player " + i);
			if(input.hasNextLine()){
				String currentName = input.nextLine();
				if(!playerNames.contains(currentName)){
					players.add(i-1, new Player(i, currentName, 1));
					playerNames.add(currentName);
					i++;
				} else {
					System.out.println("This name is already in use, please pick another name for player " +i);
				}
			} else {
				System.out.println("No legal input found, please try again.");
			}
		}
	}
	
	public String getPlayerName(int playerNb){
		return players.get(playerNb).getPlayerName();
	}
	
	public void printPlayers(){
		for(Player currentPlayer : players){
			System.out.println("Player " + currentPlayer.getPlayerName() + " is currently at space with number " + currentPlayer.getPosition() + ".");
		}
		System.out.println("This board has " + (int) Math.pow(boardDimension, 2) + " spaces.");
	}
	
	public void printBoard(){
		
	}

	public void movePlayer(int playerNb, int roll) {
		Player currentPlayer = players.get(playerNb);
		if(currentPlayer.getPosition()+roll <= Math.pow(this.boardDimension,2)){
			currentPlayer.setPosition(currentPlayer.getPosition()+roll);
		} else {
			currentPlayer.setPosition(2*((int)Math.pow(this.boardDimension,2))-(currentPlayer.getPosition()+roll));
		}
		resolveSpace(playerNb, currentPlayer.getPosition());
		System.out.println("New position is " + currentPlayer.getPosition());
	}

	private void resolveSpace(int playerNb, int position) {
		// TODO Auto-generated method stub
		
	}
	
}
