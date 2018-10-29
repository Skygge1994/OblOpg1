package PæsentationFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Præsentation extends Application {
	Label response;
	TextField tf;
	Stage window;
	Scene MainStage;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
	
	
	Button btnHent = new Button("Hent");
	btnHent.setPrefSize (100, 20);
	Button btnGem = new Button("Gem");
	btnGem.setPrefSize(100, 20);
	Button btnSlet = new Button("Slet");
	btnSlet.setPrefSize(100, 20);
	Label labelKey = new Label("Key");
	TextField tfKey = new TextField();
	tfKey.setMaxWidth(200);
	Label labelValue = new Label("Value");
	TextField tfValue = new TextField();
	tfValue.setMaxWidth(200);
	VBox layout0 = new VBox(20);
	layout0.setAlignment(Pos.CENTER);
	layout0.getChildren().addAll(labelKey, tfKey, labelValue, tfValue, btnHent, btnGem, btnSlet);
	btnSlet.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
	MainStage = new Scene(layout0, 800, 600);
	window.setScene(MainStage);
	window.show();
	}
}
