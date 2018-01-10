package myStuff1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressSunny extends Component implements ProgressInterfaceSunny {

	private int roundNum;
	private int seqNum;
	private boolean lost;
	
	
	public ProgressSunny(int x, int y, int w, int h) {
		super(x, y, w, h);
		lost = false;
		update();
	}

	@Override
	public void updateRoundNumber(int num) {
		roundNum = num;
		update();
	}

	@Override
	public void updateSequenceCount(int count) {
		seqNum = count;
		update();
	}

	@Override
	public void gameOver() {
		lost = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		super.clear();
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics();
		if(lost) {
			g.drawString("Game Over!", 0, fm.getHeight());
		}
		else {
			g.drawString("It is round " + roundNum, 0, fm.getHeight());
			g.drawString("The sequence has length: " + seqNum, 0, fm.getHeight() * 2);
		}
	}

}