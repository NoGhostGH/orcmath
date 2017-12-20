package sunny;

import java.awt.Color;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester{

	private TextField nameField;
	private TextField speciesField;
	private TextField lvlField;
	private TextArea text;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private FileOpenButton fileOpenButton;
	private monsterSummoner catalog;
	
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
		lvlField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(lvlField);
		text = new TextArea(40, 240, 200, 30, "This is where text goes.");
		viewObjects.add(text);
		addButton = new Button(20, 280, 100, 30, "button", Color.lightGray, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				addClicked();
			}
		});
		viewObjects.add(addButton);
		saveButton = new Button(140, 280, 100, 30,"addButton", Color.lightGray, new Action() {
			
			@Override
			public void act() {
				saveClicked();
				
			}
		});
		viewObjects.add(saveButton);
		deleteButton = new Button(260, 280, 100, 30,"delButton", Color.lightGray, new Action() {
			
			@Override
			public void act() {
				delClicked();
				
			}
		});
		viewObjects.add(deleteButton);
		fileOpenButton = new FileOpenButton(380, 280, 100, 30, null, this);
		viewObjects.add(fileOpenButton);
		catalog = new monsterSummoner();

	}

	protected void addClicked() {
		// TODO Auto-generated method stub
		Monster M = new Monster(nameField.getText(), speciesField.getText(), Integer.parseInt(lvlField.getText()),10,10,10);
		text.setText(M + "\n");
		monsterSummoner.addMonster(M);
	}
	protected void saveClicked() {
		// TODO Auto-generated method stub
		text.setText("saveButton has been clicked.");
	}
	protected void delClicked() {
		// TODO Auto-generated method stub
		text.setText("delButton has been clicked.");
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
