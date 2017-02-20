import java.util.ArrayList;

public class Coach {
	
	//variables
	private String coachNum;
	private ArrayList<Person> peopleOnCoach;


	//getters and setters
	public String getCoachNum() {
		return coachNum;
	}

	public void setCoachNum(String coachNum) {
		this.coachNum = coachNum;
	}
	
	public ArrayList<Person> getPeopleOnCoach() {
		return peopleOnCoach;
	}

	public void setPeopleOnCoach(ArrayList<Person> peopleOnCoach) {
		this.peopleOnCoach = peopleOnCoach;
	}


	//constructor
	public Coach(String num) {
		coachNum = num;
		peopleOnCoach = new ArrayList<Person>();
	}


	//toString method
	public String toString() {
		return ("Coach number " + coachNum + " has " + peopleOnCoach.size() + " people on board");
	}


	//add passengers to the coach
    public void getOnCoach(Person person) { 
    	
    	if(person instanceof Driver) {
    		this.peopleOnCoach.add(person);
    	} else {
    		Passenger passenger = (Passenger)person;
        	Snapper snapper = passenger.getSnapper();
    		if (snapper.spendMoney(snapper) == true) { 
    		this.peopleOnCoach.add(person);
    		}
    	}
    }


	//check if driver is on coach
	public Boolean canMove() {
	
		for (int i = 0; i < peopleOnCoach.size(); i ++) {
			if (peopleOnCoach.get(i) instanceof Driver) {
				System.out.println("Driver is on board, coach " + getCoachNum() + " can move");
				return true;
			}
		}
		return false;
	}
	
}

