/*
Error Handling & validation
@author developer
@version 4.0
*/
import java.util.*;
public class GuessApp {
	public static void main(String[] args) throws InvalidInputException {
		System.out.println("Welcome to the game");
		GameConfig game = new GameConfig();
		game.showRules();
		Scanner sc = new Scanner(System.in);
		int attempts = 0;
		int hintCount = 0;
		while(attempts < game.getMaxAttempts()){
			System.out.println("Enter you guess:" );
			// exception handling
			int guess = ValidationService.validateInput(sc.nextLine());
			attempts++;
			String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
			// if result is not correct, look for hints
			if(!"CORRECT".equals(result) && hintCount < game.getMaxHints()){
				hintCount++;
				System.out.println(HintService.generateHint(game.getTargetNumber(),hintCount));
			}
			System.out.println(result);
			// break the loop when found
			if("CORRECT".equals(result)) break;
		}
	}	
}
