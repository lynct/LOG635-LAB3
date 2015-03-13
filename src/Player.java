
public class Player {
	
	private int gamerId;
	private int league;	
	private int age;
	private int hoursPerWeek;
	private int totalHours;
	private int apm;
	private int selectByHotkeys;
	private int assignToHotkeys;
	private int uniqueHotkeys;
	private int minimapAttacks;
	private int minimapRightClicks;
	private int numberOfPACs;
	private int gapBetweenPACs;
	private int actionLatency;
	private int actionsInPAC;
	private int totalMapExplored;
	private int workersMade;
	private int uniqueUnitsMade;
	private int complexUnitsMade;
	private int complexAbilitiesUsed;

	public Player(int gamerId, int league, int age, int hoursPerWeek, int totalHours, int apm, int selectByHotkeys, int assignToHotkeys,
			int uniqueHotkeys, int minimapAttacks, int minimapRightClicks, int numberOfPACs, int gapBetweenPACs, int actionLatency, int actionsInPAC,
			int totalMapExplored, int workersMade, int uniqueUnitsMade, int complexUnitsMade, int complexAbilitiesUsed){
		
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

}
