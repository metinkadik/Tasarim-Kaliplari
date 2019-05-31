
package pattern8;

import java.util.ArrayList;
import java.util.List;

class Memento {
   private final String durum;

   public Memento(String durum){
      this.durum = durum;
   }

   public String getDurum(){
      return durum;
   }	
}

class Ev {
   private String durum;

   public void setDurum(String durum){
      this.durum = durum;
   }

   public String getDurum(){
      return durum;
   }

   public Memento MementoDurumunuKaydet(){
      return new Memento(durum);
   }

   public void getMementoDurumu(Memento memento){
      durum = memento.getDurum();
   }
}

class EvHafıza {
   private List<Memento> mementoListesi = new ArrayList<Memento>();

   public void ekle(Memento durum){
      mementoListesi.add(durum);
   }

   public Memento get(int index){
      return mementoListesi.get(index);
   }
}

public class MementoPattern {
   public static void main(String[] args) {
   
      Ev originator = new Ev();
      EvHafıza careTaker = new EvHafıza();
      
      originator.setDurum("Ev kiralık");
      originator.setDurum("Ev kiralandı");
      careTaker.ekle(originator.MementoDurumunuKaydet());
      
      originator.setDurum("Ev satıldı");
      careTaker.ekle(originator.MementoDurumunuKaydet());
      
      originator.setDurum("Ev satılık");
      System.out.println("Şuanki Durum: " + originator.getDurum());		
      
      originator.getMementoDurumu(careTaker.get(0));
      System.out.println("İlk Kaydedilen Durum: " + originator.getDurum());
      originator.getMementoDurumu(careTaker.get(1));
      System.out.println("İkinci Kaydedilen Durum: " + originator.getDurum());
   }
}
