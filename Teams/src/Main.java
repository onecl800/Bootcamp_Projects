import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import ecs100.UI;

public class Main {
	
	//create new array lists for list of teams, list of players by team and list of positions by team
    //method to add items from the scanner is in the relevant classes
    private static ArrayList<Team> teamsList = new ArrayList<Team>();
    private ArrayList<Player> teamPlayers = new ArrayList<Player>();
      
     
    //exercise 1 - print list of teams from teamsList ArrayList, using toString method in Team class
    public void listTeams() {
        for (int i = 0; i < teamsList.size(); i++) {
        	UI.println(teamsList.get(i).toString());
        }
    }
    
    
    //exercise 2 - print list of teams plus coaches from teamsList ArrayList, using toString method in team class
    public void listTeamsWithCoaches() {
        for (int i = 0; i < teamsList.size(); i++) {
        	UI.println(teamsList.get(i).tcString());
        }
    }
     
    
    //exercise 3 - print list of players for each team. Searches through teamsList ArrayList, once 
    //match is found, calls ArrayList of teamPlayers for that teamsList and prints each player using
    //toString method in player class
    public void listTeamPlayers() {
    	String team = UI.askString("Which team?");
                
        for (int i = 0; i < teamsList.size(); i++) {
            if (team.equals(teamsList.get(i).toString())) {
                teamPlayers = teamsList.get(i).playerList();
                for (int j = 0; j < teamPlayers.size(); j++) {
                	UI.println(teamPlayers.get(j).pString());
                }
            }
        }
    }
    
    
    // exercise 4 - list players by team and position
    public void listPositionPlayersOnTeam() {
    	String team = UI.askString("Which team?");
        String position = UI.askString("Which position?");
         
        //search through list of teams
        for (int i = 0; i < teamsList.size(); i++) {
            if(team.equals(teamsList.get(i).toString())) { 
                teamPlayers = teamsList.get(i).playerList();
                 
                //search through list of players and then arrayList of each player's positions
                for (int j = 0; j < teamPlayers.size(); j++) {
                	String [] positionArray = teamPlayers.get(j).getPositionArray();
                	for (int k = 0; k < positionArray.length; k++) {
                		if(position.equals(positionArray[k])) {
                			UI.println(teamPlayers.get(j).getPlayerName());
                		}
                	}
                }       
            }
        }
    }
    
    
    //exercise 5 - list players by min and max height in a team. Search through ArrayList of teamsList, once match found, searches 
    //through list of teamPlayers for that team. Checks their height (pulled from return height method in player class), checks 
    //against the heights given by the user and prints their name using toString method if it falls within the range. 
    public void listHeights() {
    	
    	String team = UI.askString("Which team?");
        int min = UI.askInt("Taller than?");
        int max = UI.askInt("Shorter than?");
    
    	 
        for (int i = 0; i < teamsList.size(); i++) {
            if (team.equals(teamsList.get(i).toString())) {
                teamPlayers = teamsList.get(i).playerList();
                 
                for (int j = 0; j < teamPlayers.size(); j++) {
                    int pheight = teamPlayers.get(j).playerHeight();
                    if (pheight > min && pheight < max) {
                       UI.println(teamPlayers.get(j).pString());
                    }
                }
            }
        }
    }
     
    
    //exercise 6
    public void checkSelection() {
    	
    	Boolean [] check = new Boolean [] {false, false, false, false, false, false, false};
    	String [] teamPos = new String [] {"GS", "GA", "WA", "C", "WD", "GD", "GK"};
    	
    	String team = UI.askString("Which team?");
    	
        //search through list of teams
        for (int i = 0; i < teamsList.size(); i++) {
            if(team.equals(teamsList.get(i).toString())) { 
                teamPlayers = teamsList.get(i).playerList();
                
                for (int j = 0; j < teamPos.length; j++) {
                	
                	for (int k = 0; k < teamPlayers.size(); k++) {
                    	String [] positionArray = teamPlayers.get(k).getPositionArray();                	
                    	for (int l = 0; l < positionArray.length; l++) {
         
                    		if (teamPos[j].equals(positionArray[l])) {
                    			check[j] = true;
                    		}
                    	}
                	}                	
                }
            }
        }
                      
        int checkNum = 0;
        for (int z = 0; z < check.length; z++) {
        	if(check[z] == true) {
        		checkNum++;
        	}
        }
        
        if (checkNum == 7) {
        	UI.println("This is a complete team");
        } else {
        	UI.println("Your team is incomplete");
        }
    }
    
    
    //exercise 7 - draw graph for every player in every team's height
    public void graphHeights() {
    	
    	//String team = UI.askString("Which team?");
         
        //draw zero line
        double startZeroX = 10;
        double endZeroX = 800;
        double ZeroLine = 400;
        UI.setColor(Color.black);
        UI.drawLine(startZeroX, ZeroLine, endZeroX, ZeroLine);
         
        //counter for number of players (will increase as it goes through each player in each team)
        int playerNum = 0;
         
        //draw bar graph
        for (int i = 0; i < teamsList.size(); i++) {
            teamPlayers = teamsList.get(i).playerList();
            for (int j = 0; j < teamPlayers.size(); j++) {
            	System.out.println(playerNum);
                int pheight = teamPlayers.get(j).playerHeight();
                UI.setColor(Color.blue);
                UI.fillRect(startZeroX + (playerNum * 7), ZeroLine - pheight, 5, pheight);
                playerNum++;
            }
        } 
    }
    
    
    public Main() {
    	
        UI.initialise();
        UI.addButton("List teams", this::listTeams);
        UI.addButton("List coaches", this::listTeamsWithCoaches);
        UI.addButton("List team players", this::listTeamPlayers);
        UI.addButton("List players by position", this::listPositionPlayersOnTeam);
        UI.addButton("Search by height", this::listHeights);
        UI.addButton("Check team lineup", this::checkSelection);
        UI.addButton("Graph player heights", this::graphHeights);
		
        try {
            Scanner scanner = new Scanner(new File("teams.txt"));
            while (scanner.hasNext()) {
                 
                String teamName = scanner.nextLine();
                String coachName = scanner.nextLine();
                int numPlayers = scanner.nextInt();
                System.out.println(teamName + ", " + coachName + ", " + numPlayers);
                Team team = new Team(teamName, coachName, numPlayers);
                 
                for (int i = 0; i < numPlayers; i++) {
                    
                	String stringPositions = scanner.next();
                    String [] positions = stringPositions.split(",");
                    
                    String playerName = scanner.nextLine(); 
                    int height = scanner.nextInt();
                    scanner.nextLine();
                    String birthPlace = scanner.nextLine();
                    
                    Player player = new Player(playerName, height, birthPlace, positions.length);
                    player.setPlayersPositions(positions);
                    System.out.println(playerName + ", " + Arrays.toString(positions) + ", " + height + ", " + birthPlace);
                   
                    team.addPlayer(player);
                }
                teamsList.add(team);
            }
            scanner.close();
            
        } catch (FileNotFoundException e) {
        	System.out.println("Error loading file: %s%n");
        }
    }
	

    
    public static void main(String[] args) {
    	
    	new Main();
    	
    }

}
