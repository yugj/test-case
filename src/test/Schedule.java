package test;
import java.util.TimerTask;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

class MySchedule extends TimerTask {

    @Override
    public void run() {
    	try {
			String str = "G:\\napianhai.mp3";
			String str2 = "G:\\SuperCommTool.exe";
			Runtime.getRuntime().exec("cmd /c start shutdown -s -t 5");

		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

}

public class Schedule {

    public static void main(String[] args) {
        Timer task = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
			date = sdf.parse("2013-06-16 03:00:00");
		} catch (ParseException e) {
			System.out.println("日期格式错误;参照：2012-11-29 21:44:00");
			e.printStackTrace();
		}
        task.schedule(new MySchedule(), date);
        
       
    }

}