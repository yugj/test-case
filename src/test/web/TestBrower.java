package test.web;

import java.io.IOException; //导入包 
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TestBrower extends JFrame { // 定义类
	JPanel contentPane;// 包含整个框架的容器
	BorderLayout borderLayoutAll = new BorderLayout();
	JLabel jLabelPrompt = new JLabel(); // 状态提示框
	JPanel jPanelMain = new JPanel(); // 包含地址栏和URL内容显示框的容器
	BorderLayout borderLayoutMain = new BorderLayout();
	JTextField textFieldURL = new JTextField();// 定义地址栏
	JEditorPane jEditorPane = new JEditorPane(); // URL内容显示窗口

	public TestBrower() { // 构造函数
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception { // 界面初始化
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(borderLayoutAll);
		jPanelMain.setLayout(borderLayoutMain);
		jLabelPrompt.setText("简单的HTML浏览器，请在text框内输入完整的URL");
		textFieldURL.setText(""); // 开始运行时，清空地址栏
		textFieldURL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) { // 输入URL，回车后执行
				textFieldURL_actionPerformed(e);
			}
		});
		jEditorPane.setEditable(false); // 网页显示部分不可修改
		jEditorPane
				.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
					public void hyperlinkUpdate(HyperlinkEvent e) {
						jEditorPane_hyperlinkUpdate(e); // 点击超级连接后执行
					}
				});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(jEditorPane);
		jPanelMain.add(textFieldURL, "North");
		jPanelMain.add(scrollPane, "Center");
		contentPane.add(jLabelPrompt, "North");
		contentPane.add(jPanelMain, "Center");
		enableEvents(AWTEvent.WINDOW_EVENT_MASK); // 启动事件监视
		this.setSize(new Dimension(600, 500)); // 窗口大小
		this.setTitle("网页浏览器"); // 设置标题
		this.setVisible(true); // 显示窗口
	}

	void textFieldURL_actionPerformed(ActionEvent e) {
		try {
			jEditorPane.setPage(textFieldURL.getText()); // 显示URL内容
		} catch (IOException ex) {
			JOptionPane msg = new JOptionPane();
			JOptionPane.showMessageDialog(this, "不正确的URL地址"
					+ textFieldURL.getText(), "不正确的输入", 0);
		}
	}

	void jEditorPane_hyperlinkUpdate(HyperlinkEvent e) {
		if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
			try {
				URL url = e.getURL(); // 获得最新URL
				jEditorPane.setPage(url); // 显示超级连接内容
				textFieldURL.setText(url.toString()); // 修改地址栏
			} catch (IOException io) {
				JOptionPane msg = new JOptionPane();
				JOptionPane.showMessageDialog(this, "不能打开连接", "不正确的输入", 0);
			}
		}
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) { // 关闭窗口
			System.exit(0); // 退出
		}
	}

	public static void main(String[] args) { // 主函数
		new TestBrower();
	}
}