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
	 * already present. If there are already players, this adds the new player
	 * before the one whose turn it is.
	 * 
	 * @param name
	 * 		the name of the new player
	 */
	private void addToPlayersRaw(String name){
		if(this.getTurnIndex()<=0) {
			this.players.add(name);
		} else {
			this.players.add(this.getTurnIndex(), name);
			this.setTurnIndex(this.getTurnIndex()+1);
		}
		
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
	
	/**
	 * @return the amount of players currently in this playermanager.
	 */
	private int getAmountOfPlayers(){
		return this.players.size();
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
		if(this.getTurnIndex() == -1)
			throw new NoPlayersPresentException("There are no players in the game!");
		if(this.getTurnIndex()>=this.getAmountOfPlayers() ||
				this.getTurnIndex()<0)
			throw new IllegalStateException("Turn is not a legal value anymore!");
		return this.players.get(getTurnIndex());
	}
	
	/**
	 * Set the turn index to the next player in the list.
	 *
	 * @throws NoPlayersPresentException
	 * 		When no players are present.
	 */
	void setNextTurn() throws NoPlayersPresentException{
		if(this.getTurnIndex() == -1)
			throw new NoPlayersPresentException("There are no players in the game!");
		if(this.getTurnIndex() == (this.getAmountOfPlayers()-1)){
			this.setTurnIndex(0);
		} else{
			this.setTurnIndex(this.getTurnIndex()+1);
		}
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
		if(this.containsPlayer(playerName))
			throw new PlayerAlreadyPresentException(playerName + " is already playing!");
		this.addToPlayersRaw(playerName);
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
		if(!this.containsPlayer(playerName))
			throw new PlayerNotPresentException(playerName + " is not playing right now!");
		if(this.getTurnIndex() > this.players.indexOf(playerName))
			this.setTurnIndex(this.getTurnIndex() -1);
		this.removeFromPlayersRaw(playerName);
		if(this.getAmountOfPlayers() == 0)
			this.setTurnIndex(-1);
	}

	/**
	 * @param playerName
	 * 		The name for the player to check.
	 * @return whether player with given name is playing right now.
	 */
	public boolean isPlaying(String playerName) {
		return this.containsPlayer(playerName);
	}

	void clearPlayers() {
		this.players.clear();
	}

}
