package action;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.BasketPool;
import resources.CubiclePool;

public class PoolTest {

	@Test
	public void test() throws ActionFinishedException, ActionNotInitializedException {
		BasketPool baskets = new BasketPool(6);
        CubiclePool cubicles = new CubiclePool(3);
        FairScheduler s = new FairScheduler();

        s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
        s.addAction(new Swimmer("Louis", baskets, cubicles, 2, 10, 4));
        s.addAction(new Swimmer("Maé", baskets, cubicles, 10, 18, 10));
        s.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
        s.addAction(new Swimmer("Louison", baskets, cubicles, 18, 3, 3));
        s.addAction(new Swimmer("Charlie", baskets, cubicles, 3, 6, 10));
        s.addAction(new Swimmer("Alexis", baskets, cubicles, 6, 5, 7));
        
        int nbSteps = 0;
        while (!s.isFinished()) {
            nbSteps++;
            s.doStep();
        }
        assertEquals(242, nbSteps);
	}

}
