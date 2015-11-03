package action;

import java.util.*;


public class FairScheduler extends Scheduler{


	/** The iterator. */
	protected Iterator<Action> it;
	
	/** The current action. */
	protected Action nextAction;
	

	public FairScheduler() {
		super();
	}

	public FairScheduler(Action action) {
		super(action);
		it = actions.iterator();
		nextAction=it.next();
	}

	public FairScheduler(List<Action> actions) {
		super(actions);
		it = actions.iterator();
		nextAction=it.next();
	}

	@Override
	public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
		this.isReady = false;
		if (this.actions.isEmpty()){
			throw new ActionNotInitializedException();
		}
		this.nextAction.doStep();
		if (this.nextAction.isFinished()){
			this.it.remove();
		}
		advancesNextAction();
	}
	
	/**
	 * move cursor on the next action
	 */
	protected void advancesNextAction() {	
		if(it.hasNext()) {
			nextAction=it.next();
		}else {
			it = actions.iterator();
			if (actions.isEmpty())
				nextAction = null;
			else nextAction=it.next();
		}
	}
	
	public void addAction(Action a) {
		super.addAction(a);
		if (it == null)
			this.it=actions.iterator();
	}
	

	/**
	 * Gets the current action.
	 *
	 * @return the current action
	 */
	public Action getCurrentAction() {
		return nextAction;
	}

}