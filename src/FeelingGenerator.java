
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class FeelingGenerator { // blueprint for generator of random feelings
	private String[] generatedFeelings = new String[3];
	private String fileName;

	public FeelingGenerator(String emotionalState) { // determines if the generated feelings will be positive or negative
		if (emotionalState == "positive") {
			fileName = "src/positive.txt";
		} else {
			fileName = "src/negative.txt";
		}
	}

	public void generate() { // populates the generatedFeelings array with emotions necessary for the YoungAdult class
		String text = null;

		try {

			for (int i = 0; i < 3; i++) {

				Random random = new Random();
				int arbitraryNumber = random.nextInt(43);
				text = Files.readAllLines(Paths.get(fileName)).get(arbitraryNumber);
				generatedFeelings[i] = text;
				
				for (int j = 0; j < generatedFeelings.length; j++) { // ensures the generator won't supply identical feelings
					for (int k = j + 1; k < generatedFeelings.length; k++) {
						if (k != j && generatedFeelings[k] == generatedFeelings[j]) {
							text = Files.readAllLines(Paths.get(fileName)).get(arbitraryNumber);
							generatedFeelings[k] = text;
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String[] getGeneratedFeelings() {
		return generatedFeelings;
	}

}
