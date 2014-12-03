package test.web;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
 
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
 
public class TestBrower2 extends JFrame implements HyperlinkListener{
	public TestBrower2() throws Exception {
		 setSize(640, 480);      setTitle("�ٶ�:�й�������������");  
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	      JEditorPane editorPane = new JEditorPane();  
	      JScrollPane scrollPane = new JScrollPane(editorPane);  
	      editorPane.setEditable(false);  
 
	      //Ҫ����Ӧ��ҳ�е����ӣ��������ϳ���������  
	      editorPane.addHyperlinkListener(this);  
	      String path = "http://www.baidu.com";  
	      try  
	      {  
	         editorPane.setPage(path);  
	      }  
	      catch (IOException e)  
	      {  
	         System.out.println("��ȡҳ�� " + path + " ����. " + e.getMessage());  
	      }  
	      Container container = getContentPane();  
	      container.setBackground(Color.WHITE);
	      //��editorPane����������������  
	      container.add(scrollPane, BorderLayout.CENTER);  
 
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestBrower2 wv = new TestBrower2();
		wv.setVisible(true);
 
	}
 
 
	  //����������������Գ������ӵĵ���¼������԰�ť�ĵ�������񲻵�  
	@Override
	   public void hyperlinkUpdate(HyperlinkEvent e)  
	   {  
	      if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)  
	      {  
	         JEditorPane pane = (JEditorPane) e.getSource();  
	         if (e instanceof HTMLFrameHyperlinkEvent)  
	         {  
	            HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent) e;  
	            HTMLDocument doc = (HTMLDocument) pane.getDocument();  
	            doc.processHTMLFrameHyperlinkEvent(evt);  
	         }  
	         else  
	         {  
	            try  
	            {  
	               pane.setPage(e.getURL());  
	            }  
	            catch (Throwable t)  
	            {  
	               t.printStackTrace();  
	            }  
	         }  
	      }  
	   }  
 
}