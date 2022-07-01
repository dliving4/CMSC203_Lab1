import java.util.Scanner;

public class RandomNumberGuesser {
	static Scanner userInput = new Scanner(System.in);
	
	static int nextGuess;
	static int highGuess;
	static int lowGuess;
	static int randNum;
	static int cont;
	static boolean playing = true;
	static boolean guessing = true;
	
	public static void main(String[] args) {
		
		while(playing == true) {
			
			System.out.println("Enter your first guess");
			
			RNG.resetCount();
			randNum = RNG.rand();
			highGuess = 100;
			lowGuess = 0;
			
			while(guessing == true) {
				
				nextGuess = userInput.nextInt();
				
				if(RNG.inputValidation(nextGuess, lowGuess, highGuess) == true) {
					
					System.out.println("Number of guesses is " + RNG.getCount());
					
					if(nextGuess == randNum) {
						
						System.out.println("Congratulations, you guessed correctly");
						guessing = false;
						break;
						
					}
					if(nextGuess > randNum) {
						
						System.out.println("Your guess is too high");
						highGuess = nextGuess;
						System.out.print("Enter your next guess between " + lowGuess + " and " + highGuess);
						
					}
					if(nextGuess < randNum) {
						
						System.out.println("Your guess is too low");
						lowGuess = nextGuess;
						System.out.print("Enter your next guess between " + lowGuess + " and " + highGuess);
						
					}
					
				} else if(RNG.inputValidation(nextGuess, lowGuess, highGuess) == false){
					System.out.println("   >>> Guess must be between "+ lowGuess +" and "+ highGuess + ".  Try again");	
				}
				
			}
			
			System.out.println("Try again? (yes(1) or no(2))");
			
			cont = userInput.nextInt();
			
			if(cont == 1) {
				guessing = true;
				continue;
			} else if(cont == 2){
				System.out.println("Thanks for playing...");
				playing = false;
				break;
			} 
			
		}
	}
}
