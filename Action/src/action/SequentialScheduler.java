package action;

import java.util.List;

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