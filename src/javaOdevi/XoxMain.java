package javaOdevi;
import java.util.*;
public class XoxMain {

	public static void main(String[] args) {
		Veriler veriler = new Veriler();
		Metotlar metotlar = new Metotlar();
		Scanner girdi = new Scanner (System.in);
		
		for(int i =  0 ; i < veriler.oyuncular.length ; i++){
			int siraInt = i+1;
			System.out.println(siraInt+". Oyuncu : "+veriler.oyuncular[i]);
		}
		// Oynanış
		System.out.print("Oynanis : ");
		System.out.println("Sirasi gelen oyuncu girmek istedigi sirayi girsin");
		
		
		// OYUN
		
		do{
			metotlar.tahtayiGoster(veriler.oyunTahtasi);
			do{
				System.out.print("Sira "+(veriler.sira + 1)+". oyuncuda : ");
				veriler.deger = girdi.nextInt();
			}while(veriler.deger < 1 || veriler.deger > 9 || metotlar.tahtaKontrol(veriler.deger, veriler.oyunTahtasi) == false);
			veriler.oyunTahtasi = metotlar.tahtaKontrol(veriler.deger,veriler.oyunTahtasi, veriler.oyuncular[veriler.sira]);
			veriler.sira = (veriler.oyuncular.length) - 1 == veriler.sira ? 0 : veriler.sira + 1;
		}while(metotlar.oyunKontrol(veriler.oyunTahtasi) && metotlar.xoxKontrol(veriler.oyunTahtasi));
		metotlar.oyunGoster(veriler.oyunTahtasi);
		metotlar.kimYendi(veriler.oyunTahtasi);	

	}

}
