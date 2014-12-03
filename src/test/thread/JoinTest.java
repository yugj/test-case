package test.thread;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new T());
		t.run();
		t.join();
		System.out.println("t end ...");
		
	}

}


class T implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
}