package test.javabasic;

import util.Print;

public class StaticBlock_NoneStaticBlock {
	public static void main(String args[]) {
		//new TT().t();
		new TT().t();
	}
}

class TT {
	public void t(){System.out.println("t()");}
	
	{
		System.out.println("noneStatic block");
	}
	
	static {
		System.out.println("static block");
	}
	
}