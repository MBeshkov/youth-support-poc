
import java.util.Scanner;

public class DemoConfiguration { // blueprint for demo settings

	private String privacyMode;
	private String answer = "";
	private boolean lockdownFlag; // important for the YoungAdult class, as activities of a certain type cannot be added once a lockdown is in effect

	public void section() {
		System.out.println("..................................................................................\n");
	}

	public void securityChecker() { // decided to implement Privacy Mode as optional and left the decision in the hands of the user
		Scanner privacy = new Scanner(System.in);

		System.out.println("Turn on private mode? (Type in either Yes or No and press enter.)\n");

		while (!this.answer.equals("Yes") || !this.answer.equals("No") || !this.answer.equals("yes")
				|| !this.answer.equals("no")) {
			this.answer = privacy.nextLine();

			if (this.answer.equals("Yes") || this.answer.equals("yes")) {
				this.privacyMode = "On";
				break;
			} else if (this.answer.equals("No") || this.answer.equals("no")) {
				this.privacyMode = "Off";
				break;
			} else {
				System.out.println("Give me a valid answer.");
			}
		}
		privacy.close();

	}

	public void availableActivitiesChecker(YoungAdult youngAdult) { 
		System.out.println("These days I am able to experience: " + youngAdult.printActivities() + "\n");
	}

	public String getPrivacyMode() {
		return privacyMode;
	}

	public boolean isLockdownFlag() {
		return lockdownFlag;
	}

	public void setLockdownFlag(boolean lockdownFlag) {
		this.lockdownFlag = lockdownFlag;
	}
}
