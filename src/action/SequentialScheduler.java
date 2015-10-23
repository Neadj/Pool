package action;

import java.util.*;



public class SequentialScheduler extends Scheduler{

	
	/** The iterator. */
	protected Iterator<Action> it;
	
	/** The current action. */
	protected Action currentAction;
	
	/**
	 * Instantiates a new sequential scheduler.
	 */
	public SequentialScheduler() {
			
	}
	
	public SequentialScheduler(Action action) {
		this.addAction(action);
		it = actions.iterator();
		currentAction = getNextAction();
	}
	/**
	 * Instantiates a new sequential scheduler.
	 *
	 * @param actions the actions
	 */
	public SequentialScheduler(List<Action> actions){
		this.actions=actions;
		it = actions.iterator();
		currentAction = getNextAction();
	}
	
	public void reallyDoStep() {
		if(currentAction.isFinished()) {
			currentAction = getNextAction();
		}
		currentAction.reallyDoStep();
	}
	
	/**
	 * Gets the next action.
	 *
	 * @return the next action
	 */
	private Action getNextAction() {
		Action action;
		if(it.hasNext()) {
			action=it.next();
		}else {
			it = actions.iterator();
			return getNextAction();
		}
		return action;
	}

	public void addAction(Action action) {
		if(actions.isEmpty()) {
			super.addAction(action);
			it=actions.iterator();
			currentAction=getNextAction();
		}else {
			super.addAction(action);
			it=actions.iterator();
		}
	}
}