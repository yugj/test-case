package test;
//LoginFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyJPanel extends JPanel implements ActionListener {
	private int count = 0;
	private JLabel label1, label2;
	private JTextField text;
	private JPasswordField pass;
	private JButton button1, button2;

	MyJPanel() {
		label1 = new JLabel("�û���");
		label2 = new JLabel("��    ��");
		button1 = new JButton("ȷ��");
		button2 = new JButton("ȡ��");
		text = new JTextField(20);
		pass = new JPasswordField(20);
		button1.setMnemonic(KeyEvent.VK_O);// ���ð�ť��ݼ�
		button2.setMnemonic(KeyEvent.VK_C);
		button1.setActionCommand("entry");
		button2.setActionCommand("cancel");
		button1.addActionListener(this);// ע�ᰴť�¼�
		button2.addActionListener(this);// ע�ᰴť�¼�
		setBackground(Color.cyan);// �趨��屳��ɫ
		add(label1);
		add(text);
		add(label2);
		add(pass);
		add(button1);
		add(button2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("entry")) {
			count++; // ����
			String username, password;
			if (count < 3) {
				username = text.getText();
				password = pass.getText();
				if (username.equals("abcd") && password.equals("123456")) {
					text.setText("�û�����������ȷ!");
					pass.setText("");
				} else {
					text.setText("");
					pass.setText("");
				}

			} else
				System.exit(0);// �˳�����
		} else
			System.exit(0);// �˳�����
	}
}

public class Login extends JFrame {
	public static void main(String[] args) {
		MyJPanel jp = new MyJPanel();// �������
		jp.setBorder(BorderFactory.createTitledBorder("�����û���������"));// �趨�߽�
		JFrame frame = new JFrame("�û���¼");
		frame.setBounds(300, 300, 300, 150);
		frame.setContentPane(jp);// �ڿ���м������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ÿ�ܹرհ�ť�¼�
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
