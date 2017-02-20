
public class Passenger implements Person {
	
	//variables
    private String name;
    private String ticket;
    private Snapper snapper;
         
    
    //getters and setters
    public String getName() {
        return name;
    }
     
    public String getTicket() {
        return ticket;
    }
    
    public Snapper getSnapper() {
		return snapper;
	}

	public void setSnapper(Snapper snapper) {
		this.snapper = snapper;
	}


    //constructor
	public Passenger(String n, String t) {
    	name = n;
    	ticket = t;
    	snapper = new Snapper(0);
    }
    
    
    //toString
    public String printBalance(Passenger p) {
    	   	
    	return ("Passenger " + getName() + " has " + p.getSnapper().getBalance() + "on their card.");
    }

	
}
