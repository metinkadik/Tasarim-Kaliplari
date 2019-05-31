
package pattern2;
import java.util.ArrayList;
import java.util.List;

public class Prototype implements Cloneable{

	private List<String> HouseList;
	
	public Prototype(){
		HouseList = new ArrayList<String>();
	}
	
	public Prototype(List<String> list){
		this.HouseList=list;
	}
	public void loadData(){
		//read all employees from database and put into the list
		HouseList.add("İzmit villa");
		HouseList.add("Çiçek Apartman");
		HouseList.add("Güneş Gayrimenkul");
		HouseList.add("Çırağan Sarayı");
	}
	
	public List<String> getHouseList() {
		return HouseList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> temp = new ArrayList<String>();
			for(String s : this.getHouseList()){
				temp.add(s);
			}
			return new Prototype(temp);
	}
	
}


class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype house = new Prototype();
		house.loadData();
		
		//Deep Copy
		Prototype houseNew = (Prototype) house.clone();
                //Shallow Copy
		Prototype houseNew1 = house;
		List<String> list = houseNew.getHouseList();
		list.add("Yeşilova Daire");
                List<String> list1 = houseNew1.getHouseList();
                list1.add("Boş daire");
		
		
		System.out.println(house.getHouseList());
		System.out.println(houseNew.getHouseList());
                System.out.println(houseNew1.getHouseList());
                
                System.out.println();
                
                System.out.println(house);
		System.out.println(houseNew);
                System.out.println(houseNew1);
                

	}

}