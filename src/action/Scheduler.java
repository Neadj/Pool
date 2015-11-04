package action;

import java.util.*;


/**
 * The Class Scheduler.
 */
public abstract class Scheduler extends Action{
	
	/** a list of action. */
	protected List<Action> actions=new ArrayList<Action>();
	
	protected boolean isReady =true;

	
	public Scheduler() {
		
	}
	
	public Scheduler(Action action) {
		this.addAction(action);
	}
	
	/**
	 * Instantiates a new scheduler.
	 *
	 * @param actions the actions
	 */
	public Scheduler(List<Action> actions){
		this.actions=actions;
	}
	
	/**
	 * Says if a Scheduler is ready or not.
	 * @return true if and only if each actions of the Scheduler is ready else False.
	 */
	public boolean isReady() {
		return this.isReady;
	}
	
	
	
	@Override
	public boolean isInProgress() {
		return !this.actions.isEmpty() && super.isInProgress();
	}



	/**
	 * remove action in scheduler
	 * 
	 * @param action
	 *            
	 */
	public void removeAction(Action action) {
		this.actions.remove(action);
	}
	
	
	/**
	 * Indicates if there is still an action in the scheduler
	 * 
	 * @return true if and only if there is no more action to do in the
	 *         scheduler
	 */
	public boolean isFinished() {
		return !isReady()&& this.actions.isEmpty();	
	}
	
	
	/**
	 * Adds the action.
	 *
	 * @param action the action
	 */
	public void addAction(Action action) {
		if (this.isFinished()){
			throw new IllegalArgumentException("Can't add a action to a finished scheduler");		
		}
		if (action.isReady() && !action.isFinished())
			this.actions.add(action);
		else throw new IllegalArgumentException("Can't add an unready or finished action");		
	}
	
	
	/**
	 * returns the list of action scheduler
	 * 
	 * @return List<Action> a list of action scheduler
	 */
	public List<Action> getListAction() {
		return this.actions;
	}
	
	
	/**
	 * Make a sentence where is displayed each action of the Scheduler.
	 *
	 * @return the string
	 */
	public String toString() {
		String s ="";
		for(Action a : actions) {
			s += a.toString() + "\n";
		}
		return s;
	}
}
