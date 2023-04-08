package ch00;

public class DisplayTextUnicode {

	public DisplayTextUnicode() {
	}

	public static void main(String[] args) {
//		char ch = '宏';
//		System.out.println("\\u"+Integer.toHexString(ch));
		
		String title = "宏碁電腦傳奇";
		System.out.println(toUnicodeEncoding(title));
	}
	
	public static String toUnicodeEncoding(String source) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int n = 0; n<source.length();n++) {
			char ch = source.charAt(n);
			stringBuffer.append("\\u" + Integer.toHexString(ch));
		}
		
		return stringBuffer.toString();
	}
	

}
