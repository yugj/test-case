package test.io;

import java.net.URL;

import org.junit.Test;

public class PathGetter {
	@Test
	public void getPath() { 
		  // �����֣�  file:/D:/git/daotie/daotie/target/classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);


        // �����֣� D:\git\daotie\daotie
        System.out.println(System.getProperty("user.dir"));
        /*
         * ����� C:\Documents and Settings\Administrator\workspace\projectName
         * ��ȡ��ǰ����·��
         */

        // �����֣�  ��ȡ���е���·�� ����jar����·��
        System.out.println(System.getProperty("java.class.path"));
	}
}
