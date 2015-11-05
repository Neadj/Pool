package action;

import resources.BasketPool;
import resources.CubiclePool;

public class SwimmerTest extends ActionTest {

	@Override
	public Action createAction() {
		BasketPool baskets = new BasketPool(1);
		CubiclePool cubicles = new CubiclePool(1);
		return new Swimmer("Swimmer", baskets, cubicles, 1, 1, 1);
	}

	@Override
	public Action createFinishedAction() throws ActionFinishedException, ActionNotInitializedException {
		Action a = createAction();
		while(!a.isFinished())
			a.doStep();
		return a;
	}

}
