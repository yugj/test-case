package test.javabasic;

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
/** 
 * <p>CopyFile.java</p> 
 * <p>Created on Apr 17, 2009, 4:33:43 PM</p> 
 * <p>Copyright (c) 2007-2009. CUCKOO Workgroup, USTC, P.R.China</p> 
 * @author Ren Jian 
 */  
public class FileCopy {  
    private boolean copy(String fileFrom, String fileTo) {  
        try {  
            FileInputStream in = new java.io.FileInputStream(fileFrom);  
            FileOutputStream out = new FileOutputStream(fileTo);  
            byte[] bt = new byte[1024];  
            int count;  
            while ((count = in.read(bt)) > 0) {  
                out.write(bt, 0, count);  
            }  
            in.close();  
            out.close();  
            return true;  
        } catch (IOException ex) {  
            return false;  
        }  
    }  
}  