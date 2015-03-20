import java.util.ArrayList;


public class KNearestNeighbourAlgorithm {
	
	ArrayList<Player> data;
	ArrayList<Player> test;
	
	public KNearestNeighbourAlgorithm(ArrayList<Player> data, ArrayList<Player> test){
		this.data = data;
		this.test = test;
	}
	
	
	public void evaluateKNN(){
		
		
		//result list containing the distance of all player in kb to our target
		float[]resultDistance = new float[data.size()];
		
		for(int i = 0; i < data.size(); i++){
			
		}
	}
	
	/***
	 * Extract attributes from players
	 * @param player 1
	 * @param player 
	 * @return
	 */
	public float[][] extractAttributes(Player p1){
		
		float[][] attributeValues = new float[][]{
			{
				p1.getApm(), p1.getHoursPerWeek(), p1.getComplexAbilitiesUsed(), p1.getTotalMapExplored(), 
				p1.getActionsInPAC(), p1.getComplexUnitsMade(), p1.getAssignToHotkeys()}
			};
		
		return attributeValues;
	}

	/****
	 * Calculate the distance between selected 6 attributes
	 ******/
	public double calculateDistance(
			int a1, int b1, int c1, int d1, int e1, int f1,
			int a2, int b2, int c2, int d2, int e2, int f2
			){
		
		double value = Math.pow((a2 - a1), 2) + Math.pow((b2 - b1), 2) + Math.pow((c2 - c1), 2) + Math.pow((d2 - d1), 2) + 
				Math.pow((e2 - e1), 2) + Math.pow((f2 - f1), 2);
		
		return value;
	}
	
	


}
