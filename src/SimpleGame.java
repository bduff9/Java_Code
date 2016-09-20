import java.util.Random;

public class SimpleGame {

	static int roll;

	public static void main(String[] args) {
		rollDie();
	}

	static void rollDie() {
		Random rand = new Random();
		roll = rand.nextInt(6) + 1;
		printRoll();
		if (roll < 3) {
			System.out.println("You lose!");
		} else if (roll < 6) {
			System.out.println("Roll again!");
			System.out.println();
			rollDie();
		} else {
			System.out.println("You win!");
		}
	}

	static void printRoll() {
		System.out.println("You rolled a " + roll + ".");
	}

}
