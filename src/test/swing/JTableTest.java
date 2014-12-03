package test.swing;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;					// 表格模板的定义在包javax.swing.table中
public class JTableTest{	
	JFrame f=new JFrame("表格JTable的用法");
	JLabel row=new JLabel("当前行是",JLabel.CENTER);
	JLabel col=new JLabel("当前列是",JLabel.CENTER);
	JLabel val=new JLabel("数据值是",JLabel.CENTER);
	Font ft=new Font("Serif",Font.BOLD,18);
	String []field={"姓名","语文","数学","英语"};// 定义表格的列标题
	Object [][]data={{"王建军","88","95","91"},{"刘国民","84","79","83"}};	// 定义表格的初始数据
	DefaultTableModel mod=new DefaultTableModel(data,field);	// 用field和data来定义表格模型
	JTable tab=new JTable(mod);			// 用模型mod来创建表格
	JScrollPane jsp=new JScrollPane();		// 创建一个滚动容器，因为表格本身没有滚动条
	JButton b1=new JButton("插入");
	JButton b2=new JButton("删除");
	JPanel pe=new JPanel(new GridLayout(3,1,10,30));
	JPanel ps=new JPanel(new GridLayout(1,2,30,10));
	void go(){
		f.getContentPane().add("Center",jsp);
		f.getContentPane().add("East",pe);
		f.getContentPane().add("South",ps);
		jsp.getViewport().add(tab);				// 将表格加到滚动容器jsp中
		pe.add(row);pe.add(col);pe.add(val);
		ps.add(b1);ps.add(b2);
		b1.addActionListener(new ButtonH(1));
		b2.addActionListener(new ButtonH(2));
		f.setSize(300,250);f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.setFont(ft);b2.setFont(ft);row.setFont(ft);
		col.setFont(ft);val.setFont(ft);tab.setFont(ft);
		// 将表格注册到监听器TableH中，它实现了接口MouseListener
    		tab.addMouseListener(new TableH());					
	}
	public static void main(String [] arg){
		JTableTest that=new JTableTest();
		that.go();
	}
	class ButtonH implements ActionListener{
		int sel;
		ButtonH(int select){
			sel=select;}
		public void actionPerformed(ActionEvent e){
			if(sel==1){								// 当按了“插入”按钮时
				Object[] dt={null,null,null,null};			// 定义一个空白行
				mod.addRow(dt);					// 在模型mod的末尾添加一行
			}
			if(sel==2)								// 当按了“删除”按钮时
				mod.removeRow(tab.getSelectedRow()); // 在模型mod中删除表格tab中的当前行
		}
	}
	class TableH extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			int rr,cc;String vv;
			rr=tab.getSelectedRow();					// 取表格tab中的当前行号
			cc=tab.getSelectedColumn();				// 取表格tab中的当前列号
			vv=(String)tab.getValueAt(rr,cc);	// 取表格tab中的第rr行、cc列的单元格的数据值
			row.setText("当前行是"+rr);
			col.setText("当前列是"+cc);
			val.setText("数据值是"+vv);
		}
	}
}
