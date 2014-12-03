package test.sort;

public class SelectSort {
	public static int[] selectSort(int[] a) {
		int temp = 0;
		int position = 0;

		for (int i = 0; i < a.length; i++) {
			position = i;
			int j = i + 1;
			for (; j < a.length; j++) {
				if (a[position] > a[j]) {
					position = j;
				}
			}

			temp = a[i];
			a[i] = a[position];
			a[position] = temp;
		}
		return a;
	}
}
