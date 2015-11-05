package action;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.BasketPool;
import resources.Cubicle;
import resources.CubiclePool;

public class SwimmerTest {
	
	public Swimmer createSwimmer() {
		BasketPool baskets = new BasketPool(1);
		CubiclePool cubicles = new CubiclePool(1);
		return new Swimmer("Swimmer", baskets, cubicles, 1, 1, 1);
	}

	@Test
	public void testNbStepsAccurate() throws ActionFinishedException, ActionNotInitializedException {
		Swimmer s = createSwimmer();
		int nbSteps = 0;
		while (!s.isFinished()) {
			s.doStep();
			nbSteps++;
		}
		assertEquals(9, nbSteps);
	}
}
