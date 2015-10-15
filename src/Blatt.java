import java.util.Scanner;

public class Blatt {
	Player p = new Player();

	void getCharacterInfo(Scanner inp) {
		int characterType;

		System.out.printf("Please enter your name: ");
		String name = inp.nextLine();

		p.setName(name);

		System.out.printf("Welcome, %s, to Blatt.\n", p.getName());

		do {
			System.out.printf("In order to continue, you must choose what\n");
			System.out.printf("type of character you will be:\n");
			System.out.printf("\t1) Warrior\n");
			System.out.printf("\t2) Thief\n");
			System.out.printf("\t3) Wizard\n");
			System.out.printf("Please enter a number: ");
			characterType = inp.nextInt();

		} while (p.setType(characterType) < 0);

		System.out.printf("Ok %s, you are a %s\n", p.getName(),
				p.getTypeString());
	}

	int doMainMenu(Scanner inp) {
		int val;

		System.out.printf("\nMain Menu:\n");
		System.out.printf("\t1) Go to the forest\n");
		System.out.printf("\t2) Display player information\n");
		System.out.printf("\t3) Quit\n");

		val = inp.nextInt();
		switch (val) {
		case 1:
			Forest f = new Forest(p,inp);
			f.go();
			break;
		case 2:
			System.out.println(p);
			break;
		case 3:
			return -1;
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
