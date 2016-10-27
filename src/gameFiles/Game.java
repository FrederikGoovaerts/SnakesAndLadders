package gameFiles;

import exceptions.NoPlayersPresentException;
import exceptions.PlayerAlreadyPresentException;
import exceptions.PlayerNotPresentException;
import exceptions.TurnException;

/**
 * The game, you just lost it.
 * The root class which holds every part of the game and delegates the methods.
 * 
 * @author Frederi(c|k) and Marley
 * @version 1.0 alpha
 */
public class Game {
	
	//--------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------
	/**
	 * Create a new Game with given Board. The board must not contain any players.
	 * The only difference with the default constructor is that this board can
	 * differ from the default board in layout.
	 * 
	 * @param board
	 * 		The board for this new Game.
	 * @throws IllegalStateException
	 * 		If given board is not empty.
	 */
	public Game(Board board) throws IllegalStateException{
		if(!board.isEmpty())
			throw new IllegalStateException("This board is already being played on!");
		this.playerMan = new PlayerManager();
		this.board = board;
	}
	
	/**
	 * Create a new Game with the default board, as defined in the Board class.
	 */
	public Game(){
		this.playerMan = new PlayerManager();
		this.board = Board.getDefaultBoard();
	}
	
	//--------------------------------------------------------------------------
	// Properties
	//--------------------------------------------------------------------------
	
	private final PlayerManager playerMan;
	

	/**
	 * @return the PlayerManager of this Game, for internal use.
	 */
	private PlayerManager getPlayerManager() {
		return playerMan;
	}
	
	private final Board board;
	
	/**
	 * @return the Board of this game, for internal use.
	 */
	private Board getBoard() {
		return board;
	}
	
	//--------------------------------------------------------------------------
	// Game Methods
	//--------------------------------------------------------------------------

	/**
	 * @return the name of the player whose turn it is.
	 * 
	 * @throws NoPlayersPresentException
	 * 		When no players are in the game.
	 */
	public String getTurnPlayer() throws NoPlayersPresentException {
		return this.getPlayerManager().getTurnPlayer();
	}

	/**
	 * Add player with given name to the game.
	 * 
	 * @param playerName
	 * 		The name for the new player.
	 * @throws PlayerAlreadyPresentException
	 * 		If the player is already in the game.
	 */
	public void addPlayer(String playerName) throws PlayerAlreadyPresentException {
		this.getPlayerManager().addPlayer(playerName);
		this.getBoard().addPlayer(playerName);
	}

	/**
	 * Remove the player with given name from the game.
	 * 
	 * @param playerName
	 * 		The name of the player.
	 * @throws PlayerNotPresentException
	 * 		If the player is not in the game.
	 */
	public void removePlayer(String playerName) throws PlayerNotPresentException{
		this.getPlayerManager().removePlayer(playerName);
		this.getBoard().removePlayer(playerName);
	}

	/**
	 * @param playerName
	 * 		The name for the player to check.
	 * @return whether player with given name is playing right now.
	 */
	public boolean isPlaying(String playerName) {
		return (this.getPlayerManager().isPlaying(playerName) && this.getBoard().isPlaying(playerName));
	}

	/**
	 * Do a turn for player with given name.
	 * 
	 * @param playerName
	 * 		The name of the player.
	 * @throws TurnException
	 * 		When it is not given player's turn.
	 * @throws PlayerNotPresentException
	 * 		When given player is not playing
	 */
	public void doTurn(String playerName) throws TurnException, PlayerNotPresentException{
		if(!isPlaying(playerName))
			throw new PlayerNotPresentException(playerName + ", you are not playing!");
		if(!getTurnPlayer().equals(playerName))
			throw new TurnException(playerName + ", it is not your turn!");
		this.getBoard().doTurn(playerName);
		if(this.getLastTurnStats().getRoll() != 6)
			this.getPlayerManager().setNextTurn();
	}

	/**
	 * @return an object with details about the last turn that happened.
	 * @throws TurnException
	 * 		When no turn has been taken yet.
	 */
	public TurnStats getLastTurnStats() throws TurnException {
		return this.getBoard().getLastTurnStats();
	}

	/**
	 * Get some info about the player in the current game.
	 * 
	 * @param playerName
	 * 		The name for the player.
	 * @return a string representing some info about given player.
	 * @throws PlayerNotPresentException
	 * 		When given player is not playing right now.
	 */
	public String getPlayerStats(String playerName) throws PlayerNotPresentException{
		if(!isPlaying(playerName))
			throw new PlayerNotPresentException(playerName + " is not playing right now!");
		return this.getBoard().getPlayerStats(playerName);
	}
	
	/**
	 * @return whether the game is won
	 */
	public boolean isGameWon(){
		return this.getBoard().isGameWon();
	}
	
	/**
	 * @return the person who won the game or an empty string if the game is in
	 * 		progress
	 */
	public String getWinner(){
		return this.getBoard().getWinner();
	}

	/**
	 * Reset the board and players to empty.
	 */
	public void restartGame() {
		this.getPlayerManager().clearPlayers();
		this.getBoard().restartGame();
	}
	
}
