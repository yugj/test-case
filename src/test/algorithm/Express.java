package test.algorithm;

public class Express {  
    
    private int n ; //�ʺ����  
    private int[] x ; //��ǰ��  
    private long sum ; //��ǰ���ҵ��Ŀ��з�����  
    private static int h ;      //��¼������������  
  
    public Express(){  
        this.sum = 0 ;  //��ʼ��������Ϊ1�������ݵ���ѷ�����ʱ�򣬾�����1  
        this.n = 8 ;    //��n�ʺ����⣬���Լ�����  
        this.x = new int[n+1];  //x[i]��ʾ�ʺ�i�������̵ĵ�i�еĵ�x[i]��  
        h = 1 ; //������Ҷ��ⶨ��ı��������ڱ��������ĸ������뿴backTrace()��h���������ã����ｫ������Ϊstatic��̬����  
    }  
  
    public boolean place (int k){  
        for (int j = 1 ; j < k ; j++){  
            //�����Ҫ��ˢѡ���ϻʺ������Ľ⣬��Ϊ�ʺ���Թ�����֮ͬһ��ͬһ�еĻ�ͬһб���ϵ�����  
            if ( (Math.abs(k - j)) == (Math.abs(x[j]-x[k])) || (x[j] == x[k]) ){  
                return false ;  //�������֮ͬһ��ͬһ�еĻ�ͬһб���ϵ����ӣ�����false;  
            }  
        }  
        return true ;//���������֮ͬһ��ͬһ�еĻ�ͬһб���ϵ����ӣ�����true;  
    }  
      
    public void backTrace (int t){  
        if (t > n){ //��t>nʱ,�㷨������Ҷ�ڵ㣬�õ�һ���µ�n�ʺ󻥲��������÷�������������1  
            sum ++ ;    //����������1  
            System.out.println ("����" + (h++) + "");  
            show(x);  
            System.out.print ("/n----------------/n");//�����ķָ���  
        }else { //��t<=nʱ����ǰ��չ�Ľ��Z�ǽ�ռ��е��ڲ���㣬�ýڵ���x[i]=1,2����,n��n���ӽ�㣬  
                //���ڵ�ǰ��չ���Z��ÿһ�����ӽ�㣬��place()�������������ԣ�  
                //����������ȵķ�ʽ�ݹ�ضԿ����������������ȥ����������  
            for (int i = 1 ; i <= n ; i++){  
                x[t] = i ;    
                if (place (t)){     //������Ƿ��������  
                    backTrace (t+1);    //�ݹ����                
                }  
            }  
        }  
    }  
      
    public void print (int[] a){    //��ӡ���飬ûɶ��  
        for (int i = 1 ; i < a.length ; i++){  
            System.out.print ("�ʺ�" + i + "��" + i + "��" +a[i] + "�С�");  
        }  
    }  
    
    public void show( int [] a)  { 
    	System.out.println();
    	for(int i = 1; i< a.length; i++) { 
    		for(int j = 1; j< a.length; j++)  { 
    			if(a[i] != j) { 
    				System.out.print(" * ");
    			} else { 
    				System.out.print(" Q ");
    			}
    		} System.out.println();
    	}
    }
      
    public static void main (String[] args){  
        Express em = new Express();  
        em.backTrace(1);    //��1��ʼ����  
        System.out.println ("/n��ϸ����������ʾ��"+"���и���Ϊ:" + em.sum);  
    }  
}

/*output:�˻ʺ�����ֻ��92�ַ���������ֻ�������е��������� 
����1 
�ʺ�1��1��1�С��ʺ�2��2��5�С��ʺ�3��3��8�С��ʺ�4��4��6�С��ʺ�5��5��3�С��ʺ�6��6��7�С��ʺ�7��7��2�С��ʺ�8��8��4�С� 
---------------- 
����2 
�ʺ�1��1��1�С��ʺ�2��2��6�С��ʺ�3��3��8�С��ʺ�4��4��3�С��ʺ�5��5��7�С��ʺ�6��6��4�С��ʺ�7��7��2�С��ʺ�8��8��5�С� 
---------------- 
        . 
        . 
        . 
����92 
�ʺ�1��1��8�С��ʺ�2��2��4�С��ʺ�3��3��1�С��ʺ�4��4��3�С��ʺ�5��5��6�С��ʺ�6��6��2�С��ʺ�7��7��7�С��ʺ�8��8��5�С� 
---------------- 
*///~  
