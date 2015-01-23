package test.thread.account;

class Account {
    String name;
    float amount;
    
    
    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public  void deposit(float amt) {
        float tmp = amount;
        tmp += amt;
        
        try {
            Thread.sleep(100);//ģ��������������Ҫ��ʱ�䣬����ˢ�����ݿ��
        } catch (InterruptedException e) {
            // ignore
        }
        
        amount = tmp;
    }

    public  void withdraw(float amt) {
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
 * ��ͬ����1000���̶߳�account���Ӽ�100����
 * ���սṹ����ԭ��ֵ
 * @author yugj
 * @date 2015��1��23�� ����10:11:05
 *
 */
public class AccountTest{
    private static int NUM_OF_THREAD = 1000;
    static Thread[] threads = new Thread[NUM_OF_THREAD];
    
    public static void main(String[] args){
        final Account acc = new Account("John", 1000.0f);
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
                threads[i].join(); //�ȴ������߳����н���
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }

}