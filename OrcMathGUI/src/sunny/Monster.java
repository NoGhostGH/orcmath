package sunny;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Monster extends Component {
	
	String name;
	String type;
	int strength;
	String fact; 
	int hp;
	int speed;

	public Monster(String name, String type, int hp, int strength, int speed) {
		super(200, 200, 41, 35);
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.strength = strength;
		this.speed = speed;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		//super.update(g);
		
	}

	public String toString()
	{
		return this.name + "," + this.type + "," + this.hp + "," + this.strength + "," + this.speed;
	}


}
