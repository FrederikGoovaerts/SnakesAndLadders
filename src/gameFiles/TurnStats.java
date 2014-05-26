package gameFiles;

public class TurnStats {

	public TurnStats(String playerName, int position, int newPosition,
			int roll, int amountOfLaddersEncountered,
			int amountOfSnakesEncountered) {
		this.playerName = playerName;
		this.oldPos = position;
		this.newPos = newPosition;
		this.nbLadders = amountOfLaddersEncountered;
		this.nbSnakes = amountOfSnakesEncountered;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public int getOldPos() {
		return oldPos;
	}

	public int getNewPos() {
		return newPos;
	}

	public int getNbLadders() {
		return nbLadders;
	}

	public int getNbSnakes() {
		return nbSnakes;
	}

	private final String playerName;
	
	private final int oldPos;
	
	private final int newPos;
	
	private final int nbLadders;
	
	private final int nbSnakes;

}
