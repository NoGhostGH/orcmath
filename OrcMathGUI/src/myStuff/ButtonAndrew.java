package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
		g.setColor(bColor);
		g.drawRect(x, y, 50, 50);
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
		g.lighten();
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		
	}
	
	public void setAction() {
		
	}

}
