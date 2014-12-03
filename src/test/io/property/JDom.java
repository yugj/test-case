package test.io.property;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class JDom {
	public static void main(String[] args) throws Exception {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(JDom.class.getClassLoader()
				.getResourceAsStream("test.xml")); // �����ĵ�����
		Element root = doc.getRootElement(); // ��ȡ��Ԫ��
		List list = root.getChildren("disk");// ȡ����Ϊdisk������Ԫ��
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element) list.get(i);
			String name = element.getAttributeValue("name");
			String capacity = element.getChildText("capacity");// ȡdisk��Ԫ��capacity������
			String directories = element.getChildText("directories");
			String files = element.getChildText("files");
			System.out.println("������Ϣ:");
			System.out.println("�����̷�:" + name);
			System.out.println("��������:" + capacity);
			System.out.println("Ŀ¼��:" + directories);
			System.out.println("�ļ���:" + files);
			System.out.println("-----------------------------------");
		}
	}
}