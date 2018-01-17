package myStuff;

import java.awt.Color;
import java.awt.Label;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class winLose extends ClickableScreen implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5057448442914282554L;
	private Button winButton;
	private Button loseButton;
	public TextArea text;
	
	public winLose(int width, int height) {
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
		text = new TextArea(100, 20, 100, 100, "Hello");
		winButton = new Button(100, 100, 50, 20 ,"Win",Color.BLUE, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				text.setText("You Win!");
				loseButton.setAction(null);
				loseButton.setText("");
			}
		});
		
		loseButton = new Button(200, 100, 50, 20, "Lose",Color.BLUE, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				text.setText("You Lose!");
				winButton.setAction(null);
				winButton.setText("");
			}
		});
		
		viewObjects.add(text);
		viewObjects.add(winButton);
		viewObjects.add(loseButton);
	}
	

}
