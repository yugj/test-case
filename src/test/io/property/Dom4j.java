package test.io.property;
import java.util.Iterator;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  
  
public class Dom4j{     
   public static void main(String[] args) throws Exception {  
      
        //创建文件对象     
        java.io.File file=new java.io.File("G:/javaweb/readXML/src/test.xml");     
        //创建一个读取XML文件的对象     
        SAXReader reader=new SAXReader();     
        //创建一个文档对象     
        Document document=reader.read(file);     
        //获取文件的根节点     
        Element element=document.getRootElement();  
        for(Iterator i=element.elementIterator("disk");i.hasNext();){  
            //获取节点元素     
            element=(Element)i.next();  
            String name=element.attributeValue("name");  
            String capacity=element.elementText("capacity");//取disk子元素capacity的内容   
            String directories=element.elementText("directories");   
            String files=element.elementText("files");   
            System.out.println("磁盘信息:");   
            System.out.println("分区盘符:"+name);   
            System.out.println("分区容量:"+capacity);   
            System.out.println("目录数:"+directories);   
            System.out.println("文件数:"+files);   
            System.out.println("-----------------------------------");   
        }     
    }     
}    