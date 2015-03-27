
public class Player {
	
	private int NBATTRIBUTES = 15;
	private int gamerId;
	private int league;	
	private int age;
	private int hoursPerWeek;
	private int totalHours;	
	private float[] attributes;
	private float[] scaledAttributes;
	
	public Player(int gamerId, int league, int age, int hoursPerWeek, int totalHours, float[] newAttributes){
		
		this.gamerId = gamerId;
		this.league = league;
		this.age = age;
		this.hoursPerWeek = hoursPerWeek;
		this.totalHours = totalHours;
		this.attributes = newAttributes;		
		this.scaledAttributes = new float[NBATTRIBUTES];		
	}

	public int getGamerId() {
		return gamerId;
	}

	public void setGamerId(int gamerId) {
		this.gamerId = gamerId;
	}

	public int getLeague() {
		return league;
	}

	public void setLeague(int league) {
		this.league = league;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	
	/**
	 * Return the attributes array used to find the player's league.
	 * @return float[] contenant les attributs a comparer
	 */
	public float[] getKNNAttributes(){
		return new float[]{scaledAttributes[0], 
						   scaledAttributes[1],
						   scaledAttributes[2],
						   scaledAttributes[3],
						   scaledAttributes[4],
						   scaledAttributes[6],
						   scaledAttributes[7],
						   scaledAttributes[8],
						   scaledAttributes[11]};
	}
	
	public void setScaledAttribute(int index, float value){
		scaledAttributes[index] = value;
	}
	
	public float[] getAttributes(){
		return attributes.clone();
	}
	
	public float getAttribute(int index){
		return attributes[index];
	}

}
