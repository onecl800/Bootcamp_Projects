import java.util.ArrayList;

public class Bus {
	
	//variables
	private String busNum;
	private ArrayList<Person> peopleOnBus;
    
    
    //getters and setters
	public String getBusNum() {
		return busNum;
	}

	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}
	
	public ArrayList<Person> getPeopleOnBus() {
		return peopleOnBus;
	}

	public void setPeopleOnBus(ArrayList<Person> peopleOnBus) {
		this.peopleOnBus = peopleOnBus;
	}

    
    //constructor
    public Bus(String num) {
        busNum = num;
        peopleOnBus = new ArrayList<Person>();
    }
     
    
    //toString method
    public String toString() {
        return ("Bus number " + busNum + " has " + peopleOnBus.size() + " people on board");
    }
     
    
    //add passengers to the bus
    public void getOnBus(Person person) { 
    	
    	if(person instanceof Driver) {
    		this.peopleOnBus.add(person);
    	} else {
    		Passenger passenger = (Passenger)person;
        	Snapper snapper = passenger.getSnapper();
    		if (snapper.spendMoney(snapper) == true) { 
    		this.peopleOnBus.add(person);
    		}
    	}
    }
    
         
    //check if bus can move
    public Boolean canMove() {
    	
    	for (int i = 0; i < peopleOnBus.size(); i ++) {
    		if (peopleOnBus.get(i) instanceof Driver) {
    			System.out.println("Driver is on board, bus " + getBusNum() + " can move");
    			return true;
    		}
    	}
    	return false;
    }

}
