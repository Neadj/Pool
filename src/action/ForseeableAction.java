package action;

public class ForseeableAction extends Action {

    protected int totalTime;
    protected int remainingTime;
    protected String name;

    /**
     * Constructor of a ForseeableActions
     *
     * @param totalTime time of the action
     * @param name
     */
    public ForseeableAction(int totalTime, String name) {
        if (totalTime <= 0) {
            throw new IllegalArgumentException("the time can't initialized zero or negative value");
        }
        this.totalTime = totalTime;
        this.remainingTime = totalTime;
        this.name = name;
    }

    @Override
    public boolean isReady() {
        return this.totalTime == this.remainingTime;
    }

    @Override
    public boolean isInProgress() {
        return !isReady() && !isFinished();
    }

    @Override
    public boolean isFinished() {
        return this.remainingTime <= 0;
    }

    @Override
    protected void reallyDoStep() {
        this.remainingTime--;

    }

}
