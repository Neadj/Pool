package action;

import static org.junit.Assert.*;
import java.util.*;

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

}
