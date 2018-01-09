package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.*;

public class ProgressAndrew extends Component implements ProgressInterfaceSunny {

	private int round;
	private int sequenceSize;
	
	public ProgressAndrew(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void gameOver() {
		
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawString("", 50, 50);
	}

	@Override
	public void setRound(int roundNumber) {
		// TODO Auto-generated method stub
		round = roundNumber;
	}

	@Override
	public void setSequenceSize(int size) {
		// TODO Auto-generated method stub
		sequenceSize = size;
	}

}
