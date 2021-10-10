import java.util.ArrayList;
import java.util.List;

public class Activity { // a blueprint for activities
	private String activityName;
	private Object Type;
	private String start;
	private String end;
	private List<Person> participants = new ArrayList<>();

	public Activity(String activityName, String ActivityType, String start, String end, YoungAdult mainParticipant, Person ...person) { /* constructor for manual creation of an activity 
																																		   with one or many participants */

		this.activityName = activityName;
		switch (ActivityType) {
		case "educational":
			this.Type = RegularActivityTypes.EDUCATIONAL;
			break;
		case "chore":
			this.Type = RegularActivityTypes.CHORE;
			break;
		case "sports":
			this.Type = RegularActivityTypes.SPORTS;
			break;
		case "entertainment":
			this.Type = RegularActivityTypes.ENTERTAINMENT;
			break;
		case "socialization":
			this.Type = RegularActivityTypes.SOCIALIZATION;
			break;
		}
		this.start = start;
		this.end = end;
		this.participants.add(mainParticipant);
		for (Person i: person) {
			this.participants.add(i);
		}
	}

	public Activity(Object activityType, YoungAdult mainParticipant) { /* constructor used in the youth support class with the purpose of 
																		being able to recommend activities suitable for the person's personality;
																		very basic (just a single activity for each activity type) for the purpose of the assignment, 
																		but a broader implementation would generate many different activities for each type from a list/txt file/enum */
		this.Type = activityType;
		this.participants.add(mainParticipant);
		if (this.Type == RecommendedPandemicActivityTypes.SELF_DEVELOPMENT) {
			this.activityName = "Keeping an emotional intelligence diary";
		} else if (this.Type == RecommendedPandemicActivityTypes.EXERCISE) {
			this.activityName = "At-home workout";
		} else if (this.Type == RecommendedPandemicActivityTypes.MEDITATION) {
			this.activityName = "Guided introspection";
		} else if (this.Type == RecommendedPandemicActivityTypes.CREATIVE) {
			this.activityName = "Fiction writing exercises";
		} else if (this.Type == RecommendedPandemicActivityTypes.ONLINE_VOLUNTEERING) {
			this.activityName = "AIESEC virtual meetings";
		}
	}

	public String getActivityName() {
		return this.activityName;
	}

	public Object getType() {
		return this.Type;
	}

	public String getStart() {
		return this.start;
	}

	public String getEnd() {
		return this.end;
	}

	public String getParticipants() {
		StringBuilder sb = new StringBuilder();
		for (Person s : participants) {
			sb.append(s);
		}
		return sb.toString();
	}

	public String toString() {
		String vowels = "aeiou";
		String res = "";
		String typeName = String.valueOf(Type).toLowerCase();
		if (vowels.indexOf(Character.toLowerCase(typeName.charAt(0))) != -1) {
			res = String.format("%s which is an %s activity", activityName, typeName);
		} else {
			res = String.format("%s which is a %s activity", activityName, typeName);
		}
		res = res.replaceAll("_", " ");
		return res;
	}
}
