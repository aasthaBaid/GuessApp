import java.util.*;

public class GuessValidator{
	public static String validateGuess(int guess, int target){
		if(guess == target) return "CORRECT";
		else if(guess < target) return "It's LOW";
		else return "It's HIGH";
	}
}