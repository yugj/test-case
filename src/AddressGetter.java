import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressGetter {

	public static boolean checkIpAddress(String ip) {
		if (ip == null)
			return false;
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		return Pattern.matches(regex, ip);
	}

	public static String getAddress(String str) {
		if (str == null)
			return null;
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while (m.find()) {
			return m.group();
		}
		return null;
	}
	
	public static void main(String[] args) {
	    String aa = (System.getProperty("os.name").toLowerCase());
	    if(aa.startsWith("win"))
	    	System.out.println(getWindowsInet4IpAddress());
	    else
	    	System.out.println(getLinuxInet4Address());
	}
	
	public static String getWindowsInet4IpAddress() {
		try {
			for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
				NetworkInterface networkInterface = interfaces.nextElement();
				if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
					continue;
				}
				Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					String ip = addresses.nextElement().getHostAddress();
					if (isInet4IpAddress(ip)) {
						return ip;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return "127.0.0.1";
	}
	
	public static String getLinuxInet4Address() {
        String ip = "";
        try {
            Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();
            while (e1.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e1.nextElement();
                if (!ni.getName().equals("eth0")) {
                    continue;
                } else {
                    Enumeration<?> e2 = ni.getInetAddresses();
                    while (e2.hasMoreElements()) {
                        InetAddress ia = (InetAddress) e2.nextElement();
                        ip = ia.getHostAddress();
                        if (isInet4IpAddress(ip)) {
    						return ip;
    					}
                    }
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "127.0.0.1";
    }

	private static boolean isInet4IpAddress(String str) {
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		return Pattern.matches(regex, str);
	}

}