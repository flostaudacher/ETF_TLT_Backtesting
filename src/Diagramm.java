import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableView;

public class Diagramm extends Application{
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init(primaryStage);
	}
	private void init(Stage primaryStage) {
		AreaChart<Number, Number> areaChart;
		BarChart<String, Number> barchart;
		TableView<Trade> tabelle;
		
		Stage st = new Stage();
		FlowPane flowpane = new FlowPane();

		Scene sce = new Scene(flowpane, 2000, 500);
		areaChart = vizualization.areachart();
		barchart = barChart.Barchart();
		tabelle = table.tableCreat();
		
		flowpane.getChildren().addAll(areaChart,barchart,tabelle);

		flowpane.setVgap(500);
		
		st.setTitle("5AHWII Florian Staudacher");
		st.setScene(sce);
		st.show();  

	}
	public static void main(String[] args) {
		launch(args);
	}
}
