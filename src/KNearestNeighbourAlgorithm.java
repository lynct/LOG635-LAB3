import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;


public final class KNearestNeighbourAlgorithm {
	
	public static final int K = 35; 			//The number of nearest neighbors
	public static double averageDistance = 0;	//The average distance for all data
	
	ArrayList<Player> data;						//Training data used to find the player league

	/**
	 * Generates the results list with the distance to each training players
	 * @param data		Training data
	 * @param player	Player to find the league
	 * @return
	 */
	public static ArrayList<Result> generateResultingDistance(ArrayList<Player> data, Player player){
		
		ArrayList<Result> resultList = new ArrayList<Result>();
		
		for(int i = 0; i < data.size(); i++){
			Player playerData = data.get(i);
			
			float distance = calculateDistance(playerData, player);
			
			Result result = new Result(playerData.getLeague(), distance);
			resultList.add(result);
		}
		
		return resultList;
	}
	
	/****
	 * Calculate the distance between selected 6 attributes
	 ******/
	private static float calculateDistance(Player p1, Player p2){
		
		float[] attributeP1 = p1.getAttributes();
		float[] attributeP2 = p2.getAttributes();
		int length = attributeP1.length;
		float distance = 0;
		
		for(int i = 0; i < length; i++ ){
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
	public static ArrayList<Result> getNearestNeighbors(ArrayList<Result> distances) {
		
		Collections.sort(distances);
		
		ArrayList<Result> neighbors = new ArrayList<Result>();
		
		for(int i = 0; i < K; i++) {
			neighbors.add(distances.get(i));
		}

		return neighbors;
	}
	
	/**
	 * Get the league based on the league value of the K nearest neighbors
	 * @param results
	 * @return
	 */
	public static int findMajority(ArrayList<Result> results){
		
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();		//contient le nombre d'occurence de chaque league
		HashMap<Integer, Float> sumDistance = new HashMap<Integer, Float>();	//contient la somme des distances pour chaque league
		
        for(int i=0; i<results.size(); i++) {
            int league = results.get(i).getLeague();
            float distance = results.get(i).getDistance();
 
            if(dict.containsKey(league))
                dict.put(league, dict.get(league)+1);		//on incremente de 1 si la league est deja presente
	        else
	            dict.put(league, 1);						//on ajoute la nouvelle league dans le dictionnaire
            
            if(sumDistance.containsKey(league))
            	sumDistance.put(league, sumDistance.get(league)+distance);
	        else
	        	sumDistance.put(league, distance);
        }
 
        int league = 0;						//league presente le plus de fois dans les X plus proches voisins
	    int maxCount = 0;					//nombre d'occurence d'une league
	    float bestDistance = 0;
	    Set<Integer> keys = dict.keySet();
	    
	    for(int k : keys) {
	        int counter = dict.get(k);				//nombre d'occurence de la league presente
        	float distance = sumDistance.get(k);
	        
	        if(counter > maxCount) {				//on garde la league qui a le plus d'occurence
	            maxCount = counter;
	            league = k;
	            bestDistance = distance;
	        }
	        else if(counter == maxCount){			//si le nombre d'occurence est le meme, on prend lui avec la plus courte distance total de tous les voisins
	        	if(distance < bestDistance){
	        		maxCount = counter;
		            league = k;
		            bestDistance = distance;
	        	}
	        	//System.out.println("EGALITE");
	        }
	    }
	    
	    return league;
	}

}
