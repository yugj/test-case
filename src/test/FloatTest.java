package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FloatTest {
	public static void main(String[] args) {
		
		float a = 0.1f;
		
		double b = 0.1;

		System.out.println(0.030 * 100);// 输出3.0

		System.out.println(0.031 * 100);// 输出3.1

		System.out.println(0.032 * 100);// 输出3.2

		System.out.println(0.033 * 100);// 输出3.3000000000000003

		System.out.println(0.034 * 100);// 输出3.4000000000000004

		System.out.println(0.035 * 100);// 输出3.5000000000000004

		System.out.println(0.036 * 100);// 输出3.5999999999999996

		System.out.println(0.037 * 100);// 输出3.6999999999999997

		System.out.println(0.038 * 100);// 输出3.8

		System.out.println(0.039 * 100);// 输出3.9

		System.out.println(a == 0.1);
		
		System.out.println(b == 0.1);
		
		int[] aa = new int[10];
		
		Arrays.sort(aa);
	}

}
