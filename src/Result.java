import java.util.Collections;
import java.util.Comparator;


public class Result implements Comparator {
	int league;
	float distance;
	
	public Result(int league, float distance){
		this.league = league;
		this.distance = distance;
	}
	
	public int getLeague(){
		return league;
	}
	
	public float getDistance(){
		return distance;
	}

	@Override
	public int compare(Object result1, Object result2) {
		return Float.compare(((Result) result1).getDistance(),((Result) result2).getDistance());
	
	}
	
}