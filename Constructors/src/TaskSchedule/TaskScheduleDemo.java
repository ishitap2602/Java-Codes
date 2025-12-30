package TaskSchedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduleDemo {
	 static class SystemTask implements Runnable{
		 @Override
		 public void run() {
			 System.out.println("Running background task running....");
		 }
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new SystemTask(), 0, 5, TimeUnit.SECONDS);
	}

}
