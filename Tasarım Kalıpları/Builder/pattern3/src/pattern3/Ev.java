
package pattern3;


public class Ev {
// Builder Design Pattern
    private final String name;
    private final String address;
    private final int price;
    private final String phone;
    

    public Ev(EvBuilder evBuilder) {
        this.name = evBuilder.name;
        this.price = evBuilder.price;
        this.phone = evBuilder.phone;
        this.address = evBuilder.address;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "Ev: " + this.name + ", " + this.price + ", " + this.phone + ", " + this.address;
    }

    public static class EvBuilder {

        private final String name;
        private int price;
        private String phone;
        private String address;

        public EvBuilder(String name) {
            this.name = name;

        }

        public EvBuilder price(int price) {
            this.price = price;
            return this;
        }

        public EvBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public EvBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Ev build() {
            Ev ev = new Ev(this);
            return ev;
        }
    }
    
     public static void main(String[] args) {
        Ev apartman = new Ev.EvBuilder("Akasya Apartman")
                .price(300000)
                .phone("+90 216 504 5655")
                .address("Akasya Acıbadem Ofis Kuleleri\n A Blok 24. Kat No:127\n Acıbadem İstanbul")
                .build();

        Ev yalı = new Ev.EvBuilder("Üsküdar Yalı")
                .price(2000000)
                .phone("+90 216 504 5655")
                .build();

        Ev prefabrik = new Ev.EvBuilder("Prefabrik Ev")
                .price(60000)
                .build();

        System.out.println(apartman);
        System.out.println(yalı);
        System.out.println(prefabrik);
    }
    
}
