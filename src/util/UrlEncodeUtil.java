package util;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class UrlEncodeUtil {

    public static String encode(String rawUrl) throws UnsupportedEncodingException {
        if (rawUrl == null || rawUrl.length() == 0) {
            return rawUrl;
        }
        StringBuffer rs = new StringBuffer();
        char[] chars = rawUrl.toCharArray();
        for (char c : chars) {
            if (c > 127) {
                rs.append(URLEncoder.encode(String.valueOf(c), "utf-8"));
                continue;
            }
            rs.append(c);
        }
        return rs.toString().replaceAll(" ", "%20");
    }
}
