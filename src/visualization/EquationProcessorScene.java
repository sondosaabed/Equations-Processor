package visualization;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

/*
 * The main Scene in this program that is created to show sections of equations 
 * and naigate them
 */
public class EquationProcessorScene {
    private Button prev;
    private Button next;
    private GridPane pane;
    private Label label;
    private TextArea textBox;

    public EquationProcessorScene(Stage stage) {
        initialize(stage);
    }

    private void initialize(Stage stage) {
        // Creating the grid pane
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(60));
        pane.setHgap(7);
        pane.setVgap(10);

        // creating a background
        pane.setBackground(null);
        Background bGround = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        pane.setBackground(bGround);

        // The app logo
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

        // Greeting Label
        label = new Label("    	Here is your equations...");
        label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        pane.add(label, 1, 0);

        // Textbox
        textBox = new TextArea();
        textBox.setPromptText("Equation");
        textBox.setPrefSize(500, 300);
        textBox.setWrapText(true);
        textBox.setEditable(false);
        textBox.setFont(Font.font("Lucida Sans Unicode", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        pane.add(textBox, 1, 1);    

        // The Prev button
        prev = new Button("Prev.");
        prev.setTextFill(Color.BLACK);
        prev.setPrefSize(100, 30);
        prev.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        prev.setStyle("-fx-background-radius: 22, 10;-fx-background-color:#80B4FB;");
        pane.add(prev, 0, 1);

        // The Next button
        next = new Button("Next");
        next.setTextFill(Color.BLACK);
        next.setPrefSize(100, 30);
        next.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
        next.setStyle("-fx-background-radius: 22, 10;-fx-background-color:lightgreen;");
        pane.add(next, 2, 1);

        // Create Scene
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Equation Processor");
        stage.getIcons().add(new Image("resources/logo.png"));
        stage.centerOnScreen();
        stage.show();
    }
    
    /*
     * Getters & Setters
     */
    public Button getPrev() {
        return prev;
    }
    public void setPrev(Button prev) {
        this.prev = prev;
    }
    public Button getNext() {
        return next;
    }
    public void setNext(Button next) {
        this.next = next;
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
    public TextArea getTextBox() {
        return textBox;
    }
    public void setTextBox(TextArea textBox) {
        this.textBox = textBox;
    }
}