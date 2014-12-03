package test.web;

import java.io.IOException; //����� 
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TestBrower extends JFrame { // ������
	JPanel contentPane;// ����������ܵ�����
	BorderLayout borderLayoutAll = new BorderLayout();
	JLabel jLabelPrompt = new JLabel(); // ״̬��ʾ��
	JPanel jPanelMain = new JPanel(); // ������ַ����URL������ʾ�������
	BorderLayout borderLayoutMain = new BorderLayout();
	JTextField textFieldURL = new JTextField();// �����ַ��
	JEditorPane jEditorPane = new JEditorPane(); // URL������ʾ����

	public TestBrower() { // ���캯��
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception { // �����ʼ��
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(borderLayoutAll);
		jPanelMain.setLayout(borderLayoutMain);
		jLabelPrompt.setText("�򵥵�HTML�����������text��������������URL");
		textFieldURL.setText(""); // ��ʼ����ʱ����յ�ַ��
		textFieldURL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) { // ����URL���س���ִ��
				textFieldURL_actionPerformed(e);
			}
		});
		jEditorPane.setEditable(false); // ��ҳ��ʾ���ֲ����޸�
		jEditorPane
				.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
					public void hyperlinkUpdate(HyperlinkEvent e) {
						jEditorPane_hyperlinkUpdate(e); // ����������Ӻ�ִ��
					}
				});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(jEditorPane);
		jPanelMain.add(textFieldURL, "North");
		jPanelMain.add(scrollPane, "Center");
		contentPane.add(jLabelPrompt, "North");
		contentPane.add(jPanelMain, "Center");
		enableEvents(AWTEvent.WINDOW_EVENT_MASK); // �����¼�����
		this.setSize(new Dimension(600, 500)); // ���ڴ�С
		this.setTitle("��ҳ�����"); // ���ñ���
		this.setVisible(true); // ��ʾ����
	}

	void textFieldURL_actionPerformed(ActionEvent e) {
		try {
			jEditorPane.setPage(textFieldURL.getText()); // ��ʾURL����
		} catch (IOException ex) {
			JOptionPane msg = new JOptionPane();
			JOptionPane.showMessageDialog(this, "����ȷ��URL��ַ"
					+ textFieldURL.getText(), "����ȷ������", 0);
		}
	}

	void jEditorPane_hyperlinkUpdate(HyperlinkEvent e) {
		if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
			try {
				URL url = e.getURL(); // �������URL
				jEditorPane.setPage(url); // ��ʾ������������
				textFieldURL.setText(url.toString()); // �޸ĵ�ַ��
			} catch (IOException io) {
				JOptionPane msg = new JOptionPane();
				JOptionPane.showMessageDialog(this, "���ܴ�����", "����ȷ������", 0);
			}
		}
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) { // �رմ���
			System.exit(0); // �˳�
		}
	}

	public static void main(String[] args) { // ������
		new TestBrower();
	}
}