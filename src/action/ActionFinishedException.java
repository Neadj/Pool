package action;


/**
 * The Exception ActionFinishedException.
 * this exception is thrown if you try to do doStep on an finished Action
 */
public class ActionFinishedException extends Exception {
	

	
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new action finished exception.
	 */
	public ActionFinishedException(){
		super();
	}

}
