
public class Adult extends Person { // subclass of Person
	private String hobby;

	public Adult(String firstName, String lastName, String birthday, String gender, String mobileNumber,
			String privacyMode, String hobby) {
		super(firstName, lastName, birthday, gender, mobileNumber, privacyMode);
		this.hobby = hobby;
		int i = Integer.parseInt(birthday);
		if (i > 1997) { // ensures the user cannot create an Adult object that isn't really an adult (decided that using just the year and not the actual birthday is enough for the scope of the current assignment)
			System.out.println("You wanted an adult but created something different. Start over.");
			System.exit(0);
		}
	}

	public String getHobby() {
		return hobby;
	}

	@Override
	public String toString() { 
		String output = String.format("Hi!. I am %s %s, a %s born in %s. I love %s. You can call me on %s.\n",
				getFirstName(), getLastName(), getGender(), getBirthday(), getHobby(), getMobileNumber());
		return output;
	}
}