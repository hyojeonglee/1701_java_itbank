import java.net.InetAddress;

public class Ex01_InetAddress {
	public static void main(String[] args) {
		InetAddress inet = null;
		String domain = "www.google.com";
		try {
			inet = InetAddress.getByName(domain);
			System.out.println(inet.getHostAddress());
			System.out.println(inet.getHostName());
			
			InetAddress[] inets = InetAddress.getAllByName(domain);
			for(InetAddress addr : inets) {
				System.out.println(addr.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
