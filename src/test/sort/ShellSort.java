package test.sort;
/**
 * ����˼�룺�㷨�Ƚ�Ҫ�����һ������ĳ������d
 * ��n/2,nΪҪ�������ĸ������ֳ������飬ÿ���м�¼���±����d.
 * ��ÿ����ȫ��Ԫ�ؽ���ֱ�Ӳ�������Ȼ������һ����С��������d/2��
 * �������з��飬��ÿ�����ٽ���ֱ�Ӳ������򡣵���������1ʱ��
 * ����ֱ�Ӳ���������������
 * @author ygj
 *
 */
public class ShellSort {
	// don't understand
	public static int[] shellSort(int[] a) {

		double d1 = a.length;
		int temp = 0;
		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1)
				break;
		}

		return a;

	}

}
