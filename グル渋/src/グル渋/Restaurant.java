package グル渋;

import java.util.ArrayList;

public class Restaurant {
	int id;
	int accountID;
	String name;
	String inf;
	String map;
	String address;
	String tel;
	String img;
	ArrayList<String>  category;
	int avg;
	
	public Restaurant(int id, String name, String inf, String map, String address,String tel,String img) {
		this.id = id;
        this.name = name;
        this.inf = inf;
        this.map = map;
        this.address = address;
        this.tel = tel;
        this.img = img;
    }
	
	public int getId(){
        return this.id;
    }
	
	public String getName(){
        return this.name;
    }

    public String getInf(){
        return this.inf;
    }
    
    public String getMap(){
        return this.map;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getTel(){
        return this.tel;
    }
    
    public String getImage(){
        return this.img;
    }
    
    public void setAvg(int score){
        this.avg = score;
    }
    
    public int getAvg(){
        return this.avg;
    }
}
