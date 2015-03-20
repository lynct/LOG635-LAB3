import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		DataReader parser = new DataReader();
		ArrayList<Player>[] data = parser.run();
		ArrayList<Result> resultList = new ArrayList<Result>();
		
		int total=0, nbCorrect=0, nbIncorrect=0;
		
		//Loop through all the test players to find their league.
		for(int i=0; i<data[1].size(); i++){
			Player p = data[1].get(i);
			
			resultList = KNearestNeighbourAlgorithm.generateResultingDistance(data[0], p);
			resultList = KNearestNeighbourAlgorithm.getNearestNeighbors(resultList);
			int league = KNearestNeighbourAlgorithm.findMajority(resultList);
			
			total++;
			
			if(p.getLeague() == league){ // || p.getLeague() == league+1 || p.getLeague() == league-1){
				nbCorrect++;
			}
			else{
				nbIncorrect++;
			}
		}
		
		System.out.println("Total: " + String.valueOf(total));
		System.out.println("Correct: " + String.valueOf(nbCorrect));
		System.out.println("Incorrect: " + String.valueOf(nbIncorrect));

		System.out.println("% Good: " + String.valueOf((double)nbCorrect/(double)total));
	}

}
