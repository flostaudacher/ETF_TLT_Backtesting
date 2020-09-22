import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class vizualizingMethods {

	static int tradingCount = 0;
	
	public static void create(Series<Number, Number> data) {
		createTheChart(data);
	}
	public static void createTheChart(Series<Number, Number> data) {
		
		for (int Rowc = 1; Rowc < Import.anzahlZeilen; Rowc++) {
			if (Import.arr[Rowc][7].equals("Fr")) {
				tradingClass.buyStock(Import.arr[Rowc-1][4]);
				tradingClass.SellStock(Import.arr[Rowc][4]);
				data.getData().add(new XYChart.Data<Number, Number>(Rowc-1,tradingClass.availabeMoney));
				tradingCount++;
			}
		}
	}
}
