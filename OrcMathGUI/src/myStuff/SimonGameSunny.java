package myStuff;

import guiPlayer.CustomGUI;
import guiTeacher.GUIApplication;

public class SimonGameSunny extends GUIApplication{

	public SimonGameSunny(int width, int height) {
		// TODO Auto-generated constructor stub
		super(width,height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		SimonScreenSunny screen1 = new SimonScreenSunny(getWidth(),getHeight());
		setScreen(screen1);
	}
	
	public static void main(String[] arg)
	{
		SimonScreenSunny s = new SimonScreenSunny(800, 550);
		Thread runner = new Thread(s);
		runner.start();
	}

}
