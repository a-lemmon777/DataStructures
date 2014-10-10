// Aaron Lemmon and Lenny Scott, Lab 11212123
public class PlayWithJava {
	public static void main(String[] args) {
		
		// problem 2
		int multiply1 = 5;
		int multiply2 = 7;
		System.out.println("multiplication result: " + multiply1 * multiply2);
		
		// problem 3
		int divide1 = 68;
		int divide2 = 11;
		int divideResult = divide1 / divide2;
		System.out.println("division result: " + divideResult); // When two numbers can't be evenly divided, then any remainder is ignored.
		
		// problem 4
		char firstChar = 'a';
		char secondChar = 'b';
		System.out.println("Is 'a' less than 'b'? " + (firstChar < secondChar));
		
		// problem 5
		//int tooBigInt = 2200000000; // the compiler complains that the number is too large
		
		// problem 6
		double lemmonsWeight = 155.8;
		System.out.println("Lemmon's weight before Thanksgiving: " + lemmonsWeight);
		lemmonsWeight += 20.3;
		System.out.println("Lemmon's weight after Thanksgiving: " + lemmonsWeight);
		
		// problem 7 
		int mod1 = 5;
		int mod2 = 2;
		System.out.println("five mod two: " + (mod1 % mod2)); // the remainder of 5 / 2 = 1
		int mod3 = -5;
		int mod4 = -2;
		System.out.println("negative five mod two: " + (mod3 % mod2)); // the remainder of -5 / 2 = -1
		System.out.println("five mod negative two: " + (mod1 % mod4)); // the remainder of 5 / -2 = 1
		System.out.println("negative five mod negative two: " + (mod3 % mod4)); // the remainder of -5 / -2 = -1
		
		// problem 8
		String name = "Lemmon";
		System.out.println("CharAt index 1: " + name.charAt(1)); // returns 'e', the character at index 1
		System.out.println("CharAt index 2: " + name.charAt(2)); // returns 'm'. the character at index 2
		//System.out.println(name.charAt(10)); // compiles but throws a StringIndexOutOfBounds Error
		
		// problem 9
		System.out.println("first character: " + name.charAt(0));
		
		// problem 10
		System.out.println("Length of my name: " + name.length());
		
		// problem 11
		//name = "";
		if (name.length() == 0) {
			System.out.println("STOP GIVING ME EMPTY STRINGS!!!");
		}
		else {
			System.out.println("Last character of ambiguous string: " + name.charAt((name.length() - 1)));
		}
		
		// problem 12
		// int myInteger = 5L; // We tried to store a long in an int. To fix it, we can take out the 'L'. The compiler complained about possible loss of precision; it required an int and it found a long. The error message was understandable. 
		/* int @JoeBeaverWeBrokeIt = 0; // The variable "@JoeBeaverWeBrokeIt" uses a special character that java won't allow. 
		To fix it, we can take out the "@". The compiler threw a "not a statement error and pointed to the effected line. The error message was understanble. */
		
		//problem 13
		// Q: What if we call length() on an uninitialized string?
		// ****TEST****
		//String string1;
		//System.out.println("Length of the string: " + string1.length());
		// A: The compiler complains that the variable might not have been initialized.
		
		
		// Q: Do ints automagically get converted to doubles?
		// ****TEST****
		int wholeNumber = 10;
		double fraction = wholeNumber;
		System.out.println("fraction equals: " + fraction);
		// A: Ints do automagically convert to doubles if asked
	}
}
