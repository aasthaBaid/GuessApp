public class ValidationService {
	public static int validateInput(String input) throws InvalidInputException {
		// using custom exception handling, to make sure that user inputs numbers between 1 and 100.
		try  {
			int value = Integer.parseInt(input);
			if(value < 1 || value > 100) {
				throw new InvalidInputException( " Number must between 1 and 100" );
			}
			return value;
		}
		catch (NumberFormatException e){
			throw new InvalidInputException("Invalid input, please enter numbers only");
		}
	}
		
}