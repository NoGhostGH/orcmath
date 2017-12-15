package sunny;

import java.util.ArrayList;

public class monsterSummoner {

	private ArrayList<Monster> monstersArray;
	
	public monsterSummoner() {
		monstersArray = new ArrayList<Monster>();
		monstersArray.add(new Monster("Google", "Dragon", 100, 50, 20));
		monstersArray.add(new Monster("Amazon", "Orc", 80, 50, 10));
		monstersArray.add(new Monster("Ikea", "Human", 10, 10, 5));

	}
	
	public static void main(String[] args)
	{
		monsterSummoner cs = new monsterSummoner();
		System.out.println(cs.getCsvContent());
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