package グル渋;

public class BookDetails {
int userId;
int restaurantId;
String restaurantName;
String date;
int people;
int courseId;
String courseName;
String tel;
String name;
	public BookDetails(int restaurantId,String date,int people,int courseId,String tel,String name,String restaurantName,String courseName) {
		this.restaurantId = restaurantId;
		this.date = date;
		this.people = people;
		this.courseId = courseId;
		this.tel = tel;
		this.name = name;
		this.restaurantName = restaurantName;
		this.courseName = courseName;
	}
	
	public int getRestaurantId(){
	    return this.restaurantId;
	}
	
	public String getDate(){
	    return this.date;
	}
	
	public int getPeople(){
	    return this.people;
	}
	
	public String getRestaurantName(){
	    return this.restaurantName;
	}
	
	public String getCourseName(){
	    return this.courseName;
	}
}
