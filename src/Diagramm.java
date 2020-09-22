import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Diagramm extends Application{
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init(primaryStage);
	}
	private void init(Stage primaryStage) {
		AreaChart<Number, Number> areaChart;

		Stage st = new Stage();
		FlowPane flowpane = new FlowPane();

		Scene sce = new Scene(flowpane, 1050, 500);
		areaChart = vizualization.areachart();

		flowpane.getChildren().addAll(areaChart);

		flowpane.setVgap(500);

		st.setTitle("5AHWII Florian Staudacher");
		st.setScene(sce);
		st.show();  

	}
	public static void main(String[] args) {
		launch(args);
	}
}
