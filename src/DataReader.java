import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
 
public class DataReader {
 
 
  public void run() {
 
	String csvFile = "Donnees_sources.csv";
	
	
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		
		
		br.readLine(); //Lecture de la premiere ligne incluant les titres des colonnes
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
			String[] player = line.split(cvsSplitBy);
 
			int[] playerInt = new int[player.length];
			
			
			for(int k=0; k<player.length;k++){
				
				if(player[k].equals("?")){
					player[k] = "-1";
				}
				
				player[k] = new BigDecimal(player[k].toUpperCase()).toPlainString();
			}
						
			
			//La colonne LeagueIndex (player[1]) ne sera pas présente dans le fichier estimation.csv
			
			Player p = new Player(Integer.parseInt(player[0]), Integer.parseInt(player[1]), Integer.parseInt(player[2]), Integer.parseInt(player[3]),
					Integer.parseInt(player[4]), Float.parseFloat(player[5]) , Float.parseFloat(player[6]) ,Float.parseFloat(player[7]) , 
					Float.parseFloat(player[8]) , Float.parseFloat(player[9]) , Float.parseFloat(player[10]) , Float.parseFloat(player[11]) , 
					Float.parseFloat(player[12]) , Float.parseFloat(player[13]) , Float.parseFloat(player[14]) , Float.parseFloat(player[15]) , Float.parseFloat(player[16]) , 
					Float.parseFloat(player[17]) , Float.parseFloat(player[18]) , Float.parseFloat(player[19]) );
			
			System.out.println("Player ["
					+ "GameID= " + player[0]  
					+ " , LeagueIndex=" + player[1] 
					+ " , Age=" + player[2]
					+ " , HoursPerWeek=" + player[3] 
					+ " , TotalHours=" + player[4]
					+ " , APM=" + player[5] 			
					+ " , SelectByHotKeys=" + player[6] 			
					+ " , AssignToHotkeys=" + player[7] 			
					+ " , UniqueHotkeys=" + player[8] 			
					+ " , MinimapAttacks=" + player[9] 			
					+ " , MinimapRightClicks=" + player[10] 			
					+ " , NumberOfPACs=" + player[11] 			
					+ " , GapBetweenPACs=" + player[12] 			
					+ " , ActionLatency=" + player[13] 			
					+ " , ActionsInPAC=" + player[14] 						
					+ " , TotalMapExplored=" + player[15]
					+ " , WorkersMade=" + player[16]
					+ " , UniqueUnitsMade=" + player[17]
					+ " , ComplexUnitsMade=" + player[18]
					+ " , ComplexAbilitiesUsed=" + player[19] 
					+ "]");
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
 
}