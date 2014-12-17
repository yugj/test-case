package test.algorithm;

import org.junit.Test;


/**
 * -2 11 -4 13 -5 -2
 * 最大子串
 * @author yugj
 * @date 2014年12月17日 上午9:25:16
 *
 */
public class MaxSubsequence {
	int[] arr = {-6, 2, 4, -7, 5, 3, 2, -1, 6 ,-9,10, -2};
	int[] arr2 = {-1,-2,-3,-4};
	
	@Test
	public void m1() { 
		int max = arr[0];int maxhead = 0; int maxtail =0;
		for(int i=0; i<arr.length; i++)  { 
			int temp = 0;int head = i; int tail = 0; int tempmax = arr[0];
			for(int j= i+1; j<arr.length; j++) { 
				temp += arr[j];
				if(temp > tempmax) { 
					tempmax = temp; tail = j;
				}
			}
			if(tempmax > max) { 
				max = tempmax; maxhead = head; maxtail = tail;
			}
		}
		System.out.println("max:" + max + " maxhead:" + maxhead + " maxtail:" + maxtail );
		for(int i= maxhead; i<=maxtail; i++) { 
			System.out.print(arr[i] + " ");
		}
	}
	
	@Test
	public void m2() {
		long maxSum = 0, thisSum = 0;
		for (int j = 0; j < arr.length; j++) {
			thisSum += arr[j];
			if (thisSum > maxSum)
				maxSum = thisSum;	//本次累加和大于最大和
			else if (thisSum < 0)
				thisSum = 0;	//累加和小于零，清零重算
		}
		System.out.println(maxSum);
	}
}
