package test;

public class InnerClassAndOuterClass {
	// 内部类
	private class InterClass {
		InterClass() {
			System.out.println("InterClass Create");
		}
	}

	// 构造函数
	public InnerClassAndOuterClass() {
		InterClass ic = new InterClass();
		System.out.println("OuterClass Create");
	}

	public static void main(String[] args) {
		InnerClassAndOuterClass oc = new InnerClassAndOuterClass();
	}
}
