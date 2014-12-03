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
		 setSize(640, 480);      setTitle("百度:中国最大的搜索引擎");  
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	      JEditorPane editorPane = new JEditorPane();  
	      JScrollPane scrollPane = new JScrollPane(editorPane);  
	      editorPane.setEditable(false);  
 
	      //要能响应网页中的链接，则必须加上超链监听器  
	      editorPane.addHyperlinkListener(this);  
	      String path = "http://www.baidu.com";  
	      try  
	      {  
	         editorPane.setPage(path);  
	      }  
	      catch (IOException e)  
	      {  
	         System.out.println("读取页面 " + path + " 出错. " + e.getMessage());  
	      }  
	      Container container = getContentPane();  
	      container.setBackground(Color.WHITE);
	      //让editorPane总是填满整个窗体  
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
 
 
	  //超链监听器，处理对超级链接的点击事件，但对按钮的点击还捕获不到  
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