
public class YouthSupport {
	private Object Type;
	private YoungAdult youngAdult;

	YouthSupport(YoungAdult youngAdult) {
		this.youngAdult = youngAdult;
	}

	public void recommend(YoungAdult youngAdult) {
		if (youngAdult.getPersonality().get("Openness") > 3) { // someone with a sense of curiosity will enjoy a self development activity
			this.Type = RecommendedPandemicActivityTypes.SELF_DEVELOPMENT;
			create();
		} else if (youngAdult.getPersonality().get("Extraversion") > 3) { // someone who seeks excitement or adventure will enjoy an exercise activity
			this.Type = RecommendedPandemicActivityTypes.EXERCISE;
			create();
		} else if (youngAdult.getPersonality().get("Neuroticism") > 3) { // someone who feels insecure and vulnerable will enjoy a meditation activity
			this.Type = RecommendedPandemicActivityTypes.MEDITATION;
			create();
		} else if (youngAdult.getPersonality().get("Conscientiousness") > 3) { // someone goal-driven with a knack for keeping things in order will enjoy a creative activity
			this.Type = RecommendedPandemicActivityTypes.CREATIVE;
			create();
		} else if (youngAdult.getPersonality().get("Agreeableness") > 3) { // someone who is caring and interested in people will enjoy an online volunteering activity
			this.Type = RecommendedPandemicActivityTypes.ONLINE_VOLUNTEERING;
			create();
		}
	}

	private void create() {
		Activity newActivity = new Activity(Type, youngAdult); // creates a new activity
		youngAdult.getActivities().add(newActivity); // adds it to the list with available for the young adult activities
	}
}
