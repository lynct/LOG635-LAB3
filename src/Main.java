import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		/*****************************************************
		 * CHANGER isTraining A FALSE POUR EVALUATION.
		 *****************************************************/
		boolean isTraining = true;
		ArrayList<Player>[] dataTraining = DataReader.run("Donnees_sources.csv", true, false);
		ArrayList<Player>[] dataEvaluation = DataReader.run("evaluation.csv", false, true);
		ArrayList<Result> resultList = new ArrayList<Result>();
		
		int total=0, nbCorrect=0, nbIncorrect=0;	//statistics variables
		
		/*****************************************************
		 * REMPLACER LE COMMENTAIRE SUIVANT POUR L'EVALUATION
		 * ET COMMENTER L'AUTRE "FOR".
		 *****************************************************/
		/*
		for(int i=0; i<dataEvaluation[0].size(); i++){
			
			Player p = dataEvaluation[0].get(i);
		*/
		
		//Loop through all the test players to find their league.
		for(int i=0; i<dataTraining[1].size(); i++){
				
			Player p = dataTraining[1].get(i);
			
			resultList = KNearestNeighbourAlgorithm.generateResultingDistance(dataTraining[0], p);
			resultList = KNearestNeighbourAlgorithm.getNearestNeighbors(resultList);
			int league = KNearestNeighbourAlgorithm.findMajority(resultList);
			
			if(isTraining){
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
		
		if(isTraining){
			System.out.println("Total: " + String.valueOf(total));
			System.out.println("Correct: " + String.valueOf(nbCorrect));
			System.out.println("Incorrect: " + String.valueOf(nbIncorrect));
			System.out.println("% Good: " + String.valueOf((double)nbCorrect/(double)total));
		}
		
	}

}
