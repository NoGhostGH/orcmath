package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenSunny extends ClickableScreen implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2264248466883566732L;
	private TextLabel txtLbl;
	private ProgressInterfaceSunny progressInterface;
	private ArrayList<MoveInterfaceSunny> sequence;
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
		acceptingInput = false;
		roundNumber ++;
		sequence.add(randomMove());
		
		progressInterface.setRound(roundNumber);
		progressInterface.setSequenceSize(sequence.size());
		
		changeText("Simon's turn");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	public void changeText(String a) {
		Thread displayLabel = new Thread(new Runnable() {
			public void run() {
				txtLbl.setText(a);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				txtLbl.setText("");
			}
		});
		displayLabel.run();
	}
	
	
	public void playSequence() {
		ButtonInterfaceSunny b = null;
		for(MoveInterfaceSunny a:sequence) {
			if(b!=null) {
				b.dim();
				b = a.getButton();
				b.highlight();
				
				int sleepTime = (2000/roundNumber);
				Thread c = new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				});
			}
		}
		b.dim();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		for(ButtonInterfaceSunny b: buttonInterface){ 
		    viewObjects.add(b); 
		}
		progressInterface = getProgress();
		txtLbl = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceSunny>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progressInterface);
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
		ProgressInterfaceSunny andrewInt = new ProgressAndrew(50,50,50,50);
		return andrewInt;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		numberOfButtons = 5;
		buttonInterface = new ButtonInterfaceSunny[numberOfButtons];
		for(int i  = 0; i < numberOfButtons; i++)
		{
			ButtonInterfaceSunny b = getAButton();
			buttonInterface[i] = b;
			b.setButtonColor(colors[i]);
			b.setX(50*i);
			b.setY(200);
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
						if(b == sequence.get(sequenceIndex).getButton())
						{
							sequenceIndex++;
						}
						else
						{
							progressInterface.gameOver();
						}
						if(sequenceIndex == sequence.size())
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
		// TODO Auto-generated method stub ahahahah
		return new ButtonAndrew(0, 0, 30, 30);
	}

}
