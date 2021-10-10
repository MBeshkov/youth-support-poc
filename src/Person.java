
import java.util.HashMap;


public class Person { // superclass of the YoungAdult and Adult classes

	private HashMap<String, String> personalInformation = new HashMap<String, String>(); // stores a person's details
	private HashMap<String, Integer> personality = new HashMap<String, Integer>(); // stores a person's personality characteristics

	public Person(String firstName, String lastName, String birthday, String gender, String mobileNumber,
			String privacyMode) {
		personalInformation.put("First Name", firstName);
		personalInformation.put("Last Name", lastName);
		personalInformation.put("Birth year", birthday);
		personalInformation.put("Gender", gender);
		personalInformation.put("Number", mobileNumber);
		personalInformation.put("Privacy", privacyMode);
	}

	public String getFirstName() { // will return a dummy value if the user turned on privacy mode; same applies for the a majority of the other "get" methods too
		if (this.personalInformation.get("Privacy") == "On") {
			return "REDACTED";
		} else {
			return this.personalInformation.get("First Name");
		}
	}

	public void setFirstName(String firstName) {
		this.personalInformation.replace("First Name", firstName);

	}

	public String getLastName() {
		if (this.personalInformation.get("Privacy") == "On") {
			return "REDACTED";
		} else {
			return this.personalInformation.get("Last Name");
		}
	}

	public void setLastName(String lastName) {
		this.personalInformation.replace("Last Name", lastName);
	}

	public String getBirthday() {
		if (this.personalInformation.get("Privacy") == "On") {
			return "REDACTED";
		} else {
			return this.personalInformation.get("Birth year");
		}
	}

	public void setBirthday(String birthday) {
		this.personalInformation.replace("Birth year", birthday);

	}

	public String getMobileNumber() {
		if (this.personalInformation.get("Privacy") == "On") {
			return "REDACTED";
		} else {
			return this.personalInformation.get("Number");
		}
	}

	public void setMobileNumber(String mobileNumber) {
		this.personalInformation.replace("Number", mobileNumber);

	}

	public String getGender() {
		if (this.personalInformation.get("Privacy") == "On") {
			return "REDACTED";
		} else {
			return this.personalInformation.get("Gender");
		}
	}

	public void setGender(String gender) {
		this.personalInformation.replace("Number", gender);
	}

	public void setPersonality(Integer conscientiousness, Integer agreeableness, Integer neuroticism, Integer openness,  // in charge of specifying the personality characteristics of a person
			Integer extraversion) {
		personality.put("Conscientiousness", conscientiousness);
		personality.put("Agreeableness", agreeableness);
		personality.put("Neuroticism", neuroticism);
		personality.put("Openness", openness);
		personality.put("Extraversion", extraversion);

	}

	public HashMap<String, Integer> getPersonality() {
		return personality;
	}

}
