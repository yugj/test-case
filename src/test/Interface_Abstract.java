package test;

public class Interface_Abstract {

}
/**
 * �ӿ�����ķ������ǳ����
 * ��Ա�������븳ֵ
 * ����Ϊpublic static final�����û��ʾ��ô�裬���Զ�ת��
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
 * ��һ�����к��г����������붨��ɳ�����
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
