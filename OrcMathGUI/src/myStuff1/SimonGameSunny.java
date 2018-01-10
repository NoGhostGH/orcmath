package myStuff1;

import guiTeacher.GUIApplication;

public class SimonGameSunny extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static SimonGameSunny theGame;
	public SimonScreenSunny theScreen;
	
	public SimonGameSunny(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		theScreen = new SimonScreenSunny(getWidth(), getHeight());
		setScreen(theScreen);
	}
	
	public static void main(String[] args) {
		theGame = new SimonGameSunny(500,400);
		Thread go = new Thread(theGame);
		go.start();
	}

}