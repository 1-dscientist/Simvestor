// Primary Author: Rushil Jayant
// p7
// 5/24/20
// 35th and final commit
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
// empty constructor
	public Timer() 
	{

	}
	// gets minute according to the LocalTime
	public int getMinute()
	{
		return myObj.getMinute();
	}
	// allows user to make transactions when the absolute minute changes
	public static void wait(int seconds) throws InterruptedException
	{
		Simvestor.txtBalance.setText(Portfolio.getDisplayValue());
		wait(60);
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