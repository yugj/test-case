package test.swing;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;					// ���ģ��Ķ����ڰ�javax.swing.table��
public class JTableTest{	
	JFrame f=new JFrame("���JTable���÷�");
	JLabel row=new JLabel("��ǰ����",JLabel.CENTER);
	JLabel col=new JLabel("��ǰ����",JLabel.CENTER);
	JLabel val=new JLabel("����ֵ��",JLabel.CENTER);
	Font ft=new Font("Serif",Font.BOLD,18);
	String []field={"����","����","��ѧ","Ӣ��"};// ��������б���
	Object [][]data={{"������","88","95","91"},{"������","84","79","83"}};	// ������ĳ�ʼ����
	DefaultTableModel mod=new DefaultTableModel(data,field);	// ��field��data��������ģ��
	JTable tab=new JTable(mod);			// ��ģ��mod���������
	JScrollPane jsp=new JScrollPane();		// ����һ��������������Ϊ�����û�й�����
	JButton b1=new JButton("����");
	JButton b2=new JButton("ɾ��");
	JPanel pe=new JPanel(new GridLayout(3,1,10,30));
	JPanel ps=new JPanel(new GridLayout(1,2,30,10));
	void go(){
		f.getContentPane().add("Center",jsp);
		f.getContentPane().add("East",pe);
		f.getContentPane().add("South",ps);
		jsp.getViewport().add(tab);				// �����ӵ���������jsp��
		pe.add(row);pe.add(col);pe.add(val);
		ps.add(b1);ps.add(b2);
		b1.addActionListener(new ButtonH(1));
		b2.addActionListener(new ButtonH(2));
		f.setSize(300,250);f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.setFont(ft);b2.setFont(ft);row.setFont(ft);
		col.setFont(ft);val.setFont(ft);tab.setFont(ft);
		// �����ע�ᵽ������TableH�У���ʵ���˽ӿ�MouseListener
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
			if(sel==1){								// �����ˡ����롱��ťʱ
				Object[] dt={null,null,null,null};			// ����һ���հ���
				mod.addRow(dt);					// ��ģ��mod��ĩβ���һ��
			}
			if(sel==2)								// �����ˡ�ɾ������ťʱ
				mod.removeRow(tab.getSelectedRow()); // ��ģ��mod��ɾ�����tab�еĵ�ǰ��
		}
	}
	class TableH extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			int rr,cc;String vv;
			rr=tab.getSelectedRow();					// ȡ���tab�еĵ�ǰ�к�
			cc=tab.getSelectedColumn();				// ȡ���tab�еĵ�ǰ�к�
			vv=(String)tab.getValueAt(rr,cc);	// ȡ���tab�еĵ�rr�С�cc�еĵ�Ԫ�������ֵ
			row.setText("��ǰ����"+rr);
			col.setText("��ǰ����"+cc);
			val.setText("����ֵ��"+vv);
		}
	}
}
