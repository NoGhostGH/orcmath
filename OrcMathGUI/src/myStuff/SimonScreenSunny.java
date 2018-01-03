package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenSunny extends ClickableScreen implements Runnable{

	private TextLabel txtLbl;
	private ProgressInterfaceSunny progessInterface;
	private ArrayList<MoveInterfaceSunny> arrList;
	private ButtonInterfaceSunny[] buttonInterface;
	private int roundNumber;
	private boolean userInputAccepted;
	private int sequenceIndex;
	private int lastSelectedButton;
	private boolean roundWon;
	
	public SimonScreenSunny(int width, int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		for(ButtonInterfaceSunny b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceSunny>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceSunny randomMove() {
		// TODO Auto-generated method stub
		int rand = (int) (Math.random()*buttons.length);
		while(rand == lastSelectedButton)
		{
			rand = (int) (Math.random()*buttons.length);
		}
		return getMove(rand);
	}

	private MoveInterfaceSunny getMove(int rand) {
		// TODO Auto-generated method stub
		return null;
	}

	//Placeholder until partner finishes implementation of Progress Interface
	private ProgressInterfaceSunny getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		
	}

}
