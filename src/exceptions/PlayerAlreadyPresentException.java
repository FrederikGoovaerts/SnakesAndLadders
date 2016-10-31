package exceptions;

public class PlayerAlreadyPresentException extends SnakesAndLaddersException {

	/**
	 * The serial UID for this exception
	 */
	private static final long serialVersionUID = -1807228140921985063L;

	/**
	 * This exception is thrown when a player is tried to be added when a player with the same name is present
	 */
	public PlayerAlreadyPresentException(String string) {
		super(string);
	}

}
