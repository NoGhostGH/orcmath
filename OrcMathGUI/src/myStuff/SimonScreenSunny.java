package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenSunny extends ClickableScreen implements Runnable{

	private TextLabel txtLbl;
	private ProgressInterfaceSunny progessInterface;
	private ArrayList<MoveInterfaceSunny> arrList;
	private ButtonInterfaceSunny[] buttonInterface;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	private int numberOfButtons;
	private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE};
	
	public SimonScreenSunny(int width, int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		txtLbl.setText("");
		nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber++;
		arrList.add(randomMove());
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		for(ButtonInterfaceSunny b: buttonInterface){ 
		    viewObjects.add(b); 
		}
		progessInterface = getProgress();
		txtLbl = new TextLabel(130,230,300,40,"Let's play Simon!");
		arrList = new ArrayList<MoveInterfaceSunny>();
		//add 2 moves to start
		lastSelectedButton = -1;
		arrList.add(randomMove());
		arrList.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progessInterface);
		viewObjects.add(txtLbl);
	}

	private MoveInterfaceSunny randomMove() {
		// TODO Auto-generated method stub
		int rand = (int) (Math.random()*buttonInterface.length);
		while(rand == lastSelectedButton)
		{
			rand = (int) (Math.random()*buttonInterface.length);
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
		numberOfButtons = 5;
		buttonInterface = new ButtonInterfaceSunny[numberOfButtons];
		for(int i  = 0; i < numberOfButtons; i++)
		{
			final ButtonInterfaceSunny b = getAButton();
			buttonInterface[i] = b;
			b.setButtonColor(colors[i]);
			b.setX(50*i);
			b.setY(100);
			b.setAction(new Action() 
			{
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					if(acceptingInput)
					{
						Thread blink = new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								b.highlight();
								try
								{
									Thread.sleep(800);
								}
								catch(InterruptedException e)
								{
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == arrList.get(sequenceIndex).getButton())
						{
							sequenceIndex++;
						}
						else
						{
							progressInterface.gameOver();
						}
						if(sequenceIndex == arrList.size())
						{
							Thread nextRound = new Thread(SimonScreenSunny.this);
							nextRound.start();
						}
					}
					
				}
			});
		}
	}

	//Placeholder until partner finishes implementation of ButtonInterface
	private ButtonInterfaceSunny getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
