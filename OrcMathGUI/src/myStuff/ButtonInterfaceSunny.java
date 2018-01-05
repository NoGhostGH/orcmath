package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceSunny extends Clickable{

	//each button has a different color
	void setButtonColor(Color color);
	
	void setAction(Action a);
	
	void highlight();
	
	void dim();
}
