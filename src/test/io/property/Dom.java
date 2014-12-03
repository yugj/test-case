package test.io.property;
/**
 * 通过dom读取xml不需要引入jar包
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
        //得到DOM解析器的工厂实例  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        //从DOM工厂中获得DOM解析器  
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();  
        //声明为File为了识别中文名  
        Document doc = null; 
        String url = "G:/javaweb/readXML/src/test.xml";
       // String url2 = Dom.class.getClass().getClassLoader().getResourceAsStream("").toString();
        doc = dbBuilder.parse(url);  
          
        //得到文档名称为Student的元素的节点列表  
        NodeList list = doc.getElementsByTagName("disk");  
          
        //遍历该集合，显示结合中的元素及其子元素的名字  
        for(int i = 0; i< list.getLength() ; i ++){  
            Element element = (Element)list.item(i);  
            String name=element.getAttribute("name");  
            String capacity=element.getElementsByTagName("capacity").item(0).getFirstChild().getNodeValue();  
            String directories=element.getElementsByTagName("directories").item(0).getFirstChild().getNodeValue();  
            String files=element.getElementsByTagName("files").item(0).getFirstChild().getNodeValue();  
            System.out.println("磁盘信息:");   
            System.out.println("分区盘符:"+name);   
            System.out.println("分区容量:"+capacity);   
            System.out.println("目录数:"+directories);   
            System.out.println("文件数:"+files);   
            System.out.println("-----------------------------------");   
        }        
    }  
 }  