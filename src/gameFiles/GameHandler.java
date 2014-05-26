package gameFiles;

import exceptions.PlayerAlreadyPresentException;
import exceptions.PlayerNotPresentException;

/**
 * Handler to use as access point for the game.
 * 
 * @author Frederik Goovaerts
 */
public class GameHandler {
	
	//--------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------
	/**
	 * Create a new GameHandler to interface with given Game.
	 * 
	 * @param game
	 * 		The Game for this handler
	 * @throws IllegalArgumentException
	 * 		When the Game is null
	 */
	public GameHandler(Game game) throws IllegalArgumentException{
		if (game == null)
			throw new IllegalArgumentException("game can not be null!");
		this.game = game;
	}
	
	/**
	 * Create a new GameHandler with an empty default Game.
	 */
	public GameHandler(){
		this.game = new Game();
	}
	
	//--------------------------------------------------------------------------
	// Properties
	//--------------------------------------------------------------------------
	
	private final Game game;
	
	/**
	 * @return the game of this class, for internal use
	 */
	private Game getGame(){
		return this.game;
	}
	
	//--------------------------------------------------------------------------
	// Handler Methods
	//--------------------------------------------------------------------------
	
	/**
	 * @return the name of the player whose turn it is.
	 */
	public String getTurnPlayer(){
		return this.getGame().getTurnPlayer();
	}
	
	/**
	 * Add player with given name to the game
	 * 
	 * @param playerName
	 *		The name of the joining player
	 * @throws PlayerAlreadyPresentException
	 * 		If the player is already in the system
	 */
	public void addPlayer(String playerName) throws PlayerAlreadyPresentException{
		this.getGame().addPlayer(playerName);
	}
	
	/**
	 * Remove player with given name from the game
	 * 
	 * @param playerName
	 *		The name of the leaving player
	 * @throws PlayerNotPresentException
	 * 		If the player is not in the system
	 */
	public void removePlayer(String playerName) throws PlayerNotPresentException{
		this.getGame().removePlayer(playerName);
	}
	
	/**
	 * @param playerName
	 * 		The player to check for
	 * @return whether or not the player with given name is present in the system
	 */
	public boolean isPlaying(String playerName){
		return this.getGame().isPlaying(playerName);
	}
	
	/**
	 * Performs the turn of given player
	 * 
	 * @param playerName
	 * 		The player whose turn to do
	 */
	public void doTurn(String playerName){
		this.getGame().doTurn(playerName);
	}
	
	/**
	 * Get an object with information about the last taken turn.
	 * 
	 * @return
	 * 		Stats of the last taken turn
	 */
	public TurnStats getLastTurnStats(){
		return this.getGame().getLastTurnStats();
	}
	
	/**
	 * Get an object with information about given player in the game.
	 * 
	 * @return
	 * 		Stats of the given player
	 */
	public String getPlayerStats(String playerName){
		return this.getGame().getPlayerStats(playerName);
	}
	
	public boolean isGameWon(){
		return this.getGame().isGameWon();
	}
	
	public String getWinner(){
		return this.getGame().getWinner();
	}
	
	public void restartGame(){
		this.getGame().restartGame();
	}
	
	
}
