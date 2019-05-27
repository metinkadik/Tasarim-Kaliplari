package pattern;
public class İlan 
{ 
    
    private static İlan instance = null; 
  
    public String ilan_id;
    public String başlık; 
    public String adres; 
    public String açıklama; 
    public int fiyat;
  
    
    private İlan() 
    { 
      //...
    } 
    
     private void İlanVer() 
    { 
        System.out.println("İlan verildi");
    } 
  
    public static İlan getInstance() 
    { 
        if (instance == null) 
            instance = new İlan(); 
  
        return instance; 
    } 

    public static void main(String[] args) {
       //Singleton
        İlan nesne = İlan.getInstance();
        İlan nesne2 = İlan.getInstance();
        
        nesne.İlanVer();
        nesne2.İlanVer();
        
        System.out.println();
        
        //Factory
         try {
        Daire daire = (Daire) EvFactory.createEv(Daire.class);
        daire.adres();
        
        Villa villa = (Villa) EvFactory.createEv(Villa.class);
        villa.adres();
          
                 } catch (Exception e) {
            e.printStackTrace();
}
    }
    
}
