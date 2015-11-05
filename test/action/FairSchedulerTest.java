package action;

import static org.junit.Assert.*;


import org.junit.Test;


public class FairSchedulerTest extends SchedulerTest {
		
	@Override
	public Scheduler createScheduler(Action action) {
		return new FairScheduler(action);
	}

	@Override
	public Scheduler createScheduler() {
		return new FairScheduler();
	}
	
	@Test(expected=ActionNotInitializedException.class)
	public void reallydoActionNotInitializedExceptionTest() throws ActionFinishedException, ActionNotInitializedException {
		FairScheduler f = new FairScheduler();
		f.reallyDoStep();
	}
	
	@Test
	public void reallyDoStepTest() throws ActionFinishedException, ActionNotInitializedException{
		Scheduler scheduler = createScheduler(action1);
		scheduler.addAction(action2);
		Scheduler scheduler2 = createScheduler(scheduler);
		scheduler2.addAction(action3);
		assertEquals(2, scheduler2.actions.size());
		assertEquals(2, scheduler.actions.size());
		
		scheduler2.reallyDoStep();
		
		assertEquals(2, scheduler2.actions.size());
		assertEquals(1, scheduler.actions.size());
		assertSame(scheduler, scheduler2.actions.get(0));
		assertSame(action2, scheduler.actions.get(0));
		assertSame(action3, scheduler2.actions.get(1));
		
		scheduler2.reallyDoStep();
		
		assertEquals(1, scheduler2.actions.size());
		assertEquals(1, scheduler.actions.size());
		assertSame(scheduler, scheduler2.actions.get(0));
		assertSame(action2, scheduler.actions.get(0));
		
		scheduler2.reallyDoStep();
		
		assertEquals(0, scheduler2.actions.size());
		assertEquals(0, scheduler.actions.size());
		
	}

}
