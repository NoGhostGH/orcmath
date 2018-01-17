package myStuff;

import java.util.List;
import java.util.Timer;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class buttonClicker extends ClickableScreen implements Runnable{

	/*A window appears on screen on which there is one Button and text that 
	 *says "Score: 0". The Button says "Ready". When the user clicks the Button,
	 *a countdown appears: "3...2...1... Go!" After the words "Go" appears, 
	 *the Text on the Button says "Click Me!". A clock shows that there are 
	 *five seconds. During this time, (and only during these five seconds) each 
	 *time the user clicks the button, the Score increases by 1. After 5 seconds 
	 *ends, the text on the Button says "Done". Clicking the button does not have 
	 *any effect. The Score remains visible on the screen. */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3167907293326572403L;
	private TextArea text;
	private Button clickMe;
	private Timer clock;
	private int score;

	public buttonClicker(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		text = new TextArea(100, 50, 100, 50, "Score: 0");
		
		
		clickMe = new Button(100, 100, 50, 20, "Ready", new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		})
		
	}

}
