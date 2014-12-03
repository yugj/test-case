package test.io.property;
import java.util.Iterator;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  
  
public class Dom4j{     
   public static void main(String[] args) throws Exception {  
      
        //�����ļ�����     
        java.io.File file=new java.io.File("G:/javaweb/readXML/src/test.xml");     
        //����һ����ȡXML�ļ��Ķ���     
        SAXReader reader=new SAXReader();     
        //����һ���ĵ�����     
        Document document=reader.read(file);     
        //��ȡ�ļ��ĸ��ڵ�     
        Element element=document.getRootElement();  
        for(Iterator i=element.elementIterator("disk");i.hasNext();){  
            //��ȡ�ڵ�Ԫ��     
            element=(Element)i.next();  
            String name=element.attributeValue("name");  
            String capacity=element.elementText("capacity");//ȡdisk��Ԫ��capacity������   
            String directories=element.elementText("directories");   
            String files=element.elementText("files");   
            System.out.println("������Ϣ:");   
            System.out.println("�����̷�:"+name);   
            System.out.println("��������:"+capacity);   
            System.out.println("Ŀ¼��:"+directories);   
            System.out.println("�ļ���:"+files);   
            System.out.println("-----------------------------------");   
        }     
    }     
}    