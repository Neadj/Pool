package action;

public class SequentialScheduler extends Scheduler{

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