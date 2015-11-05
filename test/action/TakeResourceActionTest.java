package action;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.Basket;
import resources.ResourcePool;
import resources.ResourcefulUser;


public class TakeResourceActionTest extends ResourcePoolActionTest {
	
	protected ResourcePoolAction<Basket> r;
	protected Basket b ;
	
	@Override
	public ResourcePoolAction<Basket> createAction(ResourcePool<Basket> pool,
			ResourcefulUser<Basket> user) {
		return new TakeResourceAction<>(pool, user);
	}

	
	@Test
	public void reallyDoStepTest() throws ActionFinishedException, ActionNotInitializedException{
		resourcePoolAction.doStep();
		assertTrue(resourcePoolAction.isFinished());
		assertFalse(resourcePoolAction.isReady());
		assertNotNull(basketUser.getResource());
		Basket basket = basketUser.getResource();
		assertTrue(this.baskets.ressourceIsUnavailable(basket));
		
	}

}

	