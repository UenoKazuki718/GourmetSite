package グル渋;

public class Menu {
int price;
String name;
int isCourse;
int courseId;
	public Menu(int price,String name,int isCourse,int courseId) {
		this.price = price;
		this.name = name;
		this.isCourse = isCourse;
		this.courseId = courseId;
	}
	
	public int getPrice(){
	    return this.price;
	}

	public String getName(){
	    return this.name;
	}
}
