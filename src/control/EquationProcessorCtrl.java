package control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.CursorArray;
import model.Equation;
import visualization.EquationProcessorScene;
/*
 * This is the main scene class where the user could navigate equations
 */
public class EquationProcessorCtrl{
    /*
     * Feilds
     */
	private EquationProcessorScene scene;
	private Button prev;
    private Button next;
    private GridPane pane;
    private Label label;
    private TextArea section;

    public EquationProcessorCtrl(Stage stage, CursorArray<Equation> equations) {
        initialize(stage, equations);
    }

    private void initialize(Stage stage, CursorArray<Equation> equations) {
    	setScene(new EquationProcessorScene(stage));
    	setPrev(getScene().getPrev());
    	setNext(getScene().getNext());
    	setPane(getScene().getPane());
    	setLabel(getScene().getLabel());
    	setSection(getScene().getTextBox());
    	
    	if(equations.getCurrent() != null)
    		getSection().setText(equations.getCurrent().printSection());
    	else
    		getSection().setText("No equations were found");

    	handle_next(getNext(), equations);
    	handle_prev(getPrev(), equations);
	}

	/*
	 * Button Handlers
	 */
	private void handle_prev(Button prev2, CursorArray<Equation> equations) {
		prev2.setOnAction(e->{
			if(equations.hasPrev()) {
				equations.movePrev();
				getSection().setText(equations.getCurrent().printSection());
			}else if(!equations.hasPrev()){
				getSection().setText("That was the first equation!");				
			}
		});		
	}

	private void handle_next(Button next2, CursorArray<Equation> equations) {
		next2.setOnAction(e->{
			if(equations.hasNext()) {
				equations.moveNext();
				getSection().setText(equations.getCurrent().printSection());
			}else if(!equations.hasNext()) {
				getSection().setText("That was the last equation!");				
			}
		});
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
    public TextArea getSection() {
        return section;
    }
    public void setSection(TextArea textBox) {
        this.section = textBox;
    }
	public EquationProcessorScene getScene() {
		return scene;
	}
	public void setScene(EquationProcessorScene scene) {
		this.scene = scene;
	}
}