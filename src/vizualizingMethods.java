import java.text.DecimalFormat;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class vizualizingMethods {

	static int tradingCount = 0;
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
					Backtesting_Main.tableValue[Rowc][0] = Import.arr[Rowc][0]; //Datum in TabellenArray
					Backtesting_Main.tableValue[Rowc][1] = String.valueOf(positions);
					Backtesting_Main.tableValue[Rowc][2] = String.valueOf(f.format(tradingClass.buyValue));
					Backtesting_Main.tableValue[Rowc][3] = String.valueOf(f.format(tradingClass.sellValue));
					Backtesting_Main.tableValue[Rowc][4] = "positiver Trade";
					//System.out.println("Trade: \t Anzahl Positionen = \t"+ positions + "\tgekauft zu = \t"+f.format(tradingClass.buyValue)+"\t zu = \t"+ f.format(tradingClass.sellValue)+ "\tverkauft \t positiver Trade");
					PN[0]++;
				}
				else {
					PN[1]++;
					Backtesting_Main.tableValue[Rowc][0] = Import.arr[Rowc][0]; //Datum in TabellenArray
					Backtesting_Main.tableValue[Rowc][1] = String.valueOf(positions);
					Backtesting_Main.tableValue[Rowc][2] = String.valueOf(f.format(tradingClass.buyValue));
					Backtesting_Main.tableValue[Rowc][3] = String.valueOf(f.format(tradingClass.sellValue));
					Backtesting_Main.tableValue[Rowc][4] = "negativer Trade";
					
					//System.err.println("Trade: \t Anzahl Positionen = \t"+ positions + "\tgekauft zu = \t"+f.format(tradingClass.buyValue)+"\t zu = \t"+ f.format(tradingClass.sellValue)+ "\tverkauft \t negativer Trade");
				}
				data.getData().add(new XYChart.Data<Number, Number>( (double)tradingCounter / 50,tradingClass.availabeMoney));
			}
		}
		System.out.println("positive Trads = "+ PN[0]);
		System.out.println("anzahl Trads = "+ (double)tradingCounter);
		System.out.println("Chance for positve Trade = " + f.format((PN[0] / (double)tradingCounter) * 100.0));
	}
}
