package sunny;

import guiTeacher.GUIApplication;

public class CatalogMakerGui extends GUIApplication {

	public CatalogMakerGui(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		setVisible(true);
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		CatalogScreen screen = new CatalogScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		CatalogMakerGui sample = new CatalogMakerGui(800, 550);
		Thread go = new Thread(sample);
		go.start();

	}

}
