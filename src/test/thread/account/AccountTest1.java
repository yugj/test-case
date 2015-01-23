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
            Thread.sleep(100);//ģ��������������Ҫ��ʱ�䣬����ˢ�����ݿ��
        } catch (InterruptedException e) {
            // ignore
        }
        
        amount = tmp;
    }

    public  synchronized void withdraw(float amt) {
        float tmp = amount;
        tmp -= amt;

        try {
            Thread.sleep(100);//ģ��������������Ҫ��ʱ�䣬����ˢ�����ݿ��
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
 * �ڷ�����synchronized 1000���̶߳�account1���Ӽ�100����
 * ���ΪԤ��ԭ����ֵ
 * @author yugj
 * @date 2015��1��23�� ����10:11:05
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
                threads[i].join(); //�ȴ������߳����н���
                System.out.println("thread join : " + i);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }

}