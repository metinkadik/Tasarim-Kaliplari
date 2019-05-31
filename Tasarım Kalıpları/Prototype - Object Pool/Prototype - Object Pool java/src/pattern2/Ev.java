package pattern2;

import java.util.HashMap;
import java.util.Map;

public abstract class Ev {
    public String type() {
        return "Ev";
    }
}

class Villa extends Ev {
    
    public String type() {
        return "Villa";
    }
}

class Yalı extends Ev {
    
    public String type() {
        return "Yalı";
    }
}

class Daire extends Ev {
    
    public String type() {
        return "Daire";
    }
}

class Rezidans extends Ev {
    
    public String type() {
        return "Rezidans";
    }
}


 class EvSource {
   
    private static EvSource poolManager  = null; 
    static int size=3;
    private static EvSource source = new EvSource();
    private Map<Class<? extends Ev> , Ev> poolMap = new HashMap<Class<? extends Ev>, Ev>();

    
    private EvSource() {
        
    }
    

    public static Ev getEv(Class<? extends Ev> clazz) throws IllegalAccessException, InstantiationException {    
        Ev b = source.poolMap.get(clazz);
        
        if (b == null) {
            b = clazz.newInstance();
            source.poolMap.put(b.getClass(), b);
            size--;
        }
        
   return b;
  }
           
    

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        
        //Object Pool
        
        Ev ev = EvSource.getEv(Villa.class);
        System.out.println(ev.type() + " " + ev);
        Ev ev2 = EvSource.getEv(Villa.class);
        System.out.println(ev2.type() + " " + ev2);
        Ev ev3 = EvSource.getEv(Daire.class);
        System.out.println(ev3.type() + " " + ev3);
        Ev ev4 = EvSource.getEv(Yalı.class);
        System.out.println(ev4.type() + " " + ev4);
        Ev ev5 = EvSource.getEv(Rezidans.class);
        System.out.println(ev5.type() + " " + ev5);
        Ev ev6 = EvSource.getEv(Yalı.class);
        System.out.println(ev6.type() + " " + ev6);
        
        
       
    }
 }