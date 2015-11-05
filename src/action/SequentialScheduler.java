package action;

import java.util.List;

/**
 * the order of actions execution is sequential begin action1, continue action 1 up to the action is done,
 * begin action2, continue action 2 up to the action is done, ... , begin actionn, continue action n up to the action is done,
 * 
 */

public class SequentialScheduler extends Scheduler{

	
	public SequentialScheduler() {
		super();
	}

	
	public SequentialScheduler(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}

	
	public SequentialScheduler(List<Action> actions) {
		super(actions);
	}

	
	public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
		this.isReady = false;
		if (this.actions.isEmpty()){
			throw new ActionNotInitializedException();
		}
		Action a = this.actions.get(0);
		a.doStep();
		if (a.isFinished()){
			this.actions.remove(0);
		}
	}
}