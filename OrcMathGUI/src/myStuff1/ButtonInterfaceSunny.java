package myStuff1;

import java.awt.Color;

import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceSunny extends Clickable {

	//Lights the button up
	void highlightButton();
	
	//Unhighlights the button
	void dim();

	//Sets the color of the button
	void setColor(Color color);

	//Sets the x coordinate of the button
	void setX(double x);

	//Sets the y coordinate of the button
	void setY(double y);
}