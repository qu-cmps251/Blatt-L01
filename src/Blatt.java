

import java.util.Scanner;

public class Blatt {
	private Player p;

	void getCharacterInfo(Scanner inp) {
		int characterType=-1;

		System.out.printf("Please enter your name: ");
		String name = inp.nextLine();		

		System.out.printf("Welcome, %s, to Blatt.\n", name);

		do {
			System.out.printf("In order to continue, you must choose what\n");
			System.out.printf("type of character you will be:\n");
			System.out.printf("\t1) Warrior\n");
			System.out.printf("\t2) Thief\n");
			System.out.printf("\t3) Wizard\n");
			System.out.printf("Please enter a number: ");
			String inpLine = inp.nextLine();
			
			try {
				characterType = Integer.parseInt(inpLine);				
			} catch (NumberFormatException nfe) {
				// They didn't enter a number... restart the loop
				continue;
			}
			
		} while (characterType < 0 || characterType > 3);

		p = new Player(name, characterType);
		
		System.out.printf("Ok %s, you are a %s\n", p.getName(),
				p.getTypeString());
	}

	int doMainMenu(Scanner inp) {
		String val;

		System.out.printf("\nMain Menu:\n");
		System.out.printf("\tF) Go to the forest\n");
		System.out.printf("\tS) Display player stats\n");
		System.out.printf("\tQ) Quit\n");

		val = inp.nextLine();
		switch (val) {
		case "F":
		case "f":
			Forest f = new Forest(p,inp);
			f.go();
			break;
		case "S":
		case "s":			
			System.out.print(p);
			break;
		case "Q":
		case "q":			
			return -1;		
		case "42":
			System.out.printf("You found the secret menu.  You now have 5000 Gold.\n");
			p.setGold(5000);
			break;
		}

		return 0;

	}

	public Blatt() {
		Scanner inp = new Scanner(System.in);

		System.out.printf("                 Legend of Blatt               \n");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("Welcome, warrior, to the land of Blatt, a world\n");
		System.out.printf("of myth and legend.\n\n");

		getCharacterInfo(inp);

		int ret = 0;
		while (ret == 0) {
			ret = doMainMenu(inp);
		}
		
		System.out.printf("Thanks for playing Legend of Blatt!\n");
		
		inp.close();
	}

	public static void main(String[] args) {
		new Blatt();
	}
}
