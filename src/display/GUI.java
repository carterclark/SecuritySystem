package display;

import buttons.AwayButton;
import buttons.CancelButton;
import buttons.DigitButton;
import buttons.MotionButton;
import buttons.PanelButton;
import buttons.PanelTextField;
import buttons.StayButton;
import buttons.ZoneCheckBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

	private PanelButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
			buttonStay, buttonAway, buttonCancel, buttonMotionDetector;
	private ZoneCheckBox checkBoxZone1, checkBoxZone2, checkBoxZone3;
	private PanelTextField textField;
	private Label readyStatus = new Label("Ready Status");

	// private Label labelX = new Label("x");
	// private Label labelY = new Label("y");
	// private Stage window;
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		textField = new PanelTextField("Ready");
		button1 = new DigitButton("1");
		button2 = new DigitButton("2");
		button3 = new DigitButton("3");
		button4 = new DigitButton("4");
		button5 = new DigitButton("5");
		button6 = new DigitButton("6");
		button7 = new DigitButton("7");
		button8 = new DigitButton("8");
		button9 = new DigitButton("9");
		button0 = new DigitButton("0");
		buttonStay = new StayButton("Stay");
		buttonAway = new AwayButton("Away");
		buttonCancel = new CancelButton("Cancel");
		buttonMotionDetector = new MotionButton("Motion Detector");
		checkBoxZone1 = new ZoneCheckBox("Zone 1");
		checkBoxZone2 = new ZoneCheckBox("Zone 2");
		checkBoxZone3 = new ZoneCheckBox("Zone 3");

		// textField.setText("Not Ready");
		pane.add(button1, 0, 0);
		pane.add(button2, 1, 0);
		pane.add(button3, 2, 0);
		pane.add(button4, 0, 1);
		pane.add(button5, 1, 1);
		pane.add(button6, 2, 1);
		pane.add(button7, 0, 2);
		pane.add(button8, 1, 2);
		pane.add(button9, 2, 2);
		pane.add(button0, 1, 3);
		pane.add(textField, 3, 0, 11, 1);
		pane.add(checkBoxZone1, 0, 5, 3, 1);
		pane.add(checkBoxZone2, 3, 5, 3, 1);
		pane.add(checkBoxZone3, 6, 5, 3, 1);
		pane.add(buttonStay, 10, 5);
		pane.add(buttonAway, 11, 5);
		pane.add(buttonCancel, 13, 5);
		pane.add(readyStatus, 4, 6);
		pane.add(buttonMotionDetector, 3, 7, 5, 1);
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints(50));
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints());
		pane.getColumnConstraints().add(new ColumnConstraints(80));
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Security System");
		primaryStage.setScene(scene);
		primaryStage.show();
		// window = primaryStage; // making a 'copy' of primaryStage, so that the GUI
		// can be closed (through
		// the static variable 'window' now) in the handle method
	}

	public static void main(String[] args) {
		Application.launch(args);
		System.out.println("THANK YOU!  :-)");
	}
}