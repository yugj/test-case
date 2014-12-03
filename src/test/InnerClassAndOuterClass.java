package test;

public class InnerClassAndOuterClass {
	// �ڲ���
	private class InterClass {
		InterClass() {
			System.out.println("InterClass Create");
		}
	}

	// ���캯��
	public InnerClassAndOuterClass() {
		InterClass ic = new InterClass();
		System.out.println("OuterClass Create");
	}

	public static void main(String[] args) {
		InnerClassAndOuterClass oc = new InnerClassAndOuterClass();
	}
}
