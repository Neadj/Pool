package action;

import java.util.List;

public class FairScheduler extends Scheduler {

    public FairScheduler() {
        super();
    }

    public FairScheduler(Action action) {
        super(action);
        this.nextAction = action;
    }

    public FairScheduler(List<Action> actions) {
        super(actions);
        this.nextAction = actions.get(0);
    }

    /**
     * The iterator.
     */
    protected int it = 0;

    /**
     * The current action.
     */
    protected Action nextAction;

    @Override
    public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
        this.isReady = false;
        if (this.actions.isEmpty()) {
            throw new ActionNotInitializedException();
        }
        nextAction.doStep();
        if (this.nextAction.isFinished()) {
            this.actions.remove(nextAction);
        }
        advancesNextAction();
    }

    /**
     * move cursor on the next action
     */
    protected void advancesNextAction() {
        if (this.actions.size() == 0) {
            this.it = 0;
            this.nextAction = null;
        } else {
            this.it = (it + 1) % this.actions.size();
            this.nextAction = this.actions.get(it);
        }
    }

    /**
     * Gets the current action.
     *
     * @return the current action
     */
    public Action getNextAction() {
        return nextAction;
    }

    @Override
    public void addAction(Action action) {
        if (actions.isEmpty())
            nextAction = action;
        super.addAction(action);
    }

}
