package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.Utilities;
import guiTeacher.components.*;

public class ButtonAndrew extends Button implements ButtonInterfaceSunny{

	boolean on;
	Color bColor;
	int x;
	int y;
	
	public ButtonAndrew(int x, int y, int w, int h) {
		super(x, y, w, h,"",null);
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(bColor);
		g.fillRect(x,y,getWidth(),getHeight());
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setButtonColor(Color color) {
		bColor = color;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		Color currentColor = bColor;
		Utilities.lighten(currentColor, 50);
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		Color currentColor = bColor;
		Utilities.lighten(currentColor, -50);
	}
}
