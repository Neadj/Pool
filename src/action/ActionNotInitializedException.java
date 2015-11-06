package action;

/***
 * 
 * This exception is triggered when an action wasn't initialized.
 */
public class ActionNotInitializedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ActionNotInitializedException() {
		
	}

	public ActionNotInitializedException(String message) {
		super(message);
		
	}

	public ActionNotInitializedException(Throwable cause) {
		super(cause);
		
	}

	public ActionNotInitializedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ActionNotInitializedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
