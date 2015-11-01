package action;

import static org.junit.Assert.*;

import org.junit.*;

public abstract class ActionTest {
	abstract public Action createAction();
	abstract public Action createFinishedAction() throws ActionFinishedException;
	
	@Test
	public void onlyOneValidStateEachMoment() throws ActionFinishedException{
		Action a=this.createAction();
		assertTrue(a.isReady());
		assertFalse(a.isInProgress());
		assertFalse(a.isFinished());
		
		while(!a.isFinished()){
			a.doStep();
			assertFalse(a.isReady());
			assertTrue(a.isFinished() == (!a.isInProgress()));
		}
		assertFalse(a.isReady());
		assertFalse(a.isInProgress());
		assertTrue(a.isFinished());
		
	}
	
	@Test(expected=ActionFinishedException.class)
	public void doStepTest() throws ActionFinishedException{
		Action finishedAction = createFinishedAction();
		assertTrue(finishedAction.isFinished());
		finishedAction.doStep();
	}
	
}


