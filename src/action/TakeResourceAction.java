package action;

import resources.*;
import java.util.NoSuchElementException;

/**
 * The Class TakeResourceAction.
 *
 * @param <R> the generic type
 */
public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<R> {

	/**
	 * Instantiates a new take resource action.
	 *
	 * @param pool the pool
	 * @param user the user
	 */
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	@Override
	protected void reallyDoStep() {
		
		if(user.getResource() == null){
			try{
				R res = this.pool.provideResource();
			this.user.setResource(res);
			System.out.println("success");
			this.isReady=false;
			this.isFinished=true;
			}catch (NoSuchElementException e){
				System.out.println("failed");} 
		}
		
	}
}