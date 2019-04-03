package pattern;

public class EvFactory {

    public static Ev createEv(Class clss) throws InstantiationException, IllegalAccessException {
            return  (Ev) clss.newInstance();
    
}
}
