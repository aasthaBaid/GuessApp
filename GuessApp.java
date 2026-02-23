/*
Saving results of people in another text file.
@author developer
@version 6.0
*/
import java.util.*;
public class GuessApp {
	public static void main(String[] args) throws InvalidInputException {
		System.out.println("Welcome to the game");
		boolean restart;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter player name: ");
			String player = sc.nextLine();
			
			GameConfig game = new GameConfig();
			game.showRules();
			
			int attempts = 0;
			int hintCount = 0;
			
			boolean win = false;
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
			StorageService.saveResult(player,attempts,win);
			restart = GameController.restartGame(sc);
		}while(restart);
	}	
}

