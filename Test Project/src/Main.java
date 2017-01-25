import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//System Objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		// Game Variables
		
		String[] enemies = {"Dragon", "Zombie", "Drauger", "Werewolf", "Wight", "Ghoul", "Spider", "Ghost" };
		int maxEnemyHP = 150;
		int maxEnemyAttack = 30;
		
		
		// Play Variables
		int health = 100;
		int attackdmg = 50;
		int numHealthPots = 5;
		
		int healthPotionHeal = 40;
		int healthPotionDrop = 50; //Percentage
		
		boolean running = true;
		
		System.out.println("Welcome to Dungeon Crawler 1.0!");
		
		GAME:
		while(running){
			System.out.println("----------------------------------------------------------");
			
			int enemyHP = rand.nextInt(maxEnemyHP);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHP > 0){
				System.out.println("\t Your HP: " + health);
				System.out.println("\t " + enemy + "'s HP: " + enemyHP);
				System.out.println("\n\t What would you like to do? ");
				System.out.println("\t 1. Attack! ");
				System.out.println("\t 2. Drink Potion! ");
				System.out.println("\t 3. Run! ");
				
				
				String input = in.nextLine();
				if (input.equals("1")){
					int damageDealt = rand.nextInt(attackdmg);
					int damageTaken = rand.nextInt(maxEnemyAttack);
					
					enemyHP -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t > You strike the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\t > You take " + damageTaken + " in retaliation! ");
					if (health < 1){
						System.out.println("\t > You have taken too much damage to continue on....");
						break;
					}
				}
				else if (input.equals("2")){
					if (numHealthPots > 0){
						health += healthPotionHeal;
						numHealthPots--;
						System.out.println("\t > You drink a health potion healing you for " + healthPotionHeal + "." + "\n\t > You now have " + health + " HP! " + "\n\t > You have " + numHealthPots + " health potions left!");
					}
					else{
						System.out.println("\t > You have no health potions left. Maybe an enemy can drop one...");
					}
				}
				else if(input.equals("3")){
					System.out.println("\t > You run away in fear from the " + enemy + "!");
					continue GAME;
					
				}
				else{
					System.out.println("\t > Invalid command!");
				}
			}
			
			if (health < 1){
				System.out.println("\t > You barely make it out of the dungeon. ");
				break;
			}
			
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP reamining. ");
			if (rand.nextInt(100) < healthPotionDrop){
				numHealthPots++;
				System.out.println(" # The " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPots + " health potion(s) # " );
			}
			
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Continue Fighting! ");
			System.out.println("2. Exit Dungeon! ");
			
			String input = in.nextLine();
			
			
			while (!input.equals("1") && !input.equals("2")){
				System.out.println("Invalid command!");
				input = in.nextLine();
			}
			
			if (input.equals("1")){
				System.out.println(" You continue on your grand quest! ");
			}
			
			else if (input.equals("2")){
				System.out.println(" You exit the dungeon as a mighty hero! ");
				break;
			}
		}
		
		System.out.println("#################################");
		System.out.println(" Thank you for playing!");
		System.out.println("#################################");

	}

}
