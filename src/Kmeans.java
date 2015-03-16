import java.util.ArrayList;


public class Kmeans {

	private static int NbCluster = 8;
	
	public void cluster(ArrayList<Player> data){
		
		
		calculateAgeAverage(data);
		
	}
	
	public void calculateAgeAverage(ArrayList<Player> data){
		
		//Get the age average for each cluster
		
				int[][] age = new int[NbCluster][data.size()];
				
				for(int i = 0; i < NbCluster; i++)
		        {
								
					int currentClusterIndex = 0;
					
					for(int k = 0; k < data.size(); k++){
														
						if(data.get(k).getLeague() == (i+1)){
						
							if(data.get(k).getAge() != -1){
								

								age[i][currentClusterIndex] = data.get(k).getAge();

								//System.out.println("data.get(k).getAge() = " +data.get(k).getAge());
								//System.out.println("Age i:" + i + " k:" + currentClusterIndex + " = "+age[i][currentClusterIndex]);
								
								currentClusterIndex++;
								
								
								
							}
							
						
						}
									
					}
					
		        }
				
				int[] AgeAvg = new int[8];
				
				for(int k = 0; k < NbCluster;k++)
		        {
					
					Integer sum = 0;
					Integer total = 0;
					for(int i = 0; i < data.size(); i++){
						if(age[k][i] != 0 && age[k][i] != -1){
							sum += age[k][i];
							total++;	
						}
					}
					
					
					//La league 8 a pas d'age
					if(total!=0){
						AgeAvg[k] = sum / total;
					
						System.out.println("Average league " + (k+1) + " age = "+ AgeAvg[k] );
					}
					
		        }
		
	}
	
}
