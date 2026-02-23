import java.util.*;

public class GameController{
	
	public static boolean restartGame(Scanner sc){
		System.out.println("Do you want to play again? (y/n) : ");
		return sc.nextLine().equalsIgnoreCase("y");
	}
}