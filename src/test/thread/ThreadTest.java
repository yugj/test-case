package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadTest {
	
	//��̬������פ�ڴ�
	public static final ExecutorService threadPool = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		Long s = System.currentTimeMillis();
		String t_return = t.test();
		Long e = System.currentTimeMillis();
		System.out.println("���̷߳���:" + t_return);
		System.out.println("���߳�ִ��ʱ��:" + (e-s));
	}
	
	public String test() { 
		threadPool.execute(new TestThread());
		return "test end";
	}
	
	public String test2() { 
		TestThread t = new TestThread();
		new Thread(t).start();
		return "test2 end";
	}
}

class TestThread implements Runnable {
	@Override
	public void run() {
		Long s = System.currentTimeMillis();
		try {
			//this.wait(10000L);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("���߳̽���:" + (System.currentTimeMillis() - s));
	} 
	
}
