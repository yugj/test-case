package util;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/** 
 * @author ���ض� 
 * @E-mail: zshoudong@163.com 
 * @version ����ʱ�䣺Jul 20, 2009 3:47:10 PM 
 * ��˵�� 
 */
public class PinyinToChange {

	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		PinyinToChange tt=new PinyinToChange();
		try {
			System.out.println(tt.getPinYin("�й�"));
			System.out.println(tt.getPinYin("����"));
		long endtime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endtime - starttime));
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
public static String getPinYin(String zhongwen)throws BadHanyuPinyinOutputFormatCombination {
	
	String zhongWenPinYin = "";
	char[] chars = zhongwen.toCharArray();
	
	for (int i = 0; i < chars.length; i++) {
		String[] pinYin = PinyinHelper.toHanyuPinyinStringArray(chars[i],
				getDefaultOutputFormat());
		// ��ת�����������ַ�ʱ,����null
		if (pinYin != null) {
			zhongWenPinYin += capitalize(pinYin[0]);
		} else {
			zhongWenPinYin += chars[i];
		}
	}
	
	return zhongWenPinYin;
	}
	/**  
	* Default Format Ĭ�������ʽ  
	*   
	* @return  
	*/  
	
	public static HanyuPinyinOutputFormat getDefaultOutputFormat() {
	HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// Сд
	format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// û����������
	format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u��ʾ
	
	return format;
	}
	
	/**
	* Capitalize ����ĸ��д
	* 
	* @param s
	* @return
	*/
	public static String capitalize(String s) {
	char ch[];
	ch = s.toCharArray();
	if (ch[0] >= 'a' && ch[0] <= 'z') {
		ch[0] = (char) (ch[0] - 32);
	}
	String newString = new String(ch);
	return newString;
	}
}
