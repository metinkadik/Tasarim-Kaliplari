package pattern;

public interface Ev {
int odaSasyısı = 0 ;
void adres();

}

class Villa implements Ev {

    @Override
    public void adres() {
        System.out.println("Yahya Kaptan mah");
    }

}

class Daire implements Ev {

   @Override
    public void adres() {
        System.out.println("Yeşilova mah");
    }

}


class Yalı implements Ev {

   @Override
    public void adres() {
        System.out.println("Kabaoğlu mah");
    }

}

class Müstakil implements Ev {

   @Override
    public void adres() {
        System.out.println("AliKahya mah");
    }

}

class Prefabrik implements Ev {

   @Override
    public void adres() {
        System.out.println("Kabaoğlu mah");
    }

}

