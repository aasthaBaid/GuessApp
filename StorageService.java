
import java.util.*;
import java.io.*;
public class StorageService{
	public static void saveResult(String player , int attempts, boolean win){
		try (BufferedWriter writer = new BufferedWriter(
			new FileWriter("game_Results.txt", true))) {
				writer.write("Player: " + player + 
							", Attempts: " + attempts + 	
							", Result: " + (win ? "WIN" : "LOSE"));
				writer.newLine();
			}
			catch(IOException e){
				System.out.println("Unable to save game result");
			}
	}
}