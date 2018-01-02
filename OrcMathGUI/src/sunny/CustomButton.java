package sunny;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {
	
	private String str1;
	private String str2;
	private Color cyan;

	public CustomButton(int x, int y) {
		super(x, y, 100, 30, "Bootun", null);
		// TODO Auto-generated constructor stub
	}

	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.black);
		g.drawString(str1, 50, 50);
		g.drawString(str2, 50, 100);
		g.drawRect(50,150,50,50);
		g.fillRect(50, 150, 50, 50);
	}
	
	public static void main(String[] args)
	{
		
	}
	
	void updateString1(String string)
	{
		
	}

	void updateString2(String string)
	{
		
	}

	void setIconColor(Color color)
	{
		
	}
}
