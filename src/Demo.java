
public class Demo {

	public static void main(String[] args) {

		DemoConfiguration config = new DemoConfiguration(); // in charge of the demo behavior and privacy settings

		config.securityChecker(); // invoke the method that asks the user about the privacy settings

		YoungAdult natalie = new YoungAdult("Natalie", "Jameson", "2000", "female", "0884407280", config.getPrivacyMode()); // creates the young adult that is the main topic of this demonstration
		Adult tutor = new Adult("Garry", "Bowie", "1970", "male", "5687492745", config.getPrivacyMode(), "archery"); // creates an adult tutor
		Adult mum = new Adult("Nicole", "Kidman", "1969", "female", "0123456789", config.getPrivacyMode(), "knitting"); // creates an adult mom
		Adult dad = new Adult("Ryan", "Gosling", "1975", "male", "9876543210", config.getPrivacyMode(), "racing"); // creates an adult dad
		YoungAdult sibling = new YoungAdult("Emma", "Watson", "2001", "female", "4536271894", config.getPrivacyMode()); // creates a young adult sibling
		YoungAdult friend = new YoungAdult("Ricky", "Gervais", "1999", "male", "1029384756", config.getPrivacyMode()); // creates a young adult friend

		natalie.addNetwork(tutor, mum, dad, sibling, friend); // invokes the method that specifies the relationships between the main young adult and the rest of the person objects that were creates

		System.out.println(natalie); // the personal details of the important young adult

		config.section(); // just for tidiness sake

		System.out.println(natalie.getNetwork()); // the details of the young adult's relationship with others

		config.section();

		natalie.setPersonality(5, 3, 1, 4, 3); // determines the young adult's personality traits (conscientiousness, agreeableness, neuroticism, openness, extraversion)
		tutor.setPersonality(1, 2, 3, 4, 5); // the following few lines determine other people's personalities as requested by the assignment
		mum.setPersonality(5, 4, 3, 2, 1);
		dad.setPersonality(1, 2, 3, 2, 1);
		sibling.setPersonality(5, 3, 1, 3, 5);
		friend.setPersonality(5, 5, 2, 5, 5);

		natalie.addActivity(new Activity("Pub crawl", "socialization", "21:30", "01:12", natalie, friend), config); // adds an activity using a constructor that allows an additional participant

		System.out.println("Pre lockdown after a not so enjoyable activity: " + natalie.getFeelings()); /* demonstrates that even before a lockdown, 
		                                                                                                   an activity can invoke unpleasant feelings if it is not suited to the person's personality
		                                                                                                   (in this case Natalie doesn't enjoy socialization activities) */

		natalie.addActivity(new Activity("Museum Visit", "educational", "10:30", "13:45", natalie), config); // adds an activity using a constructor for only one participant

		System.out.println("Pre lockdown after an enjoyable activity: " + natalie.getFeelings()); /* demonstrates the effect of an activity suited to a person's personality 
																									 (Natalie enjoys educational  activities) */

		config.availableActivitiesChecker(natalie); // demonstrates the activities that the young adult can experience in a day 
		
		// System.out.println(natalie.getActivities().get(0).getParticipants()); --> run this if you want to see the participants involved in a particular activity

		config.section();

		natalie.lockdownInEffect(new Lockdown(30, config)); // a new lockdown comes into effect

		System.out.println("Lockdown in effect: " + natalie.getFeelings()); // demonstrates the effect a lockdown has on emotions

		config.availableActivitiesChecker(natalie); // demonstrates the effect a lockdown has on the activities a young adult can experience in a day

		natalie.addActivity(new YouthSupport(natalie)); // the service comes into effect

		config.section();

		System.out.println("In lockdown with Youth Support: " + natalie.getFeelings()); // demonstrates the effect the support service has on emotions

		config.availableActivitiesChecker(natalie); // demonstrates the effect the support service has on the activities a young adult can experience in a day
		
		config.section();
		
		natalie.addActivity(new Activity("Pub crawl", "socialization", "21:30", "01:12", natalie, friend), config); // demonstrates that an activity not compliant with the lockdown cannot be added
		

	}

}
