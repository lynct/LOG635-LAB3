import java.util.ArrayList;


public class KNearestNeighbourAlgorithm {
	
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
}
