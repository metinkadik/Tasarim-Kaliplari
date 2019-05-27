
package pattaern7;

import java.util.ArrayList;
import java.util.List;

interface Komut {
   void uygula();
}

class Ev {
	
   private final String isim = "Lale Konağı";

   public void Al(){
      System.out.println("Ev [ Adı: "+isim+" ] alındı");
   }
   public void Sat(){
      System.out.println("Ev [ Adı: "+isim+" ] satıldı");
   }
}

class evAl implements Komut {
   private final Ev ev;

   public evAl(Ev ev){
      this.ev = ev;
   }

   @Override
   public void uygula() {
      ev.Al();
   }
}

class evSat implements Komut {
   private final Ev ev;

   public evSat(Ev ev){
      this.ev = ev;
   }

   public void uygula() {
      ev.Sat();
   }
}



  class Aracı {
   private List<Komut> komutListesi = new ArrayList<Komut>(); 

   public void Komutçu(Komut komut){
      komutListesi.add(komut);		
   }

   public void KomutVer(){
   
      for (Komut komut : komutListesi) {
         komut.uygula();
      }
      komutListesi.clear();
   }
}

public class CommandPattern {
   public static void main(String[] args) {
      Ev ev = new Ev();

      evAl evAlmaKomutu = new evAl(ev);
      evSat evSatmaKomutu = new evSat(ev);

      Aracı aracı = new Aracı();
      aracı.Komutçu(evAlmaKomutu);
      aracı.Komutçu(evSatmaKomutu);

      aracı.KomutVer();
   }
}
    
