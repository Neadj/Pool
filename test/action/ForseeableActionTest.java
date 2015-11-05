package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ForseeableActionTest extends ActionTest {
	
	protected ForseeableAction atest;
	
	public Action createAction(){
		return atest;
	}
	
	@Before
	public void initialized(){
		atest = new ForseeableAction(10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ForseeableActionExceptionIfRemaimingNotCorrect(){
		new ForseeableAction(0);
	}
	
	@Test
	public void onlyOneValidStateEachMomentForseeableableActionTest() throws ActionFinishedException, ActionNotInitializedException{		
		this.onlyOneValidStateEachMoment();
	}
	
	@Test
	public void reallyDoStepTest(){
		for(int i = 9; i >=0; i--){
			atest.reallyDoStep();
			assertEquals(i, atest.remainingTime);
		}
	}

	@Override
	public Action createFinishedAction() throws ActionFinishedException, ActionNotInitializedException {
		for (int i = 0; i < 10; i++) {
			atest.doStep();
		}
		return atest;
	}
}
