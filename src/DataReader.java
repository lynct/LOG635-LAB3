import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
 
public final class DataReader {
 
	/**
	 * Read all the data in the files.
	 * @param isTraining		Is it training data?
	 * @param isEvaluation		Is it evaluation data?
	 * @param isReadAll		If false, read 5 lines and skip 5 until the end of the file.
	 * @return	ArrayList<Player> ArrayList containing all the players and their values from the file
	 */
	public static ArrayList<Player> run(String csvFile, boolean isTraining, boolean isEvaluation, boolean isReadAll) {
 
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int lineCounter = 0;
		ArrayList<Player> data = new ArrayList<Player>();
		//Used to determine if we add the player to the ArrayList or not. depending if we are reading a training file or not.
		int validLine = isTraining ? 0 : (isEvaluation ? 1 : 0);
		
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			
			br.readLine(); //Lecture de la premiere ligne incluant les titres des colonnes
			while ((line = br.readLine()) != null) {
				
			    // use comma as separator
				String[] player = line.split(cvsSplitBy);
				
				for(int k=0; k<player.length;k++){
					
					//On nettoie les données
					player[k] = player[k].replace("\"", "");
					player[k] = player[k].replace("?", "-1");
					
					player[k] = new BigDecimal(player[k]).toPlainString();
				}
							
				Player p;
				
				//Training data
				if(isTraining){
					float[] attributes = {Float.parseFloat(player[5]) , Float.parseFloat(player[6]) ,Float.parseFloat(player[7]) , 
							Float.parseFloat(player[8]) , Float.parseFloat(player[9]) , Float.parseFloat(player[10]) , Float.parseFloat(player[11]) , 
							Float.parseFloat(player[12]) , Float.parseFloat(player[13]) , Float.parseFloat(player[14]) , Float.parseFloat(player[15]) , Float.parseFloat(player[16]) , 
							Float.parseFloat(player[17]) , Float.parseFloat(player[18]) , Float.parseFloat(player[19])};
					
					p = new Player(Integer.parseInt(player[0]), Integer.parseInt(player[1]), Integer.parseInt(player[2]), Integer.parseInt(player[3]),
							Integer.parseInt(player[4]),  attributes);
				}
				//Evaluation data
				else{
					//La colonne LeagueIndex (player[1]) ne sera pas présente dans le fichier estimation.csv
					float[] attributes = {Float.parseFloat(player[4]), Float.parseFloat(player[5]) , Float.parseFloat(player[6]) ,Float.parseFloat(player[7]) , 
							Float.parseFloat(player[8]) , Float.parseFloat(player[9]) , Float.parseFloat(player[10]) , Float.parseFloat(player[11]) , 
							Float.parseFloat(player[12]) , Float.parseFloat(player[13]) , Float.parseFloat(player[14]) , Float.parseFloat(player[15]) , Float.parseFloat(player[16]) , 
							Float.parseFloat(player[17]) , Float.parseFloat(player[18])};
					
					p = new Player(Integer.parseInt(player[0]), 0, Integer.parseInt(player[1]), Integer.parseInt(player[2]), Integer.parseInt(player[3]), attributes);
				}
				
				//When it is for practice (isReadAll == false), we read 5 lines and skip 5 until we reach the end of the file.
				if(!isReadAll){
					if(((lineCounter/5) % 2) == validLine){
						data.add(p);
					}
				}
				//Otherwise we add all the players to the ArrayList.
				else{
					data.add(p);
				}
	 
				lineCounter++;
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
		
		return data;
	}
}