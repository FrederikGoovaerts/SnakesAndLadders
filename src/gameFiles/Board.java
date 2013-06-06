package gameFiles;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Board {
	
	private int boardDimension;
	private HashSet<String> playerNames;
	private ArrayList<Player> players;
	
	public Board(int boardDimension, int amountOfPlayers){
		this.boardDimension = boardDimension;
		playerNames = new HashSet<String>();
		players = new ArrayList<Player>();
		int i = 1;
		Scanner nameScanner = new Scanner(System.in);
		while(i <= amountOfPlayers){
			System.out.println("Enter a name for player " + i);
			if(nameScanner.hasNextLine()){
				String currentName = nameScanner.nextLine();
				if(!playerNames.contains(currentName)){
					players.add(i-1, new Player(i, currentName, 0));
					playerNames.add(currentName);
					i++;
				} else {
					System.out.println("This name is already in use, please pick another name for player " +i);
				}
			} else {
				System.out.println("No legal input found, please try again.");
			}
		}
		nameScanner.close();
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
		// TODO Auto-generated method stub
		
	}
	
}
