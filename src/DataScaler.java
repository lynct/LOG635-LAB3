import java.util.ArrayList;


public final class DataScaler {
	
	static int NBATTRIBUTES = 15;

	/**
	 * Scale all the value for the KNN algorithm.
	 * @param dataTraining	ArrayList of the training data.
	 * @param dataEvaluation	ArrayList of the data to evalute.
	 */
	public static void scale(ArrayList<Player> dataTraining, ArrayList<Player> dataEvaluation) {
		
		ArrayList<Player> allData = new ArrayList<Player>();		
		
		allData.addAll(dataTraining);
		allData.addAll(dataEvaluation);
		
		//We set the max and min values to the values of the first player.
		float[] maxValues = allData.get(0).getAttributes();
		float[] minValues = allData.get(0).getAttributes();
		
		//Loop throught all the data to find the max and min values for each attributes.
		for(int i=1; i<allData.size(); i++){
			
			//Loop throught all attributes
			for(int j=0; j<NBATTRIBUTES; j++){
				
				float value = allData.get(i).getAttribute(j);
				
				if(value > maxValues[j]){
					maxValues[j] = value;
				}
				
				if(value < minValues[j]){
					minValues[j] = value;
				}
				
			}
		}
		
		//Scale data from dataTraining
		//Loop throught all the players to scale their attributes value.
		for(int i=0; i<dataTraining.size(); i++){
			
			//Loop throught all attributes
			for(int j=0; j<NBATTRIBUTES; j++){
				
				float scaledValue = (dataTraining.get(i).getAttribute(j) - minValues[j]) / (maxValues[j] - minValues[j]);
				
				dataTraining.get(i).setScaledAttribute(j, scaledValue);
			}
		}
		
		//Scale data from dataEvaluation
		//Loop throught all the players to scale their attributes value.
		for(int i=0; i<dataEvaluation.size(); i++){
			
			//Loop throught all attributes
			for(int j=0; j<NBATTRIBUTES; j++){
				
				float scaledValue = (dataEvaluation.get(i).getAttribute(j) - minValues[j]) / (maxValues[j] - minValues[j]);
				
				dataEvaluation.get(i).setScaledAttribute(j, scaledValue);
			}
		}
		
	}
}
