
import java.util.ArrayList;
import java.util.List;

public class Lockdown { //blueprint for a lockdown

	final private List<Object> forbiddenActivities = new ArrayList<>();
	private int durationInDays;

	public Lockdown(Integer durationInDays, DemoConfiguration config) { // constructor that populates the list with activities to be removed from a young adult's day
		this.durationInDays = durationInDays;
		forbiddenActivities.add(RegularActivityTypes.EDUCATIONAL);
		forbiddenActivities.add(RegularActivityTypes.ENTERTAINMENT);
		forbiddenActivities.add(RegularActivityTypes.SOCIALIZATION);
		forbiddenActivities.add(RegularActivityTypes.SPORTS);
		config.setLockdownFlag(true);
	}

	public List<Object> getForbiddenActivities() {
		return forbiddenActivities;
	}

	public int getDurationInDays() {
		return durationInDays;
	}

}
