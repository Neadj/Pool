package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class SchedulerTest extends ActionTest {
	
	OneStepAction action1;
	OneStepAction action2;
	OneStepAction action3;
	
	@Before
	public void setUp() throws Exception {
		action1 = new OneStepAction();
		action2 = new OneStepAction();
		action3 = new OneStepAction();
	}
	
	abstract public Scheduler createScheduler(Action action);
	abstract public Scheduler createScheduler();
	
	@Test 
	public void withOneStepAction() throws ActionFinishedException, ActionNotInitializedException{
		Scheduler scheduler = createScheduler(action1);
		
		assertFalse(scheduler.isFinished());
		assertFalse(action1.isFinished());
		
		scheduler.doStep();
		
		assertTrue(scheduler.isFinished());
		assertTrue(action1.isFinished());
		
	}
	
	@Test
	public void testAddAction() {	
		Scheduler scheduler = createScheduler();
		
		scheduler.addAction(action1);
		
		assertSame(action1,scheduler.actions.get(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddActionSchedulerIsFinished() throws ActionFinishedException, ActionNotInitializedException{
		Scheduler scheduler = createScheduler(action1);
		scheduler.doStep();
		scheduler.addAction(action2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddActionAddSchedulerIsFinished() throws ActionFinishedException, ActionNotInitializedException{
		Scheduler scheduler = createScheduler(action1);
		Scheduler scheduler1 = createScheduler(action1);
		scheduler1.doStep();
		scheduler.addAction(scheduler1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddActionAddSchedulerIsNotReady() throws ActionFinishedException, ActionNotInitializedException{
		Scheduler scheduler = createScheduler(action1);
		Scheduler scheduler1 = createScheduler(action1);
		scheduler1.doStep();
		scheduler1.isReady = false;
		scheduler.addAction(scheduler1);
	}
	
	
	@Test
	public void testRemoveAction() 
	{
		Scheduler scheduler = createScheduler(action1);
		scheduler.removeAction(action1);
		
		assertTrue(scheduler.actions.isEmpty());
	}
	
	@Override
	public Action createFinishedAction() throws ActionFinishedException, ActionNotInitializedException {
		Scheduler scheduler = createScheduler(action1);
		scheduler.doStep();
		return scheduler;
	}
	
	@Override
	public Action createAction() {
		Scheduler scheduler = createScheduler(action1);
		scheduler.addAction(new OneStepAction());
		Scheduler scheduler2 = createScheduler(scheduler);
		scheduler2.addAction(new OneStepAction());
		return scheduler2;
	}

}
