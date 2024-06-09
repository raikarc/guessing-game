import java.util.*;
class Main {
  public static void main(String[] args) {
		guessing();

	}
	
	public static void guessing() {
		Scanner console = new Scanner(System.in);
		int rounds = 1;
		int guesses = 0;
		int bestGuesses = 0;
		int cumulativeGuesses = guesses;
		boolean playing = true;
		boolean displayStats = false;
		
		while (playing) {
			Random rand = new Random();
			int randNum = rand.nextInt(100) + 1;
			
			System.out.println("I'm thinking of a number between 1 and 100...");
			System.out.println("Your guess?");
			int guess = console.nextInt();
			
			//int length = guess.length();
			int testing = 0;
			boolean valid_input = false;
		
//			while (length > 3) {
//				System.out.println("Your guess was not a whole number between 1 and 100");
//				System.out.println("Your guess?");
//				guess = console.next();
//				length = guess.length();
//			}
//			
//			while (valid_input)
//			for (int i = 0; i < length; i++) {
//				if (guess.charAt(i) >= 48 && guess.charAt(i) <= 57) {
//					testing += 1;
//				}
//				else {
//					System.out.println("Your guess was not a whole number between 1 and 100");
//					System.out.println("Your guess?");
//					guess = console.next();
//					length = guess.length();
//				}
//				if (testing == length) {
//					guess = (int) guess;
//				}
//			}
			
			while (guess != randNum) {
				guesses += 1;
				
				if (randNum > guess) {
					System.out.println("It's higher.");
				} 
				else if (guess > randNum) {
					System.out.println("It's lower.");
				} 
				
				System.out.println("Your guess?");
				guess = console.nextInt();
				guesses += 1;
			} 
			
			if (guess == randNum) {
				System.out.println("You guessed it in " + guesses + " guesses!");
			}	
			
			System.out.println("Play again?");
			String playAgain = console.next();
			System.out.println();
			
			if (guesses < bestGuesses) {
				bestGuesses = guesses;
			}
			
			cumulativeGuesses += guesses;
			guesses = 0;
			
			if (playAgain.charAt(0) == 'y' || playAgain.charAt(0) == 'Y') {
				playing = true;
				rounds += 1;
			}
			else {
				displayStats = true;
				playing = false;
			}
			
		}
		
		if (displayStats) {
			System.out.println("Your overall results:");
			System.out.println("Total games = " + rounds);
			System.out.println("Total guesses = " + cumulativeGuesses);
			System.out.println("Guesses/game = " + (double) (cumulativeGuesses/rounds));
			System.out.println("Best game = " + bestGuesses);
		}
		
		
	}
}