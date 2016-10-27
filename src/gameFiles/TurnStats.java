package gameFiles;

public class TurnStats {

	public TurnStats(String playerName, int position, int newPosition,
			int roll, int amountOfLaddersEncountered,
			int amountOfSnakesEncountered) {
		this.playerName = playerName;
		this.oldPos = position;
		this.newPos = newPosition;
		this.roll = roll;
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
	
	public int getRoll() {
		return roll;
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
	
	private final int roll;
	
	private final int nbLadders;
	
	private final int nbSnakes;
	
	@Override
	public String toString(){
		String result = playerName + " was at square " + oldPos + ", and rolled a " + roll +
				". ";
		if(nbLadders > 0){
			result += "Took " + nbLadders + " ladder(s). ";
		}
		if(nbSnakes > 0){
			result += "Got bit by " + nbSnakes + " snake(s). ";
		}
		result += "Ended at square " + newPos + ".";
		return result;
	}

}
