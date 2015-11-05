package action;



import org.junit.Before;
import org.junit.Test;

import resources.Basket;
import resources.BasketPool;
import resources.ResourcePool;
import resources.ResourcefulUser;

public abstract class ResourcePoolActionTest extends ActionTest {

	protected ResourcefulUser<Basket> basketUser;
	protected BasketPool baskets;
	protected ResourcePoolAction<Basket> resourcePoolAction;
	
	@Before
	public void setUp(){
		basketUser = new ResourcefulUser<>();
		baskets = new BasketPool(6);
		resourcePoolAction = createAction(baskets, basketUser);
	}
		

	public abstract ResourcePoolAction<Basket> createAction(ResourcePool<Basket> pool, ResourcefulUser<Basket> user);
	
	@Test
	public void isReadyTest()
	{
		assert(resourcePoolAction.isReady());
	}
	
	@Test
	public void isFinishedTest()
	{
		assert(resourcePoolAction.isFinished());
	}
	
	@Override
	public Action createAction() {
		return this.resourcePoolAction;
	}
	

	@Override
	public Action createFinishedAction() throws ActionFinishedException, ActionNotInitializedException {
		this.resourcePoolAction.doStep();
		return this.resourcePoolAction;
	}

}
