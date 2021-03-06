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
		if (die == null)
			throw new IllegalArgumentException("die can not be null!");
		this.boardEvents = new TreeMap<>(events);
		this.players = new TreeMap<String, Integer>();
		this.die = die;
		this.boardSize = size;
		this.gameIsWon = false;
		this.winner = "";
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
	
	//--------- BoardEvent methods ---------//

	private final Map<Integer, Integer> boardEvents;
	
	/**
	 * Check whether there is a boardEvent on given square.
	 * 
	 * @param square
	 * 		The square to check for
	 * @return
	 * 		Whether there is a board event on given square
	 */
	private boolean hasBoardEventFor(int square){
		return this.boardEvents.containsKey(square);
	}
	
	/**
	 * Get the board event for given square. Returns null if there is no event.
	 * 
	 * @param Square
	 * 		The square to check for
	 * @return The boardevent at given square.
	 */
	private int getBoardEventAt(Integer Square){
		return this.boardEvents.get(Square);
	}

	//----- end of BoardEvent methods -----//
	
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
	
	private void setPlayerSquare(String playerName, int square) throws PlayerNotPresentException{
		if(!players.containsKey(playerName))
			throw new PlayerNotPresentException(playerName + " is not playing right now.");
		this.players.put(playerName, square);
	}
	
	/**
	 * @return the amount of players on this board
	 */
	private int getAmountOfPlayers(){
		return players.size();
	}

	/**
	 * Add given player to the board, at the starting square.
	 * 
	 * @param playerName
	 * 		Name of the player
	 */
	public void addPlayer(String playerName) {
		players.put(playerName, 1);
	}

	/**
	 * Remove given player from the board.
	 * 
	 * @param playerName
	 * 		Name of the player
	 */
	public void removePlayer(String playerName) {
		players.remove(playerName);
	}
	
	private final Map<String, Integer> players;

	//----- end of Player methods -----//
	
	private final Die die;
	
	//--------- Game State property ---------//

	private boolean gameIsWon;
	
	private String winner;
	
	/**
	 * @return whether the game is won
	 */
	public boolean isGameWon(){
		return this.gameIsWon;
	}
	
	/**
	 * @return the person who won the game or an empty string if the game is in
	 * 		progress
	 */
	public String getWinner(){
		return this.winner;
	}
	
	/**
	 * Set the game as won, and the given player as winner
	 * 
	 * @param playerName
	 * 		Name of the winner
	 */
	private void setGameWon(String playerName){
		this.gameIsWon = true;
		this.winner = playerName;
	}
	
	/**
	 * Empty the board, and set the win state to false.
	 */
	void restartGame(){
		this.gameIsWon = false;
		this.winner = "";
		this.players.clear();
	}

	//----- end of Game State property -----//

	
	//--------------------------------------------------------------------------
	// Methods
	//--------------------------------------------------------------------------

	/**
	 * Do a turn for player with given name.
	 * 
	 * @param playerName
	 * 		The name of the player.
	 * @throws PlayerNotPresentException
	 * 		When given player is not playing
	 */
	public void doTurn(String playerName) {
		int position = this.getPlayerSquare(playerName);
		int roll = die.roll();
		int newPosition = position + roll;
		if(newPosition > this.getSize()){
			newPosition = this.getSize() - (newPosition - this.getSize());
		}
		int amountOfLaddersEncountered = 0;
		int amountOfSnakesEncountered = 0;
		boolean hasMoved = true;
		while(hasMoved){
			if(!this.hasBoardEventFor(newPosition)){
				hasMoved = false;
			} else {
				int temp = newPosition;
				newPosition = this.getBoardEventAt(newPosition);
				hasMoved = true;
				if(temp < newPosition){
					amountOfLaddersEncountered++;
				} else {
					amountOfSnakesEncountered++;
				}
			}
		}
		this.setPlayerSquare(playerName, newPosition);
		TurnStats newStats = new TurnStats(playerName, position, newPosition,
				roll, amountOfLaddersEncountered, amountOfSnakesEncountered);
		this.setTurnStats(newStats);
		if(newPosition == this.boardSize){
			this.setGameWon(playerName);
		}
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
		snakesAndLadders.put(80, 99);
		snakesAndLadders.put(87, 24);
		snakesAndLadders.put(93, 73);
		snakesAndLadders.put(95, 75);
		snakesAndLadders.put(98, 79);
		return new Board(100, die, snakesAndLadders);
		
	}


}
