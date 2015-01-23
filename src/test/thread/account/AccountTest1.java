package test.thread.account;

class Account1 {
    String name;
    float amount;
    
    
    public Account1(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public  synchronized void deposit(float amt) {
        float tmp = amount;
        tmp += amt;
        
        try {
            Thread.sleep(100);//模拟其它处理所需要的时间，比如刷新数据库等
        } catch (InterruptedException e) {
            // ignore
        }
        
        amount = tmp;
    }

    public  synchronized void withdraw(float amt) {
        float tmp = amount;
        tmp -= amt;

        try {
            Thread.sleep(100);//模拟其它处理所需要的时间，比如刷新数据库等
        } catch (InterruptedException e) {
            // ignore
        }        

        amount = tmp;
    }

    public float getBalance() {
        return amount;
    }
}


/**
 * 在方法家synchronized 1000个线程对account1做加减100操作
 * 结果为预期原来的值
 * @author yugj
 * @date 2015年1月23日 上午10:11:05
 *
 */
public class AccountTest1{
    private static int NUM_OF_THREAD = 1000;
    static Thread[] threads = new Thread[NUM_OF_THREAD];
    
    public static void main(String[] args){
        final Account1 acc = new Account1("John", 1000.0f);
        for (int i = 0; i< NUM_OF_THREAD; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    acc.deposit(100.0f);
                    acc.withdraw(100.0f);
                }
            });
            threads[i].start();
        }

        for (int i=0; i<NUM_OF_THREAD; i++){
            try {
            	System.out.println("thread prepare join : " + i);
                threads[i].join(); //等待所有线程运行结束
                System.out.println("thread join : " + i);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }

}