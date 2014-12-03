package test.javabasic;

public class Runable{

	
	public static void main(String[] args) {
		//new Thread(new TestAscii()).start();
	}

}

class Test implements Runnable{

	@Override
	public void run() {
		System.out.println("run");
	}
	
}
