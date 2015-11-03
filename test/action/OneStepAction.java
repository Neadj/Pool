package action;

public class OneStepAction extends Action {

	boolean actionDone = false;
	
	@Override
	public boolean isReady() {
		return !actionDone;
	}
	
	@Override
	public boolean isInProgress() {
		return false;
	}

	@Override
	public boolean isFinished() {
		return actionDone;
	}


	@Override
	public void doStep() {
		actionDone = true;
	}

	@Override
	protected void reallyDoStep() {

	}

}
