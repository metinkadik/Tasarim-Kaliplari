
package pattern4;

//ABSTRACT FACTORY
enum EvType 
{ 
    YALI, APARTMAN, PREFABRİK 
} 
  
abstract class Ev 
{ 
    Ev(EvType model, Location location) 
    { 
        this.model = model; 
        this.location = location; 
    } 
   
    abstract void construct(); 
   
    EvType model = null; 
    Location location = null; 
   
    EvType getModel() 
    { 
        return model; 
    } 
   
    void setModel(EvType model) 
    { 
        this.model = model; 
    } 
   
    Location getLocation() 
    { 
        return location; 
    } 
   
    void setLocation(Location location) 
    { 
        this.location = location; 
    } 
   
    @Override
    public String toString() 
    { 
        return "EvModel - "+model + " Adresi "+location; 
    } 
} 
  
class PrefabrikEv extends Ev 
{ 
    PrefabrikEv(Location location) 
    { 
        super(EvType.PREFABRİK, location); 
        construct(); 
    } 
    @Override
    protected void construct() 
    { 
        System.out.println("PREFABRİK Ev"); 
    } 
} 
  
class ApartmanEv extends Ev 
{ 
    ApartmanEv(Location location) 
    { 
        super(EvType.APARTMAN, location); 
        construct(); 
    } 
    @Override
    protected void construct() 
    { 
        System.out.println("APARTMAN Ev "); 
    } 
} 
  
class YalıEv extends Ev 
{ 
    YalıEv(Location location) 
    { 
        super(EvType.YALI,location ); 
        construct(); 
    } 
      
    @Override
    void construct() 
    { 
        System.out.println("YALI Ev"); 
    } 
} 
  
enum Location 
{ 
  DEFAULT, İSTANBUL, İZMİT 
} 
  
class İzmitEvFactory 
{ 
    static Ev buildEv(EvType model) 
    { 
        Ev ev = null; 
        switch (model) 
        { 
            case APARTMAN: 
                ev = new ApartmanEv(Location.İZMİT); 
                break; 
              
            case YALI: 
                ev = new YalıEv(Location.İZMİT); 
                break; 
                  
            case PREFABRİK: 
                ev = new PrefabrikEv(Location.İZMİT); 
                break; 
                  
                default: 
                break; 
              
        } 
        return ev; 
    } 
} 
  
class DefaultEvFactory 
{ 
    public static Ev buildEv(EvType model) 
    { 
        Ev ev = null; 
        switch (model) 
        { 
            case APARTMAN: 
                ev = new ApartmanEv(Location.DEFAULT); 
                break; 
              
            case YALI: 
                ev = new YalıEv(Location.DEFAULT); 
                break; 
                  
            case PREFABRİK: 
                ev = new PrefabrikEv(Location.DEFAULT); 
                break; 
                  
                default: 
                break; 
              
        } 
        return ev; 
    } 
} 
  
  
class İstanbulEvFactory 
{ 
    public static Ev buildEv(EvType model) 
    { 
        Ev ev = null; 
        switch (model) 
        { 
            case APARTMAN: 
                ev = new ApartmanEv(Location.İSTANBUL); 
                break; 
              
            case YALI: 
                ev = new YalıEv(Location.İSTANBUL); 
                break; 
                  
            case PREFABRİK: 
                ev = new PrefabrikEv(Location.İSTANBUL); 
                break; 
              
        } 
        return ev; 
    } 
} 
  
  
  
class EvFactory 
{ 
    private EvFactory()  
    { 
          
    } 
    public static Ev buildEv(EvType type ,Location location) 
    { 
        Ev ev = null; 
        
          
        switch(location) 
        { 
            case İSTANBUL: 
                ev = İstanbulEvFactory.buildEv(type); 
                break; 
                  
            case İZMİT: 
                ev = İzmitEvFactory.buildEv(type); 
                break; 
                      
            default: 
                ev = DefaultEvFactory.buildEv(type); 
  
        } 
          
        return ev; 
  
    } 
} 
  
class AbstractDesign  
{ 
    public static void main(String[] args) 
    { 
        System.out.println(EvFactory.buildEv(EvType.YALI,Location.İSTANBUL));
        System.out.println(EvFactory.buildEv(EvType.APARTMAN,Location.İZMİT)); 
        System.out.println(EvFactory.buildEv(EvType.PREFABRİK,Location.İSTANBUL)); 

    } 
} 
