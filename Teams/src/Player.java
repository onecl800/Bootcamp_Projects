import java.util.Arrays;

public class Player {
	
	//variables
    private String playerName;
    private String[] playersPositions;
    private int height;
    private String birthPlace;
    private int numPositions;
     
    
    //player constructor
    public Player (String pn, int h, String bp, int num) {
        playerName = pn;
        height = h;
        birthPlace = bp;
        numPositions = num;
        playersPositions = new String[num];
    }
    
    public String getPlayerName() {
    	return playerName;
    }
    
    
	public void setPlayersPositions(String[] playersPositions) {
		this.playersPositions = playersPositions;
	}
	
	public String[] getPositionArray() {
		return playersPositions;
	}
    
	public String getPlayersPositions() {
		return Arrays.toString(playersPositions);
	}
	
	public int getNumPositions() {
		return numPositions;
	}
	
	public void setNumPositions(int numPositions) {
		this.numPositions = numPositions;
	}
	
	
    
    
    //print list of players for exercise 3
    public String pString() {
        return (playerName + ", " + height + ", " + birthPlace + ", " + getPlayersPositions());
    }
    
    
    //to call int player height for exercise 5
    public int playerHeight() {
        return height;
    }
}
