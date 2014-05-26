package gameFiles;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoPlayersPresentException;
import exceptions.PlayerAlreadyPresentException;
import exceptions.PlayerNotPresentException;

public class PlayerManager {
	
	//--------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------
	/**
	 * Create a new empty playerManager.
	 */
	public PlayerManager(){
		this.players = new ArrayList<>();
		this.turnIndex = -1;
	}
	
	//--------------------------------------------------------------------------
	// Properties
	//--------------------------------------------------------------------------
		
	private final List<String> players;
	
	/**
	 * Check whether this manager contains given player.
	 * 
	 * @param name
	 * 		Name of the player
	 * @return whether this manager contains given player
	 */
	private boolean containsPlayer(String name){
		return this.players.contains(name);
	}
	
	/**
	 * Add this player to the Manager, regardless of the fact if he/she is
	 * already present.
	 * 
	 * @param name
	 * 		the name of the new player
	 */
	private void addToPlayersRaw(String name){
		this.players.add(name);
	}
	
	/**
	 * Remove this player from the Manager, regardless of the fact if he/she is
	 * actually present.
	 * 
	 * @param name
	 * 		the name of the new player
	 */
	private void removeFromPlayersRaw(String name){
		this.players.remove(name);
	}
	
	private int turnIndex;
	
	/**
	 * @return the index of the active player
	 */
	private int getTurnIndex(){
		return this.turnIndex;
	}
	
	/**
	 * Set the turn index to given value. This denotes the index of the active 
	 * player in the list.
	 * 
	 * @param turn
	 * 		The new index value
	 */
	private void setTurnIndex(int turn){
		this.turnIndex = turn;
	}
	
	//--------------------------------------------------------------------------
	// Class Methods
	//--------------------------------------------------------------------------

	/**
	 * @return the name of the player whose turn it is.
	 * 
	 * @throws NoPlayersPresentException
	 * 		When no players are in this manager.
	 */
	public String getTurnPlayer() throws NoPlayersPresentException{
		return null;
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Set the turn index to the next player in the list.
	 *
	 * @throws NoPlayersPresentException
	 * 		When no players are present.
	 */
	void setNextTurn() throws NoPlayersPresentException{
		//TODO
	}

	/**
	 * Add player with given name to this manager.
	 * 
	 * @param playerName
	 * 		The name for the new player.
	 * @throws PlayerAlreadyPresentException
	 * 		If the player is already in the game.
	 */
	public void addPlayer(String playerName) throws PlayerAlreadyPresentException{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Remove the player with given name from this manager.
	 * 
	 * @param playerName
	 * 		The name of the player.
	 * @throws PlayerNotPresentException
	 * 		If the player is not in this manager.
	 */
	public void removePlayer(String playerName) throws PlayerNotPresentException{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param playerName
	 * 		The name for the player to check.
	 * @return whether player with given name is playing right now.
	 */
	public boolean isPlaying(String playerName) {
		// TODO Auto-generated method stub
		return false;
	}

}
