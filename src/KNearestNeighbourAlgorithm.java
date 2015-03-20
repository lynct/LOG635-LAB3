import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;


public class KNearestNeighbourAlgorithm {
	
	public static final int K = 70; 			//The number of nearest neighbors
	public static double averageDistance = 0;	//The average distance for all data
	
	ArrayList<Player> data;
	ArrayList<Player> test;
	
	private final int ENTRIES = 6; //# of attributes we are evaluating
		
	
	public KNearestNeighbourAlgorithm(ArrayList<Player> data, ArrayList<Player> test){
		this.data = data;
		this.test = test;
	}

	public ArrayList<Result> generateResultingDistance(){
		
		ArrayList<Result> resultList = new ArrayList<Result>();
		
		//testing player 1
		Player playerTest = test.get(0);
		
		for(int i = 0; i < data.size(); i++){
			Player playerData = data.get(i);
			
			float distance = calculateDistance(playerData, playerTest);
			
			Result result = new Result(playerData.getLeague(), distance);
			resultList.add(result);
		}
		
		return resultList;
	}
	
	/****
	 * Calculate the distance between selected 6 attributes
	 ******/
	public float calculateDistance(Player p1, Player p2){
		
		float[] attributeP1 = p1.getAttributes();
		float[] attributeP2 = p2.getAttributes();
		
		float distance = 0;
		
		for(int i = 0; i < ENTRIES; i++ ){
			distance += Math.pow(attributeP1[i] - attributeP2[i], 2);
		}
		
		return distance;
	}
	
	/**
	 * Get the K number nearest neighbors
	 * 
	 * @param distances
	 * @return
	 */
	public static ArrayList getNearestNeighbors(ArrayList<Result> distances) {
		
		//Sorting by distance ASC
		Collections.sort(distances, new Comparator<Result>() {
	     
			@Override
			public int compare(Result result1, Result result2) {

				return Float.compare(result1.getDistance(),result2.getDistance());
				
			}
	    });
			
	
		ArrayList<Result> neighbors = new ArrayList<Result>();
		
		for(int i = 0; i < K; i++) {
			neighbors.add(distances.get(i));
		}

		return neighbors;
	}
	
	public static int findMajority(ArrayList<Result> results){
		
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		
        for(int i = 0; i < results.size(); i++) {
            int d = results.get(i).getLeague();
 
            if(dict.containsKey(d))
                dict.put(d, dict.get(d)+1);		//on incremente de 1 si la league est deja presente
        else
            dict.put(d, 1);					//on ajoute la nouvelle league dans le dictionnaire
        }
 
        int maxMode = 0;						//league presente le plus de fois dans les X plus proches voisins
	    int maxCount = 0;						//nombre d'occurence d'uen league
	    Set<Integer> keys = dict.keySet();
	    
	    for(int d : keys) {
	        int tCount = dict.get(d);
	        if(tCount > maxCount) {
	            maxCount = tCount;
	            maxMode = d;
	        }
	    }
	    
	    return maxMode;
	}

}
