package action;

import org.junit.Before;

import resources.Resource;
import resources.ResourcePool;
import resources.ResourcefulUser;

public class FreeResourceActionTest <R extends Resource> extends ActionTest {
	protected FreeResourceAction<?> freeResAction;
	
	@Before
	public void init(ResourcePool<R> pool, ResourcefulUser<R> user){
		freeResAction = new FreeResourceAction<R>(pool, user);
	}
	
	@Override
	public Action createAction() {
		return freeResAction;
	}

	@Override
	public Action createFinishedAction() throws ActionFinishedException, ActionNotInitializedException {
		for (int i = 0; i < 10; i++) {
			freeResAction.doStep();
		}
		return freeResAction;
	}
}