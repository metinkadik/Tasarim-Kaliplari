/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern9;

import java.util.ArrayList;
import java.util.List;

class Adres {
   private String adres;
   private String derinlik;
   private List<Adres> liste;

   // constructor
   public Adres(String adres,String derinlik) {
      this.adres = adres;
      this.derinlik = derinlik;

      liste = new ArrayList<Adres>();
   }

   public void add(Adres e) {
      liste.add(e);
   }

   public void remove(Adres e) {
      liste.remove(e);
   }

   public List<Adres> getListe(){
     return liste;
   }

   @Override
   public String toString(){
      return ("Adres :[ isim : " + adres + ", derinlik : " + derinlik + " ]");
   }   
}

public class CompositePatternDemo {
   public static void main(String[] args) {
   
      Adres il = new Adres("İstanbul","İl");
      Adres il2 = new Adres("Kocaeli","İl");
      
      Adres ilçe = new Adres("Pendik","İlçe");
      Adres ilçe2 = new Adres("İzmit","İlçe");
      
      Adres mah = new Adres("Güzelyalı","Mahalle");
      Adres mah2 = new Adres("Yeşilova","Mahalle");
      Adres mah3 = new Adres("Kabaoğlu","Mahalle");
      
      Adres sokak = new Adres("Kartal","Sokak");

      il.add(ilçe);
      il2.add(ilçe2);
      
      ilçe.add(mah);

      ilçe2.add(mah2);
      ilçe2.add(mah3);

      mah3.add(sokak);
     
      //print all employees of the organization
      System.out.println(il); 
      
      for (Adres headAdres : il.getListe()) {
         System.out.println(headAdres);
         
         for (Adres adres : headAdres.getListe()) {
            System.out.println(adres);
            
         }
      }	
      
      System.out.println(il2); 
      
      for (Adres headAdres : il2.getListe()) {
         System.out.println(headAdres);
         
         for (Adres adres : headAdres.getListe()) {
            System.out.println(adres);
            
            for (Adres subadres : adres.getListe()) {
            System.out.println(subadres);
            
            }
         }
         
      }
   }
}
