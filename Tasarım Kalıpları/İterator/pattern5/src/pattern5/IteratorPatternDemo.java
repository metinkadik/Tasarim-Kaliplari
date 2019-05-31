
package pattern5;


 interface Iterator {
   public boolean hasNext();
   public Object next();
}

 interface Container {
   public Iterator getIterator();
}

 class HouseRepository implements Container {
   public String houses[] = {"Apartman" , "Yalı" ,"Villa" , "Prefabrik"};

   @Override
   public Iterator getIterator() {
      return new HouseIterator();
   }

   private class HouseIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
      
         if(index < houses.length){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return houses[index++];
         }
         return null;
      }		
   }
}



public class IteratorPatternDemo {
	
   public static void main(String[] args) {
      HouseRepository namesRepository = new HouseRepository();

      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
         String house = (String)iter.next();
         System.out.println("House : " + house);
      } 	
   }
}