package exceptions;

public class NoPlayersPresentException extends SnakesAndLaddersException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5352520326677480180L;

	/**
	 * Exception thrown when game is to be started when no players are present
	 */
	public NoPlayersPresentException(String string) {
		super(string);
	}
}
