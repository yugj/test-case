package test.javabasic;
import java.util.LinkedList;
import java.util.Random;


public class RandomSort {
	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<32; i++) {
			list.add(i);
		}
		
		int grop[] = new int[32];
		for(int i=0; i<32; i++) {
			grop[i] = 0;
		}
		
		Random rand = new Random();
		for(int i=0; i<32; i++) {
			int temp = rand.nextInt(32-i);
			grop[i] = (int)list.get(temp);
			list.remove(temp);
		}
		
		for(int i=0; i<32; i++) {
			if(i<30 && i%5==0) {
				System.out.println();
			}
			System.out.print(grop[i] + " ");
		}
	}

}
