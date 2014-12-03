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
		label1 = new JLabel("用户名");
		label2 = new JLabel("密    码");
		button1 = new JButton("确定");
		button2 = new JButton("取消");
		text = new JTextField(20);
		pass = new JPasswordField(20);
		button1.setMnemonic(KeyEvent.VK_O);// 设置按钮快捷键
		button2.setMnemonic(KeyEvent.VK_C);
		button1.setActionCommand("entry");
		button2.setActionCommand("cancel");
		button1.addActionListener(this);// 注册按钮事件
		button2.addActionListener(this);// 注册按钮事件
		setBackground(Color.cyan);// 设定面板背景色
		add(label1);
		add(text);
		add(label2);
		add(pass);
		add(button1);
		add(button2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("entry")) {
			count++; // 计数
			String username, password;
			if (count < 3) {
				username = text.getText();
				password = pass.getText();
				if (username.equals("abcd") && password.equals("123456")) {
					text.setText("用户名及密码正确!");
					pass.setText("");
				} else {
					text.setText("");
					pass.setText("");
				}

			} else
				System.exit(0);// 退出程序
		} else
			System.exit(0);// 退出程序
	}
}

public class Login extends JFrame {
	public static void main(String[] args) {
		MyJPanel jp = new MyJPanel();// 定义面板
		jp.setBorder(BorderFactory.createTitledBorder("输入用户名和密码"));// 设定边界
		JFrame frame = new JFrame("用户登录");
		frame.setBounds(300, 300, 300, 150);
		frame.setContentPane(jp);// 在框架中加载面板
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置框架关闭按钮事件
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
