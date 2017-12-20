package sunny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;

public class monsterSummoner {

	private static ArrayList<Monster> monstersArray;
	
	public monsterSummoner() {
		monstersArray = new ArrayList<Monster>();
		monstersArray.add(new Monster("Google", "Dragon", 10, 100, 50, 20));
		monstersArray.add(new Monster("Amazon", "Orc", 8, 80, 50, 10));
		monstersArray.add(new Monster("Ikea", "Human", 3, 10, 10, 5));
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
		{
			adding = false;
		}
		
		else
		{
			adding = true;
		}
		while(adding)
		{
			String name = askMonsterName();
			String race = askMonsterSpecies();
			int level = 1;
			int hp = (int) (Math.random()*100)+1;
			int atk = (int) (Math.random()*50)+1;
			int spd = (int) (Math.random()*20)+1;
			monstersArray.add(new Monster(name, race, level, hp, atk, spd));
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
	
	/*public static int askMonsterLevel()
	{
		//not done
		System.out.println("What level is this monster?");
		Scanner input = new Scanner(System.in);
		int integer = Integer.parseInt(input.nextLine());
		while(input.nextLine() == "")
		{
			System.out.println("Please input a number above zero.");
		}
		return integer;
	}
	*/
	
	public String getCsvContent()
	{
		String data = "";
		for(Monster m: monstersArray)
		{
			data += m + "\n";
		}
		return data;
	}
	
	private void save() {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(Monster m: monstersArray){
				fw.write(m+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
	private void addMonster(Monster m){
		monsterSummoner.add(m);
	}
	
	
	/*private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		monstersArray = new ArrayList<Monster>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(",");
					//add a new Book for each line in the save file
					monstersArray.add(new Book(param[0],param[1],Integer.parseInt(param[2])));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}*/
}