package グル渋;

public class Menu {
int price;
String name;
int isDish;
	public Menu(int price,String name,int isDish) {
		this.price = price;
		this.name = name;
		this.isDish = isDish;
	}
	
	public int getPrice(){
	    return this.price;
	}

	public String getName(){
	    return this.name;
	}
	
	public int isDish(){
	    return this.isDish;
	}
}
