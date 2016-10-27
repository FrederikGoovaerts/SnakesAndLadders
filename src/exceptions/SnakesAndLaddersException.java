package exceptions;

public class SnakesAndLaddersException extends RuntimeException {
	
	/**
	 * ID for serialization
	 */
	private static final long serialVersionUID = 3407579264813960330L;

	/**
	 * Constructor without message, default exception
	 */
	public SnakesAndLaddersException(){
		super();
	}
	
	/**
	 * Constructor with message
	 */
	public SnakesAndLaddersException(String message){
		super(message);
	}
}
