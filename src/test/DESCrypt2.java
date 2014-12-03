package test;

import java.security.Key;  
import java.security.SecureRandom;  
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;  
  
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  
  
/** 
 *  
 * ʹ��DES���������,�ɶ�byte[],String���ͽ��м�������� ���Ŀ�ʹ��String,byte[]�洢. 
 *  
 * ����: void getKey(String strKey)��strKey����������һ��Key 
 *  
 * String getEncString(String strMing)��strMing���м���,����String���� String 
 * getDesString(String strMi)��strMin���н���,����String���� 
 *  
 * byte[] getEncCode(byte[] byteS)byte[]�͵ļ��� byte[] getDesCode(byte[] 
 * byteD)byte[]�͵Ľ��� 
 */  
  
public class DESCrypt2 {  
    Key key;  
    private static String strDefaultKey = "goodluck";  
    public DESCrypt2(){  
        getKey(strDefaultKey);  
    }  
    /** 
     * ���ݲ�������KEY 
     *  
     * @param strKey 
     */  
    public  void getKey(String strKey) {  
        try {  
            KeyGenerator _generator = KeyGenerator.getInstance("DES");  
            _generator.init(new SecureRandom(strKey.getBytes()));  
            this.key = _generator.generateKey();  
            _generator = null;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * ����String��������,String������� 
     *  
     * @param strMing 
     * @return 
     */  
    public String getEncString(String strMing) {  
        byte[] byteMi = null;  
        byte[] byteMing = null;  
        String strMi = "";  
        BASE64Encoder base64en = new BASE64Encoder();  
        try {  
            byteMing = strMing.getBytes("UTF8");  
            byteMi = this.getEncCode(byteMing);  
            strMi = base64en.encode(byteMi);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            base64en = null;  
            byteMing = null;  
            byteMi = null;  
        }  
        return strMi;  
    }  
  
    /** 
     * ���� ��String��������,String������� 
     *  
     * @param strMi 
     * @return 
     */  
    public String getDesString(String strMi) {  
        BASE64Decoder base64De = new BASE64Decoder();  
        byte[] byteMing = null;  
        byte[] byteMi = null;  
        String strMing = "";  
        try {  
            byteMi = base64De.decodeBuffer(strMi);  
            byteMing = this.getDesCode(byteMi);  
            strMing = new String(byteMing, "UTF8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            base64De = null;  
            byteMing = null;  
            byteMi = null;  
        }  
        return strMing;  
    }  
  
    public String getDesStr(String strMi) {  
        BASE64Decoder base64De = new BASE64Decoder();  
        byte[] byteMing = null;  
        byte[] byteMi = null;  
        String strMing = "";  
        try {  
            byteMi = base64De.decodeBuffer(strMi);  
            byteMing = this.getDesCode(byteMi);  
            strMing = new String(byteMing, "UTF8");  
        } catch (Exception e) {  
            //e.printStackTrace();  
            strMing = strMi;  
        } finally {  
            base64De = null;  
            byteMing = null;  
            byteMi = null;  
        }  
        return strMing;  
    }  
  
    /** 
     * ������byte[]��������,byte[]������� 
     *  
     * @param byteS 
     * @return 
     */  
    private byte[] getEncCode(byte[] byteS) {  
        byte[] byteFina = null;  
        Cipher cipher;  
        try {  
            cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.ENCRYPT_MODE, key);  
            byteFina = cipher.doFinal(byteS);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            cipher = null;  
        }  
        return byteFina;  
    }  
  
    /** 
     * ������byte[]��������,��byte[]������� 
     *  
     * @param byteD 
     * @return 
     */  
    private byte[] getDesCode(byte[] byteD) {  
        Cipher cipher;  
        byte[] byteFina = null;  
        try {  
            cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.DECRYPT_MODE, key);  
            byteFina = cipher.doFinal(byteD);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            cipher = null;  
        }  
        return byteFina;  
  
    }  
  
    public static void main(String[] args) {  
  
        System.out.println("des demo");  
        DESCrypt2 des = new DESCrypt2();// ʵ����һ������  
        //des.getKey("MYKEY11");// �����ܳ�  
        //System.out.println("key=MYKEY11");  
        String strEnc = des.getEncString("����һ�����ԣ�");// �����ַ���,����String������  
        System.out.println("����=" + strEnc);  
  
        String strDes = des.getDesString(strEnc);// ��String ���͵����Ľ���  
        System.out.println("����=" + strDes);  
  
    }  
  
}  