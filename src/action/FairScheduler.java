package action;

import java.util.*;


public class FairScheduler extends Scheduler{


	/** The iterator. */
	protected Iterator<Action> it;
	
	/** The current action. */
	protected Action currentAction;
	
	
	/**
	 * Instantiates a new fair scheduler.
	 */
	public FairScheduler(){
		it = actions.iterator();
	}
	
	/**
	 * Instantiates a new fair scheduler.
	 *
	 * @param actions the actions
	 */
	public FairScheduler(List<Action> actions){
		this.actions=actions;
		it = actions.iterator();
	}
	

	@Override
	protected void reallyDoStep() 
	{
		Action a = getNextAction();
		a.reallyDoStep();
	}
	
	/**
	 * Gets the next action.
	 *
	 * @return the next action
	 */
	private Action getNextAction() {
		
		
		if(it.hasNext()) {
			currentAction=it.next();
			if(currentAction.isFinished())
				return getNextAction();
		}else {
			it = actions.iterator();
			return getNextAction();
		}
		return currentAction;

	}
	
	
	public void addAction(Action a) {
		this.actions.add(a);
		it=actions.iterator();
		while(it.hasNext() && !it.next().equals(currentAction));
	}
	

	/**
	 * Gets the current action.
	 *
	 * @return the current action
	 */
	public Action getCurrentAction() {
		return currentAction;
	}

}