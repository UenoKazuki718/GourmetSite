package グル渋;

public class Course {
	int id;
	String name;
	int price;
	String text;
		public Course(int id, String name, int price, String text) {
			this.id = id;
			this.name = name;
		    this.price = price;
		    this.text = text;
		}
		
		public int getId(){
		    return this.id;
		}
		
		public String getName(){
		    return this.name;
		}		
		
		public int getPrice(){
		    return this.price;
		}

		public String getText(){
		    return this.text;
		}
}
