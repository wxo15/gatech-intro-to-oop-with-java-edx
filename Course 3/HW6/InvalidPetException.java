import java.io.UncheckedIOException;

public class InvalidPetException extends RuntimeException {
	
	public InvalidPetException(String message) {
		super(message);
	}
	
	public InvalidPetException() {
		super("Your pet is invalid!");
	}

}
