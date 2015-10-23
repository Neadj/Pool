package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ForseeableableActionTest extends ActionTest {
	
	protected ForseeableAction atest;
	
	public Action createAction(){
		return atest;
	}
	
	@Before
	public void initialized(){
		atest = new ForseeableAction(10);
	}
	
	@Test
	public void onlyOneValidStateEachMomentForseeableableActionTest() throws ActionFinishedException{
		
		this.onlyOneValidStateEachMoment();
	}
	
	@Test
	public void isReadyForseeableableActionTest() throws ActionFinishedException{
		assertTrue(atest.isReady());
		atest.doStep();
		assertFalse(atest.isReady());	
	}

	@Override
	public Action createFinishedAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
