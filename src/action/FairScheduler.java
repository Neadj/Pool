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
		currentAction=it.next();
	}
	
	/**
	 * Instantiates a new fair scheduler.
	 *
	 * @param actions the actions
	 */
	public FairScheduler(List<Action> actions){
		this.actions=actions;
		it = actions.iterator();
		currentAction=it.next();
	}
	

	@Override
	public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
		if (this.actions.isEmpty()){
			throw new ActionNotInitializedException();
		}
		this.currentAction.reallyDoStep();
		if (this.currentAction.isFinished()){
			this.it.remove();
		}
		advancesNextAction();
	}
	
	/**
	 * move cursor on the next action
	 */
	protected void advancesNextAction() {	
		if(it.hasNext()) {
			currentAction=it.next();
		}else {
			it = actions.iterator();
			currentAction=it.next();
		}
	}
	
	public void addAction(Action a) {
		super.addAction(a);
		this.it=actions.iterator();
		while(this.it.hasNext() && !this.it.next().equals(this.currentAction));
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