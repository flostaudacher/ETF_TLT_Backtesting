
import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class table extends Pane{
	public static TableView<Trade> table = new TableView<Trade>();
	public static ObservableList<Trade> data = FXCollections.observableArrayList();

	static int tradingCounter = 0;
	static DecimalFormat f = new DecimalFormat("#0.00");

	@SuppressWarnings("unchecked")
	public static VBox tableCreat() {

		final Label label = new Label("Trading History");
		label.setFont(new Font("Arial", 20));
		table.setEditable(false);
		calc();


		fill();
		TableColumn Datum = new TableColumn("Datum");
		Datum.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Datum")
				);
		TableColumn Positionen = new TableColumn("Positionen");
		Positionen.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Positionen")
				);
		TableColumn Kaufpreis = new TableColumn("Kaufpreis");
		Kaufpreis.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Kaufpreis")
				);
		TableColumn Verkaufspreis = new TableColumn("Verkaufpreis");
		Verkaufspreis.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Verkaufpreis")
				);
		TableColumn Umsatz = new TableColumn("Umsatz");
		Umsatz.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Umsatz")
				);
		table.setItems(data);
		table.getColumns().addAll(Datum, Positionen, Kaufpreis, Verkaufspreis,Umsatz);
		table.minWidth(425);
		final VBox vbox = new VBox();
		vbox.setMinWidth(425);
		vbox.getChildren().addAll(label, table);

		return vbox;
	}


	public static void fill() {

		for (int Rowc = 1; Rowc < tradingCounter;Rowc++) {
			System.out.println("liste = "+Backtesting_Main.tableValue[Rowc][0]);
			data.addAll(new Trade(Backtesting_Main.tableValue[Rowc][0], Backtesting_Main.tableValue[Rowc][1], Backtesting_Main.tableValue[Rowc][2],Backtesting_Main.tableValue[Rowc][3],Backtesting_Main.tableValue[Rowc][4]));
		}
	}

	public static void calc() {
		for (int Rowc = 1; Rowc < Import.anzahlZeilen; Rowc++) {
			if (Import.arr[Rowc][7].equals("Fr")) {
				tradingClass.buyStock(Import.arr[Rowc-1][4]);
				int positions = tradingClass.amountOfStockAvailable;
				tradingClass.SellStock(Import.arr[Rowc][4]);
				tradingCounter++;
				if ((tradingClass.getValueAtBuy() - tradingClass.getValueAtSell()) < 0) {
					Backtesting_Main.tableValue[tradingCounter][0] = Import.arr[Rowc][0]; //Datum in TabellenArray
					Backtesting_Main.tableValue[tradingCounter][1] = String.valueOf(positions);
					Backtesting_Main.tableValue[tradingCounter][2] = String.valueOf(f.format(tradingClass.buyValue));
					Backtesting_Main.tableValue[tradingCounter][3] = String.valueOf(f.format(tradingClass.sellValue));
					Backtesting_Main.tableValue[tradingCounter][4] = "positiver Trade";
				}
				else {
					Backtesting_Main.tableValue[tradingCounter][0] = Import.arr[Rowc][0]; //Datum in TabellenArray
					Backtesting_Main.tableValue[tradingCounter][1] = String.valueOf(positions);
					Backtesting_Main.tableValue[tradingCounter][2] = String.valueOf(f.format(tradingClass.buyValue));
					Backtesting_Main.tableValue[tradingCounter][3] = String.valueOf(f.format(tradingClass.sellValue));
					Backtesting_Main.tableValue[tradingCounter][4] = "negativer Trade";
				}
			}
		}
	}

}
