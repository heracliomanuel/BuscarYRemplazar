package dad.javafx.BuscarYReemplazar;

import java.awt.GridBagConstraints;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private Label buscarLabel,reemplazarlabel;
	private TextField busText,reemText;
	private Button buscarButton,reemplazarButton,reemplazarTButton,cerrarButton,ayudaButton;
	private CheckBox MyM,Bha,ER,RR;
	
	public void start(Stage primaryStage) throws Exception {

		buscarLabel = new Label("Buscar: ");
		reemplazarlabel = new Label("Reemplazar con: ");
		
		busText = new TextField();
		busText.setPromptText("buscar ");
		busText.setPadding(new Insets(5));
		
		reemText = new TextField();
		reemText.setPromptText("remplazar ");
		
		buscarButton = new Button("Buscar");
		buscarButton.setMaxWidth(Double.MAX_VALUE);
		
		reemplazarButton = new Button("Reemplazar");
		reemplazarButton.setMaxWidth(Double.MAX_VALUE);

		reemplazarTButton = new Button("Reemplazar todo");
		reemplazarTButton.setMaxWidth(Double.MAX_VALUE);
		
		cerrarButton = new Button("Cerrar");
		cerrarButton.setMaxWidth(Double.MAX_VALUE);
		
		ayudaButton = new Button("Ayuda");
		ayudaButton.setMaxWidth(Double.MAX_VALUE);
		
		MyM = new CheckBox("Mayusculas y minúsculas");
		Bha = new CheckBox("Buscar hacia atrás");
		ER = new CheckBox("Expresión regular");
		RR = new CheckBox("Resaltar resultados");
		
		GridPane root = new GridPane();
		
		VBox vboxButton = new VBox(buscarButton,reemplazarButton,reemplazarTButton,cerrarButton,ayudaButton);
		vboxButton.setAlignment(Pos.TOP_CENTER);
		vboxButton.setPadding(new Insets(5));
		
		
		VBox vboxCheck1 = new VBox(MyM,ER);
		vboxCheck1.setAlignment(Pos.TOP_LEFT);
		
		VBox vboxCheck2 = new VBox(Bha,RR);
		vboxCheck2.setAlignment(Pos.TOP_LEFT);
		
		HBox hboxCheck = new HBox(vboxCheck1,vboxCheck2);
		hboxCheck.setAlignment(Pos.TOP_LEFT);
		hboxCheck.setPadding(new Insets(8));
		
		root.setPadding(new Insets(30));
		root.addRow(0,buscarLabel,busText,vboxButton);
		root.addRow(1, reemplazarlabel,reemText);
		root.addRow(2, new Label(),hboxCheck);
		
		root.setHgap(5);
		root.setVgap(5);
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),
				new ColumnConstraints(),
		};
		RowConstraints [] rows = {
				new RowConstraints(),
				new RowConstraints(),
		};
		
		
/*		rows[1].setVgrow(Priority.ALWAYS);
		root.getRowConstraints().setAll(rows);

*/		
		cols[1].setHgrow(Priority.ALWAYS);
		root.getColumnConstraints().setAll(cols);
		
		GridPane.setRowSpan(vboxButton, 3);
		GridPane.setFillHeight(vboxButton, true);
		GridPane.setVgrow(vboxButton, Priority.ALWAYS);
		
		GridPane.setFillWidth(buscarLabel, true);
		GridPane.setFillWidth(busText, true);
		GridPane.setFillWidth(reemplazarlabel, true);
		GridPane.setFillWidth(reemText, true);
		
		GridPane.setFillHeight(hboxCheck, true);
		GridPane.setVgrow(hboxCheck, Priority.ALWAYS);
		

		
		Scene scene = new Scene(root,320,200);
		
		primaryStage.setTitle("Buscar y Reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	
}
