import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataReader parser = new DataReader();
		ArrayList<Player>[] data = parser.run();
		
		KNearestNeighbourAlgorithm k = new KNearestNeighbourAlgorithm(data[0], data[1]);
		
		k.generateResultingDistance();
		
		//k.cluster(data[0]);
		

	}

}
