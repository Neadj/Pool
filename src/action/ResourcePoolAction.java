package action;
import resources.*;

/*
 * The Class ResourcePoolAction.
 *
 * @param <R> the generic type
 */
public abstract class ResourcePoolAction <R extends Resource>extends Action{
	
	/** The pool. */
	protected final ResourcePool<R> pool;
	
	/** The user. */
	protected final ResourcefulUser<R> user;
	
	/** The booleans isReady and isFinished. */
	protected boolean isReady, isFinished;
	
	/**
	 * Instantiates a new resource pool action.
	 *
	 * @param pool the pool
	 * @param user the user
	 */
	public ResourcePoolAction(ResourcePool<R>pool,ResourcefulUser<R>user)
	{
		this.pool=pool;
		this.user=user;
		this.isReady=true;
		this.isFinished=false;
	}
	
	/**
	 * Says if a ResourcePoolAction is ready or not.
	 * @return true if it's ready else false
	 */
	public boolean isReady()
	{
		return this.isReady;
	}
	
	/**
	 * Says if a ResourcePoolAction is Finished or not.
	 * @return true if it's Finished else false
	 */
	public boolean isFinished()
	{
		return this.isFinished;
	}

	/**
	 * Really do a step.
	 */
	protected abstract void reallyDoStep();

}
