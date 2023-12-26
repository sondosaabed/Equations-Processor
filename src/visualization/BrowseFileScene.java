/**
 * 
 */
package visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This scene is created to let the user browse a file
 */
public class BrowseFileScene {
	private Button browse;
	private Button next;
	private Button cancel;
	private GridPane pane;
	private Label label;
	
	public BrowseFileScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
    	//Creating the grid pane
		pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100));
		pane.setHgap(20);
		pane.setVgap(20);
		
		pane.setBackground(null);
		Background bGround = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
		pane.setBackground(bGround); 
		
		Image img = new Image("resources/logo.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(150);
		v.setFitHeight(150);
		
		// a disabled button that shows the Logo
		Button logo = new Button();
		logo.setPrefSize(150, 150);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		pane.add(logo, 0, 0);
		
		//Greeting Label
		label = new Label("    	Hello user, Browse your equations file first...");
		label.setMaxWidth(700);
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 1,0);
		
		//The run button
		next = new Button("Next");
		next.setTextFill(Color.BLACK);
		next.setPrefSize(100, 30);
		next.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		next.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgreen;");
		
		//Button to browse for files
		browse = new Button("Browse"); 
		browse.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#80B4FB;");
		browse.setTextFill(Color.BLACK);
		browse.setPrefSize(100, 30);
		browse.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(browse , 2,1);
		
		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font(14)); 
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#80B4FB;");
		cancel.setTextFill(Color.BLACK);
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(cancel,3,1); 
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Browse for the equations file");
		stage.getIcons().add(new Image("resources/logo.png"));
		stage.centerOnScreen();
		stage.show();
    }
	
	/*
	 * Getters & setters
	 */
	public Button getBrowse() {
		return browse;
	}
	public void setBrowse(Button browse) {
		this.browse = browse;
	}
	public Button getNext() {
		return next;
	}
	public void setNext(Button next) {
		this.next = next;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
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
}