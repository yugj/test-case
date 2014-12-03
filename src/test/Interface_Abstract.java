package test;

public class Interface_Abstract {

}
/**
 * 接口里面的方法都是抽象的
 * 成员变量必须赋值
 * 而且为public static final，如果没显示这么设，将自动转化
 * @author ygj
 *
 */
interface Inte {
	abstract void t();
	public void tet();
	/*public void test2() {
		
	}*/

}
/**
 * 当一个类中含有抽象类该类必须定义成抽象类
 * @author ygj
 *
 */
abstract class Abst {
	
	abstract void t();
	public void f() {

	}
}

class ExtendsAbst extends Abst {
	public  void t() {
		
	}
}
