package action;

public class ForseeableAction extends Action{

	
	protected int totalTime;
	protected int remainigTime;
	protected String name;
	
	
	/**
	 * Constructor of a ForseeableActions
	 * 
	 * @param totalTime time of the action 
	 * @param name
	 */
	public ForseeableAction(int totalTime,String name){
		if(totalTime<=0)
			throw new IllegalArgumentException("the time can't initialized zero or negative value");
		this.totalTime=totalTime;
		this.remainigTime=totalTime;
		this.name=name;
	}
	public boolean isReady() {
		return this.totalTime==this.remainigTime;
	}

	
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	
	public boolean isFinished() {
		return this.remainigTime<=0;
	}
		
	
	protected void reallyDoStep() {
		this.remainigTime--;
		
	}
	

}
