package test.swing;

import javax.swing.*;  

public class JTableTest2  
{  
    JFrame jf = new JFrame("�򵥱��");  
    JTable table;  
    // �����ά������Ϊ�������  
    Object[][] tableData =   
    {  
        new Object[]{"������" , 29 , "Ů"},  
        new Object[]{"�ո�����", 56 , "��"},  
        new Object[]{"���", 35 , "��"},  
        new Object[]{"Ū��", 18 , "Ů"},  
        new Object[]{"��ͷ" , 2 , "��"}  
    };  
    // ����һά������Ϊ�б���  
    Object[] columnTitle = {"����" , "����" , "�Ա�"};  
    public void init()  
    {  
        // �Զ�ά�����һά����������һ��JTable����  
        table = new JTable(tableData , columnTitle);  
        // ��JTable�������JScrollPane�У�  
        // ������JScrollPane���ڴ�������ʾ����  
        jf.add(new JScrollPane(table));  
        jf.pack();  
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jf.setVisible(true);  
    }  
    public static void main(String[] args)   
    {  
        new JTableTest2().init();  
    }  
}  