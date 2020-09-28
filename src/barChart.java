import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class barChart extends Pane{

	public static BarChart<String, Number> Barchart() {
		CategoryAxis xAxis = new CategoryAxis();  
		xAxis.setCategories(FXCollections.<String>
		observableArrayList(Arrays.asList("positiv", "negativ")));
		xAxis.setLabel("Chance");
		
		NumberAxis yAxis= new NumberAxis();
		yAxis.setLabel("Chance for positiv/negativ Trade");

		BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);
		barChart.setTitle("Positiv/Negativ");

		XYChart.Series<Number, Number> data = new XYChart.Series<Number, Number>();
		data.setName("Backtesting result if you try the tactic with 10k in the year 2010");


		barChart.getData().addAll(barChartMethods.create(new XYChart.Series<String, Number>(), "positiv"));	
		barChart.getData().addAll(barChartMethods.create(new XYChart.Series<String, Number>(), "negativ"));	
		
		barChart.setCategoryGap(20);
		
		return barChart;
	}
}