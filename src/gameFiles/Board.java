package gameFiles;

import java.util.Map;
import java.util.TreeMap;

import exceptions.PlayerNotPresentException;
import exceptions.TurnException;

public class Board {

	//--------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------
	/**
	 * Create a new board with given size, die and events. These events are the
	 * snakes and the ladders. An empty player map is made.
	 * 
	 * @param size
	 * 		The size for this new board.
	 * @param die
	 * 		The die for this new board.
	 * @param events
	 * 		The events of this new board.
	 */
	public Board(int size, Die die, Map<Integer, Integer> events){
		if (events == null)
			throw new IllegalArgumentException("events can not be null!");
		if (events.containsKey(null))
			throw new IllegalArgumentException("events key can not contain null!");
		if (events.containsValue(null))
			throw new IllegalArgumentException("events value can not contain null!");
		if (die == null)
			throw new IllegalArgumentException("die can not be null!");
		this.boardEvents = new TreeMap<>(events);
		this.players = new TreeMap<String, Integer>();
		this.die = die;
		this.boardSize = size;
	}
	
	//--------------------------------------------------------------------------
	// Properties
	//--------------------------------------------------------------------------
	
	//--------- Turnstats ---------//

	private TurnStats turnStats = null;
	
	/**
	 * @return the stats about the last turn
	 */
	private TurnStats getTurnStats() {
		return turnStats;
	}
	
	/**
	 * @return whether or not there are TurnStats in this Board
	 */
	private boolean hasTurnStats() {
		return (getTurnStats() != null);
	}
	
	/**
	 * Set turnStats to the given value
	 * 
	 * @param stats
	 * 		The new stats
	 */
	private void setTurnStats(TurnStats stats){
		this.turnStats = stats;
	}

	//----- end of Turnstats -----//

	private final int boardSize;
	
	/**
	 * @return the amount of squares on this board
	 */
	public int getSize(){
		return this.boardSize;
	}
	
	private final Map<Integer, Integer> boardEvents;
	
	//--------- Player methods ---------//
	
	/**
	 * Get the position this player is at on the board.
	 * 
	 * @param playerName
	 * 		The player to check for.
	 * @return the position of given player.
	 * @throws PlayerNotPresentException
	 * 		If the player is not present on this board.
	 */
	private int getPlayerSquare(String playerName) throws PlayerNotPresentException{
		if(!players.containsKey(playerName))
			throw new PlayerNotPresentException(playerName + " is not playing right now.");
		return players.get(playerName);
	}
	
	/**
	 * @return the amount of players on this board
	 */
	private int getAmountOfPlayers(){
		return players.size();
	}
	
	private final Map<String, Integer> players;

	//----- end of Player methods -----//
	
	private final Die die;
	
	//--------------------------------------------------------------------------
	// Methods
	//--------------------------------------------------------------------------

	public void doTurn(String playerName) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get the info of the last taken turn.
	 * 
	 * @return the info of the last taken turn.
	 * 
	 * @throws TurnException
	 * 		When no turns have been taken yet.
	 */
	public TurnStats getLastTurnStats() throws TurnException {
		if(!hasTurnStats())
			throw new TurnException("No turn has been taken yet!");
		return this.getTurnStats();
	}

	/**
	 * @param playerName
	 * 		The player to check for
	 * @return if given player is playing on this board
	 */
	public boolean isPlaying(String playerName) {
		return this.players.containsKey(playerName);
	}

	/**
	 * Get a string representation of the current status of the player on this
	 * board.
	 * 
	 * @param playerName
	 * 		The player to check for.
	 * @return the current status of the player on this board.
	 * @throws PlayerNotPresentException
	 * 		If the given player is not present on this board.
	 */
	public String getPlayerStats(String playerName) throws PlayerNotPresentException{
		if(!isPlaying(playerName))
			throw new PlayerNotPresentException(playerName + " is not playing "
					+ "right now.");
		return playerName + " is currently at square " + 
					this.getPlayerSquare(playerName) +" of " + this.getSize() +
					".";
	}

	/**
	 * @return whether or not there are players on this board.
	 */
	public boolean isEmpty() {
		return (this.getAmountOfPlayers() == 0);
	}
	
	//--------------------------------------------------------------------------
	// Default board values
	//--------------------------------------------------------------------------
	/**
	 * @return a default snakes and ladders board with size 100, some snakes and
	 * 		ladders according to popular versions of the game, and a six-sided
	 * 		die.
	 */
	public static Board getDefaultBoard() {
		Die die = new Die(6);
		Map<Integer, Integer> snakesAndLadders = new TreeMap<>();
		snakesAndLadders.put(2, 38);
		snakesAndLadders.put(4, 14);
		snakesAndLadders.put(9, 31);
		snakesAndLadders.put(17, 7);
		snakesAndLadders.put(21, 42);
		snakesAndLadders.put(28, 84);
		snakesAndLadders.put(51, 67);
		snakesAndLadders.put(54, 34);
		snakesAndLadders.put(62, 19);
		snakesAndLadders.put(64, 60);
		snakesAndLadders.put(71, 91);
		snakesAndLadders.put(80, 100);
		snakesAndLadders.put(87, 24);
		snakesAndLadders.put(93, 73);
		snakesAndLadders.put(95, 75);
		snakesAndLadders.put(98, 79);
		return new Board(100, die, snakesAndLadders);
		
	}

}
