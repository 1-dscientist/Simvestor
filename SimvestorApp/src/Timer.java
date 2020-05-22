import java.time.LocalTime;
import java.io.File;
import java.lang.Object;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Timer {

	// Fields
	private LocalTime myObj = LocalTime.now();

	public Timer() {

	}

	public int getMinute()
	{
		return myObj.getMinute();
	}

	public static void wait(int seconds)
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
