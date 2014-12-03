package test.str;

public class TestEquals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = new String("hello");
		String b = new String("hello");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		
		Cat cat1 = new Cat();
		Cat cat2 = new Cat();
		cat1.name = "cc";
		cat2.name = "cc";
		System.out.println("****************************");
		System.out.println(cat1 == cat2);
		System.out.println(cat1.equals(cat2));
		System.out.println(cat1.name == cat2.name);
		System.out.println(cat1.name.equals(cat2.name));
	}

}

class Cat {
	String name;
}
