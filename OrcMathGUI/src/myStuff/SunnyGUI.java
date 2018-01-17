package myStuff;

import guiTeacher.GUIApplication;

public class SunnyGUI extends GUIApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9068894176244816202L;

	public SunnyGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		winLose a = new winLose(getWidth(), getHeight());
		setScreen(a);
	}

	public static void main(String[] args)
	{
		SunnyGUI s = new SunnyGUI(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}
}
