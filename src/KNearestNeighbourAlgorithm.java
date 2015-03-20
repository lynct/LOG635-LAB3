import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
	

}
