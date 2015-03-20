import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataReader parser = new DataReader();
		ArrayList<Player>[] data = parser.run();
		
		Kmeans k = new Kmeans();
		
		//k.cluster(data);
		

	}

}
