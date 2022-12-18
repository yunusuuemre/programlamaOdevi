package javaOdevi;

public class Metotlar {

	public static void tahtayiGoster(char x[][]){
		System.out.println();
		for(int i = 0 ; i < x.length;i++){
			for(int j = 0 ; j < x[i].length;j++){	
				System.out.print((j < x[i].length) ? "\t" : "");	
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean tahtaKontrol(int deger,char x[][]){	
		char a = '*';
		int i,j,degeri  = deger,sayim = x.length;
		if(deger % sayim == 0)
			deger--;
		double id = deger/sayim ;
		i = (int) Math.floor(id) ;	
		if(i >= x.length)
			i = x.length - 1;
		j = (degeri - (i * sayim)) - 1 ;
		if(x[i][j] == a)
			return true;
		else
			return false;	
	}
	public static char[][] tahtaKontrol(int deger,char x[][],char t){
		if(tahtaKontrol(deger,x)){	
				int i,j,degeri = deger,sayim = x.length;
				if(deger % sayim == 0)
					deger--;
				double id = deger/sayim ;
				i = (int) Math.floor(id) ;
				if(i >= x.length)
					i = x.length - 1;
				j = (degeri - (i * sayim)) - 1 ;
				x[i][j] = t ;
				return x;
		}else{	
			return x;	
		}
	}
	
	
	public static boolean oyunKontrol(char[][] x){
		boolean donus = false;
		char t= '*';
		for(int i = 0 ; i < x.length;i++){
			for(int j = 0;j < x[i].length;j++)
				if(x[i][j] == t)
					donus = true;
		}	
		return donus;	
	}	
	public static void oyunGoster(char x[][]){
		System.out.println();
		for(int i = 0 ; i < x.length;i++){
			for(int j = 0 ; j < x[i].length;j++){	
				System.out.print((j < x[i].length) ? "\t" : "");	
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean xoxKontrol(char[][] x){
		boolean kontrol = true;
		String[][] hepsi = xoxKontrol_t(x); 
		String[] satir = hepsi[0],deger = {"XXX","OOO"},sutun = hepsi[1],caprz = hepsi[2];
		for(int i = 0 ; i < x.length; i++)
				kontrol = (caprz[1].contains(deger[0]) || caprz[1].contains(deger[1]) || caprz[0].contains(deger[0]) || caprz[0].contains(deger[1]) || satir[i].contains(deger[0]) || satir[i].contains(deger[1]) ||  sutun[i].contains(deger[0]) || sutun[i].contains(deger[1])) ?  false  : kontrol;
		return kontrol;	
	}
	public static String[][] xoxKontrol_t(char[][] x){
		String[] satir = {"","",""},sutun = {"","",""},caprz = {"","",""},temp = new String[2];
		int length = x.length;
			for(int i= 0;i < length;i++){
				for(int j = 0; j< x[i].length;j++){
					temp[0] = Character.toString(x[i][j]);
						satir[j] += temp[0];		
						sutun[i] += temp[0];
						if((i == 0 && j == 0) || (i == 2 && j == 2))
							caprz[0] += temp[0];
						else if((i == 0 && j == 2) || (i == 2 && j == 0))
							caprz[1] += temp[0];
						if(i == 1 && j == 1){
							caprz[0] += temp[0];
							caprz[1] += temp[0];
						}
				}				
			}
			String t[][] = {satir,sutun,caprz};
		return t;
	}
	public static void    kimYendi(char[][] x){
		boolean[] oyuncu = {false,false};
		String[][] hepsi = xoxKontrol_t(x); 
		String[] satir = hepsi[0],deger = {"XXX","OOO"},sutun = hepsi[1],caprz = hepsi[2];	
			for(int i = 0 ; i < x.length; i++){
				oyuncu[0] = (satir[i].contains(deger[0])  ||  sutun[i].contains(deger[0]) || caprz[i].contains(deger[0])) ?  true  : oyuncu[0];
				oyuncu[1] = (satir[i].contains(deger[1])  ||  sutun[i].contains(deger[1]) || caprz[i].contains(deger[1])) ?  true  : oyuncu[1];
			}
			int kac = oyuncu[0] ? 1 : (oyuncu[1] ? 2 : 0);
		    System.out.println(kac > 0 ? kac+". Oyuncu kazandi" : "Oyun Berabere");
		
		
	}
	
	
	
}
