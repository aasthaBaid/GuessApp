/*
Make guesses
@author developer
@version 2.0
*/
import java.util.*;
public class GuessApp {
	public static void main(String[] args){
		System.out.println("Welcome to the game");
		GameConfig game = new GameConfig();
		game.showRules();
		Scanner sc = new Scanner(System.in);
		int attempts = 0;
		while(attempts < game.getMaxAttempts()){
			System.out.println("Enter you guess:" );
			int guess = sc.nextInt();
			attempts++;
			String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
			System.out.println(result);
			if("CORRECT".equals(result)) break;
		}
	}	
}
