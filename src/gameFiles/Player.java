package gameFiles;

public class Player {

	private int playerNumber;
	private String playerName;
	private int position;
	
	public Player(int playerNumber, String playerName, int position) {
		this.setPlayerNumber(playerNumber);
		this.setPlayerName(playerName);
		this.setPosition(position);
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
