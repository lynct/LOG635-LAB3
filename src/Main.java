import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		/*****************************************************
		 * CHANGER isDebug A FALSE POUR EVALUATION.
		 *****************************************************/
		boolean isDebug = false;
		int total=0, nbCorrect=0, nbIncorrect=0;	//statistics variables
		//Reading players information from file
		ArrayList<Player> dataTraining;
		ArrayList<Player> dataEvaluation;
		if(isDebug){
			dataTraining = DataReader.run("Donnees_sources.csv", true, false, false);
			dataEvaluation = DataReader.run("Donnees_sources.csv", true, true, false);
		}
		else{
			dataTraining = DataReader.run("Donnees_sources.csv", true, false, true);
			dataEvaluation = DataReader.run("evaluation.csv", false, true, true);
		}
		
		ArrayList<Result> resultList = new ArrayList<Result>();
		
		//Scaling the players values
		DataScaler.scale(dataTraining, dataEvaluation);
		
		//Loop through all the test players to find their league.
		for(int i=0; i<dataEvaluation.size(); i++){
				
			Player p = dataEvaluation.get(i);
			
			resultList = KNearestNeighbourAlgorithm.generateResultingDistance(dataTraining, p);
			resultList = KNearestNeighbourAlgorithm.getNearestNeighbors(resultList);
			int league = KNearestNeighbourAlgorithm.findMajority(resultList);
			
			//
			if(isDebug){
				total++;
				//On est correct a + ou - 1 de la vraie valeur de la league.
				if(p.getLeague() == league || p.getLeague() == league+1 || p.getLeague() == league-1){
					nbCorrect++;
				}
				else{
					nbIncorrect++;
				}
			}
			else{
				System.out.println("GameID: " + String.valueOf(p.getGamerId()) + " - League: " + String.valueOf(league));
			}
		}
		
		if(isDebug){
			System.out.println("Total: " + String.valueOf(total));
			System.out.println("Correct: " + String.valueOf(nbCorrect));
			System.out.println("Incorrect: " + String.valueOf(nbIncorrect));
			System.out.println("% Good: " + String.valueOf((double)nbCorrect/(double)total));
		}
		
	}

}
