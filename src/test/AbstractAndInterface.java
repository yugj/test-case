package test;

public class AbstractAndInterface implements B,C{

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}


interface A extends B,C{
	
}

interface B {
	void test();
	int a = 2;//默认转化为public final
}

interface C {
	void test();
}

abstract interface D {
	void t();
}

abstract class E {
	
}


