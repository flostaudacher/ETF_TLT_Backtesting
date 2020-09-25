import java.text.DecimalFormat;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class vizualizingMethods {

	static double [] PN = new double [2];
	static int tradingCounter = 0;
	static DecimalFormat f = new DecimalFormat("#0.00");
	public static void create(Series<Number, Number> data) {
		createTheChart(data);
	}
	public static void createTheChart(Series<Number, Number> data) {

		for (int Rowc = 1; Rowc < Import.anzahlZeilen; Rowc++) {
			if (Import.arr[Rowc][7].equals("Fr")) {
				tradingClass.buyStock(Import.arr[Rowc-1][4]);
				int positions = tradingClass.amountOfStockAvailable;
				tradingClass.SellStock(Import.arr[Rowc][4]);
				tradingCounter++;
				if ((tradingClass.getValueAtBuy() - tradingClass.getValueAtSell()) < 0) {
					PN[0]++;
				}
				else {
					PN[1]++;
				}
				data.getData().add(new XYChart.Data<Number, Number>( (double)tradingCounter / 50,tradingClass.availabeMoney));
			}
		}
	}
}
