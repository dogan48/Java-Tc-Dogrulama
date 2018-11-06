import java.util.Scanner;

public class TcDogrulama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System. in);
		String TC = scanner. nextLine();
		
		if(isTC(TC)) 
			System.out.println("TC Kimlik Numaras� Do�rudur. ");
		else
			System.out.println("TC Kimlik Numaras� Yanl��t�r. ");

	}
	
	public static boolean isTC(String tc) {
		if(tc.length() < 11 || tc.length() > 11 )	// kontrol edilen dizi 11 hane de�il ise tc de�ildir.
			return false;
		for(int i = 0;i < 11; i++)					// kontrol edilen dizi rakamlardan olu�muyor ise tc de�ildir.
			if(!Character.isDigit(tc.charAt(i)))
				return false;
		int TC1 = Integer.parseInt(String.valueOf(tc.charAt(0)));
		if(TC1 == 0)								// kontrol edilen dizi 0 ile ba�l�yor ise tc de�ildir.
			return false;
		
		int TC10 = calculateTC10(tc);				// tcnin 10. hanesini hesapla do�rulu�unu kontrol et.
		if(TC10 != Integer.parseInt(String.valueOf(tc.charAt(9))))
			return false;
		
		int TC11 = calculateTC11(tc);				// tcnin 11. hanesini hesapla do�rulu�unu kontrol et.
		if(TC11 != Integer.parseInt(String.valueOf(tc.charAt(10))))
			return false;
													// dizi t�m kontrolleri ge�mi� ise tc do�rudur.
			return true;
	}
	
	public static int calculateTC10(String tc) {	// TC'nin 10. hanesini hesaplama fonksiyonu
		int TC10 = (Integer.parseInt(String.valueOf(tc.charAt(0)))+Integer.parseInt(String.valueOf(tc.charAt(2)))
		+Integer.parseInt(String.valueOf(tc.charAt(4)))+Integer.parseInt(String.valueOf(tc.charAt(6)))
		+Integer.parseInt(String.valueOf(tc.charAt(8))));
		TC10 *= 7;
		TC10 -= (Integer.parseInt(String.valueOf(tc.charAt(1)))+Integer.parseInt(String.valueOf(tc.charAt(3)))
		+Integer.parseInt(String.valueOf(tc.charAt(5)))+Integer.parseInt(String.valueOf(tc.charAt(7))));
		TC10 = TC10 % 10;
		return TC10;
	}
	
	public static int calculateTC11(String tc) {	// TC'nin 11. hanesini hesaplama fonksiyonu
		int TC11 = (Integer.parseInt(String.valueOf(tc.charAt(0)))+Integer.parseInt(String.valueOf(tc.charAt(1)))
		+Integer.parseInt(String.valueOf(tc.charAt(2)))+Integer.parseInt(String.valueOf(tc.charAt(3)))
		+Integer.parseInt(String.valueOf(tc.charAt(4)))+Integer.parseInt(String.valueOf(tc.charAt(5)))
		+Integer.parseInt(String.valueOf(tc.charAt(6)))+Integer.parseInt(String.valueOf(tc.charAt(7)))
		+Integer.parseInt(String.valueOf(tc.charAt(8)))+Integer.parseInt(String.valueOf(tc.charAt(9))));
		TC11 = TC11 % 10;
		return TC11 % 10;
	}
	

}
