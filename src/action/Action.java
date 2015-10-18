

package action;


/**
 * The Class Action.
 *
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
	 * Checks if the action is finished, then do a step.
	 *
	 * @throws ActionFinishedException if the action is already finished
	 */
	public void doStep() throws ActionFinishedException
	{
		if(this.isFinished())
		{
			throw new ActionFinishedException();
		}
		
		this.reallyDoStep();
		
	}


	/**
	 * Really do the step.
	 */
	protected abstract void reallyDoStep();
	
}
