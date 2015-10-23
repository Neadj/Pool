package action;

import resources.ResourcePool;
import resources.ResourcefulUser;

public class TakeResourceAction extends Action {
    
    ResourcePool pool;
    ResourcefulUser user;
    
    public TakeResourceAction(ResourcePool pool, ResourcefulUser user) {
        this.pool = pool;
        this.user = user;
    }

    @Override
    public boolean isReady() {
        return user.getResource() == null;
    }

    @Override
    public boolean isFinished() {
        return user.getResource() != null;
    }

    @Override
    protected void reallyDoStep() {
        user.setResource(pool.provideResource());
    }

}
