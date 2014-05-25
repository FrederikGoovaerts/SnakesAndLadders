package gameFiles;

import exceptions.TurnException;

public class Board {

	
	//--------------------------------------------------------------------------
	// Properties
	//--------------------------------------------------------------------------
	
	private TurnStats turnStats = null;
	
	private TurnStats getTurnStats() {
		return turnStats;
	}
	
	private boolean hasTurnStats() {
		return (getTurnStats() != null);
	}
	
	private void setTurnStats(TurnStats stats){
		this.turnStats = stats;
	}
	
	//--------------------------------------------------------------------------
	// Methods
	//--------------------------------------------------------------------------
	
	
	public static Board getDefaultBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	public void doTurn(String playerName) {
		// TODO Auto-generated method stub
		
	}
	
	public TurnStats getLastTurnStats() throws TurnException {
		if(!hasTurnStats())
			throw new TurnException("No turn has been taken yet!");
		return this.getTurnStats();
	}

	public boolean isPlaying(String playerName) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPlayerStats(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
