import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
 
public class DataReader {
 
 
  public ArrayList<Player>[] run() {
 
	String csvFile = "Donnees_sources.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	int lineCounter = 0;
	ArrayList<Player>[] data = new ArrayList[2];
	
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		ArrayList<Player> dataForTraining = new ArrayList();
		ArrayList<Player> dataForTest = new ArrayList();
		
		br.readLine(); //Lecture de la premiere ligne incluant les titres des colonnes
		while ((line = br.readLine()) != null) {
			
		    // use comma as separator
			String[] player = line.split(cvsSplitBy);
 
			int[] playerInt = new int[player.length];
			
			for(int k=0; k<player.length;k++){
				
				//On nettoie les données
				player[k] = player[k].replace("\"", "");
				player[k] = player[k].replace("?", "-1");
				
				player[k] = new BigDecimal(player[k]).toPlainString();
			}
						
			
			//La colonne LeagueIndex (player[1]) ne sera pas présente dans le fichier estimation.csv
			
			Player p = new Player(Integer.parseInt(player[0]), Integer.parseInt(player[1]), Integer.parseInt(player[2]), Integer.parseInt(player[3]),
					Integer.parseInt(player[4]), Float.parseFloat(player[5]) , Float.parseFloat(player[6]) ,Float.parseFloat(player[7]) , 
					Float.parseFloat(player[8]) , Float.parseFloat(player[9]) , Float.parseFloat(player[10]) , Float.parseFloat(player[11]) , 
					Float.parseFloat(player[12]) , Float.parseFloat(player[13]) , Float.parseFloat(player[14]) , Float.parseFloat(player[15]) , Float.parseFloat(player[16]) , 
					Float.parseFloat(player[17]) , Float.parseFloat(player[18]) , Float.parseFloat(player[19]) );
			
			if(((lineCounter/5) % 2) == 0){
				dataForTraining.add(p);
			}
			else{
				dataForTest.add(p);
			}
 
			lineCounter++;
		}
		
		data[0] = dataForTraining;
		data[1] = dataForTest;
		
		return data;
 
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
	return null;
	
  }
 
}