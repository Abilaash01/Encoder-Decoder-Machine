/**
 * This program encodes/decodes messages the user inputs using the caesar cipher algorithm.
 * First the user chooses whether to encode, decode, or go through a tutorial.
 * It takes in user's input for a number which will be used to make the new alphabet using this algorithm.
 * Then the user will enter a message to encode or decode, which the program takes in and checks whether it's valid or not.
 * The program then encodes or decodes the message and outputs it the the console. The user finally inputs whether they
 * want to encode or decode another message or not, if yes, the program repeats, if not, then a table of statistics would
 * be shown at the end.
 * 
 * Authors: Abilaash, Uthayachandran  &  Devang, Sharma
 * Date: June/14/2018
 * 
 **/
import java.util.*;

public class EncoderDecoderMachine {

	/* DECLARE AND INITIALIZE SCANNER, VARIABLES AND ARRAYS. ASSIGN VALUES FOR SOME */

	public static Scanner in = new Scanner(System.in);
	public static char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public static char newAlphabet[] = new char[26];
	public static char tempAlphabetArray[] = new char[26];
	public static char caesarCipher2DArray[][] = new char[26][26];
	public static int count = -1;
	public static String userChoice, tempKeyNum, userMessage, keyMessage;
	public static char userContinueResponse;
	public static int keyNum, numOfLettersEncodedDecoded = 0, numOfLettersEncoded = 0, numOfLettersDecoded = 0,
			numOfWordsEncoded = 0, numOfWordsDecoded = 0, numOfWordsEncodedDecoded = 0, spaceCount = 0;
	public static double avgLettersPerWordEncodedDecoded = 0;


	public static void main(String[] args) {
		/* MAIN PART OF THE PROGRAM. CONNECTS TO THE INTRODUCTION METHOD TO GET USER INPUT. ALSO CONNECTS TO ENCODE/DECODE METHODS */

		//First display the name of the program and give a brief explanation of what the program does.
		System.out.println("\t\t\t\t\t\t\tWelcome to the CC Encoder-Decoder Machine!!!!");
		System.out.println("I can encode or decode any message you desire.");

		/* LOOP THE ENCODE/DECODE PART OF THE PROGRAM UNTIL USER ENTERS NO AS LAST RESPONSE TO EXIT */

		do {
			// Give the user choices to choose from and get user input.
			System.out.println("");
			System.out.println("-------------------------------------------");
			System.out.println("");
			System.out.println("You have 3 options to choose from:");
			System.out.println("(1) Encode a message");
			System.out.println("(2) Decode a message");
			System.out.println("(3) Tutorial");
			System.out.println("");
			System.out.print("Please enter an option: ");
			userChoice = in.nextLine();

			// Check if the user's input is valid, if so, continue to next part, if not, prompt again for the input.
			for(int i = 0; i < userChoice.length(); i++) {
				if(Character.isLetter(userChoice.charAt(i)) || Integer.parseInt(userChoice) < 1 || Integer.parseInt(userChoice) > 3
						|| Character.isSpace(userChoice.charAt(i))) {
					while(Character.isLetter(userChoice.charAt(i)) || Integer.parseInt(userChoice) <= 0 || Integer.parseInt(userChoice) > 3
							|| Character.isSpace(userChoice.charAt(i))) {
						System.out.println("");
						System.out.println("Invalid input, the option must be between 1-3!");
						System.out.print("Please enter an option: ");
						userChoice = in.nextLine();
						i = 0;
					}
				}
			}

			/* CHECK WHICH CHOICE THE USER INPUT. IF IT IS CHOICE 1, CONTINUE TO THE ENCODE SECTION, IF IT IS 2,
			 * CONTINUE TO THE DECODE SECTION, IF IT IS 3, CONTINUE TO THE TUTORIAL SECTION */
			if(Integer.parseInt(userChoice) == 1) {
				// Go through the introduction method
				introduction();
				// Print the encoded message
				System.out.println("");
				System.out.println("Here is the encoded message of '" + userMessage + "': " + encodeMessage(userMessage, keyMessage));

			} else if(Integer.parseInt(userChoice) == 2) {
				// Go through the introduction method
				introduction();
				// Output the decoded message
				System.out.println("");
				System.out.println("Here is the decoded message of '" + userMessage + "': " + decodeMessage(userMessage, keyMessage));

			} else {
				// Go through the tutorial method
				tutorial();
				spaceCount = 0;
				String tempEncodedMessage = encodeMessage(userMessage, keyMessage);
				System.out.println("");
				System.out.println("Here is the encoded message: " + encodeMessage(userMessage, keyMessage));
				System.out.println("");
				System.out.println("If the user wants to decode the message, they should input the same key number, the encoded message as their first message,"
						+ " and the same key message");
				System.out.println("to get the right decoded message.");
				System.out.println("");
				System.out.println("In this case, your decoded message of '" + encodeMessage(userMessage, keyMessage) + "', if you input the key number");
				System.out.println("as " + keyNum + ", the user message as '" + encodeMessage(userMessage, keyMessage) + "', and the key message");
				System.out.println("as '" + keyMessage + "', would be: " + decodeMessage(tempEncodedMessage, keyMessage));
				System.out.println("");
				System.out.println("You can choose to encode/decode another message or leave. At the end, a summary of statistics will be shown.");
			}

			// Ask and get from user if they want to encode/decode another message or not
			System.out.print("Do you want to encode/decode another message? Please enter (y/n): ");
			userContinueResponse = in.nextLine().charAt(0);

			// Check if user's input is valid or not
			if(userContinueResponse != 'y' && userContinueResponse != 'Y' && userContinueResponse != 'n' && userContinueResponse != 'N') {
				System.out.println("");
				System.out.println("Invalid input. You must choose either 'y' or 'n'!");
				System.out.print("Do you want to encode/decode another message? Please enter (y/n): ");
				userContinueResponse = in.nextLine().charAt(0);
			}

			// count becomes neutral again for the next time a letter is encoded or decoded
			count = -1;

		} while(userContinueResponse == 'y' || userContinueResponse == 'Y');


		// This section displays the statistics recorded through all of the user's calls.
		avgLettersPerWordEncodedDecoded = numOfLettersEncodedDecoded * 1.0 / numOfWordsEncodedDecoded;
		System.out.println("");
		System.out.println("");
		System.out.println("========================================================================");
		System.out.println("");
		System.out.println("STATISTICS");
		System.out.println("----------");
		System.out.println("");
		System.out.println("Total number of letters encoded/decoded: " + numOfLettersEncodedDecoded);
		System.out.println("Total number of letters encoded: " + numOfLettersEncoded);
		System.out.println("Total number of letters decoded: " + numOfLettersDecoded);
		System.out.println("Total number of words encoded/decoded: " + numOfWordsEncodedDecoded);
		System.out.println("Total number of words encoded: " + numOfWordsEncoded);
		System.out.println("Total number of words decoded: " + numOfWordsDecoded);
		System.out.println("Total number of letters per word encoded/decoded: " + avgLettersPerWordEncodedDecoded);
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\tThank you for using CC Encoder-Decoder Machine!!!!");

		in.close();

	}

	
	public static void introduction() {
		/* Introduction THE PROGRAM AND GETS THE USER'S INPUTS */

		// User enters a key number for the new alphabet array
		System.out.println("");
		System.out.print("Please enter the key number between 0-26 for the new alphabet: ");
		tempKeyNum = in.nextLine();

		// Checks if the user's input is valid or not
		for(int i = 0; i < tempKeyNum.length(); i++) {
			if(Character.isLetter(tempKeyNum.charAt(i)) || Integer.parseInt(tempKeyNum) < 0 || Integer.parseInt(tempKeyNum) > 26) {
				while(Character.isLetter(tempKeyNum.charAt(i)) || Integer.parseInt(tempKeyNum) < 0 || Integer.parseInt(tempKeyNum) > 26) {
					System.out.println("");
					System.out.println("Invalid input, the key number must be between 0-26!");
					System.out.print("Please enter the key number between 0-26: ");
					tempKeyNum = in.nextLine();
					i = 0;
				}

				System.out.println("");
			}
		}

		keyNum = Integer.parseInt(tempKeyNum);
		// Create the new alphabet array using the key number
		caesarCipherArray(keyNum);
		// Create the 2D array using the new alphabet
		twoDimensionalArray();
		// get user's message
		System.out.print("Please enter a message with a length of 3 or more: ");
		userMessage = in.nextLine();

		// Check if user's input is valid or not
		for(int i = 0; i < userMessage.length(); i++) {
			if(Character.isSpace(userMessage.charAt(i))) {
				spaceCount += 1;
			}

			if(userMessage.length() < 3 || spaceCount == userMessage.length()) {
				while(userMessage.length() < 3 || spaceCount == userMessage.length()) {
					System.out.println("");
					System.out.println("Invalid input, the message must have a length of 3 or higher!");
					System.out.print("Please enter a message with a length of 3 or more: ");
					userMessage = in.nextLine();
					i = 0;
				}

				System.out.println("");
			}
		}

		spaceCount = 0;
		// Get key message from user
		System.out.print("Please enter another message of the same length or more: ");
		keyMessage = in.nextLine();

		// Check if user's key message is valid or not
		for(int i = 0; i < keyMessage.length(); i++) {
			if(Character.isSpace(keyMessage.charAt(i))) {
				spaceCount += 1;
			}

			if(userMessage.length() > keyMessage.length() || spaceCount == keyMessage.length()) {
				while(userMessage.length() > keyMessage.length() || spaceCount == keyMessage.length()) {
					System.out.println("");
					System.out.println("Invalid input, another message must be of the same length or longer!");
					System.out.print("Please enter another message of the same length or more: ");
					keyMessage = in.nextLine();
					i = 0;
				}
			}
		}

		spaceCount = 0;
	}

	
	public static void tutorial() {
		/* GIVE A WALKTHROUGH OF HOW TO USE THE PROGRAM */
		
		// Brief explanation and gets user's input for their key number
		System.out.println("");
		System.out.println("");
		System.out.println("Here is a walkthrough of how to use the CC Encoder-Decoder machine.");
		System.out.println("");
		System.out.println("If you choose to encode or decode a message, first things first is to enter a number between 0-26.");
		System.out.println("This will allow the program to create a caesar cipher type algorithm which will be used to either encode");
		System.out.print("or decode your message. We use the number to shift each letter backwards that key number of spaces. Please enter a number: ");
		tempKeyNum = in.nextLine();

		// Check if user's input is valid or not
		for(int i = 0; i < tempKeyNum.length(); i++) {
			if(Character.isLetter(tempKeyNum.charAt(i)) || Integer.parseInt(tempKeyNum) < 0 || Integer.parseInt(tempKeyNum) > 26) {
				while(Character.isLetter(tempKeyNum.charAt(i)) || Integer.parseInt(tempKeyNum) < 0 || Integer.parseInt(tempKeyNum) > 26) {
					System.out.println("");
					System.out.println("Invalid input, the key number must be between 0-26!");
					System.out.print("Please enter the key number between 0-26: ");
					tempKeyNum = in.nextLine();
					i = 0;
				}
			}
		}

		System.out.println("");
		keyNum = Integer.parseInt(tempKeyNum);
		// Creates new alphabet using the key number
		caesarCipherArray(keyNum);
		// Creates the 2D array
		twoDimensionalArray();
		//Displays the 2D array for the user to see
		System.out.println("Here is what the algorithm looks like for the number you just entered.");
		System.out.println("");

		for(int i = 0; i < caesarCipher2DArray.length; i++) {
			for(int j = 0; j < caesarCipher2DArray.length; j++) {
				System.out.print(caesarCipher2DArray[i][j] + " ");
			}

			System.out.println("");
		}

		// Brief explanation and get user's message
		System.out.println("");
		System.out.println("Now that the program has the algorithm, all there's left for you to input");
		System.out.println("is the message you want to encode/decode and another message of the same length as your");
		System.out.print("first message or longer, which will be considered as your 'key' message. Please enter your message: ");
		userMessage = in.nextLine();
		
		// Check if user's input is valid or not
		for(int i = 0; i < userMessage.length(); i++) {
			if(Character.isSpace(userMessage.charAt(i))) {
				spaceCount += 1;
			}

			if(userMessage.length() < 3 || spaceCount == userMessage.length()) {
				while(Character.isLetter(userMessage.charAt(i)) == false || userMessage.length() < 3) {
					System.out.println("");
					System.out.println("Invalid input, the message must have a length of 3 or higher!");
					System.out.print("Please enter a message with a length of 3 or more: ");
					userMessage = in.nextLine();
					i = 0;
				}
			}
		}

		// Ask user and get the key message
		spaceCount  = 0;
		System.out.println("");
		System.out.print("Now input the second message of equal length or more to the first: ");
		keyMessage = in.nextLine();
		
		// Check if user's input is valid or not
		for(int i = 0; i < keyMessage.length(); i++) {
			if(Character.isSpace(keyMessage.charAt(i))) {
				spaceCount += 1;
			}

			if(userMessage.length() > keyMessage.length() || spaceCount == keyMessage.length()) {
				while(userMessage.length() > keyMessage.length() || spaceCount == keyMessage.length()) {
					System.out.println("");
					System.out.println("Invalid input, another message must be of the same length or longer!");
					System.out.print("Please enter another message of the same length or more: ");
					keyMessage = in.nextLine();
					i = 0;
				}
			}
		}
	}

	
	public static String encodeMessage(String userMessage, String keyMessage) {
		/* ENCODE EACH LETTER OF THE USER'S MESSAGE AND RETURN THE ENCODED MESSAGE AS A STRING TYPE */

		String encodedMessage = "";
		int indexOfFirstLetter = 0;
		int indexOfSecondLetter = 0;

		// Encode each letter of the message
		for(int k = 0; k < userMessage.length(); k++) {
			
			/* If there is a space in the user's message, add a space to the encoded message,
			 * else, if there is no space nor letter, add that character to the encoded message,
			 * else, encode the letter.
			 */
			if(Character.isSpaceChar(userMessage.charAt(k))) {
				encodedMessage += " ";
			} else if(Character.isLetter(userMessage.charAt(k)) == false) {
				encodedMessage += userMessage.charAt(k);
			} else {
				// Find in which column the letter in the first row matches the letter in the user's message
				for(int i = 0; i < caesarCipher2DArray.length; i++) {
					if(caesarCipher2DArray[0][i] == Character.toLowerCase(userMessage.charAt(k))) {
						indexOfFirstLetter = i;
					}
				}

				/* If the key message has a space or a different character, the index of the row for the 2D array is 0, else,
				 * search for when the character in the column found above of the 2D array matches the character in the key message.
				 */
				if(Character.isSpaceChar(keyMessage.charAt(k)) || Character.isLetter(keyMessage.charAt(k)) == false) {
					indexOfSecondLetter = 0;
				} else {
					for(int i = 0; i < caesarCipher2DArray.length; i++) {
						if(caesarCipher2DArray[i][0] == Character.toLowerCase(keyMessage.charAt(k))) {
							indexOfSecondLetter = i;
						}
					}
				}

				// If the user's choice is either 1 or 2, add 1 to the local variables
				if(Integer.parseInt(userChoice) == 1 || Integer.parseInt(userChoice) == 2) {
					numOfLettersEncoded += 1;
					numOfLettersEncodedDecoded += 1;
				}

				// If the letter in the user's message is lower case, the new letter is lower case, else upper case
				if(Character.isLowerCase(userMessage.charAt(k))) {
					encodedMessage += caesarCipher2DArray[indexOfFirstLetter][indexOfSecondLetter];
				} else {
					encodedMessage += Character.toUpperCase(caesarCipher2DArray[indexOfFirstLetter][indexOfSecondLetter]);
				}
			}
		}

		// If the user's choice is 1 or 2, add the number of words encoded to the local variables
		if(Integer.parseInt(userChoice) == 1 || Integer.parseInt(userChoice) == 2) {
			for(int i = 0; i < userMessage.length(); i++) {
				if(Character.isLetter(userMessage.charAt(i))) {
					while(Character.isLetter(userMessage.charAt(i)) && (i + 1 < userMessage.length())) {
						i++;
					}

					numOfWordsEncodedDecoded += 1;
					numOfWordsEncoded += 1;
				}
			}
		}

		// Return encoded message to the main method
		return encodedMessage;
	}


	public static String decodeMessage(String userMessage, String keyMessage) {
		/* DECODE MESSAGE AND RETURN IT TO THE MAIN METHOD */

		String decodedMessage = "";
		int indexOfFirstLetter = 0;
		int indexOfSecondLetter = 0;

		// Decodes each letter of the user's message and adds it to the string type variable decodedMessage
		for(int k = 0; k < userMessage.length(); k++) {


			/* Checks if the character at that index is a space. If so, it adds a space to the decoded message,
			 * if it isn'ta space nor a letter, it adds that character to the decoded message, else, it decodes that
			 * letter using the 2D array.
			 */

			if(Character.isSpaceChar(userMessage.charAt(k))) {
				decodedMessage += " ";
			} else if(Character.isLetter(userMessage.charAt(k)) == false) {
				decodedMessage += userMessage.charAt(k);
			} else {

				/* If the key message is a space or a character, the index of the row for the 2D array is 0, else,
				 * the program searches for when the letter of the first column matches the letter of the first
				 * character of the key message.
				 */
				if(Character.isSpaceChar(keyMessage.charAt(k)) || Character.isLetter(keyMessage.charAt(k)) == false) {
					indexOfSecondLetter = 0;
				} else {
					for(int i = 0; i < caesarCipher2DArray.length; i++) {
						if(caesarCipher2DArray[i][0] == Character.toLowerCase(keyMessage.charAt(k))) {
							indexOfSecondLetter = i;
						}
					}
				}

				// Searches for when the character in the row found above matches the user's message character
				for(int i = 0; i < caesarCipher2DArray.length; i++) {
					if(caesarCipher2DArray[indexOfSecondLetter][i] == Character.toLowerCase(userMessage.charAt(k))) {
						indexOfFirstLetter = i;
					}
				}

				// If the user chooses choice 1 or 2, these letters are added to the local variables for the stats
				if(Integer.parseInt(userChoice) == 1 || Integer.parseInt(userChoice) == 2) {
					numOfLettersDecoded += 1;
					numOfLettersEncodedDecoded += 1;
				}

				// If the letter in user's message is lower case, the decoded letter is also lower case, else, upper case
				if(Character.isLowerCase(userMessage.charAt(k))) {
					decodedMessage += caesarCipher2DArray[0][indexOfFirstLetter];
				} else {
					decodedMessage += Character.toUpperCase(caesarCipher2DArray[0][indexOfFirstLetter]);
				}
			}
		}

		// If the user chose choice 1 or 2, this block of code will count how many words were decoded and adds that to the local variables for the statistics
		if(Integer.parseInt(userChoice) == 2 || Integer.parseInt(userChoice) == 1) {
			for(int i = 0; i < userMessage.length(); i++) {
				if(Character.isLetter(userMessage.charAt(i))) {
					while(Character.isSpace(userMessage.charAt(i)) == false && (i + 1 < userMessage.length())) {
						i++;
					}

					numOfWordsEncodedDecoded += 1;
					numOfWordsDecoded += 1;
				}
			}
		}

		// Returns the decoded message to the main method
		return decodedMessage;
	}


	public static void twoDimensionalArray() {
		/* CREATE THE 2D ARRAY USING THE NEW ALPHABET */

		for(int i = 0; i < caesarCipher2DArray.length; i++) {
			// Go to the method and run it before carrying out the rest of the program
			constantlyChangingCaesarCipherArray();

			for(int j = 0; j < caesarCipher2DArray.length; j++) {
				caesarCipher2DArray[i][j] = tempAlphabetArray[j];
			}
		}
	}


	public static void caesarCipherArray(int keyNum) {
		/* METHOD CREATES THE NEW ALPHABET USING THE CAESAR CIPHER ALGORITHM */

		for(int i = 0; i < newAlphabet.length; i++) {
			if(i + keyNum <= 25) {
				newAlphabet[i] = alphabet[i + keyNum];
			} else {
				newAlphabet[i] = alphabet[i + keyNum - 26];
			}
		}
	}


	public static void constantlyChangingCaesarCipherArray() {
		/* METHOD CREATES THE NEW ALPHABET FOR EACH ROW OF THE 2D ARRAY BY STARTING AT THE NEXT LETTER IN THE ALPHABET FOR EACH ROW */

		// Add one to the counter of the new starting letter of each row
		count += 1;

		// Create new temporary array starting with the new letter
		for(int i = 0; i < newAlphabet.length; i++) {
			if(i + count <= 25) {
				tempAlphabetArray[i] = newAlphabet[i + count];
			} else {
				tempAlphabetArray[i] = newAlphabet[i + count - 26];
			}
		}
	}

}
