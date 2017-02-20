import java.util.ArrayList;

public class Team {
	
	//variables
    private String teamName;
    private String coachName;
    private int numPlayers;
    private ArrayList<Player> teamPlayers;
     
     
    //team constructor
    public Team(String tn, String cn, int np) {
        //fields/parameters
        teamName = tn;
        coachName = cn;
        numPlayers = np;
        teamPlayers = new ArrayList<Player>();
    }
     
   
    public int getNumPlayers() {
    	return numPlayers;
    }
        
    
    //method to add players to arrayList of players in each team called teamPlayers
    public void addPlayer(Player p) {
        this.teamPlayers.add(p);
    }
     
    //to call player names to allow to add to arrayList of players
    public ArrayList<Player> playerList(){
            return teamPlayers;
    }
         
 
    //print team name for exercise 1
    public String toString() {
        return teamName;
    }
     
    //print team and coach for exercise 2
    public String tcString() {
        return teamName + ": " +  coachName;
    }

}
