package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * ��ȡexcel��������
 * 
 *
 */
public class TestExcel {
	/**
	 * 
	 * @param excelFile ��ȡ�ļ�����
	 * @param rowNum �ӵڼ��п�ʼ���������һ�б�ͷ��ӵڶ��п�ʼ��
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public static List<String[]> readExcel(File excelFile,int rowNum) throws BiffException,
			IOException {
		// ����һ��list �����洢��ȡ������
		List<String[]> list = new ArrayList<String[]>();
		Workbook rwb = null;
		Cell cell = null;
		// ����������
		InputStream stream = new FileInputStream(excelFile);
		// ��ȡExcel�ļ�����
		rwb = Workbook.getWorkbook(stream);
		// ��ȡ�ļ���ָ�������� Ĭ�ϵĵ�һ��
		Sheet sheet = rwb.getSheet(0);
		// ����(��ͷ��Ŀ¼����Ҫ����1��ʼ)
		for (int i = rowNum-1; i < sheet.getRows(); i++) {
			// ����һ������ �����洢ÿһ�е�ֵ
			String[] str = new String[sheet.getColumns()];
			// ����
			for (int j = 0; j < sheet.getColumns(); j++) {
				// ��ȡ��i�У���j�е�ֵ
				cell = sheet.getCell(j, i);
				str[j] = cell.getContents();
			}
			// �Ѹջ�ȡ���д���list
			list.add(str);
		}
		// ����ֵ����
		return list;
	}
	
	public static void main(String[] args) {
		String excelFileName = "abc.xls";
		try {
			List<String[]> list = TestExcel.readExcel(new File(excelFileName),1);
			for (int i = 0; i < list.size(); i++) {
				String[] str = (String[])list.get(i);
				for (int j = 0; j < str.length; j++) {
					System.out.println(str[j]);
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

