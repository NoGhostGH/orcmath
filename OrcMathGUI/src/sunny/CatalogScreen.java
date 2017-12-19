package sunny;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField nameField;
	private TextField speciesField;
	private TextField lvlField;

	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		nameField = new TextField(40, 60, 200, 30, "Enter text", "Name");
		viewObjects.add(nameField);
		speciesField = new TextField(40, 120, 200, 30, "Enter text", "Species");
		viewObjects.add(speciesField);
		lvlField = new TextField(40, 180, 200, 30, "Enter text", "Level");
		viewObjects.add(lvlField);

	}

}
