package test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public static void main(String[] args) {
		Timer t = new Timer();
		Th tt = new Th();
		t.schedule(tt, 2L, 2L);
	}
}

class Th extends TimerTask {
	@Override
	public void run() {
		System.out.println("两秒一次" + TestTimer.df.format(new Date()));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("三秒打印" + TestTimer.df.format(new Date()));
	}

}
