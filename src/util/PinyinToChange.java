package util;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/** 
 * @author 翟守东 
 * @E-mail: zshoudong@163.com 
 * @version 创建时间：Jul 20, 2009 3:47:10 PM 
 * 类说明 
 */
public class PinyinToChange {

	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		PinyinToChange tt=new PinyinToChange();
		try {
			System.out.println(tt.getPinYin("中国"));
			System.out.println(tt.getPinYin("余贵军"));
		long endtime = System.currentTimeMillis();
		System.out.println("耗时：" + (endtime - starttime));
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
		// 当转换不是中文字符时,返回null
		if (pinYin != null) {
			zhongWenPinYin += capitalize(pinYin[0]);
		} else {
			zhongWenPinYin += chars[i];
		}
	}
	
	return zhongWenPinYin;
	}
	/**  
	* Default Format 默认输出格式  
	*   
	* @return  
	*/  
	
	public static HanyuPinyinOutputFormat getDefaultOutputFormat() {
	HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
	format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 没有音调数字
	format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u显示
	
	return format;
	}
	
	/**
	* Capitalize 首字母大写
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
