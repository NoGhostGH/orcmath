package myStuff1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenSunny extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9141981357720287918L;
	
	private ProgressInterfaceSunny progress;
	
	//SETTINGS FOR GAME
	private int moveIndex;
	
	//Add Simon's moves to this list and compare it to the player's. 
	private ArrayList<MoveInterfaceSunny> moves;
	private int roundNumber;
	private boolean acceptingUserInput;
	private ButtonInterfaceSunny[] buttons;
	private TextLabel label;
	
	private int lastSelectedButton;

	public SimonScreenSunny(int width, int height) {
		super(width, height);
		//Since this screen will be updating the player with information, we will need to make a thread
		Thread screen = new Thread(this);
		screen.start();
	}

	//Simon plays not the PLAYER
	//Choose random buttons 
	//Update round number
	public void run() {
	    label.setText("");
	    nextRound();
	}
	
	private void nextRound() {
		acceptingUserInput = false;
		roundNumber++;
		moves.add(randomMove());
		progress.updateRoundNumber(roundNumber);
		progress.updateSequenceCount(moves.size());
		changeText("It is Simon's turn.");
		label.setText("");
		playSequence(); 
		changeText("It is now your turn.");
		acceptingUserInput = true;
		moveIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceSunny b = null;
		for(int i = 0; i < moves.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = moves.get(i).getButton();
			b.highlightButton();
			//Shorter the more rounds
			int sleepTime = 2000 / roundNumber;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}
	
	private void changeText(String s) {
		label.setText(s);
		update();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		roundNumber = 0;
		addGameButtons();
		for(ButtonInterfaceSunny b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = (new TextLabel(100,100,300,80,"Let's Play Simon!"));
		moves = new ArrayList<MoveInterfaceSunny>();
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	//WAIT FOR PARTNER
	private ProgressInterfaceSunny getProgress() {
		return new ProgressSunny(100, 150, 300, 100);
	}

	public void addGameButtons() {
		Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
		buttons = new ButtonInterfaceSunny[6]; 
		for(int i = 0; i < buttons.length; i++) {
			final ButtonInterfaceSunny b = getAButton();
		    double x = 90*i;
		    double y = 100;                
			b.setColor(colors[i]); 
		    b.setX(50+x);
		    b.setY(200+y);
		    b.setAction(new Action() {

		    	public void act() {
		    		
		    		if(acceptingUserInput) {
		    			
		    			Thread blink = new Thread(new Runnable() {

		    				public void run() {
		    					
		    					b.highlightButton();
		    					try {
			    					Thread.sleep(800);
		    					} catch (InterruptedException e) {
			    					e.printStackTrace();
		    					}
		    					b.dim();
		    					
		    				}

		    			});
		    			
		    			blink.start();
		    			
		    			//Checks if the user clicked the same button as the one that Simon clicked
		    			if(b == moves.get(moveIndex).getButton()) {
		    				
		    				moveIndex++;
		    			
		    			}
		    			else {
		    				
		    				progress.gameOver();
		    				
		    			}
		    			if(moveIndex == moves.size()) { 
		    			    Thread nextRound = new Thread(SimonScreenSunny.this); 
		    			    nextRound.start(); 
		    			    
		    			}
		    			
		    		}
		    		
		    	}

		    });
			buttons[i] = b;
		}
	}

	//WAIT FOR PARTNER
	private ButtonInterfaceSunny getAButton() {
		return new ButtonSunny(0, 0, 40, 40, "", Color.red, null);
	}

	private MoveInterfaceSunny randomMove() {
	    int moveIndex = (int) (Math.random() * buttons.length);
	    while(moveIndex == lastSelectedButton){
	        moveIndex = (int)(Math.random() * buttons.length);
	    }
	    lastSelectedButton = moveIndex;
	    return getMove(moveIndex);
	}
	
	//WAIT FOR PARTNER
	private MoveInterfaceSunny getMove(int bIndex) {
	    return new MoveSunny(buttons[bIndex]);
	}
}