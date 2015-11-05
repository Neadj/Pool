package action;


/**
 * The Action abstract class.
 * 
 */
public abstract class Action 
{	
	
	/**
	 * Checks if the action is ready.
	 *
	 * @return true, if the action is ready
	 */
	 public abstract boolean isReady();
	 
	 /**
 	 * Checks if the action is in progress.
 	 *
 	 * @return true, if the action is in progress
 	 */
	 public boolean isInProgress()
	 {
		 return !this.isReady() && !this.isFinished();
	 }

	/**
	 * Checks if the action is finished.
	 *
	 * @return true, if the action is finished
	 */
	public abstract boolean isFinished();
	
	/**
	 * Checks if the action is finished, then does a step.
	 *
	 * @throws ActionFinishedException if the action is already finished
	 * @throws ActionNotInitializedException 
	 */
	public void doStep() throws ActionFinishedException, ActionNotInitializedException
	{
		if(this.isFinished())
		{
			throw new ActionFinishedException();
		}
		
		this.reallyDoStep();
		
	}


	/**
	 * Does the next action
	 * @throws ActionFinishedException 
	 * @throws ActionNotInitializedException 
	 */
	protected abstract void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException;
	
}
