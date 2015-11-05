package action;

import static org.junit.Assert.*;


import org.junit.Test;

import resources.Basket;
import resources.ResourcePool;
import resources.ResourcefulUser;


public class FreeResourceActionTest extends ResourcePoolActionTest {
	
	@Override
	public ResourcePoolAction<Basket> createAction(ResourcePool<Basket> pool,
			ResourcefulUser<Basket> user) {
		TakeResourceAction<Basket> takeResourceAction = new TakeResourceAction<>(this.baskets, this.basketUser);
		try {
			takeResourceAction.doStep();
		} catch (ActionFinishedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ActionNotInitializedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FreeResourceAction<>(pool, user);
	}
	
	@Test
	public void reallyDoStepTest() throws ActionFinishedException, ActionNotInitializedException{
		TakeResourceAction<Basket> takeResourceAction = new TakeResourceAction<>(this.baskets, this.basketUser);
		takeResourceAction.doStep();
		
		Basket basket = basketUser.getResource();
		resourcePoolAction.doStep();
		assertTrue(resourcePoolAction.isFinished());
		assertFalse(resourcePoolAction.isReady());
		assertTrue(this.baskets.ressourceIsAvailable(basket));
		assertNull(basketUser.getResource());
	}

}

	


	
