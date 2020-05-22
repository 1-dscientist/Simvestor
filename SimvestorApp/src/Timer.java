import java.time.LocalTime;
import java.lang.Object;
import java.util.concurrent.TimeUnit;

public class Timer {
	
	// Fields
	private LocalTime myObj = LocalTime.now();
	
	public Timer() {
		
	}
	
	public int getMinute()
	{
		return myObj.getMinute();
	}
	
	public void wait(int seconds)
	{
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String[] args)
//	{
//		Timer time = new Timer();
//		System.out.println(time.getMinute());
//		try {
//			TimeUnit.SECONDS.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(time.getMinute());
//	}
}
