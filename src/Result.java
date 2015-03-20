public class Result implements Comparable<Result> {
	private int league;
	private float distance;
	
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
	public int compareTo(Result r) {
		return Float.compare(this.getDistance(), r.getDistance());
	}
	
}