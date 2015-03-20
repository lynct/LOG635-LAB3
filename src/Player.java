
public class Player {
	
	private int gamerId;
	private int league;	
	private int age;
	private int hoursPerWeek;
	private int totalHours;
	private float apm;
	private float selectByHotkeys;
	private float assignToHotkeys;
	private float uniqueHotkeys;
	private float minimapAttacks;
	private float minimapRightClicks;
	private float numberOfPACs;
	private float gapBetweenPACs;
	private float actionLatency;
	private float actionsInPAC;
	private float totalMapExplored;
	private float workersMade;
	private float uniqueUnitsMade;
	private float complexUnitsMade;
	private float complexAbilitiesUsed;

	public Player(int gamerId, int league, int age, int hoursPerWeek, int totalHours, float apm, float selectByHotkeys, float assignToHotkeys,
			float uniqueHotkeys, float minimapAttacks, float minimapRightClicks, float numberOfPACs, float gapBetweenPACs, float actionLatency, float actionsInPAC,
			float totalMapExplored, float workersMade, float uniqueUnitsMade, float complexUnitsMade, float complexAbilitiesUsed){
		
		this.gamerId = gamerId;
		this.league = league;
		this.age = age;
		this.hoursPerWeek = hoursPerWeek;
		this.totalHours = totalHours;
		this.apm = apm;
		this.selectByHotkeys = selectByHotkeys;
		this.assignToHotkeys = assignToHotkeys;
		this.uniqueHotkeys = uniqueHotkeys;
		this.minimapAttacks = minimapAttacks;
		this.minimapRightClicks = minimapRightClicks;
		this.numberOfPACs = numberOfPACs;
		this.gapBetweenPACs = gapBetweenPACs;
		this.actionLatency = actionLatency;
		this.actionsInPAC = actionsInPAC;
		this.totalMapExplored = totalMapExplored;
		this.workersMade = workersMade;
		this.uniqueUnitsMade = uniqueUnitsMade;
		this.complexUnitsMade = complexUnitsMade;
		this.complexAbilitiesUsed = complexAbilitiesUsed;
		
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

	public float getApm() {
		return apm;
	}

	public void setApm(float apm) {
		this.apm = apm;
	}

	public float getSelectByHotkeys() {
		return selectByHotkeys;
	}

	public void setSelectByHotkeys(float selectByHotkeys) {
		this.selectByHotkeys = selectByHotkeys;
	}

	public float getAssignToHotkeys() {
		return assignToHotkeys;
	}

	public void setAssignToHotkeys(float assignToHotkeys) {
		this.assignToHotkeys = assignToHotkeys;
	}

	public float getUniqueHotkeys() {
		return uniqueHotkeys;
	}

	public void setUniqueHotkeys(float uniqueHotkeys) {
		this.uniqueHotkeys = uniqueHotkeys;
	}

	public float getMinimapAttacks() {
		return minimapAttacks;
	}

	public void setMinimapAttacks(float minimapAttacks) {
		this.minimapAttacks = minimapAttacks;
	}

	public float getMinimapRightClicks() {
		return minimapRightClicks;
	}

	public void setMinimapRightClicks(float minimapRightClicks) {
		this.minimapRightClicks = minimapRightClicks;
	}

	public float getNumberOfPACs() {
		return numberOfPACs;
	}

	public void setNumberOfPACs(float numberOfPACs) {
		this.numberOfPACs = numberOfPACs;
	}

	public float getGapBetweenPACs() {
		return gapBetweenPACs;
	}

	public void setGapBetweenPACs(float gapBetweenPACs) {
		this.gapBetweenPACs = gapBetweenPACs;
	}

	public float getActionLatency() {
		return actionLatency;
	}

	public void setActionLatency(float actionLatency) {
		this.actionLatency = actionLatency;
	}

	public float getActionsInPAC() {
		return actionsInPAC;
	}

	public void setActionsInPAC(float actionsInPAC) {
		this.actionsInPAC = actionsInPAC;
	}

	public float getTotalMapExplored() {
		return totalMapExplored;
	}

	public void setTotalMapExplored(float totalMapExplored) {
		this.totalMapExplored = totalMapExplored;
	}

	public float getWorkersMade() {
		return workersMade;
	}

	public void setWorkersMade(float workersMade) {
		this.workersMade = workersMade;
	}

	public float getUniqueUnitsMade() {
		return uniqueUnitsMade;
	}

	public void setUniqueUnitsMade(float uniqueUnitsMade) {
		this.uniqueUnitsMade = uniqueUnitsMade;
	}

	public float getComplexUnitsMade() {
		return complexUnitsMade;
	}

	public void setComplexUnitsMade(float complexUnitsMade) {
		this.complexUnitsMade = complexUnitsMade;
	}

	public float getComplexAbilitiesUsed() {
		return complexAbilitiesUsed;
	}

	public void setComplexAbilitiesUsed(float complexAbilitiesUsed) {
		this.complexAbilitiesUsed = complexAbilitiesUsed;
	}
	
	/**
	 * Return the attributes array used to find the player's league.
	 * @return float[] contenant les attributs a comparer
	 */
	public float[] getAttributes(){
		return new float[]{	assignToHotkeys,
							uniqueHotkeys, 
							numberOfPACs, 
							gapBetweenPACs, 
							actionLatency,
							actionsInPAC};
	}

}
