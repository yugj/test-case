package test.io.property;
/**
 * ͨ��dom��ȡxml����Ҫ����jar��
 * @author ygj
 *
 */
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NodeList;  
  
public class Dom {  
      
    public static void main(String[] args)throws Exception {  
        //�õ�DOM�������Ĺ���ʵ��  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        //��DOM�����л��DOM������  
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();  
        //����ΪFileΪ��ʶ��������  
        Document doc = null; 
        String url = "G:/javaweb/readXML/src/test.xml";
       // String url2 = Dom.class.getClass().getClassLoader().getResourceAsStream("").toString();
        doc = dbBuilder.parse(url);  
          
        //�õ��ĵ�����ΪStudent��Ԫ�صĽڵ��б�  
        NodeList list = doc.getElementsByTagName("disk");  
          
        //�����ü��ϣ���ʾ����е�Ԫ�ؼ�����Ԫ�ص�����  
        for(int i = 0; i< list.getLength() ; i ++){  
            Element element = (Element)list.item(i);  
            String name=element.getAttribute("name");  
            String capacity=element.getElementsByTagName("capacity").item(0).getFirstChild().getNodeValue();  
            String directories=element.getElementsByTagName("directories").item(0).getFirstChild().getNodeValue();  
            String files=element.getElementsByTagName("files").item(0).getFirstChild().getNodeValue();  
            System.out.println("������Ϣ:");   
            System.out.println("�����̷�:"+name);   
            System.out.println("��������:"+capacity);   
            System.out.println("Ŀ¼��:"+directories);   
            System.out.println("�ļ���:"+files);   
            System.out.println("-----------------------------------");   
        }        
    }  
 }  