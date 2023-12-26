package control;

import java.io.File;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.CursorArray;
import model.Equation;
import utils.FileValidation;
import utils.ReadFile;
import javafx.stage.Stage;
import visualization.BrowseFileScene;

public class BrowseFileCtrl {
	// Fields
	private FileChooser fileChooser;
	private File equationsFile;
		
	private BrowseFileScene BrowseScene;
	
	private GridPane pane;
	private Label label;
	private Button next;
	private Button browse;
	private Button cancel;
	
	public BrowseFileCtrl(Stage stage) {
		initialize(stage);
	}
	
	private void initialize(Stage stage) {
		setBrowseScene(new BrowseFileScene(stage));
		setPane(getBrowseScene().getPane());
		setLabel(getBrowseScene().getLabel());
		setNext(getBrowseScene().getNext());
		setCancel(getBrowseScene().getCancel());
		setBrowse(getBrowseScene().getBrowse());
		setFileChooser(new FileChooser());
		
		//From the requirment is suppose to input a 242 file 
        getFileChooser().getExtensionFilters().add(new ExtensionFilter("242 Files", "*.242"));
		
		handle_browse(getBrowse(), stage);
		handle_cancel(getCancel());
	}

	/*
	 * Button Handlers
	 */
	private void handle_cancel(Button cancel) {
		cancel.setOnAction(a->{
			Platform.exit();
		});
	}

	private void handle_browse(Button browse, Stage stage) {
		browse.setOnAction(ac->{
			setEquationsFile(getFileChooser().showOpenDialog(stage));
			if (getEquationsFile() == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a file yet!", "No file");
				a.show();
			} else {
				/*
				 * The file is not null , now check if valid
				 */
				Boolean ans = FileValidation.isFileValid(getEquationsFile());
				
				if(ans == true) {
					GridPane.setHalignment(next, HPos.CENTER);
					pane.add(next, 3, 1);
					handle_next(next, stage, getEquationsFile());
					label.setText(getEquationsFile().getPath());
				}else {
					AlertBoxCtrl a = new AlertBoxCtrl("An error in your tags occured", "Tags Error");
					a.show();
				}
			}
		});
	}

	private void handle_next(Button next2, Stage stage, File equationsFile) {
		next2.setOnAction(e->{
			/* Read the linked list here  */
			CursorArray<Equation> equations = ReadFile.loadEquationsFromFile(equationsFile);
			new EquationProcessorCtrl(stage, equations);
		});
	}


	/*
	 * Getters & Setters
	 */
	public FileChooser getFileChooser() {
		return fileChooser;
	}
	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	public File getEquationsFile() {
		return equationsFile;
	}
	public void setEquationsFile(File equationsFile) {
		this.equationsFile = equationsFile;
	}
	public BrowseFileScene getBrowseScene() {
		return BrowseScene;
	}
	public void setBrowseScene(BrowseFileScene browseScene) {
		BrowseScene = browseScene;
	}
	public GridPane getPane() {
		return pane;
	}
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public Button getNext() {
		return next;
	}
	public void setNext(Button next) {
		this.next = next;
	}
	public Button getBrowse() {
		return browse;
	}
	public void setBrowse(Button browse) {
		this.browse = browse;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}
