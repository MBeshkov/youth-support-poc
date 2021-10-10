
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YoungAdult extends Person { // subclass of Person
	final private HashMap<String, Person> socialNetwork = new HashMap<String, Person>(); // stores a young adult's connections with other people
	private String[] feelings = new String[3]; // a young adult's emotions
	private List<Activity> activities = new ArrayList<>(); // the activities that a young adult is able to experience at a given point in time

	public YoungAdult(String firstName, String lastName, String birthday, String gender, String mobileNumber,
			String privacyMode) {
		super(firstName, lastName, birthday, gender, mobileNumber, privacyMode);
		int i = Integer.parseInt(birthday);
		if (i > 2005 || i < 1997) { // ensures the user cannot create a YoungAdult object that isn't really a young adult (decided that using just the year and not the actual birthday is enough for the scope of the current assignment)
			System.out.println("You wanted a young adult but created something different. Start over.");
			System.exit(0);
		}

	}

	public void addNetwork(Person tutor, Person mother, Person father, Person sibling, Person friend) {
		socialNetwork.put("Tutor", tutor);
		socialNetwork.put("Mother", mother);
		socialNetwork.put("Father", father);
		socialNetwork.put("Sibling", sibling);
		socialNetwork.put("Friend", friend);
	}

	public void addActivity(Activity activity, DemoConfiguration config) { // important for ensuring the young adult gives the correct emotional response to the activity in their day
		if (config.isLockdownFlag() == false) {
			if (activity.getType() == RegularActivityTypes.EDUCATIONAL) {
				if (this.getPersonality().get("Openness") > 3) { // someone with a sense of curiosity will enjoy an educational activity
					generatePositiveFeelings();
				} else {
					generateNegativeFeelings();
				}
			} else if (activity.getType() == RegularActivityTypes.CHORE) {
				if (this.getPersonality().get("Conscientiousness") > 3) { // someone goal-driven with a knack for keeping things in order will enjoy a chore activity
					generatePositiveFeelings();
				} else {
					generateNegativeFeelings();
				}
			} else if (activity.getType() == RegularActivityTypes.SPORTS) {
				if (this.getPersonality().get("Extraversion") > 3) { // someone who seeks excitement or adventure will enjoy a sports activity
					generatePositiveFeelings();
				} else {
					generateNegativeFeelings();
				}
			} else if (activity.getType() == RegularActivityTypes.ENTERTAINMENT) {
				if (this.getPersonality().get("Neuroticism") > 3) { // someone who feels insecure and vulnerable might not enjoy wasting time on entertainment
					generateNegativeFeelings();
				} else {
					generatePositiveFeelings();
				}
			} else if (activity.getType() == RegularActivityTypes.SOCIALIZATION) {
				if (this.getPersonality().get("Agreeableness") > 3) { // someone who is caring and interested in people will enjoy a socialization activity
					generatePositiveFeelings();
				} else {
					generateNegativeFeelings();
				}
			}
			activities.add(activity);
		} else { // if a lockdown is in effect, the only type of activity that can be added is a chore one; other types must be recommended by the youth support service
			if (activity.getType() == RegularActivityTypes.CHORE) {
				if (this.getPersonality().get("Conscientiousness") > 3) {
					generatePositiveFeelings();
				} else {
					generateNegativeFeelings();
				}
			} else {
				System.out.println("The activity you tried is forbidden during a lockdown!");
			}
		}
		
	}

	public void addActivity(YouthSupport youthSupport) { // method overload; uses a YouthSupport object to recommend an activity suitable for the person and compliant with lockdown
		youthSupport.recommend(this);
		generatePositiveFeelings();
	}

	private void generatePositiveFeelings() { // uses the FeelingGenerator object to "come up" with random positive emotions
		FeelingGenerator gen = new FeelingGenerator("positive");
		gen.generate();
		feelings = gen.getGeneratedFeelings().clone();
	}
 
	private void generateNegativeFeelings() { // uses the FeelingGenerator object to "come up" with random negative emotions
		FeelingGenerator gen = new FeelingGenerator("negative");
		gen.generate();
		feelings = gen.getGeneratedFeelings().clone();
	}

	public void lockdownInEffect(Lockdown lockdown) { // removes activities that aren't compliant with lockdown rules
		for (int j = 0; j < lockdown.getForbiddenActivities().size(); j++) {
			for (int i = 0; i < activities.size(); i++) {
				if (lockdown.getForbiddenActivities().contains(activities.get(i).getType())) {
					activities.remove(i);
				}
			}
		}
		generateNegativeFeelings();
	}

	public String getFeelings() {
		return ("Today I am feeling " + feelings[0].toLowerCase() + ", " + feelings[1].toLowerCase() + " and "
				+ feelings[2].toLowerCase() + ".\n");
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public String printActivities() { // print-friendly version of the available activities
		if (activities.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Activity s : activities) {
				sb.append(s);
				sb.append("; ");
			}
			return sb.toString();
		} else {
			return "nothing noteworthy.";
		}
	}

	public String getNetwork() { // print-friendly version of the young adult's relationships
		String network = String.format(
				"I go to %s for consultations. %s is my mum and %s is my dad.\n I also live with %s and in my free time I hang out with %s.\n",
				socialNetwork.get("Tutor").getFirstName(), socialNetwork.get("Mother").getFirstName(),
				socialNetwork.get("Father").getFirstName(), socialNetwork.get("Sibling").getFirstName(),
				socialNetwork.get("Friend").getFirstName());
		return network;
	}

	@Override
	public String toString() {
		String output = String.format("Hi! I am %s %s, a %s born in %s. You can call me on %s.\n", getFirstName(),
				getLastName(), getGender(), getBirthday(), getMobileNumber());
		return output;

	}
}
