package sunny;

import java.util.ArrayList;
import java.util.Scanner;

public class monsterSummoner {

	private static ArrayList<Monster> monstersArray;
	private String[] species = {"dragon", "human", "orc", "phoenix", "android"};
	
	public monsterSummoner() {
		monstersArray = new ArrayList<Monster>();
		monstersArray.add(new Monster("Google", "Dragon", 100, 50, 20));
		monstersArray.add(new Monster("Amazon", "Orc", 80, 50, 10));
		monstersArray.add(new Monster("Ikea", "Human", 10, 10, 5));
	}
	
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		boolean adding;
		monsterSummoner cs = new monsterSummoner();
		
		System.out.println(cs.getCsvContent());
		System.out.println("Would you like to add a monster to your catalog?");
		String str = input.nextLine();
		
		if(str.equalsIgnoreCase("no") || str.equalsIgnoreCase("nope"))
			adding = false;
		else
			adding = true;
		while(adding)
		{
			String name = askMonsterName();
			String race = askMonsterSpecies();
			int hp = (int) (Math.random()*100)+1;
			int atk = (int) (Math.random()*50)+1;
			int spd = (int) (Math.random()*20)+1;
			monstersArray.add(new Monster(name, race, hp, atk, spd));
			System.out.println("Would you like to add another monster?");
			str = input.nextLine();
			if(str.equalsIgnoreCase("no") || str.equalsIgnoreCase("nope"))
				adding = false;
		}
		System.out.println(cs.getCsvContent());
	}
	
	public static String askMonsterName() 
	{	
		System.out.println("What would you like to name this monster?");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		while(str == "")
		{
			System.out.println("That is not a valid name, try again.");
		}
		return str;
	}
	public static String askMonsterSpecies()
	{
		//System.out.println("What species is this monster? A dragon, human, orc, phoenix or android?");
		System.out.println("What species is this monster?");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		while(str == "")
		{
			System.out.println("That is not a valid species, try again.");
		}
		return str;
	}
	
	
	public String getCsvContent()
	{
		String data = "";
		for(Monster m: monstersArray)
		{
			data += m + "\n";
		}
		return data;
	}
}