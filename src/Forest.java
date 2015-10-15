import java.util.Random;
import java.util.Scanner;

public class Forest {
	Player p;
	Scanner inp;

	public Forest(Player p, Scanner inp) {
		this.p = p;
		this.inp = inp;
	}

	public void printMenu() {
		System.out.printf("\nWelcome to the forest!  Beware of monsters...\n");
		System.out.printf("What do you want to do?\n");
		System.out.printf("\t1) Go hunting\n");
		System.out.printf("\t2) Return to the Main Menu\n");
	}

	public void go() {
		int menuChoice;
		do {
			printMenu();
			menuChoice = inp.nextInt();
		} while (menuChoice < 1 || menuChoice > 2);

		switch (menuChoice) {
		case 1:
			hunt();
			break;
		case 2:
			// Quit the menu
			return;
		default:
			break;
		}
	}

	void hunt() {
		Random r = new Random();

		int monsterHp = 5;
		System.out.printf("You found a monster!\n");
		while (true) {
			System.out.printf(
					"You are fighting a Monster with %d hit points\n",
					monsterHp);
			System.out.printf("You currently have %d hit points\n",
					p.getCurrHp());
			System.out.printf("\t1) Attack\n");
			System.out.printf("\t2) Run Away\n");

			int choice = inp.nextInt();

			if (choice == 1) {
				// Generate a random damage the player does and apply it.
				int playerAttack = r.nextInt(3);
				System.out.printf("You attack the monster and do %d damage!\n",
						playerAttack);
				monsterHp -= playerAttack;
				if (monsterHp <= 0) {
					// Monster is dead

					// Give the player 10 Gold
					System.out
							.printf("You killed the monster and received 10 gold\n");
					p.setGold(p.getGold() + 10);
					return;
				}

				// Generate a random damage the Monster does
				int monsterAttack = r.nextInt(3);
				System.out.printf(
						"The monster attacks you and does %d damage!\n",
						monsterAttack);
				p.setCurrHp(p.getCurrHp() - monsterAttack);

				if (p.getCurrHp() <= 0) {
					// Player is dead
					System.out.printf("You died!");
					// This quits the program...
					System.exit(0);
				}
			} else if (choice == 2) {
				// Run away!
				return;
			} else {
				/*
				 * They entered something useless, print an error and the menu
				 * again.
				 */
				System.out.printf("Invalid entry, please try again!\n");
				continue;
			}
		}
	}
}
