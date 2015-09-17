import java.util.Scanner;

public class Blatt {

	public static String typeToName(int charType) {
		switch (charType) {
		case 1:
			return "Warrior";
		case 2:
			return "Thief";
		case 3:
			return "Mage";
		case 4:
			return "Sharpshooter";
		}
		// This should never occur
		return "Invalid";
	}

	public static void main(String arg[]) {
		String name;
		int charType;

		Scanner input = new Scanner(System.in);

		System.out.printf("                 Legend of Blatt               \n");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("Welcome, adventurer, to the land of Blatt, a\n");
		System.out.printf("world of myth and legend.\n\n");

		System.out.printf("Please enter your name: ");
		name = input.nextLine();

		System.out.printf("Welcome, %s, to Blatt.\n", name);

		System.out.printf("In order to continue, you must choose what\n");
		System.out.printf("type of character you will be:\n");
		System.out.printf("\t1) Warrior\n");
		System.out.printf("\t2) Thief\n");
		System.out.printf("\t3) Mage\n");
		System.out.printf("\t4) Sharpshooter\n");
		charType = input.nextInt();

		while (charType < 1 || charType > 4) {
			System.out.println("Please choose a number between 1 and 4: ");
			charType = input.nextInt();

		}

		System.out.printf("You chose %s\n", typeToName(charType));
		
		/*
		 * if (charType == 1) { System.out.println("You chose Warrior"); } else
		 * if (charType == 2) { System.out.println("You chose Thief"); } else if
		 * (charType == 3) { System.out.println("You chose Mage"); } else if
		 * (charType == 4) { System.out.println("You chose Sharpshooter"); }
		 */

	}

}
