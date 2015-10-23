package action;

import resources.ResourcePool;
import resources.ResourcefulUser;

public class FreeResourceAction extends Action {

    ResourcePool pool;
    ResourcefulUser user;

    public FreeResourceAction(ResourcePool pool, ResourcefulUser user) {
        this.pool = pool;
        this.user = user;
    }
    
    @Override
    public boolean isReady() {
        return user.getResource() != null;
    }

    @Override
    public boolean isFinished() {
        return user.getResource() == null;
    }

    @Override
    protected void reallyDoStep() {
        pool.freeResource(user.getResource());
        user.resetResource();
    }
    
}
