package action;

import resources.*;

/**
 * The Class FreeResourceAction.
 * It makes a ResourcefulUser free its currently held resource into the ResourcePool that was associated.
 * 
* @param <R> the generic resource type
 */
public class FreeResourceAction<R extends Resource> extends ResourcePoolAction<R> {

    /**
     * Instantiates a new free resource action.
     *
     * @param pool the pool
     * @param user the user
     */
    public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
        super(pool, user);

    }

    /**
     * Really do a step. Thats mean free a resource and display a sentence
     * which reported it. Then, the resource is finished.
     */
    @Override
    protected void reallyDoStep() {
        R res = user.getResource();

        System.out.println("freeing resource from pool " + res.description() + "...");

        if (res != null) {
            this.pool.freeResource(res);
            this.user.resetResource();
            this.isReady = false;
            this.isFinished = true;
        }

    }

}
