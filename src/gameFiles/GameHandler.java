package gameFiles;

import exceptions.PlayerAlreadyPresentException;
import exceptions.PlayerNotPresentException;

public class GameHandler {
	
	//--------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------
	public GameHandler(Game game){
		if (game == null)
			throw new IllegalArgumentException("game can not be null!");
		this.game = game;
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
	public PlayerStats getPlayerStats(String playerName){
		return this.getGame().getPlayerStats(playerName);
	}
	
	
}
