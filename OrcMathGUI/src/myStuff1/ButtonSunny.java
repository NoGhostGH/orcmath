package myStuff1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonSunny extends Button implements ButtonInterfaceSunny {

	private Color baseColor;
	private Color currentColor;
	
	public ButtonSunny(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		setColor(color);
		setActiveBorderColor(Color.BLACK);
		update();
	}

	@Override
	public void highlightButton() {
		Color newColor = Utilities.lighten(currentColor, 100);
		
		currentColor = newColor;
		
		update();
	}

	@Override
	public void dim() {
		currentColor = baseColor;
		update();
	}

	@Override
	public void setColor(Color color) {
		baseColor = color;
		currentColor = color;
		update();
	}

	@Override
	public void setX(double x) {
		setX((int)x);
	}

	@Override
	public void setY(double y) {
		setY((int)y);
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		Ellipse2D ellipse = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
		g.setColor(currentColor);
		g.draw(ellipse);
		g.fill(ellipse);
	}

	public void update() {
		BufferedImage hoverImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D hoverG = hoverImage.createGraphics();
		applyStyles(hoverG);
		drawButton(hoverG, true);
		super.update();
	}
	
}